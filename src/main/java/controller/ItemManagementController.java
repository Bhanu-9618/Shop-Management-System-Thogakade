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
import model.ItemInfo;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ItemManagementController implements Initializable {

    @FXML
    private JFXButton btnAddItem;

    @FXML
    private JFXButton btnDeleteItem;

    @FXML
    private JFXButton btnUpdateItem;

    @FXML
    private JFXButton btnViewItem;

    @FXML
    private TableColumn<?, ?> colcode;

    @FXML
    private TableColumn<?, ?> coldescription;

    @FXML
    private TableColumn<?, ?> colpacksize;

    @FXML
    private TableColumn<?, ?> colqtyonhand;

    @FXML
    private TableColumn<?, ?> colunitprice;

    @FXML
    private TableView<ItemInfo> tblitemmanagement;

    Stage additem = new Stage();
    Stage updateitem = new Stage();
    Stage deleteitem = new Stage();

    public void btnAddItemOnAction(ActionEvent event) {

        try {
            additem.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AddItemForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        additem.show();
    }

    public void btnUpdateItemOnAction(ActionEvent event) {

        try {
            updateitem.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/UpdateitemForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        updateitem.show();

    }

    public void btnDeleteItemOnAction(ActionEvent event) {

        try {
            deleteitem.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DeleteitemForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        deleteitem.show();
    }

    public void btnViewItemOnAction(ActionEvent event) {

        ObservableList<ItemInfo> itemInfos = FXCollections.observableArrayList();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ thogakade2", "root", "1234");
            String SQL = "select * from itemmanagement";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                ItemInfo itemInfo = new ItemInfo(
                        resultSet.getString("itemcode"),
                        resultSet.getString("description"),
                        resultSet.getString("packsize"),
                        resultSet.getDouble("unitprice"),
                        resultSet.getInt("qty_on_hand")
                );

                itemInfos.add(itemInfo);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        colcode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        coldescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colpacksize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colunitprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colqtyonhand.setCellValueFactory(new PropertyValueFactory<>("qtyonHand"));

        tblitemmanagement.setItems(itemInfos);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<ItemInfo> itemInfos = FXCollections.observableArrayList();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ thogakade2", "root", "1234");
            String SQL = "select * from itemmanagement";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                ItemInfo itemInfo = new ItemInfo(
                        resultSet.getString("itemcode"),
                        resultSet.getString("description"),
                        resultSet.getString("packsize"),
                        resultSet.getDouble("unitprice"),
                        resultSet.getInt("qty_on_hand")
                );

                itemInfos.add(itemInfo);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        colcode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        coldescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colpacksize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colunitprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colqtyonhand.setCellValueFactory(new PropertyValueFactory<>("qtyonHand"));

        tblitemmanagement.setItems(itemInfos);
    }
}

