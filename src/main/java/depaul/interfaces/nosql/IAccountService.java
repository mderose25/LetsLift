package depaul.interfaces.nosql;

import depaul.interfaces.oracle.IAccount;
import depaul.tables.Account;

public interface IAccountService {

    boolean loginAccount(String accountName, String password);

    String findAccount(String name);

    void deleteAccount(String accountName);

    void createAccount(Account account);

    Account returnAccountInfo(String accountName);
}
