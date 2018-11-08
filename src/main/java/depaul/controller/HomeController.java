package depaul.controller;

import depaul.tables.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @RequestMapping(value = "/home")
    public String goToHome(){
        return "home";
    }

    @RequestMapping(value = "/workout")
    public String goToWorkouts(){
        return "workout";
    }

    @RequestMapping(value = "/exercise")
    public String goToExercise(){
        return "exercise";
    }

    @RequestMapping(value = "/about")
    public String goToAbout(){
        return "about";
    }

    @RequestMapping(value = "/accountHome")
    public String goToAccountHome(HttpServletRequest request,
                                  Model model){

        Account account = (Account) request.getSession().getAttribute("loggedInUser");
        model.addAttribute("name", account.getFirstName().toUpperCase());
        return "accountHome";
    }
}
