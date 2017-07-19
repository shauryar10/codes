import java.io.File;
import java.util.Scanner;

/**
 * Created by vanshika on 23/6/17.
 */
public class FileIoHelper {
    private String  filepath;

    public String instantiateFile(){

        Scanner a = new Scanner(System.in);
        System.out.println("enter the path of the file ");
        this.filepath = a.next();

        File file = new File(filepath);

        boolean fileExists = file.exists();


        System.out.println(fileExists);
        return filepath;

    }

}
