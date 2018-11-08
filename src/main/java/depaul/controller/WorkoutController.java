package depaul.controller;

import depaul.service.WorkoutService;
import depaul.tables.Account;
import depaul.tables.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

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
    public String submitWorkout(@ModelAttribute Workout workout,
                                HttpServletRequest request){
        Account account = (Account) request.getSession().getAttribute("loggedInUser");
        workout.setAccountName(account.getAccountName());
        workoutService.createWorkout(workout);
        return "workoutCreated";
    }

    @GetMapping("/workout/viewWorkout")
    public String viewWorkouts(Model model, HttpServletRequest request){
        Account account = (Account) request.getSession().getAttribute("loggedInUser");
        model.addAttribute("workouts", workoutService.getWorkouts(account));
        return "viewWorkout";
    }

    @GetMapping("/workout/deleteWorkout")
    public String deleteWorkoutForm(Model model, HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("loggedInUser");
        model.addAttribute("workout", workoutService.getWorkouts(account));
        return "deleteWorkout";
    }

    @PostMapping("/workout/deleteWorkout")
    public String deleteWorkout(@ModelAttribute Workout workout){
        workoutService.deleteWorkout(workout);
        return "workoutDeleted";
    }
}
