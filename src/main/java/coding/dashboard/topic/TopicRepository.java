package coding.dashboard.topic;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TopicRepository extends ListCrudRepository<Topic, Long> {
    public List<Topic> findBySheetId(Long sheetId);
}