package model;

public class Delivery {
    private String vehicleNum;
    private String vehicleType;
    private String driverName;
    private String leftDate;
    private String leftTime;

    public Delivery() {
    }

    public Delivery(String vehicleNum, String vehicleType, String driverName, String leftDate, String leftTime) {
        this.setVehicleNum(vehicleNum);
        this.setVehicleType(vehicleType);
        this.setDriverName(driverName);
        this.setLeftDate(leftDate);
        this.setLeftTime(leftTime);
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLeftDate() {
        return leftDate;
    }

    public void setLeftDate(String leftDate) {
        this.leftDate = leftDate;
    }

    public String getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(String leftTime) {
        this.leftTime = leftTime;
    }
    @Override
    public String toString() {
        return "OnDelivery{" +
                "vehicleNumber='" + vehicleNum + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", driverName='" + driverName + '\'' +
                ", leftTime='" + leftTime + '\'' +
                '}';
    }
}
