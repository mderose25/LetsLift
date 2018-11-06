package depaul.controller;

import depaul.service.AccountService;
import depaul.tables.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SessionAttributes("account")
@Controller
public class LoginController {

    @Autowired
    AccountService accountService = new AccountService();

    @RequestMapping(value = "/login")
    public String goToLogin(){
        return "login";
    }

    @GetMapping("/login")
    public String accountForm(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    @PostMapping("/accountHome")
    public String verifyLogin(@ModelAttribute Account account,
                              Model model, HttpServletRequest request
                              ){
        String enteredAccountName = account.getAccountName();
        String enteredPassword = account.getPassword();

        if(accountService.loginAccount(enteredAccountName, enteredPassword)){
            Account startSession = accountService.returnAccountInfo(enteredAccountName);
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedInUser", startSession);
            model.addAttribute("name", startSession.getFirstName().toUpperCase());
            return "accountHome";
        };

        model.addAttribute("loginError", "Error logging in.");
        return "redirect:/login";
    }
}
