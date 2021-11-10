package fr.dylan.unairdejava;

import fr.dylan.unairdejava.entity.band;
import fr.dylan.unairdejava.entity.piece;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assert i1TitleCol != null : "fx:id=\"i1TitleCol\" was not injected: check your FXML file 'homeView.fxml'.";
        assert i1DureeCol != null : "fx:id=\"i1DureeCol\" was not injected: check your FXML file 'homeView.fxml'.";
        assert i1NomCol != null : "fx:id=\"i1NomCol\" was not injected: check your FXML file 'homeView.fxml'.";
        assert i1TvGroupe != null : "fx:id=\"i1TvGroupe\" was not injected: check your FXML file 'homeView.fxml'.";
        assert i1TvTitre != null : "fx:id=\"i1TvTitre\" was not injected: check your FXML file 'homeView.fxml'.";

        i1TitleCol.setCellValueFactory(new PropertyValueFactory<piece, String>("duration_piece"));
        i1DureeCol.setCellValueFactory(new PropertyValueFactory<piece, Integer>("duration_piece"));
        i1NomCol.setCellValueFactory(new PropertyValueFactory<band, String>("name_band"));
    }
}

