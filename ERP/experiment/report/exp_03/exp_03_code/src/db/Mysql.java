package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Mysql {
    private Connection connection;
    private Statement statement;
    private String url;
    private Properties config;

    public Mysql(Properties config) {
        this.config = config;
        url = "jdbc:mysql://%HOST%:%PORT%/%DATABASE%?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        flushUrl();
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql: Driver Not Found. " + e.getMessage());
        }
    }

    private void flushUrl() {
        url = url.replace("%HOST%", config.getProperty("mysql.host")).replace("%PORT%", config.getProperty("mysql.port"))
                .replace("%DATABASE%", config.getProperty("mysql.dbname"));
//        System.out.println("Mysql.url: " + url);
    }

    public boolean connect() {
        boolean result;
        try {
            connection = DriverManager.getConnection(url, config.getProperty("mysql.user"), config.getProperty("mysql.passwd"));
            statement = connection.createStatement();
            result = true;
        } catch (SQLException e) {
            result = false;
            System.out.println("Mysql: Connection Failed. " + e.getMessage());
        }
        return result;
    }

    public void disconnect() {
        try {
            if (!statement.isClosed()) statement.close();
            if (!connection.isClosed()) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public void setConfig(Properties config) {
        this.config = config;
        flushUrl();
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}