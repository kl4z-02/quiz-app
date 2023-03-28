
public class Question
{

    private String upText;
    private String[] validAnswers;

    Question(String upText, String[] validAnswers)
    {
        this.upText = upText;
        this.validAnswers = validAnswers;
    }
    public boolean validate(String inp){
        for(String var: validAnswers){
            if(var.equalsIgnoreCase(inp))
                return true;
        }
        return false;
    }
    
    public String getUpText(){
        return upText;
    }
    
    public String getAnswer(){
        return validAnswers[0];
    }
}
