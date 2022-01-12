package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;


import javax.swing.*;


import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static controller.DataController.*;

public class ParkingSystemFormController {
    public AnchorPane parkingSystemAnchorPaneContext;
    public ComboBox <String> cmbVehicle;
    public ComboBox <String>cmbDriver;
    //public AnchorPane loginAnchorPaneContext;
    public TextField currentDate;
    public TextField currentTime;
    public Label lblSlotNum;
    public JFXButton btnParkVehicle;
    public JFXButton btnOnDelivery;
    public Label txtVehicleType;
    String vehicleNumber;


    public void setDisable(String vehicleNumber){
        for (Park p : ParkingList) {
            if (p.getVehicleNum().equals(vehicleNumber)) {
                cmbDriver.setDisable(false);
                btnParkVehicle.setDisable(true);
                btnOnDelivery.setDisable(false);

                break;
            }else{
                for (DriverSearch s :driverSearch) {
                    if(cmbVehicle.getSelectionModel().getSelectedItem().equals(s.getVehicleNumber())){
                        cmbDriver.setValue(s.getDriverName());
                        cmbDriver.setDisable(true);
                        break;
                    }
                }
                btnParkVehicle.setDisable(false);
                btnOnDelivery.setDisable(true);
            }
        }
    }

    public void initialize(){
        try {
            new Timer(1000, e -> {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss aa");
                String time = simpleDateFormat.format(new Date());
                String date = new SimpleDateFormat("MMM/dd/YYYY", Locale.ENGLISH).format(new Date());
                currentDate.setText(date);
                currentTime.setText(time);
            }).start();
        } catch (Exception exception) {

        }

        cmbVehicle.getItems().clear();
        for (Vehicle v : VehicleList) {
            cmbVehicle.getItems().add(v.getVehicleNumber());
        }
        cmbDriver.getItems().clear();
        for (Driver dr : DriverList) {
            cmbDriver.getItems().add(dr.getDriverName());
        }
        cmbVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                for (Vehicle v : VehicleList) {
                    if (newValue.equals(v.getVehicleNumber())) {
                       txtVehicleType.setText(" " + v.getVehicleType());
                        vehicleNumber = v.getVehicleNumber();
                        if (ParkingList.size() == 0) {
                            btnParkVehicle.setDisable(false);
                            btnOnDelivery.setDisable(true);
                            for (DriverSearch s : driverSearch) {
                                if (cmbVehicle.getSelectionModel().getSelectedItem().equals(s.getVehicleNumber())) {
                                    cmbDriver.setValue(s.getDriverName());
                                    cmbDriver.setDisable(true);
                                    break;
                                }
                            }
                        } else {
                            setDisable((String) newValue);
                        }
                    }
                }
            } catch (Exception ex) {
            }
        });


    }

    public void onParkVehicle(ActionEvent actionEvent) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm aa");
        Date date = new Date();
        String dateAndTime = formatter.format(date);
        for (Delivery d : DeliveryList) {
            if(d.getVehicleNum().equalsIgnoreCase(cmbVehicle.getSelectionModel().getSelectedItem())){
                DeliveryList.remove(d);

                if(txtVehicleType.getText().equalsIgnoreCase(" Van")){
                    for (SlotNumber s : vanSlot) {
                        if(s.getVehicleNumber().equalsIgnoreCase("null")) {
                            String slotNumber = s.getSlotNumber();
                            lblSlotNum.setText(slotNumber);
                            Park inParking1 = new Park(cmbVehicle.getSelectionModel().getSelectedItem(),txtVehicleType.getText(),slotNumber,dateAndTime);
                            ParkingList.add(inParking1);
                            s.setVehicleNumber(cmbVehicle.getSelectionModel().getSelectedItem());
                            break;
                        }
                    }
                }
                if(txtVehicleType.getText().equalsIgnoreCase(" Bus")){
                    for (SlotNumber s : busSlot) {
                        if(s.getVehicleNumber().equalsIgnoreCase("null")) {
                            String slotNumber = s.getSlotNumber();
                            lblSlotNum.setText(slotNumber);

                            Park inParking1 = new Park(cmbVehicle.getSelectionModel().getSelectedItem(),txtVehicleType.getText(),slotNumber,dateAndTime);
                            ParkingList.add(inParking1);

                            s.setVehicleNumber(cmbVehicle.getSelectionModel().getSelectedItem());
                            break;
                        }
                    }
                }

                if(txtVehicleType.getText().equalsIgnoreCase(" Cargo Lorry")){
                    for (SlotNumber s : cargoLorrySlot) {
                        if(s.getVehicleNumber().equalsIgnoreCase("null")) {
                            String slotNumber = s.getSlotNumber();
                            lblSlotNum.setText(slotNumber);

                            Park inParking1 = new Park(cmbVehicle.getSelectionModel().getSelectedItem(),txtVehicleType.getText(),slotNumber,dateAndTime);
                            ParkingList.add(inParking1);

                            s.setVehicleNumber(cmbVehicle.getSelectionModel().getSelectedItem());
                            break;
                        }
                    }
                }
                new Alert(Alert.AlertType.CONFIRMATION, "You Can Park now", ButtonType.OK).show();
            }
        }
        for (DriverSearch d : driverSearch) {
            if(cmbVehicle.getSelectionModel().getSelectedItem().equals(d.getVehicleNumber())){
                driverSearch.remove(d);
                break;
            }
        }
    }

    public void onDeliveryShift(ActionEvent actionEvent) throws IOException {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm aa");
            Date date = new Date();
            String dateAndTime = formatter.format(date);
            if (!cmbVehicle.getSelectionModel().getSelectedItem().equals("null") && !cmbDriver.getSelectionModel().getSelectedItem().equals("null")) {
                for (Park p : ParkingList) {
                    if (p.getVehicleNum().equalsIgnoreCase(cmbVehicle.getSelectionModel().getSelectedItem())) {
                        ParkingList.remove(p);
                        Delivery onDelivery1 = new Delivery(cmbVehicle.getSelectionModel().getSelectedItem(),txtVehicleType.getText(), cmbDriver.getSelectionModel().getSelectedItem(), dateAndTime,"null");
                        DeliveryList.add(onDelivery1);
                        DriverSearch driverSearch1 = new DriverSearch(cmbVehicle.getSelectionModel().getSelectedItem(), cmbDriver.getSelectionModel().getSelectedItem());
                        driverSearch.add(driverSearch1);
                        if (txtVehicleType.getText().equalsIgnoreCase(" Van")) {
                            for (SlotNumber s : vanSlot) {
                                if (cmbVehicle.getSelectionModel().getSelectedItem().equalsIgnoreCase(s.getVehicleNumber())) {
                                    s.setVehicleNumber("null");
                                }
                            }
                        }
                        if (txtVehicleType.getText().equalsIgnoreCase(" Bus")) {
                            for (SlotNumber s : busSlot) {
                                if (cmbVehicle.getSelectionModel().getSelectedItem().equalsIgnoreCase(s.getVehicleNumber())) {
                                    s.setVehicleNumber("null");
                                }
                            }
                        }
                        if (txtVehicleType.getText().equalsIgnoreCase(" Cargo Lorry")) {
                            for (SlotNumber s : cargoLorrySlot) {
                                if (cmbVehicle.getSelectionModel().getSelectedItem().equalsIgnoreCase(s.getVehicleNumber())) {
                                    s.setVehicleNumber("null");
                                }
                            }
                        }
                        new Alert(Alert.AlertType.CONFIRMATION, "You can Deliver now..", ButtonType.OK).show();

                        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
                        Parent load = FXMLLoader.load(resource);
                        parkingSystemAnchorPaneContext.getChildren().clear();
                        parkingSystemAnchorPaneContext.getChildren().add(load);

                    }
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "Please fill all fields and try again...", ButtonType.CLOSE).show();
            }


        }catch (Exception e){}

    }


    public void onManagementLogin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        parkingSystemAnchorPaneContext.getChildren().clear();
        parkingSystemAnchorPaneContext.getChildren().add(load);
    }
}
