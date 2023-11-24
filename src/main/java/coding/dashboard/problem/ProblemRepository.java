package coding.dashboard.problem;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProblemRepository extends ListCrudRepository<Problem, Long> {
    public List<Problem> findByTopicId(Long topicId);
}