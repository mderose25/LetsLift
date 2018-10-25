package depaul.interfaces.oracle;

import depaul.tables.Exercise;
import java.util.Collection;

public interface IWorkout {

    Long getAccountId();

    void setAccountId(Long accountId);

    Long getWorkoutID();

    void setWorkoutID(Long workoutID);

    String getWorkoutName();

    void setWorkoutName(String workoutName);

    String getDescription();

    void setDescription(String description);

    String getWorkoutDate();

    void setWorkoutDate(String workoutDate);

    Collection<Exercise> getExercises();

    void setExercises(Collection<Exercise> exercises);

    boolean equals(Object object);

    int hashCode();

    String toString();
}
