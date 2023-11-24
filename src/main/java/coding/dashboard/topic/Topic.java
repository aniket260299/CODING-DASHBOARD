package coding.dashboard.topic;

import org.springframework.data.annotation.Id;

public record Topic(@Id Long id, int position, String topic, Long sheetId) {
}
