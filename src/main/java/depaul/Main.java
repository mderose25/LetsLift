package depaul;

import depaul.service.AccountService;
import depaul.service.WorkoutService;
import depaul.tables.Account;
import depaul.tables.Workout;
import depaul.tables.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan("depaul")
public class Main implements CommandLineRunner {

    @Autowired
    AccountService accountService = new AccountService();
    @Autowired
    WorkoutService workoutService = new WorkoutService();

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    public void run(String... args) throws Exception {
    }

    private void createAccount(){
        Account account = new Account();
        account.setAccountName("depaulTest");
        account.setPassword("test");
        account.setFirstName("Mark");
        account.setLastName("DeRose");
        accountService.createAccount(account);
    }

    private void deleteAccount() {
        accountService.deleteAccount("depaulTest");
        System.out.println("Deletion complete.");
    }

    private Workout createWorkout() {
        Workout workout = new Workout(new Long(730), "Chest", "chest workout", "10/29/1987");
        workoutService.saveWorkout(workout);
        return workout;
    }

    private void deleteWorkout(Workout workout) {
        workoutService.deleteWorkout(workout);
    }

    private Exercise createExercise(Workout workout) {
        Exercise exercise = new Exercise();
        exercise.setExerciseName("Bench press");
        exercise.setWeight(new Long(13));
        exercise.setReps(new Long(30));
        exercise.setWorkout(workout);
        workoutService.saveExercise(exercise);
        return exercise;
    }

    private void deleteExercise(Exercise exercise) {
        workoutService.deleteExercise(exercise);
    }
}