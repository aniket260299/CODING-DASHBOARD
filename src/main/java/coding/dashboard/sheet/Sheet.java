package coding.dashboard.sheet;

import org.springframework.data.annotation.Id;

public record Sheet(@Id Long id, int position, String sheet, String username) {
}
