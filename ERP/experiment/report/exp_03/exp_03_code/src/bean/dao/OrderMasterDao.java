package bean.dao;

import bean.OrderMaster;

import java.sql.ResultSet;

public class OrderMasterDao extends AbstractDao{

    public int insert(OrderMaster orderMaster) {
        return super.getMysqlCurd().update(orderMaster.getInsertSql());
    }

    public int delete(OrderMaster orderMaster) {
        return super.getMysqlCurd().update(orderMaster.getDeleteSql("orderNo", orderMaster.getOrderNo()));
    }

    public ResultSet queryAll() {
        return super.getMysqlCurd().query("SELECT * FROM orderMaster");
    }
}
