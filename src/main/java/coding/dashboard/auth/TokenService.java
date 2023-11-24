package coding.dashboard.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TokenService {

    private final JwtEncoder encoder;
    private final JwtDecoder decoder;

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(24, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        var encoderParameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);
        return this.encoder.encode(encoderParameters).getTokenValue();
    }

    public boolean isValidToken(String token) {
        try {
            Jwt decodedToken = decoder.decode(token);
            Instant now = Instant.now();
            Instant expiry = decodedToken.getExpiresAt();
            assert expiry != null;
            if (now.compareTo(expiry) < 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public String getCurrentUserName() {
        String bearerToken = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest().getHeader("Authorization");
        String token = bearerToken.substring(bearerToken.indexOf(" ") + 1).trim();
        return decoder.decode(token).getClaimAsString("sub");
    }

}