package controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.CustomerInfo;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CustomerManagementController implements Initializable {

    @FXML
    private JFXButton btnAddCust;

    @FXML
    private JFXButton btnDeleteCust;

    @FXML
    private JFXButton btnUpdateCust;

    @FXML
    private JFXButton btnViewCust;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colcity;

    @FXML
    private TableColumn<?, ?> colcustid;

    @FXML
    private TableColumn<?, ?> coldob;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> colpostalcode;

    @FXML
    private TableColumn<?, ?> colprovince;

    @FXML
    private TableColumn<?, ?> colsalary;

    @FXML
    private TableColumn<?, ?> coltitle;

    @FXML
    private TableView<CustomerInfo> tblcustmanagement;

    Stage Addcust = new Stage();
    Stage updatecust = new Stage();
    Stage deletecust = new Stage();

    public void btnAddCustOnAction(ActionEvent event) {

        try {
            Addcust.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AddCustomerForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Addcust.show();
    }

    public void btnUpdateCustOnAction(ActionEvent event) {

        try {
            updatecust.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/UpdatecustForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        updatecust.show();
    }

    public void btnDeleteCustOnAction(ActionEvent event) {

        try {
            deletecust.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DeletecustForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        deletecust.show();
    }

    public void btnViewCustOnAction(ActionEvent event) {

        ObservableList<CustomerInfo> customerInfos = FXCollections.observableArrayList();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ thogakade2","root","1234");
            String SQL = "select * from customermanagement";
            PreparedStatement preparedStatement =connection.prepareStatement(SQL);
            ResultSet resultSet =preparedStatement.executeQuery();

            while (resultSet.next()){

                CustomerInfo customerInfo = new CustomerInfo(
                        resultSet.getString("custid"),
                        resultSet.getString("title"),
                        resultSet.getString("name"),
                        resultSet.getDate("Dob"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postalcode")
                );

                customerInfos.add(customerInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        colcustid.setCellValueFactory(new PropertyValueFactory<>("custID"));
        coltitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        coldob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colsalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colcity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colprovince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colpostalcode.setCellValueFactory(new PropertyValueFactory<>("postalcode"));

        tblcustmanagement.setItems(customerInfos);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<CustomerInfo> customerInfos = FXCollections.observableArrayList();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ thogakade2","root","1234");
            String SQL = "select * from customermanagement";
            PreparedStatement preparedStatement =connection.prepareStatement(SQL);
            ResultSet resultSet =preparedStatement.executeQuery();

            while (resultSet.next()){

                CustomerInfo customerInfo = new CustomerInfo(
                        resultSet.getString("custid"),
                        resultSet.getString("title"),
                        resultSet.getString("name"),
                        resultSet.getDate("Dob"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postalcode")
                );

                customerInfos.add(customerInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        colcustid.setCellValueFactory(new PropertyValueFactory<>("custID"));
        coltitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        coldob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colsalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colcity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colprovince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colpostalcode.setCellValueFactory(new PropertyValueFactory<>("postalcode"));

        tblcustmanagement.setItems(customerInfos);
    }
}
