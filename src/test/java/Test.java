import pojo.Order;
import pojo.OrderDetail;
import service.ReadOrderDetailExcel;
import service.ReadOrderExcel;
import utils.DbUtils;
import utils.MySQLUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 宝超 on 2017/6/10.
 */
public class Test {
    public static void main(String[] args) throws Exception {
       // testJDBC();
        testExcel();
    }
    public static void testJDBC() throws Exception {
        String dbHost="localhost";
        String dbName="ccic_data";
        String dbUser="root";
         String dbPass="root";

        DbUtils sqlUtils=new MySQLUtils(dbHost,dbName,dbUser,dbPass);
        sqlUtils.connect();
        String sql="select * from ccic_agency";
        ResultSet resultSet= sqlUtils.executeQuery(sql);
        while(resultSet.next()){
            System.out.println(resultSet.getString(1)+","+resultSet.getString(2));
        }

    }
    public static void testExcel(){
        ReadOrderDetailExcel imp=new ReadOrderDetailExcel();
        List<OrderDetail> list ;
        System.out.println(System.getProperty("user.dir") );
        list=imp.readOrderDetailExcel(System.getProperty("user.dir") +"\\data\\4detail.xlsx");
        for(OrderDetail orderDetail:list){
            System.out.println(orderDetail);
        }
    }
}
