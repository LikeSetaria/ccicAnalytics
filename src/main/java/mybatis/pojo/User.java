package mybatis.pojo;

import java.util.Date;

/**
 * Created by 宝超 on 2017/6/26.
 */
public class User {
    private String vipNo;
    private String vipLevel;
    private String vipName;
    private String IDNo;
    private String telephone;
    private String vehicleType;
    private String carLicenseNo;
    private String chassisNo;
    private String insuranceStartTime;
    private String insuranceDuration;
    private String policyNo;
    private double premium;
    private String ownershipInstitution;
    private String source;
    private String assignProvider;
    private double vipValue;
    private int VAS_paint;
    private int VAS_maintenance;
    private int VAS_wash;
    private int VAS_AnnualInspection;
    private int VAS_other1;
    private int VAS_other2;
    private String memo;

    public String getVipNo() {
        return vipNo;
    }

    public void setVipNo(String vipNo) {
        this.vipNo = vipNo;
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String level) {
        this.vipLevel = level;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getIDNo() {
        return IDNo;
    }

    public void setIDNo(String IDNo) {
        this.IDNo = IDNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCarLicenseNo() {
        return carLicenseNo;
    }

    public void setCarLicenseNo(String carLicenseNo) {
        this.carLicenseNo = carLicenseNo;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getInsuranceStartTime() {
        return insuranceStartTime;
    }

    public void setInsuranceStartTime(String insuranceStartTime) {
        this.insuranceStartTime = insuranceStartTime;
    }

    public String getInsuranceDuration() {
        return insuranceDuration;
    }

    public void setInsuranceDuration(String insuranceDuration) {
        this.insuranceDuration = insuranceDuration;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public String getOwnershipInstitution() {
        return ownershipInstitution;
    }

    public void setOwnershipInstitution(String ownershipInstitution) {
        this.ownershipInstitution = ownershipInstitution;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAssignProvider() {
        return assignProvider;
    }

    public void setAssignProvider(String assignProvider) {
        this.assignProvider = assignProvider;
    }

    public double getVipValue() {
        return vipValue;
    }

    public void setVipValue(double vipValue) {
        this.vipValue = vipValue;
    }

    public int getVAS_paint() {
        return VAS_paint;
    }

    public void setVAS_paint(int VAS_paint) {
        this.VAS_paint = VAS_paint;
    }

    public int getVAS_maintenance() {
        return VAS_maintenance;
    }

    public void setVAS_maintenance(int VAS_maintenance) {
        this.VAS_maintenance = VAS_maintenance;
    }

    public int getVAS_wash() {
        return VAS_wash;
    }

    public void setVAS_wash(int VAS_wash) {
        this.VAS_wash = VAS_wash;
    }

    public int getVAS_AnnualInspection() {
        return VAS_AnnualInspection;
    }

    public void setVAS_AnnualInspection(int VAS_AnnualInspection) {
        this.VAS_AnnualInspection = VAS_AnnualInspection;
    }

    public int getVAS_other1() {
        return VAS_other1;
    }

    public void setVAS_other1(int VAS_other1) {
        this.VAS_other1 = VAS_other1;
    }

    public int getVAS_other2() {
        return VAS_other2;
    }

    public void setVAS_other2(int VAS_other2) {
        this.VAS_other2 = VAS_other2;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "User{" +
                "vipNo='" + vipNo + '\'' +
                ", vipLevel='" + vipLevel + '\'' +
                ", vipName='" + vipName + '\'' +
                ", IDNo='" + IDNo + '\'' +
                ", telephone='" + telephone + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", carLicenseNo='" + carLicenseNo + '\'' +
                ", chassisNo='" + chassisNo + '\'' +
                ", insuranceStartTime='" + insuranceStartTime + '\'' +
                ", insuranceDuration='" + insuranceDuration + '\'' +
                ", policyNo='" + policyNo + '\'' +
                ", premium=" + premium +
                ", ownershipInstitution='" + ownershipInstitution + '\'' +
                ", source='" + source + '\'' +
                ", assignProvider='" + assignProvider + '\'' +
                ", vipValue=" + vipValue +
                ", VAS_paint='" + VAS_paint + '\'' +
                ", VAS_maintenance='" + VAS_maintenance + '\'' +
                ", VAS_wash='" + VAS_wash + '\'' +
                ", VAS_AnnualInspection='" + VAS_AnnualInspection + '\'' +
                ", VAS_other1='" + VAS_other1 + '\'' +
                ", VAS_other2='" + VAS_other2 + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
