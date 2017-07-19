import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Created by datreont on 7/5/17.
 */
  class MongoConnection {
      //enter your password and host in uri
    protected MongoClientURI uri  = new MongoClientURI("mongodb://project:Qwerty321@localhost:27017/project");

    public MongoConnection() {
        System.out.println("default constructor doesn't do anything ");;
    }
    public MongoConnection(MongoClientURI uri) {
        this.uri = uri;
    }

    public MongoClientURI getUri() {
        return uri;
    }

    public void setUri(MongoClientURI uri) {
        this.uri = uri;
    }

    protected MongoClient client = new MongoClient(uri);
    protected MongoDatabase db = client.getDatabase(uri.getDatabase());

    public void printDB ()
    {

        System.out.println(db.getName());
    }
}
