package depaul.tables;

import depaul.interfaces.oracle.IAccount;
import javax.persistence.*;
import java.util.Collection;

public class Account implements IAccount {

    private long accountID;

    private String accountName;

    private String password;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "id",
            fetch = FetchType.EAGER)
    private Collection<Workout> workouts;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "id",
            fetch = FetchType.EAGER)
    private Collection<Exercise> exercises;

    @Override
    public Long getAccountID() {
        return accountID;
    }

    @Override
    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    @Override
    public String getAccountName() {
        return accountName;
    }

    @Override
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "Account ID = " + accountID + ", Account = " + accountName + '}';
    }

    public Collection<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Collection<Workout> workouts) {
        this.workouts = workouts;
    }

    public void addWorkout(Workout workout){
        workouts.add(workout);
    }

    public Collection<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Collection<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }

}