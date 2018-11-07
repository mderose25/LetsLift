package depaul.controller;

import depaul.service.WorkoutService;
import depaul.tables.Account;
import depaul.tables.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService = new WorkoutService();

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping(value = "/workout/createWorkout")
    public String goToCreateWorkout(){
        return "createWorkout";
    }

    @RequestMapping(value = "/workout/createWorkout/workoutCreated")
    public String goToWorkoutCreated(){
        return "workoutCreated";
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
    public String submitWorkout(Model model,
                                @ModelAttribute Workout workout,
                                HttpServletRequest request){
        Account account = (Account) request.getSession().getAttribute("loggedInUser");
        workout.setAccountName(account.getAccountName());
        workoutService.createWorkout(workout);
        return "workoutCreated";
    }

    @GetMapping("/workout/viewWorkout")
    public String viewWorkouts(Model model){
        model.addAttribute("workouts", workoutService.getWorkouts());
        return "viewWorkout";
    }
}
