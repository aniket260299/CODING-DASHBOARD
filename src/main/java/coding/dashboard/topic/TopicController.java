package coding.dashboard.topic;

import coding.dashboard.common.CommonDBService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/topic")
public class TopicController {
    private final TopicRepository repository;
    private final CommonDBService commonDBService;

    @GetMapping("/{id}")
    public Optional<Topic> getById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("/sheet/{id}")
    public List<Topic> getAllBySheetID(@PathVariable Long id) {
        return repository.findBySheetId(id);
    }

    @RequestMapping(value = "", method = {RequestMethod.PUT, RequestMethod.POST})
    public Topic addOrUpdate(@RequestBody Topic topic) {
        return repository.save(topic);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        commonDBService.deleteTopic(id);
    }
}
