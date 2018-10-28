package depaul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorkoutController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/workout")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "workout";
    }

    @RequestMapping(value = "/workout/createWorkout")
    public String goToCreateWorkout(){
        return "createWorkout";
    }

    @RequestMapping(value = "/workout/viewWorkout")
    public String goToViewWorkout(){
        return "viewWorkout";
    }

    @RequestMapping(value = "/workout/deleteWorkout")
    public String goToDeleteWorkout(){
        return "deleteWorkout";
    }
}
