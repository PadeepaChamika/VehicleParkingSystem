package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;

import static controller.DataController.DriverList;
import static controller.DataController.VehicleList;

public class AddDriverFormController {
    public AnchorPane addDriverAnchorPaneContext;
    public TextField txtName;
    public TextField txtNic;
    public TextField txtLNo;
    public TextField txtAddress;
    public TextField txtContact;

    public void onAddDriver(ActionEvent actionEvent) {
        try {
            Driver driver = new Driver(txtName.getText(), (String) txtNic.getText(), txtLNo.getText(),txtAddress.getText(),txtContact.getText());
            if (txtNic.getText().equals("")& txtName.getText().equals("")) {
                new Alert(Alert.AlertType.CONFIRMATION, "Invalid Input ", ButtonType.OK).show();
            } else {
                if (DriverList.add(driver)) {

                    txtName.clear();
                    txtNic.clear();
                    txtLNo.clear();
                    txtAddress.clear();
                    txtContact.clear();
                    //initialize();
                    System.out.println(VehicleList.toString());
                    new Alert(Alert.AlertType.CONFIRMATION, "Vehicle details saved successfully", ButtonType.OK).show();
                }
            }
        }catch(NumberFormatException e){
            new Alert(Alert.AlertType.WARNING, "Please try again..!\n Fill all data Or Enter correct data format.. ", ButtonType.CLOSE).show();
        }
        Stage stage= (Stage)addDriverAnchorPaneContext.getScene().getWindow();
        stage.close();

    }

    public void moveToNic(ActionEvent actionEvent) {
        txtNic.requestFocus();
    }

    public void moveToLNo(ActionEvent actionEvent) {
        txtLNo.requestFocus();
    }

    public void moveToAddress(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void moveToContact(ActionEvent actionEvent) {
        txtContact.requestFocus();
    }
}
