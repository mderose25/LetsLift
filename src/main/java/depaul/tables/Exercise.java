package depaul.tables;

import depaul.interfaces.oracle.IExercise;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Exercise implements Serializable, IExercise {

    public Exercise(){
    }

    public Exercise(Long accountId, String exerciseName, Long weight){
        this.accountId = accountId;
        this.exerciseName = exerciseName;
        this.weight = weight;
    }

    private Long accountId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long exerciseID;

    @NotNull
    private String exerciseName;

    private Long weight;

    private Long reps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workoutID", nullable = false)
    private Workout workout;

    @Override
    public Long getAccountId() {
        return accountId;
    }

    @Override
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public Long getExerciseID() {
        return exerciseID;
    }

    @Override
    public void setExerciseID(Long exerciseID) {
        this.exerciseID = exerciseID;
    }

    @Override
    public String getExerciseName() {
        return exerciseName;
    }

    @Override
    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    @Override
    public Workout getWorkout() {
        return this.workout;
    }

    @Override
    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public Long getReps() {
        return reps;
    }

    @Override
    public void setReps(Long reps) {
        this.reps = reps;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Exercise)) {
            return false;
        }
        Exercise other = (Exercise) object;
        if ((this.exerciseID == null && other.exerciseID != null) || (this.exerciseID != null && !this.exerciseID.equals(other.exerciseID))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exerciseID != null ? exerciseID.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder retval = new StringBuilder();
        retval.append("Exercise {");
        retval.append("Exercise ID =");
        retval.append(exerciseID);
        retval.append(", Exercise Name =");
        retval.append(exerciseName);
        retval.append(", Reps =");
        retval.append(reps);

        return retval.toString();
    }

}
