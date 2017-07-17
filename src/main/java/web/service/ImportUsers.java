package web.service;

import mybatis.dao.UserDao;
import mybatis.pojo.User;
import core.utils.DbUtils;
import core.utils.MySQLUtils;

import java.util.List;

/**
 * 导入增值服务使用记录到数据库
 * Created by 宝超 on 2017/6/11.
 */
public class ImportUsers {
    public static void main(String[] args) throws Exception{
    String dbHost="localhost";
    String dbName="ccic_data";
    String dbUser="root";
    String dbPass="root";

    DbUtils sqlUtils=new MySQLUtils(dbHost,dbName,dbUser,dbPass);
        UserDao dao=new UserDao(sqlUtils);

        ReadUserExcel readUserExcel=new ReadUserExcel();
    List<User> lists= readUserExcel.readUserExcel(System.getProperty("user.dir") + "\\data\\20170626users.xlsx");
        System.out.println(lists.size());
    dao.insertCCICUser(lists);
    }
}
