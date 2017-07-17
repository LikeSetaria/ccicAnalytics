package web.service;

import mybatis.dao.OrderDetailDao;
import mybatis.pojo.OrderDetail;
import core.utils.DbUtils;
import core.utils.MySQLUtils;

import java.util.List;

/**
 * 导入增值服务使用记录到数据库
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
    List<OrderDetail> lists= readDetailExcel.readOrderDetailExcel(System.getProperty("user.dir") + "\\data\\vas1-5.xlsx");
        System.out.println(lists.size());
    dao.insertCCICOrder(lists);
    }
}
