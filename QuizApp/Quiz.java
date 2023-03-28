import java.util.List;
import java.util.ArrayList;

public abstract class Quiz
{
    // instance variables - replace the example below with your own
    private int questionCount;
    private List<Question> questionList;
    private final String questionType;
    public Quiz(String questionType)
    {
        this.questionCount = 0;
        this.questionList = new ArrayList<Question>();
        this.questionType = questionType;
    }
    void addQuestion(Question q){
        questionList.add(q);
    }
}
