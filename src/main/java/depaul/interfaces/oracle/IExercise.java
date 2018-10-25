package depaul.interfaces.oracle;

import depaul.tables.Workout;

public interface IExercise {

    Long getAccountId();

    void setAccountId(Long accountId);

    Long getExerciseID();

    void setExerciseID(Long exerciseID);

    String getExerciseName();

    void setExerciseName(String exerciseName);

    String getDescription();

    void setDescription(String description);

    Long getReps();

    void setReps(Long reps);

    Workout getWorkout();

    void setWorkout(Workout workout);

    boolean equals(Object object);

    int hashCode();

    String toString();
}
