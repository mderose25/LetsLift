package depaul.interfaces.nosql;

import depaul.interfaces.oracle.IAccount;

public interface IAccountService {
    void deleteAccount(int accountId);

    void saveAccount(IAccount account);
}
