package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainWindowController {

    Stage Custmanagement = new Stage();
    Stage Itemmanagement = new Stage();

    public void btnCustManagementOnAction(ActionEvent event) {

        try {
            Custmanagement.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerManagement.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Custmanagement.show();
    }

    public void btnItemManagementOnAction(ActionEvent event) {

        try {
            Itemmanagement.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ItemManagement.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Itemmanagement.show();
    }
}
