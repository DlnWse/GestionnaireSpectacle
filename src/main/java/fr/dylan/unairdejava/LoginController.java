package fr.dylan.unairdejava;

import fr.dylan.unairdejava.utils.ConnectionBDD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//import java.sql.Connection;

public class LoginController implements Initializable {


    @FXML
    private Button btnConnect, btnLeave;

    @FXML
    private Label lblConnectError;

    @FXML
    private TextField tfId,tfMdp;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public boolean doConnectBdd(){
        if (!tfId.getText().isBlank() && !tfMdp.getText().isBlank()) {
            validateLogin();
        } else {
            errorLogin();
            return false;
        }
        // Connection a la BDD
        ConnectionBDD dataBaseConnection = new ConnectionBDD();

        return dataBaseConnection.isConnected();
    }


    @FXML
    void onConnectAction(ActionEvent event) throws IOException {


        if (doConnectBdd()){
           FXMLLoader loader = new FXMLLoader(getClass().getResource("homeView.fxml"));
           Parent root = loader.load();
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();

       }



    }

    public void validateLogin(){
        lblConnectError.setText("vous etes connecter");
    }

    public void errorLogin(){
        lblConnectError.setText("Erreur");
    }

    @FXML
    private void onLeaveAction(ActionEvent event) {
        Stage stage = (Stage) btnLeave.getScene().getWindow();
        stage.close();
    }


}
