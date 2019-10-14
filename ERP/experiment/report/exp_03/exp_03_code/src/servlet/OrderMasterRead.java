package servlet;

import bean.OrderMaster;
import bean.dao.OrderMasterDao;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

// /servlet/master/all?r=t&l=2&s=3
@WebServlet("/servlet/master/all")
public class OrderMasterRead extends javax.servlet.http.HttpServlet {
    private ArrayList<OrderMaster> list = null;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //是否刷新记录
        String reload = request.getParameter("r");
        //读取行数
        int lines = Integer.parseInt(request.getParameter("l")),
                //起始行号
                start = Integer.parseInt(request.getParameter("s"));

        //获取数据
        if (list == null || Objects.equals(reload, "true")) {
            System.out.println("data reload");
            list = new ArrayList<>();
            ResultSet resultSet = new OrderMasterDao().queryAll();

            try {
                while (resultSet.next()) {
                    OrderMaster orderMaster = new OrderMaster();
                    orderMaster.setOrderNo(resultSet.getString(1));
                    orderMaster.setCustomerNo(resultSet.getString(2));
                    orderMaster.setSaleNo(resultSet.getString(3));
                    orderMaster.setOrderSum(resultSet.getDouble(4));
                    orderMaster.setOrderData(resultSet.getString(5));
                    orderMaster.setShipDate(resultSet.getString(6));
                    orderMaster.setInvoiceNo(resultSet.getString(7));
                    list.add(orderMaster);
                }
            } catch (SQLException e) {
                System.err.println("OrderMasterRead: get table error.");
                e.printStackTrace();
            }
        }


        //生成返回数据
        //assert list != null;
        String reply = "{\"size\":"+list.size()+", \"list\":[";
        OrderMaster orderMaster;
        for (int i=start; i< start+lines; i++) {
            if (i < list.size()) {
                orderMaster = list.get(i);
            } else {
                orderMaster = null;
            }
            if (orderMaster != null) {
                if (i == start) {
                    reply += orderMaster.toJson();
                } else {
                    reply += ", " + orderMaster.toJson();
                }
            } else {
                break;
            }
        }
        reply += "]}";

        response.getWriter().print(reply);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
