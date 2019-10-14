package servlet;

import bean.PriceStage;
import bean.dao.ReportDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/servlet/master/psr")
public class PriceStageReport extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //容器
        ArrayList<PriceStage> list = new ArrayList<>();
        //获取数据
        ResultSet resultSet = new ReportDao().queryCall("getPriceStage()");
        try {
            while (resultSet.next()) {
                PriceStage priceStage = new PriceStage();
                priceStage.setPrice(resultSet.getInt(1));
                priceStage.setNumber(resultSet.getInt(2));
                list.add(priceStage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //加工数据
        String reply = "[";
        for (int i=0; i<list.size(); i++) {
            PriceStage priceStage = list.get(i);

            if (i == 0) {
                reply += priceStage.toJson();
            } else {
                reply += ", " + priceStage.toJson();
            }
        }
        reply += "]";

        //返回数据
        response.getWriter().print(reply);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
