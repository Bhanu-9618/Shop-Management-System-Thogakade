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

public class UpdatecustFormController implements Initializable {

    @FXML
    private JFXButton btnupdatecustform;

    @FXML
    private JFXComboBox<String> newcomboprovince;

    @FXML
    private JFXComboBox<String> newcombotitle;

    @FXML
    private DatePicker newdatedob;

    @FXML
    private JFXTextArea txtnewaddress;

    @FXML
    private JFXTextArea txtnewcity;

    @FXML
    private JFXTextArea txtnewcustid;

    @FXML
    private JFXTextArea txtnewname;

    @FXML
    private JFXTextArea txtnewpostalcode;

    @FXML
    private JFXTextArea txtnewsalary;

    @FXML
    private JFXTextArea txtupdatecustid;


    public void btnupdatecustformOnAction(ActionEvent event) {

        String custidupdate = txtupdatecustid.getText().trim();
        String custid = txtnewcustid.getText().trim();
        String title = newcombotitle.getValue();
        String name = txtnewname.getText().trim();
        LocalDate dob = newdatedob.getValue();
        String salary = txtnewsalary.getText().trim();
        String address = txtnewaddress.getText().trim();
        String city = txtnewcity.getText().trim();
        String province = newcomboprovince.getValue();
        String postalcode = txtnewpostalcode.getText().trim();

        if (custidupdate.isEmpty()) {

            System.out.println("Input CustID you want to update!");

        } else {

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade2", "root", "1234");

                if (title != null){
                    String SQL = "UPDATE customermanagement SET title = ? WHERE custid = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, title);
                    preparedStatement.setObject(2, custidupdate);

                    preparedStatement.executeUpdate();

                }
                if (!name.isEmpty()){
                    String SQL = "UPDATE customermanagement SET name = ? WHERE custid = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, name);
                    preparedStatement.setObject(2, custidupdate);

                    preparedStatement.executeUpdate();

                }
                if (dob != null){
                    String SQL = "UPDATE customermanagement SET Dob = ? WHERE custid = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, dob);
                    preparedStatement.setObject(2, custidupdate);

                    preparedStatement.executeUpdate();

                }
                if (!salary.isEmpty()){
                    String SQL = "UPDATE customermanagement SET salary = ? WHERE custid = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, salary);
                    preparedStatement.setObject(2, custidupdate);

                    preparedStatement.executeUpdate();

                }
                if (!address.isEmpty()){
                    String SQL = "UPDATE customermanagement SET address = ? WHERE custid = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, address);
                    preparedStatement.setObject(2, custidupdate);

                    preparedStatement.executeUpdate();

                }
                if (!city.isEmpty()){
                    String SQL = "UPDATE customermanagement SET city = ? WHERE custid = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, city);
                    preparedStatement.setObject(2, custidupdate);

                    preparedStatement.executeUpdate();

                }
                if (province != null){
                    String SQL = "UPDATE customermanagement SET province = ? WHERE custid = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, province);
                    preparedStatement.setObject(2, custidupdate);

                    preparedStatement.executeUpdate();

                }
                if (!postalcode.isEmpty()){
                    String SQL = "UPDATE customermanagement SET postalcode = ? WHERE custid = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, postalcode);
                    preparedStatement.setObject(2, custidupdate);

                    preparedStatement.executeUpdate();

                }
                if (!custid.isEmpty()){
                    String SQL = "UPDATE customermanagement SET custid = ? WHERE custid = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                    preparedStatement.setObject(1, custid);
                    preparedStatement.setObject(2, custidupdate);

                    preparedStatement.executeUpdate();

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> titles = FXCollections.observableArrayList(
                "Mr",
                "Mrs",
                "Ms"
        );

        newcombotitle.setItems(titles);

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
        newcomboprovince.setItems(provinces);
    }
}
