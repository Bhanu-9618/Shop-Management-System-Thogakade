package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteitemFormController {

    @FXML
    private JFXButton btndeleterow;

    @FXML
    private JFXTextArea txtdeleteitemcode;

    public void btndeleterowonAction(ActionEvent event) {

        String itemcode = txtdeleteitemcode.getText();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade2", "root", "1234");
            String SQL = "DELETE FROM itemmanagement\n" +
                    "WHERE itemcode = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, itemcode);
            preparedStatement.executeUpdate();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
