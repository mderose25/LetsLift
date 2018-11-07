package depaul.controller;

import depaul.service.AccountService;
import depaul.tables.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("account")
public class AccountController {

    private AccountService accountService = new AccountService();

    @GetMapping("/createAccount")
    public String accountForm(Model model) {
        model.addAttribute("account", new Account());
        return "createAccount";
    }

   @PostMapping("/login")
    public String createAccount(@ModelAttribute Account account) {
        accountService.createAccount(account);
        return "login";
    }
}
