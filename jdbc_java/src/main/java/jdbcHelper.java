import java.sql.*;
import java.util.Scanner;

/**
 * Created by vanshika on 15/6/17.
 */
public class jdbcHelper {
    private String jdbcUrl, username, password, ReadTableSql, tableName, CreateTableSql, InsertSqlStatement, u1, u2, u3, u4;
    String[] a = new String[55];
    String[] b = new String[55];
    String[] c = new String[55];


    private Connection connection;
    private int n, i;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String[] getA() {
        return a;
    }

    public void setA(String[] a) {
        this.a = a;
    }

    public String[] getB() {
        return b;
    }

    public void setB(String[] b) {
        this.b = b;
    }

    public String getCreateTableSql() {
        return CreateTableSql;
    }

    public void setCreateTableSql(String createTableSql) {
        CreateTableSql = createTableSql;
    }

    public String getInsertSqlStatement() {
        return InsertSqlStatement;
    }

    public void setInsertSqlStatement(String insertSqlStatement) {
        InsertSqlStatement = insertSqlStatement;
    }

    public String getU1() {
        return u1;
    }

    public void setU1(String u1) {
        this.u1 = u1;
    }

    public String getU2() {
        return u2;
    }

    public void setU2(String u2) {
        this.u2 = u2;
    }

    public String getU3() {
        return u3;
    }

    public void setU3(String u3) {
        this.u3 = u3;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    //to get connection details//

    public void GetConnectionDetails() {
        try {
            Scanner a = new Scanner(System.in);
            System.out.println("ENTER THE JDBC URL");
            this.jdbcUrl = a.next();

            Scanner b = new Scanner(System.in);
            System.out.println("ENTER THE USERNAME OF DATABASE");
            this.username = b.next();

            Scanner c = new Scanner(System.in);
            System.out.println("ENTER PASSWORD");
            this.password = c.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //to create connection//

    public void CreateConnection() {
        try {

            this.connection = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("connection made ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //to get files for the table//

    public int GetTableField() {
        try {
            Scanner d = new Scanner(System.in);
            System.out.println("ENTER THE TABLENAME");
            this.tableName = d.next();

            Scanner e = new Scanner(System.in);
            System.out.println("ENTER THE NUMBER OF FIELDS YOU WANT TO USE IN  " + tableName);
            this.n = e.nextInt();

            System.out.println("ENTER THE FIELD NAMES");
            for (i = 1; i <= n; i++) {
                Scanner k = new Scanner(System.in);
                a[i] = k.next();

            }


        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return n;
    }

    //to create table//

    public String[] CreateTable() {
        try {
            this.i = 0;
            this.CreateTableSql = "CREATE TABLE " + tableName + "(";
            for (i = 1; i <= n; i++) {
                if (i < (n)) this.CreateTableSql = CreateTableSql.concat(a[i] + " varchar(255), ");
                else this.CreateTableSql = CreateTableSql.concat(a[i] + " varchar(255) ");

            }
            System.out.println(CreateTableSql);
            this.CreateTableSql = CreateTableSql.concat(");");
            System.out.println(CreateTableSql);
            Statement statement = connection.createStatement();
            statement.executeUpdate(CreateTableSql);
            System.out.println("table created successfully ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    //to get details which you want to insert in table//

    public void InsertTableDetails() {
        System.out.println("enter the details of the ROW you want to insert ");

        for (i = 1; i <= n; i++) {
            Scanner f = new Scanner(System.in);
            System.out.println("enter the data of " + a[i]);
            this.b[i] = f.next();

        }
        this.InsertSqlStatement = " values(";
        for (i = 1; i <= n; i++) {
            if (i < (n)) this.InsertSqlStatement = InsertSqlStatement.concat("? ,");
            else this.InsertSqlStatement = InsertSqlStatement.concat("?");

        }
        this.InsertSqlStatement = InsertSqlStatement.concat(")");
        System.out.println(InsertSqlStatement);

    }

    //to insert row in table//

    public void InsertRowInTable() {
        try {
            PreparedStatement insertStatement = connection.prepareStatement("insert into " + tableName + InsertSqlStatement);
            for (i = 1; i <= n; i++) {
                System.out.println(i + a[i]);
                insertStatement.setString(i, b[i]);


            }
            insertStatement.executeUpdate();
            System.out.println("data inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet ReadTable() {
        ResultSet rs = null;
        try {

            String sql = "SELECT * from " + tableName +" ;";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}



