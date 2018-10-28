package depaul.interfaces.oracle;

import depaul.tables.Workout;

public interface IExercise {

    Long getAccountId();

    void setAccountId(Long accountId);

    Long getExerciseID();

    void setExerciseID(Long exerciseID);

    String getExerciseName();

    void setExerciseName(String exerciseName);

    Long getWeight();

    void setWeight(Long weight);

    Long getReps();

    void setReps(Long reps);

    Workout getWorkout();

    void setWorkout(Workout workout);

    boolean equals(Object object);

    int hashCode();

    String toString();
}
