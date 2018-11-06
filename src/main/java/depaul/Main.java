package depaul;

import depaul.service.AccountService;
import depaul.service.WorkoutService;
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

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    public void run(String... args) throws Exception {
    }
}
