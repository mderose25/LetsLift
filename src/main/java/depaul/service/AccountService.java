package depaul.service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import depaul.interfaces.oracle.IAccount;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import depaul.interfaces.nosql.IAccountService;
import depaul.repository.AccountRepository;
import depaul.tables.Account;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository accountRepository;

    private MongoCollection<Document> db;
    private static final String dbAccountName = "accountName";
    private static final String dbPassword = "password";
    private static final String dbFirstName = "firstName";
    private static final String dbLastName = "lastName";

    private static final String USER_NAME = "mderose25";
    private static final String PASSWORD = "Depaul12!";
    private static final String MONGO_URL = "mongodb://"+USER_NAME+":"+PASSWORD + "@ds119302.mlab.com:19302/letslift";
    private static final String COLLECTION_NAME = "letsLiftAccounts";

    public AccountService(){
        MongoClientURI uri  = new MongoClientURI(MONGO_URL);
        MongoClient mongoClient = new MongoClient(uri);

        db = mongoClient.getDatabase(uri.getDatabase()).getCollection(COLLECTION_NAME);

    }

    @Override
    public String findAccount(String name){
        return "";
    }

    @Override
    public void deleteAccount(String accountName){
       db.deleteMany(new Document(dbAccountName, accountName));
    }

    @Override
    public void createAccount(Account account){
        db.insertOne(new Document().
                append(dbAccountName, account.getAccountName()).
                append(dbPassword, account.getPassword()).
                append(dbFirstName, account.getFirstName()).
                append(dbLastName, account.getLastName()));
    }

    @Override
    public boolean loginAccount(String accountName, String enteredPassword) {

        //Get account name from Mongo DB and regex for password:
        Bson query = Filters.eq("accountName", accountName);
        Bson projection = Projections.include("password");
        FindIterable<Document> iterator = db.find(query).projection(projection);
        Document result = iterator.first();
        String toSplit = result.toString();
        String split[] = toSplit.split("=");
        String mongoPassword[] = split[2].split("}}");

        if(mongoPassword[0].equals(enteredPassword)){
            return true;
        }
        else {
            return false;
        }
    }


}

