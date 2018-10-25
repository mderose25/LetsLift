package depaul.interfaces.oracle;

public interface IAccount {

    Long getAccountID();

    void setAccountID(Long accountID);

    String getAccountName();

    void setAccountName(String accountName);

    String getPassword();

    void setPassword(String password);

    boolean equals(Object object);

    int hashCode();

    String toString();

}
