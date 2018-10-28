package depaul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExerciseController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/exercise")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "exercise";
    }

    @RequestMapping(value = "/exercise/createExercise")
    public String goToCreateExercise(){
        return "createExercise";
    }

    @RequestMapping(value = "/exercise/viewExercise")
    public String goToViewExercise(){
        return "viewExercise";
    }

    @RequestMapping(value = "/exercise/deleteExercise")
    public String goToDeleteWorkout(){
        return "deleteExercise";
    }
}
