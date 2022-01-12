package controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class InParkingFormController {
    public AnchorPane inParkingFormAnchorPaneContext;
    public TableView tblInParking;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedDate;

    public void initialize(){
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory("vehicleNum"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleTypeP"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory("parkingSlot"));
        colParkedDate.setCellValueFactory(new PropertyValueFactory("date"));


        tblInParking.setItems(FXCollections.observableArrayList(DataController.ParkingList));
    }
}
