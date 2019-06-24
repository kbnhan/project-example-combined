package combined;

public class MultiChoice {

    private String answer1 = "Blue";
    private String user_answer1 = "";
    private String answer2 = "2";
    private String user_answer2 = "";

    //Question 1
    public String getAnswer1() {
        return answer1;
    }

    public void setUserAnswer1(String input) {
        this.user_answer1 = input;
    }

    public String getUserAnswer1() {
        return user_answer1;
    }

    //Question 2
    public String getAnswer2() {
        return answer2;
    }

    public void setUserAnswer2(String input) {
        this.user_answer2 = input;
    }

    public String getUserAnswer2() {
        return user_answer2;
    }

    
}