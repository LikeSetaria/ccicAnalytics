package service;

import dao.OrderDao;
import pojo.Order;
import utils.DbUtils;
import utils.MySQLUtils;

import java.util.List;

/**
 * 订单存取到数据库
 * Created by 宝超 on 2017/6/11.
 */
public class ImportOrders {
    public static void main(String[] args) throws Exception{
    String dbHost="localhost";
    String dbName="ccic_data";
    String dbUser="root";
    String dbPass="root";

    DbUtils sqlUtils=new MySQLUtils(dbHost,dbName,dbUser,dbPass);
    OrderDao dao=new OrderDao(sqlUtils);

        ReadOrderExcel readExcel=new ReadOrderExcel();
    List<Order> lists= readExcel.readOrderExcel(System.getProperty("user.dir") +"\\data\\ccicTest.xlsx");
        System.out.println(lists.size());
    dao.insertCCICOrder(lists);
    }
}
