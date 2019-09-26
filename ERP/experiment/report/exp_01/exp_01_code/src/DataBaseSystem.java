import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DataBaseSystem {
    public static final String LOCALHOST = "localhost";
    private Connection connect;
    private Statement statement;

    protected abstract void flushUrl();

    public abstract boolean connect();

    public boolean disconnect() {
        boolean success = true;

        try {
            if (connect != null) {
                if (!connect.isClosed()) {
                    connect.close();
                }
            }

            if (statement != null) {
                if (!statement.isClosed()) {
                    statement.close();
                }
            }
        } catch (SQLException e) {
            success = false;
            System.out.println("DatabaseSystem: 关闭连接失败 " + e.getMessage());
        }
        return success;
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
        try {
            statement = connect.createStatement();
        } catch (SQLException e) {
            System.out.println("DataBaseSystem: 创建statement失败");
        }
    }

    public Statement getStatement() {
        return statement;
    }

}