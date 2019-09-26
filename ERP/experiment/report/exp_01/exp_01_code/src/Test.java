import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    private static final String DATA_DB_PROPERTIES = "data/db.properties";

    public static void main(String[] args) {
        ReadConfigure readConfig = new ReadConfigure(DATA_DB_PROPERTIES);
        boolean isConnect = false;
        try {
            MysqlConnect mysql = new MysqlConnect(readConfig.getAllConfigure());
            System.out.println("url: " + mysql.getUrl());
            isConnect = mysql.connect();
            System.out.println("connect: " + isConnect);
            Statement state = mysql.getStatement();
            ResultSet result = state.executeQuery("select number from User where username='TestA'");
            if (result.next()) System.out.println(result.getString(1));
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}