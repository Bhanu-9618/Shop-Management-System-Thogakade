package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateitemFormController {

    @FXML
    private JFXButton btnupdateitem;

    @FXML
    private JFXTextArea txtnewdescription;

    @FXML
    private JFXTextArea txtnewitemcode;

    @FXML
    private JFXTextArea txtnewpacksize;

    @FXML
    private JFXTextArea txtnewqtyonhand;

    @FXML
    private JFXTextArea txtnewunitprice;

    @FXML
    private JFXTextArea txtupdateitemcode;


    public void btnupdateitemOnAction(javafx.event.ActionEvent event) {

        String updateitemcode = txtupdateitemcode.getText().trim();
        String itemcode = txtnewitemcode.getText().trim();
        String description = txtnewdescription.getText().trim();
        String packsize = txtnewpacksize.getText().trim();
        String unitprice = txtnewunitprice.getText().trim();
        String qtyonhand = txtnewqtyonhand.getText().trim();

        if (updateitemcode.isEmpty()) {

            System.out.println("Input itemcode you want to update!");

        } else {

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade2", "root", "1234");

                if (!description.isEmpty()){
                    String SQL = "UPDATE itemmanagement SET description = ? WHERE itemcode = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, description);
                    preparedStatement.setObject(2, updateitemcode);

                    preparedStatement.executeUpdate();

                }
                if (!packsize.isEmpty()){
                    String SQL = "UPDATE itemmanagement SET packsize = ? WHERE itemcode = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, packsize);
                    preparedStatement.setObject(2, updateitemcode);

                    preparedStatement.executeUpdate();

                }
                if (!unitprice.isEmpty()){
                    String SQL = "UPDATE itemmanagement SET unitprice = ? WHERE itemcode = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, unitprice);
                    preparedStatement.setObject(2, updateitemcode);

                    preparedStatement.executeUpdate();

                }
                if (!qtyonhand.isEmpty()){
                    String SQL = "UPDATE itemmanagement SET qty_on_hand = ? WHERE itemcode = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, qtyonhand);
                    preparedStatement.setObject(2, updateitemcode);

                    preparedStatement.executeUpdate();

                }
                if (!itemcode.isEmpty()){
                    String SQL = "UPDATE itemmanagement SET itemcode = ? WHERE itemcode = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, itemcode);
                    preparedStatement.setObject(2, updateitemcode);

                    preparedStatement.executeUpdate();

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
