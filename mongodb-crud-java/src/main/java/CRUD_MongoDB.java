import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by datreont on 7/5/17.
 */
public class CRUD_MongoDB  extends  MongoConnection {
    private String name="CRUD_MongoDB";
    static final Logger log= Logger.getLogger(CRUD_MongoDB.class.getName());


    MongoConnection currentConnection= new MongoConnection(uri) ;



    public void  printMe(){
        System.out.println("this is mongoDB CRUD");
        log.info("i m doing mongo crud logging");
    }

    public void Create(){
        List <String> createlist = new ArrayList<>();
        db.getCollection("vanshika");
        System.out.println("collection created");

        MongoCollection <org.bson.Document> collection = db.getCollection("mycoll");

// insert a document
        org.bson.Document document = new org.bson.Document("name","vanshika");
        collection.insertOne(document);
        System.out.println("document inserted ");


    }
    public void Read(){
       db.getCollection("vanshika");
        Iterator dbcoursur = currentConnection.client.listDatabases().iterator();
        while (dbcoursur.hasNext()){
            System.out.println(dbcoursur.next());

    }}

    public void Delete(){


        db.getCollection("student");
        BasicDBObject document = new BasicDBObject();


    }




}
