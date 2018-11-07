package depaul.controller;

import depaul.service.WorkoutService;
import depaul.tables.Account;
import depaul.tables.Exercise;
import depaul.tables.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class ExerciseController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    WorkoutService workoutService = new WorkoutService();

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
    public String exerciseForm(Model model, HttpServletRequest request) {
        model.addAttribute("exercise", new Exercise());
        return "createExercise";
    }

    @PostMapping("/workout/createExercise")
    public String createExercise(@ModelAttribute Exercise exercise,
                                 @ModelAttribute Workout workout,
                                 Model model,
                                 HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("loggedInUser");
        exercise.setAccountName(account.getAccountName());
        Collection<Workout> workouts = workoutService.getWorkouts();
        model.addAttribute("workouts", workouts);
        workoutService.saveExercise(exercise);
        return "exerciseCreated";
    }
}
