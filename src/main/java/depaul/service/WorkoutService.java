package depaul.service;

import depaul.interfaces.oracle.IWorkoutService;
import depaul.repository.ExerciseRepository;
import depaul.tables.Exercise;
import depaul.tables.Workout;
import depaul.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService implements IWorkoutService {

    @Autowired
    WorkoutRepository workoutRepository;
    @Autowired
    ExerciseRepository exerciseRepository;

    @Override
    public void saveWorkout(Workout workout) {
        workoutRepository.save(workout);
    }

    @Override
    public void deleteWorkout(Workout workout) {
        workoutRepository.delete(workout);
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

