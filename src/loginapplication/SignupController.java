/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapplication;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import loginapplication.util.ConnectionUtil;

/**
 * FXML Controller class
 *
 * @author paul
 */
public class SignupController implements Initializable {

    @FXML
    private TextField textEmail;

    @FXML
    private PasswordField textPassword;

    Stage stage = new Stage();
    Scene scene;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    //ResultSet resultSet = null;

    public SignupController() {
        connection = ConnectionUtil.connectdb();
    }

    @FXML
    private void submit(ActionEvent event) {
        String email = textEmail.getText();
        String password = textPassword.getText();

        String sql = "INSERT INTO `woodfire`.`user` (`email_address`, `password`) VALUES (?, ?);";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            if (validateEmail(email)) {
               infoBox("Please enter a valid email address", "Invalid Email Address", null); 
            } else {

            infoBox("Registration Successfull", "Success", null);
            Node source = (Node) event.getSource();
            stage = (Stage) source.getScene().getWindow();
            stage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("LoginSignup.fxml")));
            stage.setScene(scene);
            stage.show();}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Set up Alerts
    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
    
    //Boolean method to verify email address
    private boolean validateEmail(String email) {
        if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)"
                + "*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
