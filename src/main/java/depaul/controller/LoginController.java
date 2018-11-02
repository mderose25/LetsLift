package depaul.controller;

import depaul.interfaces.oracle.IAccount;
import depaul.service.AccountService;
import depaul.tables.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public String verifyLogin(@ModelAttribute Account account){
        String enteredAccountName = account.getAccountName();
        String enteredPassword = account.getPassword();

        if(accountService.loginAccount(enteredAccountName, enteredPassword)){
            return "accountHome";
        };

        return "login";
    }
}
