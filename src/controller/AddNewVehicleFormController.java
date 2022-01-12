package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Park;
import model.SlotNumber;
import model.Vehicle;

import java.text.SimpleDateFormat;
import java.util.Date;

import static controller.DataController.*;

public class AddNewVehicleFormController {
    public AnchorPane addNewVehicleAnchorPaneContext;
    public ComboBox <String>cmbVehicleType;
    public TextField txtVehicleNumber;
    public TextField txtMaxWeight;
    public TextField txtPassenger;

    static int countBus=0;
    static int countVan=0;
    static int countLorry=0;
    public int searchAvailabilityBus(){
        for (Vehicle v : VehicleList) {
            if(v.getVehicleType().equals("Bus")){
                countBus++;
            }
        }
        return countBus;
    }
    public int searchAvailabilityVan(){
        for (Vehicle v : VehicleList) {
            if(v.getVehicleType().equals("Van")){
                countVan++;
            }
        }
        return countVan;
    }
    public int searchAvailabilityLorry(){
        for (Vehicle v : VehicleList) {
            if(v.getVehicleType().equals("Cargo Lorry")){
                countLorry++;
            }
        }
        return countLorry;
    }

    public void initialize() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        for (String temp1 : VehicleTypeList
        ) {
        obList.add(temp1);
        }
        cmbVehicleType.setItems(obList);
    }


    public void onAddVehicle(ActionEvent actionEvent) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm aa");
        Date date = new Date();
        String dateAndTime = formatter.format(date);
        try {
            if (!txtVehicleNumber.getText().equals("") && !txtMaxWeight.getText().equals("") && !txtPassenger.getText().equals("") && !cmbVehicleType.getSelectionModel().getSelectedItem().equalsIgnoreCase("null")) {
                Vehicle vehicle = new Vehicle(txtVehicleNumber.getText(), cmbVehicleType.getSelectionModel().getSelectedItem(), (txtMaxWeight.getText()), (txtPassenger.getText()));
                VehicleTypeList.remove(cmbVehicleType.getSelectionModel().getSelectedItem());
                try {
                    if (cmbVehicleType.getSelectionModel().getSelectedItem().equals("Van")) {
                        int vanCount = searchAvailabilityVan();
                        if (vanCount < 6) {
                            if (VehicleList.add(vehicle)) {
                                if (cmbVehicleType.getSelectionModel().getSelectedItem().equals("Van")) {
                                    for (SlotNumber s : vanSlot) {
                                        if (s.getVehicleNumber().equalsIgnoreCase("null")) {
                                            s.setVehicleNumber(txtVehicleNumber.getText());

                                            Park parkedVehicle1 = new Park(txtVehicleNumber.getText(), cmbVehicleType.getSelectionModel().getSelectedItem(), s.getSlotNumber(), "(newly Added) " + dateAndTime);
                                            ParkingList.add(parkedVehicle1);
                                            countVan =0;
                                            break;
                                        }
                                    }
                                }
                                txtVehicleNumber.clear();
                                txtMaxWeight.clear();
                                txtPassenger.clear();
                                cmbVehicleType.getItems().clear();
                                initialize();
                                new Alert(Alert.AlertType.CONFIRMATION, "Add successfully", ButtonType.OK).show();
                            }
                        } else {
                            new Alert(Alert.AlertType.WARNING, "You can't Add..Van Parking is full... ", ButtonType.OK).show();
                        }
                    }
                    if (cmbVehicleType.getSelectionModel().getSelectedItem().equals("Bus")) {
                        int busCount = searchAvailabilityBus();
                        if (busCount == 0) {
                            if (VehicleList.add(vehicle)) {
                                if (cmbVehicleType.getSelectionModel().getSelectedItem().equalsIgnoreCase("Bus")) {
                                    for (SlotNumber s : busSlot) {
                                        if (s.getVehicleNumber().equalsIgnoreCase("null")) {
                                            s.setVehicleNumber(txtVehicleNumber.getText());

                                            Park parkedVehicle2 = new Park(txtVehicleNumber.getText(), cmbVehicleType.getSelectionModel().getSelectedItem(), s.getSlotNumber(), "(newly Added) " + dateAndTime);
                                            ParkingList.add(parkedVehicle2);
                                            break;
                                        }
                                    }
                                }
                                txtVehicleNumber.clear();
                                txtMaxWeight.clear();
                                txtPassenger.clear();
                                cmbVehicleType.getItems().clear();
                                initialize();
                                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Details Saved", ButtonType.OK).show();
                            }
                        } else {
                            new Alert(Alert.AlertType.WARNING, "You can't Add..Bus Parking is full... ", ButtonType.OK).show();
                        }
                    }
                    if (cmbVehicleType.getSelectionModel().getSelectedItem().equals("Cargo Lorry")) {
                        int lorryCount = searchAvailabilityLorry();
                        if (lorryCount < 7) {
                            if (VehicleList.add(vehicle)) {
                                if (cmbVehicleType.getSelectionModel().getSelectedItem().equalsIgnoreCase("Cargo Lorry")) {
                                    for (SlotNumber s : cargoLorrySlot) {
                                        if (s.getVehicleNumber().equalsIgnoreCase("null")) {
                                            s.setVehicleNumber(txtVehicleNumber.getText());
                                            Park parkedVehicle3 = new Park(txtVehicleNumber.getText(), cmbVehicleType.getSelectionModel().getSelectedItem(), s.getSlotNumber(), "(newly Added) " + dateAndTime);
                                            ParkingList.add(parkedVehicle3);
                                            countLorry=0;
                                            break;
                                        }
                                    }
                                }
                                txtVehicleNumber.clear();
                                txtMaxWeight.clear();
                                txtPassenger.clear();
                                cmbVehicleType.getItems().clear();
                                initialize();
                                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Add successfully..", ButtonType.OK).show();
                            }
                        }else{
                            new Alert(Alert.AlertType.WARNING, "You can't Add..Cargo Lorry Parking is full... ", ButtonType.OK).show();
                        }
                    }
                } catch (Exception e) {}
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "please Try again.", ButtonType.OK).show();


            }
        } catch (Exception e) {


            new Alert(Alert.AlertType.CONFIRMATION, "Please try again..", ButtonType.OK).show();
        }
        Stage stage= (Stage)addNewVehicleAnchorPaneContext.getScene().getWindow();
        stage.close();
    }

    public void moveToVehicleType(ActionEvent actionEvent) {
        cmbVehicleType.requestFocus();
    }

    public void moveToPassenger(ActionEvent actionEvent) {
        txtPassenger.requestFocus();
    }

    public void moveToMaxWeight(ActionEvent actionEvent) {
        txtMaxWeight.requestFocus();
    }
}

