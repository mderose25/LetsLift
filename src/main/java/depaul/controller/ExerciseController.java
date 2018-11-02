package depaul.controller;

import depaul.service.WorkoutService;
import depaul.tables.Exercise;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExerciseController {

    @Value("${spring.application.name}")
    private String appName;

    WorkoutService workoutService = new WorkoutService();

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

    @GetMapping("/exercise/createExercise")
    public String exerciseForm(Model model) {
        model.addAttribute("exercise", new Exercise());
        return "createExercise";
    }

    @PostMapping("/workout/createExercise")
    public String createExercise(@ModelAttribute Exercise exercise) {
        workoutService.saveExercise(exercise);
        return "createExercise";
    }
}
