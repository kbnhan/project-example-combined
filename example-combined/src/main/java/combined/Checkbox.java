package combined;

import java.util.ArrayList;

public class Checkbox {

    private ArrayList<String> answers = new ArrayList<String>();

    public void addAnswer(String answer) {
        this.answers.add(answer); 
    }

    public ArrayList<String> getAnswers() {
        return this.answers;
    }

    
}