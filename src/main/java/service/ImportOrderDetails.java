package service;

import dao.OrderDao;
import dao.OrderDetailDao;
import pojo.Order;
import pojo.OrderDetail;
import utils.DbUtils;
import utils.MySQLUtils;

import java.util.List;

/**
 * 订单存取到数据库
 * Created by 宝超 on 2017/6/11.
 */
public class ImportOrderDetails {
    public static void main(String[] args) throws Exception{
    String dbHost="localhost";
    String dbName="ccic_data";
    String dbUser="root";
    String dbPass="root";

    DbUtils sqlUtils=new MySQLUtils(dbHost,dbName,dbUser,dbPass);
    OrderDetailDao dao=new OrderDetailDao(sqlUtils);

        ReadOrderDetailExcel readDetailExcel=new ReadOrderDetailExcel();
    List<OrderDetail> lists= readDetailExcel.readOrderDetailExcel(System.getProperty("user.dir") + "\\data\\4detail.xlsx");
        System.out.println(lists.size());
    dao.insertCCICOrder(lists);
    }
}
