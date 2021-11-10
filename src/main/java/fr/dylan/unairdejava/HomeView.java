package fr.dylan.unairdejava;

import fr.dylan.unairdejava.entity.band;
import fr.dylan.unairdejava.entity.piece;
import fr.dylan.unairdejava.utils.ConnectionBDD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class HomeView implements Initializable {

    @FXML private TableView<piece> i1TvTitre;
    @FXML private TableColumn<piece, String> i1TitleCol;
    @FXML private TableColumn<piece, Integer> i1DureeCol;
    @FXML private TableView<band> i1TvGroupe;
    @FXML private TableColumn<band, String> i1NomCol;


    @FXML private TableColumn<?, ?> i2InterpreteCol;
    @FXML private TableColumn<?, ?> i2LieuxCol;
    @FXML private TableColumn<?, ?> i2TimeCol;
    @FXML private TableColumn<?, ?> i2TitleCol;

    @FXML private ChoiceBox<?> i3CbSpecialite;
    @FXML private TableColumn<?, ?> i3FirstnameCol;
    @FXML private TableColumn<?, ?> i3LastnameCol;
    @FXML private TableColumn<?, ?> i3RencontreCol;

    @FXML private TableColumn<?, ?> i4PaysCol;
    @FXML private TableColumn<?, ?> i4ResPaysCol;
    @FXML private TextField i4TfDuree;
    @FXML private TableColumn<?, ?> i4TitleCol;

    @FXML private TableColumn<?, ?> i5GroupeCol;
    @FXML private TableColumn<?, ?> i5RencontreCol;

    @FXML private TableColumn<?, ?> i6InstrumentCol;
    @FXML private TableColumn<?, ?> i6RencontreCol;

    @FXML private TableColumn<?, ?> i7DateStartCol;
    @FXML private TableColumn<?, ?> i7DateStopCol;
    @FXML private TableColumn<?, ?> i7GroupeNameCol;
    @FXML private TableColumn<?, ?> i7PaysCol;
    @FXML private TableColumn<?, ?> i7RencontreCol;


    private piece selectedPiece = null;
    private ObservableList<piece> data = FXCollections.observableArrayList();

    private void displayTitle() {

        try {
             //Connection a la BDD
            ConnectionBDD dataBaseConnection = new ConnectionBDD();


            // Création de la requete d'affichage
            String reqAffichage = "CALL get_all_pieces()";
            PreparedStatement stat = dataBaseConnection.getConnection().prepareStatement(reqAffichage);
            ResultSet rs = stat.executeQuery();

            //reinitialisation du tableview
            data.removeAll(data);
            while (rs.next()){
                System.out.println(rs.getInt(1));
                piece piece = new piece(rs.getString(2),rs.getInt(4));
                data.add(piece);
            }
            dataBaseConnection.getConnection().close();


        }catch (Exception e){
            e.printStackTrace();

        }

        i1TitleCol.setCellValueFactory(new PropertyValueFactory<piece, String>("name_piece"));
        i1DureeCol.setCellValueFactory(new PropertyValueFactory<piece, Integer>("duration_piece"));
        i1NomCol.setCellValueFactory(new PropertyValueFactory<band, String>("name_band"));
        i1TvTitre.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assert i1TitleCol != null : "fx:id=\"i1TitleCol\" was not injected: check your FXML file 'homeView.fxml'.";
        assert i1DureeCol != null : "fx:id=\"i1DureeCol\" was not injected: check your FXML file 'homeView.fxml'.";
        assert i1NomCol != null : "fx:id=\"i1NomCol\" was not injected: check your FXML file 'homeView.fxml'.";
        assert i1TvGroupe != null : "fx:id=\"i1TvGroupe\" was not injected: check your FXML file 'homeView.fxml'.";
        assert i1TvTitre != null : "fx:id=\"i1TvTitre\" was not injected: check your FXML file 'homeView.fxml'.";

        displayTitle();

    }
}

