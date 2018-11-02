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

    Long accountID;

    @Override
    public Long getAccountID(){
        return this.accountID;
    }

    @Override
    public void setAccountID(Long accountID){
        this.accountID = accountID;
    }

    @Override
    public void saveWorkout(Workout workout) {
        workout.setAccountId(this.accountID);
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

