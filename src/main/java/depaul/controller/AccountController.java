package depaul.controller;

import depaul.interfaces.oracle.IAccount;
import depaul.service.AccountService;
import depaul.tables.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    private AccountService accountService = new AccountService();

    @GetMapping("/createAccount")
    public String accountForm(Model model) {
        model.addAttribute("account", new Account());
        return "createAccount";
    }

   @PostMapping("/createAccount")
    public String createAccount(@ModelAttribute IAccount account) {
        accountService.createAccount(account);
        return "workout";
    }

}
