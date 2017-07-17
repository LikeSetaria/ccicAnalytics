package core.utils;

/**
 * Created by 宝超 on 2017/6/10.
 */
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据库工具
 * Created by ksafe on 2014/5/22.
 */
public class DbUtils {
     Connection connection;
     Statement statement;

    public void connect() throws Exception {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new Exception("设置不自动提交失败");
        }
        statement = null;
    }

    public void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    private Statement getStatement() throws SQLException {
        if (statement == null) {
            statement = connection.createStatement();
        }
        return statement;
    }

    public boolean execute(String sql) throws SQLException {
        return getStatement().execute(sql);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        return getStatement().executeQuery(sql);
    }

    public ResultSet executeQueryForSybase(String sql) throws SQLException {
        return getStatement2().executeQuery(sql);
    }

    public Statement getStatement2() throws SQLException {
        if (statement == null) {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
        return statement;
    }

    public boolean isClosed() {
        try {
            return connection == null  || connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
    public static void main(String[] args){
        SimpleDateFormat sdf  =new SimpleDateFormat("yyyyMM");
        String format = sdf.format(new Date());
        System.out.println("format="+format);
    }
}
