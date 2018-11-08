package depaul.interfaces.oracle;

import depaul.tables.Account;
import depaul.tables.Exercise;
import depaul.tables.Workout;

import java.util.Collection;
import java.util.List;

public interface IWorkoutService {
    void createWorkout(Workout workout);

    void deleteWorkout(Workout workout);

    Collection<Workout> getWorkouts(Account account);

    void createExercise(Exercise exercise);

    void deleteExercise(Exercise exercise);

    List<Exercise> getExercises();
}
