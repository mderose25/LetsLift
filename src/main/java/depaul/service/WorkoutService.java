package depaul.service;

import depaul.interfaces.oracle.IWorkoutService;
import depaul.repository.ExerciseRepository;
import depaul.tables.Exercise;
import depaul.tables.Workout;
import depaul.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class WorkoutService implements IWorkoutService {

    @Autowired
    WorkoutRepository workoutRepository;
    @Autowired
    ExerciseRepository exerciseRepository;

    @Override
    public void createWorkout(Workout workout) {
        workoutRepository.save(workout);
    }

    @Override
    public void deleteWorkout(Workout workout) {
        workoutRepository.delete(workout);
    }

    @Override
    public List<Workout> getWorkouts(){
        return workoutRepository.findAll();
    }

    @Override
    public void saveExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @Override
    public void deleteExercise(Exercise exercise) {
        exerciseRepository.delete(exercise);
    }
}

