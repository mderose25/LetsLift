package depaul.controller;

import depaul.service.WorkoutService;
import depaul.tables.Account;
import depaul.tables.Workout;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class WorkoutController {

    private WorkoutService workoutService = new WorkoutService();

    @Value("${spring.application.name}")
    private String appName;

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

    @GetMapping("/workout/createWorkout")
    public String workoutForm(Model model) {
        model.addAttribute("workout", new Workout());
        return "createWorkout";
    }

    @PostMapping("/workout/createWorkout")
    public String submitWorkout(@ModelAttribute Account account,
                                Model model, HttpSession session,
                                HttpServletRequest request, HttpServletResponse response
    ){

        return "createWorkout";
    }
}
