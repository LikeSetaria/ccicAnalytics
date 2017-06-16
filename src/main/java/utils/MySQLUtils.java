package utils;


import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * MySQL数据库操作工具
 * Created by ksafe on 2014/5/22.
 */
public class MySQLUtils extends DbUtils {
    private String dbHost;
    private String dbName;
    private String dbUser;
    private String dbPass;

    public MySQLUtils(String dbHost, String dbName, String dbUser, String dbPass) {
        this.dbHost = dbHost;
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    public void connect() throws Exception {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            throw new Exception("找不到MySQL驱动", e);
        }
        String db_Url;
        if (dbHost.split(":").length > 1) {
            //jdbc:mysql://192.168.199.10:3306/epmm
            //jdbc:mysql://192.168.199.10:3306/alpaca?useUnicode=true&characterEncoding=utf-8
            db_Url = "jdbc:mysql://" + dbHost + "/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
        } else {
            db_Url = "jdbc:mysql://" + dbHost + ":3306/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
        }
        try {
            connection = DriverManager.getConnection(db_Url, dbUser, dbPass);
        } catch (SQLException e) {
            throw new Exception("MySQL数据库连接失败", e);
        }
        super.connect();
    }
}
