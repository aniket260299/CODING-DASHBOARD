package coding.dashboard.problem;

import org.springframework.data.annotation.Id;

public record Problem(@Id Long id, int position, String title, int difficulty, String link,
                      String hint, String notes, String solution, Long topicId) {
}
