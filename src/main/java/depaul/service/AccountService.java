package depaul.service;

import depaul.interfaces.oracle.IAccount;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import depaul.interfaces.nosql.IAccountService;
import depaul.repository.AccountRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    AccountRepository accountRepository;

    private MongoCollection<Document> db;
    private static final String dbAccountID = "accountID";
    private static final String dbAccountName = "accountName";
    private static final String dbPassword = "password";

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
    public void deleteAccount(int accountID){
       db.deleteMany(new Document(dbAccountID, accountID));
    }

    @Override
    public void saveAccount(IAccount account){
        db.insertOne(new Document().
                append(dbAccountID, account.getAccountID()).
                append(dbAccountName, account.getAccountName()).
                append(dbPassword, account.getPassword()));
          }

    }

