package bean.dao;

import java.sql.ResultSet;

public class ReportDao extends AbstractDao {

    public ResultSet queryCall(String procedure) {
        return super.getMysqlCurd().query("call "+procedure);
    }

    public int updateCall(String produce) {
        return super.getMysqlCurd().update("call "+produce);
    }
}
