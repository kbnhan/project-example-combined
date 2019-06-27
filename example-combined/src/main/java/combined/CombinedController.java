package combined;

// Imports for Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Controller
public class CombinedController {

    // // Initialize Question #1 - a multiple choice type
    // public String[] question1_options = {"Red", "Yellow", "Blue", "Green"};
    // MultiChoice question1 = new MultiChoice("What is the color of the sky", question1_options, "Blue");

    // Initialize Question #2 - a checkbox type
    public String[] question2_options = {"Cats", "Dogs", "Chinchillas"};
    public String[] question2_answers = {"Cats", "Dogs"};
    Checkbox question2 = new Checkbox("What is your favorite animal?", question2_options, question2_answers);

    public MultiChoice question = convert();

    @GetMapping("/combined")
    public String displayQuestion (Model model) {
        model.addAttribute("question1", question);
        model.addAttribute("question2", question2);
        return "combined";
    }

    @RequestMapping("/result")
    public String getAnswerParam (
        @RequestParam(name="group1", required=false) String answer1, 
        @RequestParam(name="box1", required=false) String animal1,
        @RequestParam(name="box2", required=false) String animal2,
        @RequestParam(name="box3", required=false) String animal3, 
        Model model 
        ) {
        model.addAttribute("question1", question);
        model.addAttribute("question2", question2);
        question.setUserAnswer(answer1);
        question2.clearUserAnswer();
        question2.addUserAnswer(animal1);
        question2.addUserAnswer(animal2);
        question2.addUserAnswer(animal3);
        return "result";
    }

    public MultiChoice convert() {
        Gson gson = new Gson();
        try {
            Reader reader = new FileReader("/Users/knhan/Desktop/project-example-combined/example-combined/src/main/java/combined/question1.json");
            MultiChoice question = gson.fromJson(reader, MultiChoice.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return question;
    }
    
}

