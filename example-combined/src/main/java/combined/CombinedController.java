package combined;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CombinedController {

    public String[] question1_options = {"Red", "Yellow", "Blue", "Green"};
    MultiChoice question1 = new MultiChoice("What is the color of the sky", question1_options, "Blue");

    // @GetMapping("/combined")
    // public String initialize(Model model) {
    //     model.addAttribute("question1", new MultiChoice(
    //         "What is the color of the sky", 
    //         question1_options,
    //         "Blue"));
    //     return "combined";
    // }

    @RequestMapping("/result")
    public String getAnswerParam(@RequestParam("group1") String answer1, @ModelAttribute MultiChoice question1) {
        question1.setUserAnswer(answer1);
        return "result";
    }
    
}