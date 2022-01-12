package model;

public class Driver {
    private String driverName;
    private String NIC;
    private String drivingLNumber;
    private String address;
    private String contact;

    public Driver() {
    }

    public Driver(String driverName, String NIC, String drivingLNumber, String address, String contact) {
        this.setDriverName(driverName);
        this.setNIC(NIC);
        this.setDrivingLNumber(drivingLNumber);
        this.setAddress(address);
        this.setContact(contact);
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getDrivingLNumber() {
        return drivingLNumber;
    }

    public void setDrivingLNumber(String drivingLNumber) {
        this.drivingLNumber = drivingLNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    @Override
    public String toString() {
        return "Driver{" +
                "Name='" + driverName + '\'' +
                ", NIC='" + NIC + '\'' +
                ", LNum='" + drivingLNumber + '\'' +
                ", Address='" + address + '\'' +
                ", Contact='" + contact + '\'' +
                '}';
    }
}
