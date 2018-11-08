package depaul.service;

import depaul.interfaces.oracle.IWorkoutService;
import depaul.repository.ExerciseRepository;
import depaul.tables.Account;
import depaul.tables.Exercise;
import depaul.tables.Workout;
import depaul.repository.WorkoutRepository;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public void createExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @Override
    public void deleteWorkout(Workout workout) {
        workoutRepository.delete(workout);
    }

    @Override
    public void deleteExercise(Exercise exercise) {
        exerciseRepository.delete(exercise);
    }

    @Override
    public List<Workout> getWorkouts(Account account) {
        List<Workout> allWorkouts = workoutRepository.findAll();
        List<Workout> toReturn = new ArrayList<Workout>();

        for(int i = 0; i < allWorkouts.size(); i++){
            Workout toCheck = allWorkouts.get(i);

            if(toCheck.getAccountName().equals(account.getAccountName())){
                toReturn.add(toCheck);
            }
        }
        return toReturn;
    }

    @Override
    public List<Exercise> getExercises(){
        return exerciseRepository.findAll();
    }
}


