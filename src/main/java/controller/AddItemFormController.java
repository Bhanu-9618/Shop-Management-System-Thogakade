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

public class AddItemFormController {

    @FXML
    private JFXButton btnadditemform;

    @FXML
    private JFXTextArea txtdescription;

    @FXML
    private JFXTextArea txtitemcode;

    @FXML
    private JFXTextArea txtpacksize;

    @FXML
    private JFXTextArea txtqtyonhand;

    @FXML
    private JFXTextArea txtunitprice;

    public void btnadditemformOnAction(ActionEvent event) {

        String itemcode = txtitemcode.getText().trim();
        String description = txtdescription.getText().trim();
        String packsize = txtpacksize.getText().trim();
        String unitprice = txtunitprice.getText().trim();
        String qtyonhand = txtqtyonhand.getText().trim();

        if (itemcode.isEmpty() | description.isEmpty() | packsize.isEmpty() | unitprice.isEmpty() | qtyonhand.isEmpty()){

            System.out.println("Fill all details!");
        }else {

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade2", "root", "1234");
                String SQL = "INSERT INTO itemmanagement VALUES(?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setObject(1, itemcode);
                preparedStatement.setObject(2, description);
                preparedStatement.setObject(3, packsize);
                preparedStatement.setObject(4, unitprice);
                preparedStatement.setObject(5, qtyonhand);

                preparedStatement.executeUpdate();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
