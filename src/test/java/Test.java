import mybatis.pojo.User;
import web.service.ReadUserExcel;
import core.utils.DbUtils;
import core.utils.MySQLUtils;

import java.sql.*;
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
        String sql="select * from ccic_vip_orders";
        ResultSet resultSet= sqlUtils.executeQuery(sql);
        while(resultSet.next()){
            System.out.println(resultSet.getString(1)+","+resultSet.getString(2));
        }
    }
    public static void testExcel(){
        ReadUserExcel imp=new ReadUserExcel();
        List<User> list ;
        System.out.println(System.getProperty("user.dir") );
        list=imp.readUserExcel(System.getProperty("user.dir") + "\\data\\20170626users.xlsx");
        for(User orderDetail:list){
            System.out.println(orderDetail);
        }
    }
}
