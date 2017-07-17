package mybatis.dao;

import mybatis.pojo.OrderDetail;
import mybatis.pojo.User;
import core.utils.DbUtils;
import core.utils.MySQLUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 宝超 on 2017/6/26.
 */
public class UserDao {
    private DbUtils targetDb;
    public UserDao(DbUtils targetDb)throws Exception{
        this.targetDb=targetDb;
    }
    public List<User> getCCICUsers()throws Exception {
        List<User> list= new ArrayList<User>();
        String sql = "SELECT  vipNo,vipLevel,vipName,IDNo,telephone,vehicleType,carLicenseNo,chassisNo,insuranceStartTime,insuranceDuration,policyNo,premium," +
                "ownershipInstitution, source,assignProvider,vipValue,VAS_paint,VAS_maintenance,VAS_wash,VAS_AnnualInspection,VAS_other1,VAS_other2,memo FROM ccic_vip_users";
        ResultSet rs;

        if (targetDb.isClosed()) {
            targetDb.connect();
        }
        rs = targetDb.executeQuery(sql);
        while(rs.next()){
           User user=new User();
            user.setVipNo(rs.getString("vipNo"));
            user.setVipLevel(rs.getString("vipLevel"));
            user.setVipName(rs.getString("vipName"));
            user.setIDNo(rs.getString("IDNo"));
            user.setTelephone(rs.getString("telephone"));
            user.setVehicleType(rs.getString("vehicleType"));
            user.setCarLicenseNo(rs.getString("carLicenseNo"));
            user.setChassisNo(rs.getString("chassisNo"));
            user.setInsuranceStartTime(rs.getString("insuranceStartTime"));
            user.setInsuranceDuration(rs.getString("insuranceDuration"));
            user.setPolicyNo(rs.getString("policyNo"));
            user.setPremium(rs.getDouble("premium"));
            user.setOwnershipInstitution(rs.getString("ownershipInstitution"));
            user.setSource(rs.getString("source"));
            user.setAssignProvider(rs.getString("assignProvider"));
            user.setVipValue(rs.getDouble("vipValue"));
            user.setVAS_paint(rs.getInt("VAS_paint"));
            user.setVAS_maintenance(rs.getInt("VAS_maintenance"));
            user.setVAS_wash(rs.getInt("VAS_wash"));
            user.setVAS_AnnualInspection(rs.getInt("VAS_AnnualInspection"));
            user.setVAS_other1(rs.getInt("VAS_other1"));
            user.setVAS_other2(rs.getInt("VAS_other2"));
            user.setMemo(rs.getString("memo"));
            list.add(user);
        }
        rs.close();
        return list;
    }
    public void insertCCICUser(List<User> list)throws  Exception{
        String insertSql="insert into ccic_vip_users (vipNo,vipLevel,vipName,IDNo,telephone,vehicleType,carLicenseNo,chassisNo,insuranceStartTime,insuranceDuration,policyNo,premium,ownershipInstitution, source,assignProvider,vipValue,VAS_paint,VAS_maintenance,VAS_wash,VAS_AnnualInspection,VAS_other1,VAS_other2,memo ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        targetDb.connect();
        PreparedStatement pstm =targetDb.prepareStatement(insertSql);
        int count = 0;
        for(User user:list){
            pstm.setString(1,user.getVipNo());
            pstm.setString(2,user.getVipLevel());
            pstm.setString(3,user.getVipName());
            pstm.setString(4, user.getIDNo());
            pstm.setString(5, user.getTelephone());
            pstm.setString(6,user.getVehicleType());
            pstm.setString(7, user.getCarLicenseNo());
            pstm.setString(8, user.getChassisNo());

            pstm.setString(9, user.getInsuranceStartTime());
            // System.out.println(user.getInsuranceStartTime());
            pstm.setString(10, user.getInsuranceDuration());
            pstm.setString(11,user.getPolicyNo());
            pstm.setDouble(12, user.getPremium());
            pstm.setString(13, user.getOwnershipInstitution());
            pstm.setString(14, user.getSource());
            pstm.setString(15, user.getAssignProvider());
            pstm.setDouble(16, user.getVipValue());
            pstm.setInt(17, user.getVAS_paint());
            pstm.setInt(18, user.getVAS_maintenance());
            pstm.setInt(19, user.getVAS_wash());
            pstm.setInt(20, user.getVAS_AnnualInspection());
            pstm.setInt(21, user.getVAS_other1());
            pstm.setInt(22, user.getVAS_other2());
            pstm.setString(23, user.getMemo());
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
