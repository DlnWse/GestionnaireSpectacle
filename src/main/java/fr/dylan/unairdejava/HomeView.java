package fr.dylan.unairdejava;

import fr.dylan.unairdejava.entity.band;
import fr.dylan.unairdejava.entity.piece;
import fr.dylan.unairdejava.utils.ConnectionBDD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class HomeView implements Initializable {

    @FXML private AnchorPane root;

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

    private ConnectionBDD dataBaseConnection;

    private final ObservableList<piece> tab1Title = FXCollections.observableArrayList();
    private final ObservableList<band> tab1Group = FXCollections.observableArrayList();

    private final EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                piece selection = i1TvTitre.getSelectionModel().getSelectedItem();
                getGroupsByPiece(selection.getId_piece());
            }
        }
    };

    private void getGroupsByPiece(int idPiece){
        // Création de la requete d'affichage
        String reqAffichage = String.format("CALL get_bands_playing_piece(%d)", idPiece);
        PreparedStatement stat = null;
        try {
            stat = dataBaseConnection.getConnection().prepareStatement(reqAffichage);
            ResultSet rs = stat.executeQuery();

            //reinitialisation du tableview
            tab1Group.removeAll(tab1Group);
            while (rs.next()){
                band band = new band(rs.getString(1));
                tab1Group.add(band);
            }
            i1NomCol.setCellValueFactory(new PropertyValueFactory<band, String>("name_band"));
            i1TvGroupe.setItems(tab1Group);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayTitle() {

        try {

            // Création de la requete d'affichage
            String reqAffichage = "CALL get_all_pieces()";
            PreparedStatement stat = dataBaseConnection.getConnection().prepareStatement(reqAffichage);
            ResultSet rs = stat.executeQuery();

            //reinitialisation du tableview
            tab1Title.removeAll(tab1Title);
            while (rs.next()) {
                piece piece = new piece(rs.getInt(1), rs.getString(2),rs.getInt(4));
                tab1Title.add(piece);
            }
            //dataBaseConnection.getConnection().close();



        }catch (Exception e){
            e.printStackTrace();

        }

        i1TitleCol.setCellValueFactory(new PropertyValueFactory<piece, String>("name_piece"));
        i1DureeCol.setCellValueFactory(new PropertyValueFactory<piece, Integer>("duration_piece"));
        i1TvTitre.setItems(tab1Title);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assert i1TitleCol != null : "fx:id=\"i1TitleCol\" was not injected: check your FXML file 'homeView.fxml'.";
        assert i1DureeCol != null : "fx:id=\"i1DureeCol\" was not injected: check your FXML file 'homeView.fxml'.";
        assert i1NomCol != null : "fx:id=\"i1NomCol\" was not injected: check your FXML file 'homeView.fxml'.";
        assert i1TvGroupe != null : "fx:id=\"i1TvGroupe\" was not injected: check your FXML file 'homeView.fxml'.";
        assert i1TvTitre != null : "fx:id=\"i1TvTitre\" was not injected: check your FXML file 'homeView.fxml'.";

        i1TvTitre.setOnMouseReleased(mouseHandler);

        dataBaseConnection = new ConnectionBDD();

        displayTitle();

    }
}

