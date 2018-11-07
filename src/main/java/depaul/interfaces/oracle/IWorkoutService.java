package depaul.interfaces.oracle;

import depaul.tables.Exercise;
import depaul.tables.Workout;

import java.util.Collection;

public interface IWorkoutService {

    void createWorkout(Workout workout);

    void deleteWorkout(Workout workout);

    Collection<Workout> getWorkouts();

   // void saveWorkout(Workout workout);

    void deleteExercise(Exercise exercise);

    void saveExercise(Exercise exercise);
}
