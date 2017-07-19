import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vanshika on 15/6/17.
 */
public class DBtoFileUtils {

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String[] getA() {
        return a;
    }

    public void setA(String[] a) {
        this.a = a;
    }

    private ResultSet rs;
    private String filepath ;
    private int n,i;
    String[] a = new String[55];
    public void ReadData() {

        try {
            jdbcHelper jdbchelper = new jdbcHelper();

            jdbchelper.GetConnectionDetails();

            jdbchelper.CreateConnection();

            this.n = jdbchelper.GetTableField();

            this.a = jdbchelper.CreateTable();

            jdbchelper.InsertTableDetails();

            jdbchelper.InsertRowInTable();

            this.rs = jdbchelper.ReadTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void  WriteData(){
        try {
            FileIoHelper fileIoHelper = new FileIoHelper();

            this.filepath = fileIoHelper.instantiateFile();

            FileWriter fileWriter = new FileWriter(filepath);

            while (this.rs.next()) {

                for (int i = 1; i <= (n - 1); i++) {
                    fileWriter.append(rs.getString(this.a[i]));
                    fileWriter.append(',');
                }
                fileWriter.append(rs.getString(a[n]));

            }
            System.out.println("csv created");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
