import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlConnect extends DataBaseSystem {

    private String url = "jdbc:mysql://%HOST%:%PORT%/%DATABASE%?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private Properties config;

    public MysqlConnect(Properties config) {
        this.config = config;
        flushUrl();
    }

    /**
     * load driver
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql: Driver Not Found. " + e.getMessage());
        }
    }

    protected void flushUrl() {
        url = url.replace("%HOST%", config.getProperty("db.host")).replace("%PORT%", config.getProperty("db.port"))
                .replace("%DATABASE%", config.getProperty("db.dbname"));
    }

    public boolean connect() {
        boolean result;
        try {
            super.setConnect(
                    DriverManager.getConnection(url, config.getProperty("db.user"), config.getProperty("db.passwd")));
            result = true;
        } catch (SQLException e) {
            result = false;
            System.out.println("Mysql: Connection Failed. " + e.getMessage());
        }
        return result;
    }

    public String getUrl() {
        return url;
    }

    public void setConfig(Properties config) {
        this.config = config;
        flushUrl();
    }
}