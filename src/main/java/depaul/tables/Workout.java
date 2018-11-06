package depaul.tables;

import depaul.interfaces.oracle.IWorkout;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Workout implements Serializable, IWorkout {

    public Workout(){
    }

    public Workout(String accountName, String workoutName, String description, String workoutDate){
        this.accountName = accountName;
        this.workoutName = workoutName;
        this.description = description;
        this.workoutDate = workoutDate;
    }

    private String accountName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long workoutID;

    @NotNull
    private String workoutName;

    private String description;

    private String workoutDate;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "workout")
    private Collection<Exercise> exercises;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public Long getWorkoutID() {
        return workoutID;
    }

    @Override
    public void setWorkoutID(Long workoutID) {
        this.workoutID = workoutID;
    }

    @Override
    public String getWorkoutName() {
        return this.workoutName;
    }

    @Override
    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getWorkoutDate() {
       return this.workoutDate;
    }

    @Override
    public void setWorkoutDate(String workoutDate) {
        this.workoutDate = workoutDate;
    }

    @Override
    public Collection<Exercise> getExercises() {
        return exercises;
    }

    @Override
    public void setExercises(Collection<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Workout)) {
            return false;
        }
        Workout other = (Workout) object;
        if ((this.workoutID == null && other.workoutID != null) || (this.workoutID != null && !this.workoutID.equals(other.workoutID))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workoutID != null ? workoutID.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder retval = new StringBuilder();
        retval.append("Workout {");
        retval.append("Workout ID=");
        retval.append(workoutID);
        retval.append(", Workout Name =");
        retval.append(workoutName);

        return retval.toString();
    }

}
