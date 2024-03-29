package combined;

// Imports for Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CombinedController {

    // // Initialize Question #1 - a multiple choice type
    // public String[] question1_options = {"Red", "Yellow", "Blue", "Green"};
    // MultiChoice question1 = new MultiChoice("What is the color of the sky", question1_options, "Blue");

    // Initialize Question #2 - a checkbox type
    public String[] question2_options = {"Cats", "Dogs", "Chinchillas"};
    public String[] question2_answers = {"Cats", "Dogs"};
    Checkbox question2 = new Checkbox("What is your favorite animal?", question2_options, question2_answers);

    @GetMapping("/combined")
    public String displayQuestion (Model model) {

        model.addAttribute("question1", question1);
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
        
        //model.addAttribute("question1", question1);
        model.addAttribute("question2", question2);
        //question1.setUserAnswer(answer1);
        question2.clearUserAnswer();
        question2.addUserAnswer(animal1);
        question2.addUserAnswer(animal2);
        question2.addUserAnswer(animal3);
        return "result";
        
    }
    
}

