/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author paul
 */
public class BabyBackRibsController implements Initializable {
    
    @FXML
    public void home(ActionEvent event) throws IOException {
        Parent dinoRibsParent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene dinoRibsScene = new Scene(dinoRibsParent);
        
        //This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(dinoRibsScene);
        window.show();
    }
    
    @FXML
    public void ingredients(ActionEvent event) throws IOException {
        Parent dinoRibsParent = FXMLLoader.load(getClass().getResource("BabyBackIngredients.fxml"));
        Scene dinoRibsScene = new Scene(dinoRibsParent);
        
        //This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(dinoRibsScene);
        window.show();
    }
    
    @FXML
    public void technique(ActionEvent event) throws IOException {
        Parent dinoRibsParent = FXMLLoader.load(getClass().getResource("BabyBackTechnique.fxml"));
        Scene dinoRibsScene = new Scene(dinoRibsParent);
        
        //This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(dinoRibsScene);
        window.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
