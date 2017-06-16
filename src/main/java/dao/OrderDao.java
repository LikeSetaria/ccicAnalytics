package dao;

import pojo.Order;
import utils.DbUtils;
import utils.MySQLUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 宝超 on 2017/6/10.
 */
public class OrderDao {
    private DbUtils targetDb;
   public OrderDao(DbUtils targetDb)throws Exception{
       this.targetDb=targetDb;
   }
    public List<Order> getCCICOrder()throws Exception {
        List<Order> list= new ArrayList<Order>();
        String sql = "SELECT  sale_mode_id,order_date,policy_no,premium,insured_person," +
                "project_name,HANDLER,agency_name,agency_id,start_date FROM ccic_order";
        ResultSet rs;

        if (targetDb.isClosed()) {
            targetDb.connect();
        }
        rs = targetDb.executeQuery(sql);
        while(rs.next()){
            Order order=new Order();
            order.setSaleModeID(rs.getString("sale_mode_id"));
            order.setOrderDate(rs.getString("sale_mode_id"));
            order.setPolicyID(rs.getString("policy_no"));
            order.setPremium(rs.getDouble("premium"));
            order.setInsuredPerson(rs.getString("insured_person"));
            order.setProjectName(rs.getString("project_name"));
            order.setHandler(rs.getString("HANDLER"));
            order.setCCICCompanyCode(rs.getString("agency_id"));
            order.setCCICCompanyName(rs.getString("agency_name"));
            order.setStartDate(rs.getString("start_date"));
            list.add(order);
        }
        rs.close();
        return list;
    }
    public void insertCCICOrder(List<Order> list)throws  Exception{
        String insertSql="insert into ccic_order ( sale_mode_id,order_date,policy_no,premium,insured_person,project_name,HANDLER,agency_name,agency_id,start_date) values(?,?,?,?,?,?,?,?,?,?)";
        targetDb.connect();
        PreparedStatement pstm =targetDb.prepareStatement(insertSql);
        int count = 0;

        for(Order order:list){
            pstm.setString(1,order.getSaleModeID());
            pstm.setString(2,order.getStartDate());
            pstm.setString(3,order.getPolicyID());
            pstm.setDouble(4, order.getPremium());
            pstm.setString(5, order.getInsuredPerson());
            pstm.setString(6,order.getProjectName());
            pstm.setString(7,order.getHandler());
            pstm.setString(8,order.getCCICCompanyName());
            pstm.setString(9,order.getCCICCompanyCode());
            pstm.setString(10,order.getStartDate());
            pstm.addBatch();          // 加入批量处理
            count++;
        }
        pstm.executeBatch(); // 执行批量处理
        targetDb.commit();  // 提交
        System.out.println("All down : " + count);
        targetDb.close();
    }
  public static void main(String[] args)throws  Exception{
      String dbHost="localhost";
      String dbName="ccic_data";
      String dbUser="root";
      String dbPass="root";

      DbUtils sqlUtils=new MySQLUtils(dbHost,dbName,dbUser,dbPass);
      OrderDao dao=new OrderDao(sqlUtils);
      List<Order> lists=dao.getCCICOrder();
      System.out.println(lists.get(0));
      Order neworder=lists.get(0);
      neworder.setPolicyID("Pox9892030");
      neworder.setCCICCompanyName("张大大的无比的利好");
      lists.clear();
      lists.add(neworder);
      dao.insertCCICOrder(lists);
  }
}
