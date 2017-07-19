/**
 * Created by datreont on 7/5/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("this is main");
        CRUD_MongoDB mongoCRUD= new CRUD_MongoDB();
        mongoCRUD.printMe();
        mongoCRUD.printDB();
        mongoCRUD.Create();
        //mongoCRUD.Delete();
    }
}
