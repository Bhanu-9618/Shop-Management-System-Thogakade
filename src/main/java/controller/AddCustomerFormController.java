package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    @FXML
    private JFXButton btnaddcustform;

    @FXML
    private JFXComboBox<String> comboprovince;

    @FXML
    private JFXComboBox<String> combotitle;

    @FXML
    private DatePicker datedob;

    @FXML
    private JFXTextArea txtaddress;

    @FXML
    private JFXTextArea txtcity;

    @FXML
    private JFXTextArea txtcustid;

    @FXML
    private JFXTextArea txtname;

    @FXML
    private JFXTextArea txtpostalcode;

    @FXML
    private JFXTextArea txtsalary;

    public void btnaddcustformOnAction(ActionEvent event) {

        String custid = txtcustid.getText().trim();
        String title = combotitle.getValue();
        String name = txtname.getText().trim();
        LocalDate dob = datedob.getValue();
        String salary = txtsalary.getText().trim();
        String address = txtaddress.getText().trim();
        String city = txtcity.getText().trim();
        String province = comboprovince.getValue();
        String postalcode = txtpostalcode.getText().trim();


        if ((custid.isEmpty()) || (title==null) || (name.isEmpty()) || (dob==null) || (salary.isEmpty() ) || (address.isEmpty() ) || (city.isEmpty()) || (province==null) || (postalcode.isEmpty())){

                System.out.println("fill all details!");
                return;

            }else {

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade2", "root", "1234");
                    String SQL = "INSERT INTO customermanagement VALUES(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, custid);
                    preparedStatement.setObject(2, title);
                    preparedStatement.setObject(3, name);
                    preparedStatement.setObject(4, dob);
                    preparedStatement.setObject(5, salary);
                    preparedStatement.setObject(6, address);
                    preparedStatement.setObject(7, city);
                    preparedStatement.setObject(8, province);
                    preparedStatement.setObject(9, postalcode);

                    preparedStatement.executeUpdate();

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.close();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> titles = FXCollections.observableArrayList(
                "Mr",
                "Mrs",
                "Ms"
        );
        combotitle.setItems(titles);

        ObservableList<String> provinces = FXCollections.observableArrayList(
                "Northern",
                "Western",
                "Central",
                "Southern",
                "Eastern",
                "North western",
                "Sabaragamuwa",
                "Uwa",
                "North Central"
        );
        comboprovince.setItems(provinces);
    }
}
