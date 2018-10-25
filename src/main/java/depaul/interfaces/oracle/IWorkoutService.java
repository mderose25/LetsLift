package depaul.interfaces.oracle;

import depaul.tables.Exercise;
import depaul.tables.Workout;

public interface IWorkoutService {
    void deleteWorkout(Workout workout);

    void saveWorkout(Workout workout);

    void deleteExercise(Exercise exercise);

    void saveExercise(Exercise exercise);
}