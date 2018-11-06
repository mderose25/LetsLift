package depaul.interfaces.oracle;

import depaul.tables.Account;

public interface IAccount {

    String getAccountName();

    void setAccountName(String accountName);

    String getPassword();

    void setPassword(String password);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String firstName);

    boolean equals(Object object);

    int hashCode();

    String toString();

}
