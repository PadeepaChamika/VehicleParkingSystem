package controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class OnDeliveryFormController {
    public AnchorPane onDeliveryFormAnchorPaneContext;
    public TableView tblOnDelivery;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;
    public TableColumn colLeftDate;

    public void initialize(){
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory("vehicleNum"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory("driverName"));
        colLeftDate.setCellValueFactory(new PropertyValueFactory("leftDate"));

        tblOnDelivery.setItems(FXCollections.observableArrayList(DataController.DeliveryList));
    }
}
