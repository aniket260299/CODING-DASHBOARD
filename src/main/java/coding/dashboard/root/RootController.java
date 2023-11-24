package coding.dashboard.root;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class RootController {
    @GetMapping
    public Boolean alive() {
        return true;
    }
}
