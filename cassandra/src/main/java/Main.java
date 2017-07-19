import static java.lang.System.out;

/**
 * Created by vanshika on 12/7/17.
 */
public class Main {
    public static void main(String[] args) {


        Crud crud = new Crud();
        final String ipAddress ="172.17.0.2";
        final int port =  9042;
        System.out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
        crud.connect(ipAddress,port);


    }
}