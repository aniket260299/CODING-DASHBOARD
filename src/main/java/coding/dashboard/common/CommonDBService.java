package coding.dashboard.common;

import coding.dashboard.problem.Problem;
import coding.dashboard.problem.ProblemRepository;
import coding.dashboard.sheet.Sheet;
import coding.dashboard.sheet.SheetRepository;
import coding.dashboard.topic.Topic;
import coding.dashboard.topic.TopicRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Service
public class CommonDBService {
    private final TopicRepository topicRepository;
    private final ProblemRepository problemRepository;
    private final SheetRepository sheetRepository;

    public void deleteSheet(Long id) {
        sheetRepository.deleteById(id);
        List<Topic> topicList = topicRepository.findBySheetId(id);
        topicList.forEach(topic -> deleteTopic(topic.id()));
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
        List<Problem> problemList = problemRepository.findByTopicId(id);
        problemList.forEach(problem -> problemRepository.deleteById(problem.id()));
    }

    public String getExport(String username) throws JsonProcessingException {
        List<Sheet> sheets = sheetRepository.findByUsername(username);
        List<Topic> topics = new ArrayList<>();
        List<Problem> problems = new ArrayList<>();

        sheets.forEach(sheet -> {
            List<Topic> topicBySheetId = topicRepository.findBySheetId(sheet.id());
            topics.addAll(topicBySheetId);
        });

        topics.forEach(topic -> {
            List<Problem> problemsByTopic = problemRepository.findByTopicId(topic.id());
            problems.addAll(problemsByTopic);
        });

        ExportedData data = new ExportedData(sheets, topics, problems);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(data);
    }

    public String doImport(String username, String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ExportedData exportedData = mapper.readValue(data, ExportedData.class);

        HashMap<Long, Long> oldNewSheetId = new HashMap<>();
        exportedData.sheets.forEach(sheet -> {
            Sheet newSheet = sheetRepository.save(new Sheet(null, sheet.position(),
                    sheet.sheet(), username));
            oldNewSheetId.put(sheet.id(), newSheet.id());
        });

        HashMap<Long, Long> oldNewTopicId = new HashMap<>();
        exportedData.topics.forEach(topic -> {
            Topic newTopic = topicRepository.save(new Topic(null, topic.position(), topic.topic(),
                    oldNewSheetId.get(topic.sheetId())));
            oldNewTopicId.put(topic.id(), newTopic.id());
        });

        exportedData.problems.forEach(problem -> {
            problemRepository.save(new Problem(null, problem.position(), problem.title(),
                    problem.difficulty(), problem.link(), problem.hint(), problem.notes(),
                    problem.solution(), oldNewTopicId.get(problem.topicId())));
        });
        return "imported successfully";
    }
}
