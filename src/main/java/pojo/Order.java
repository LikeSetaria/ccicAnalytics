package pojo;

/**
 * Created by 宝超 on 2017/6/10.
 */
public class Order {
    private String policyID;//保单号
    private String saleModeID;//销售方式
    private String orderDate;//保单日期
    private double premium;//保费
    private String insuredPerson;//确保人
    private String CCICCompanyCode;//大地保险分支机构码
    private String CCICCompanyName;//大地保险分支机构名称
    private String handler;//操作员
    private String projectName;//服务商名称
    private String startDate;//开始日期
    public String getPolicyID() {
        return policyID;
    }

    public void setPolicyID(String policyID) {
        this.policyID = policyID;
    }

    public String getSaleModeID() {
        return saleModeID;
    }

    public void setSaleModeID(String saleModeID) {
        this.saleModeID = saleModeID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public String getInsuredPerson() {
        return insuredPerson;
    }

    public void setInsuredPerson(String insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public String getCCICCompanyCode() {
        return CCICCompanyCode;
    }

    public void setCCICCompanyCode(String CCICCompanyCode) {
        this.CCICCompanyCode = CCICCompanyCode;
    }

    public String getCCICCompanyName() {
        return CCICCompanyName;
    }

    public void setCCICCompanyName(String CCICCompanyName) {
        this.CCICCompanyName = CCICCompanyName;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "ccicOrder{" +
                "policyID='" + policyID + '\'' +
                ", saleModeID=" + saleModeID +
                ", orderDate='" + orderDate + '\'' +
                ", premium=" + premium +
                ", insuredPerson='" + insuredPerson + '\'' +
                ", CCICCompanyCode='" + CCICCompanyCode + '\'' +
                ", CCICCompanyName='" + CCICCompanyName + '\'' +
                ", handler='" + handler + '\'' +
                ", projectName='" + projectName + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
