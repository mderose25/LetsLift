package depaul.tables;

import depaul.interfaces.oracle.IAccount;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

public class Account implements IAccount {

    public Account(String acctName, String pword, String first, String last){
        this.accountName = acctName;
        this.password = pword;
        this.firstName = first;
        this.lastName = last;
    }

    public Account(){
    }

    @NotNull
    @NotEmpty
    private String accountName;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "accountName",
            fetch = FetchType.EAGER)
    private Collection<Workout> workouts;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "accountName",
            fetch = FetchType.EAGER)
    private Collection<Exercise> exercises;

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
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getFirstName(){
        return firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Account{" + ", Account = " + accountName + ", First Name = " + firstName + ", Last Name = " +
                lastName + '}';
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