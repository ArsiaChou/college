package db;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlCurd {
    private Mysql mysql;

    public MysqlCurd(Mysql mysql) {
        this.mysql = mysql;
    }

    public int update(String sql) {
        int result = -1;
        mysql.connect();
        try {
            result = mysql.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("MysqlCurd: update error.");
            e.printStackTrace();
        }
        mysql.disconnect();
        return result;
    }

    public ResultSet query(String sql) {
        CachedRowSetImpl cachedRowSet = null;
        ResultSet resultSet           = null;
        mysql.connect();
        try {
            resultSet = mysql.getStatement().executeQuery(sql);
            cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
        } catch (SQLException e) {
            System.err.println("MysqlCurd: query error.");
            e.printStackTrace();
        }
        mysql.disconnect();
        return cachedRowSet;
    }

    public Mysql getMysql() {
        return mysql;
    }

    public void setMysql(Mysql mysql) {
        this.mysql = mysql;
    }
}
