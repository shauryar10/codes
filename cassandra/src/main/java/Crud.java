/**
 * Created by vanshika on 12/7/17.
 */
public class Crud extends Connection {
public void createtable(){
    final String createtableCql =
            "CREATE TABLE vanshika.songs (title varchar, year int, description varchar, PRIMARY KEY (title, year))";
    getSession().execute(createtableCql);

    }
    public void insertintable(){
    
    }
}
