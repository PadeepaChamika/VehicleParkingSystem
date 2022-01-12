package model;

public class Vehicle {
    private String vehicleNumber;
    private String vehicleType;
    private String maxWeight;
    private String passenger;

    public Vehicle() {
    }

    public Vehicle(String vehicleNumber, String vehicleType, String maxWeight, String passenger) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        this.setMaxWeight(maxWeight);
        this.setPassenger(passenger);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(String maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }
    @Override
    public String toString() {
        return "Vehicle{" +
                "VNum='" + vehicleNumber + '\'' +
                ", VType='" + vehicleType + '\'' +
                ", VMaximumWeight=" + maxWeight+
                ", VNumOfPassengers=" + passenger +
                '}';
    }
}
