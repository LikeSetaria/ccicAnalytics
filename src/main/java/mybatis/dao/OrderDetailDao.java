package mybatis.dao;

import core.utils.DbUtils;
import mybatis.pojo.OrderDetail;
import core.utils.MySQLUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 宝超 on 2017/6/10.
 */
public class OrderDetailDao {
    private DbUtils targetDb;
    public OrderDetailDao(DbUtils targetDb)throws Exception{
       this.targetDb=targetDb;
   }
    public List<OrderDetail> getCCICOrderDetail()throws Exception {
        List<OrderDetail> list= new ArrayList<OrderDetail>();
        String sql = "SELECT  orderDate,VIPUserName,providerName,VIPNo,CarLicenseNo," +
                "policyID,usedIntegral,paintCount,maintenanceCount,washCount,annualInspectionCount,illegalHandledCount,memo,orderDetailID FROM ccic_order_detail";
        ResultSet rs;

        if (targetDb.isClosed()) {
            targetDb.connect();
        }
        rs = targetDb.executeQuery(sql);
        while(rs.next()){
            OrderDetail order=new OrderDetail();
            order.setDate(rs.getString("orderDate"));
            order.setVIPUserName(rs.getString("VIPUserName"));
            order.setProviderName(rs.getString("providerName"));
            order.setVIPNo(rs.getString("VIPNo"));
            order.setCarLicenseNo(rs.getString("CarLicenseNo"));
            order.setPolicyID(rs.getString("policyID"));
            order.setUsedIntegral(rs.getDouble("usedIntegral"));
            order.setPaintCount(rs.getInt("paintCount"));
            order.setMaintenanceCount(rs.getInt("maintenanceCount"));
            order.setWashCount(rs.getInt("washCount"));
            order.setAnnualInspectionCount(rs.getInt("annualInspectionCount"));
            order.setIllegalHandledCount(rs.getInt("illegalHandledCount"));
            order.setMemo(rs.getString("memo"));
            order.setOrderDetailID(rs.getString("orderDetailID"));
            list.add(order);
        }
        rs.close();
        return list;
    }
    public void insertCCICOrder(List<OrderDetail> list)throws  Exception{
        String insertSql="insert into ccic_order_detail ( orderDate,VIPUserName,providerName,VIPNo,CarLicenseNo,policyID,usedIntegral,paintCount,maintenanceCount,washCount,annualInspectionCount,illegalHandledCount,memo,orderDetailID) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        targetDb.connect();
        PreparedStatement pstm =targetDb.prepareStatement(insertSql);
        int count = 0;
        for(OrderDetail orderDetail:list){
            pstm.setString(1,orderDetail.getDate());
            pstm.setString(2,orderDetail.getVIPUserName());
            pstm.setString(3,orderDetail.getProviderName());
            pstm.setString(4, orderDetail.getVIPNo());
            pstm.setString(5, orderDetail.getCarLicenseNo());
            pstm.setString(6,orderDetail.getPolicyID());
            pstm.setDouble(7, orderDetail.getUsedIntegral());
            pstm.setInt(8, orderDetail.getPaintCount());
            pstm.setInt(9, orderDetail.getMaintenanceCount());
            pstm.setInt(10, orderDetail.getWashCount());
            pstm.setInt(11,orderDetail.getAnnualInspectionCount());
            pstm.setInt(12,orderDetail.getIllegalHandledCount());
            pstm.setString(13, orderDetail.getMemo());

            pstm.setString(14,orderDetail.getOrderDetailID());

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
      OrderDetailDao dao=new OrderDetailDao(sqlUtils);
      List<OrderDetail> lists=dao.getCCICOrderDetail();
      System.out.println(lists.get(0));
//      Order neworder=lists.get(0);
//      neworder.setPolicyID("Pox9892030");
//      neworder.setCCICCompanyName("张大大的无比的利好");
//      lists.clear();
      //lists.add(neworder);
      //dao.insertCCICOrder(lists);
  }
}
