package mybatis.pojo;

/**
 * Created by 宝超 on 2017/6/11.
 */
public class OrderDetail {
    private String date;
    private String VIPUserName;//会员名称
    private String providerName;//服务商名称
    private String VIPNo;//会员卡号
    private String CarLicenseNo;//车牌号
    private String policyID;//保单号
    private double usedIntegral;//已使用积分
    private int paintCount;//已使用油漆保养次数。默认为0次
    private int maintenanceCount;//保养次数，默认为0次
    private int washCount;//洗车次数，默认为0次
    private int annualInspectionCount;//年检次数
    private int illegalHandledCount;//违章处理次数
    private String memo;//备注

    public String getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    private String orderDetailID;//主键，由保单号和日期合并构成



    public int getAnnualInspectionCount() {
        return annualInspectionCount;
    }

    public void setAnnualInspectionCount(int annualInspectionCount) {
        this.annualInspectionCount = annualInspectionCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVIPUserName() {
        return VIPUserName;
    }

    public void setVIPUserName(String VIPUserName) {
        this.VIPUserName = VIPUserName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getVIPNo() {
        return VIPNo;
    }

    public void setVIPNo(String VIPNo) {
        this.VIPNo = VIPNo;
    }

    public String getCarLicenseNo() {
        return CarLicenseNo;
    }

    public void setCarLicenseNo(String carLicenseNo) {
        CarLicenseNo = carLicenseNo;
    }

    public String getPolicyID() {
        return policyID;
    }

    public void setPolicyID(String policyID) {
        this.policyID = policyID;
    }

    public double getUsedIntegral() {
        return usedIntegral;
    }

    public void setUsedIntegral(double usedIntegral) {
        this.usedIntegral = usedIntegral;
    }

    public int getPaintCount() {
        return paintCount;
    }

    public void setPaintCount(int paintCount) {
        this.paintCount = paintCount;
    }

    public int getMaintenanceCount() {
        return maintenanceCount;
    }

    public void setMaintenanceCount(int maintenanceCount) {
        this.maintenanceCount = maintenanceCount;
    }

    public int getWashCount() {
        return washCount;
    }

    public void setWashCount(int washCount) {
        this.washCount = washCount;
    }

    public int getIllegalHandledCount() {
        return illegalHandledCount;
    }

    public void setIllegalHandledCount(int illegalHandledCount) {
        this.illegalHandledCount = illegalHandledCount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "date='" + date + '\'' +
                ", VIPUserName='" + VIPUserName + '\'' +
                ", providerName='" + providerName + '\'' +
                ", VIPNo='" + VIPNo + '\'' +
                ", CarLicenseNo='" + CarLicenseNo + '\'' +
                ", policyID='" + policyID + '\'' +
                ", usedIntegral=" + usedIntegral +
                ", paintCount=" + paintCount +
                ", maintenanceCount=" + maintenanceCount +
                ", washCount=" + washCount +
                ", annualInspectionCount=" + annualInspectionCount +
                ", illegalHandledCount=" + illegalHandledCount +
                ", memo='" + memo + '\'' +
                ", orderDetailID='" + orderDetailID + '\'' +
                '}';
    }
}
