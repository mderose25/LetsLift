package depaul.controller;

import depaul.service.WorkoutService;
import depaul.tables.Account;
import depaul.tables.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ExerciseController {

    @Autowired
    WorkoutService workoutService;

    @RequestMapping(value = "/exercise/createExercise")
    public String goToCreateExercise(){
        return "createExercise";
    }

    @RequestMapping(value = "/exercise/createExercise/exerciseCreated")
    public String goToExerciseCreated(){
        return "exerciseCreated";
    }

    @RequestMapping(value = "/exercise/viewExercise")
    public String goToViewExercise(){
        return "viewExercise";
    }

    @RequestMapping(value = "/exercise/deleteExercise")
    public String goToDeleteWorkout(){
        return "deleteExercise";
    }

    @GetMapping("/exercise/createExercise")
    public String exerciseForm(Model model,
                               HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("loggedInUser");
        model.addAttribute("exercise", new Exercise());
        model.addAttribute("workouts", workoutService.getWorkouts());
        return "createExercise";
    }

    @PostMapping("/exercise/createExercise")
    public String submitExercise(@ModelAttribute Exercise exercise,
                                 HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("loggedInUser");
        exercise.setAccountName(account.getAccountName());
        workoutService.createExercise(exercise);
        return "exerciseCreated";
    }

    @GetMapping("/exercise/viewExercise")
    public String viewExercises(Model model){
        model.addAttribute("exercises", workoutService.getExercises());
        return "viewExercise";
    }
}
