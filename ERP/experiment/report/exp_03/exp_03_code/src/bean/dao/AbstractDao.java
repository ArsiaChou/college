package bean.dao;

import db.Mysql;
import db.MysqlCurd;
import db.ReadConfigure;

public abstract class AbstractDao {
    private MysqlCurd mysqlCurd;

    public AbstractDao() {
        String mainPath = this.getClass().getResource("/").getPath();
        mysqlCurd = new MysqlCurd(new Mysql(new ReadConfigure(mainPath+"config/database.properties").getAllConfigure()));
    }

    public MysqlCurd getMysqlCurd() {
        return mysqlCurd;
    }
}
