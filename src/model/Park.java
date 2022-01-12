package model;

public class Park {
    private String vehicleNum;
    private String vehicleTypeP;
    private String parkingSlot;
    private String date;


    public Park() {
    }

    public Park(String vehicleNum, String vehicleTypeP, String parkingSlot, String date) {
        this.vehicleNum = vehicleNum;
        this.vehicleTypeP = vehicleTypeP;
        this.parkingSlot = parkingSlot;
        this.date = date;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getVehicleTypeP() {
        return vehicleTypeP;
    }

    public void setVehicleTypeP(String vehicleTypeP) {
        this.vehicleTypeP = vehicleTypeP;
    }

    public String getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(String parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
