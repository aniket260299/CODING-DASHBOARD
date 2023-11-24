package coding.dashboard.common;

import coding.dashboard.problem.Problem;
import coding.dashboard.sheet.Sheet;
import coding.dashboard.topic.Topic;

import java.util.List;

public class ExportedData {
    public List<Sheet> sheets;
    public List<Topic> topics;
    public List<Problem> problems;

    public ExportedData(List<Sheet> sheets, List<Topic> topics, List<Problem> problems) {
        this.sheets = sheets;
        this.topics = topics;
        this.problems = problems;
    }

    public ExportedData() {
        
    }
}
