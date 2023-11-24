package coding.dashboard.sheet;

import coding.dashboard.common.CommonDBService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sheet")
public class SheetController {
    private final SheetRepository repository;
    private final CommonDBService commonDBService;

    @GetMapping
    public List<Sheet> getAllSheets() {
        return repository.findAll();
    }

    @GetMapping("/user/{username}")
    public List<Sheet> getSheetsByUsername(@PathVariable String username) {
        return repository.findByUsername(username);
    }

    @GetMapping("/{id}")
    public Optional<Sheet> getSheetById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("/export/{username}")
    public String exportByUsername(@PathVariable String username) throws JsonProcessingException {
        return commonDBService.getExport(username);
    }

    @PostMapping("/import/{username}")
    public String importForUsername(@PathVariable String username, @RequestBody String data) throws IOException {
        return commonDBService.doImport(username, data);
    }

    @RequestMapping(value = "", method = {RequestMethod.PUT, RequestMethod.POST})
    public Sheet addOrUpdate(@RequestBody Sheet sheet) {
        return repository.save(sheet);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        commonDBService.deleteSheet(id);
    }
}
