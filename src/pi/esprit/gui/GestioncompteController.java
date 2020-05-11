/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.esprit.gui;

import edu.mawhebti.gui.InsertDataController;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pi.esprit.entities.personnes;
import pi.esprit.services.PersonneCRUD;

/**
 * FXML Controller class
 *
 * @author bureau
 */
public class GestioncompteController implements Initializable {

    @FXML
    private AnchorPane login;
    @FXML
    private TableView<personnes> tableview;
    @FXML
    private TableColumn<personnes, Integer> idColumn;
    @FXML
    private TableColumn<personnes, String> lastNameColumn;
    @FXML
    private TableColumn<personnes, String> firstNameColumn;
    @FXML
    private TableColumn<personnes, String> adressColumn;
    @FXML
    private TableColumn<personnes, String> profilColumn;
    @FXML
    private TableColumn<personnes, String> photoColumn;
    private TableColumn<personnes, String> loginColumn;
    @FXML
    private TableColumn<personnes, String> pwdColumn;
    @FXML
    private Button addUserBtn;
    @FXML
    private Button deleteUserBtn;
    @FXML
    private Button editUserBtn;
    @FXML
    private TextField searchTf;
    @FXML
    private Label filterSearchLb;
    @FXML
    private Button searchBtn;
    @FXML
    private RadioButton idRB;
    @FXML
    private ToggleGroup filterRadioButtons;
    @FXML
    private RadioButton nomRB;
    @FXML
    private RadioButton prenomRB;
    @FXML
    private TableColumn<?, ?> loginClolumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //inserer les donner dans le tableau
        idColumn.setCellValueFactory(new PropertyValueFactory<personnes, Integer>("id_user"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<personnes, String>("nom"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<personnes, String>("prenom"));
        adressColumn.setCellValueFactory(new PropertyValueFactory<personnes, String>("adress"));
        profilColumn.setCellValueFactory(new PropertyValueFactory<personnes, String>("profil"));
        photoColumn.setCellValueFactory(new PropertyValueFactory<personnes, String>("photo"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<personnes, String>("login"));
        pwdColumn.setCellValueFactory(new PropertyValueFactory<personnes, String>("pwd"));
        ObservableList<personnes> data = FXCollections.observableArrayList(PersonneCRUD.selectUsers());
        tableview.setItems(data);
        tableview.getColumns().addAll(idColumn,lastNameColumn,firstNameColumn,adressColumn,profilColumn,photoColumn,loginColumn,pwdColumn);
        tableview.getSelectionModel().setCellSelectionEnabled(true);
    }    

    @FXML
    private void addUser(ActionEvent event) {
        Stage addUserWindow = new Stage();
        addUserWindow.initModality(Modality.APPLICATION_MODAL);
        try {FXMLLoader loader =
             new FXMLLoader(getClass().getResource("SetDataController.fxml"));
            Parent root2 = loader.load();
            InsertDataController sDC= new InsertDataController();
            sDC.add(addUserWindow);
            tableview.refresh();
        } catch (IOException ex) {
        System.out.println(ex.getMessage());        }
    }

    @FXML
    private void deleteUser(ActionEvent event) {
                ObservableList selectedCells = tableview.getSelectionModel().getSelectedCells();
        personnes p = new personnes();
        selectedCells.addListener(new ListChangeListener() {
        @Override
        public void onChanged(ListChangeListener.Change c) {
        TablePosition tablePosition = (TablePosition) selectedCells.get(0);
        personnes p = (personnes) tablePosition.getTableColumn().getCellData(tablePosition.getRow());
        }
        });
        PersonneCRUD.supprimerPersonne(p.getId_user());


        tableview.refresh();
    }

    @FXML
    private void editUser(ActionEvent event) {
        ObservableList selectedCells = tableview.getSelectionModel().getSelectedCells();
        personnes p = new personnes();
        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                personnes p = (personnes) tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                }
                });

        PersonneCRUD.updatePersonne(p);
        tableview.refresh();
    }
    
    public String getSearchTf(){
          return searchTf.getText();   
         }

    @FXML
    private void userSearch(ActionEvent event) {
        filterRadioButtons.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
        public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
            String filterRb = new String();
            if (filterRadioButtons.getSelectedToggle() != null) {
            filterRb = new String(filterRadioButtons.getSelectedToggle().getUserData().toString());
            ObservableList<personnes> data = FXCollections.observableArrayList(PersonneCRUD.selectUsers());
            ObservableList<personnes> filtredData=null;
            String searchText = new String(getSearchTf());
            if (filterRb.equals("id")){
               filtredData = FXCollections.observableArrayList(data.
                       stream().filter(x->searchText.equals(x.getId_user())).findAny().orElse(null)); 
                
            } 
            if (filterRb.equals("nom")){
               filtredData = FXCollections.observableArrayList(data.
                       stream().filter(x->searchText.equals(x.getNom())).findAny().orElse(null)); 
                
            } 
            if (filterRb.equals("prenom")){
                filtredData = FXCollections.observableArrayList(data.
                stream().filter(x->searchText.equals(x.getPrenom())).findAny().orElse(null)); 
                
            } 
                    tableview.setItems(filtredData);
            tableview.getColumns().addAll(idColumn,lastNameColumn,firstNameColumn,adressColumn,profilColumn,photoColumn,loginColumn,pwdColumn);
            tableview.getSelectionModel().setCellSelectionEnabled(true);
         }
         
        }
     

          });
        
    }
    
}
