package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ParkingSystemDetailsFormController {
    public AnchorPane parkingDetailsAnchorPaneContext;
    public AnchorPane tableAnchorPaneContext;
    public ComboBox cmbSelectOption;

    private static ArrayList<String> SelectParkDelivery=new ArrayList<>();

    static {
        SelectParkDelivery.add("In Parking");
        SelectParkDelivery.add("On Delivery");
    }
    public void initialize() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        for (String temp1 : SelectParkDelivery
        ) {
            obList.add(temp1);
        }
        cmbSelectOption.setItems(obList);
    }


    public void onLogout(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) parkingDetailsAnchorPaneContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ParkingSystemForm.fxml"))));
    }

    public void onAddVehicle(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddNewVehicleForm.fxml"));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void onAddDriver(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddDriverForm.fxml"));
        Parent parent=loader.load();
        Scene scene=new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void selectOption(ActionEvent actionEvent) throws IOException {
        if(cmbSelectOption.getValue().equals("In Parking")){
            URL resource = getClass().getResource("../view/InParkingForm.fxml");
            Parent load = FXMLLoader.load(resource);
            tableAnchorPaneContext.getChildren().clear();
            tableAnchorPaneContext.getChildren().add(load);
        }else if(cmbSelectOption.getValue().equals("On Delivery")){
            URL resource = getClass().getResource("../view/OnDeliveryForm.fxml");
            Parent load = FXMLLoader.load(resource);
            tableAnchorPaneContext.getChildren().clear();
            tableAnchorPaneContext.getChildren().add(load);
        }

    }
}
