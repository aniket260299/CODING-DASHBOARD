package coding.dashboard.problem;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/problem")
public class ProblemController {
    private final ProblemRepository repository;

    @GetMapping("/{id}")
    public Optional<Problem> getById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("/topic/{id}")
    public List<Problem> getAllByTopicId(@PathVariable Long id) {
        return repository.findByTopicId(id);
    }

    @RequestMapping(value = "", method = {RequestMethod.PUT, RequestMethod.POST})
    public Problem addOrUpdate(@RequestBody Problem problem) {
        return repository.save(problem);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
