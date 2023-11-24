package coding.dashboard.sheet;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface SheetRepository extends ListCrudRepository<Sheet, Long> {
    public List<Sheet> findByUsername(String username);
}
