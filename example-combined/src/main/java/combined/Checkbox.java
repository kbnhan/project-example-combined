package combined;

import java.util.ArrayList;

public class Checkbox extends Question{

    private String[] answers; 
    private ArrayList<String> user_answers = new ArrayList<String>();

    public Checkbox(String text, String[] options, String[] answers) {
        super(text, options);
        this.answers = answers;
    }

    public String[] getAnswers() {
        return this.answers;
    }

    public void addUserAnswer(String answer) {
        this.user_answers.add(answer); 
    }

    public ArrayList<String> getUserAnswers() {
        return this.user_answers;
    }

    
}