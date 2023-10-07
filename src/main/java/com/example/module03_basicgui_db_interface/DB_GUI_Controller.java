package com.example.module03_basicgui_db_interface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the database GUI.
 */
public class DB_GUI_Controller implements Initializable {

    // ObservableList to store data for the TableView
    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person(1, "Jacob", "Smith", "CPIS", "CS"),
                    new Person(2, "Jacob2", "Smith1", "CPIS1", "CS")
            );

    @FXML
    TextField first_name, last_name, department, major;
    @FXML
    private TableView<Person> tv;
    @FXML
    private TableColumn<Person, Integer> tv_id;
    @FXML
    private TableColumn<Person, String> tv_fn, tv_ln, tv_dept, tv_major;

    @FXML
    ImageView img_view;

    /**
     * Initializes the controller and sets up the TableView.
     * @param url The location used to resolve relative paths.
     * @param resourceBundle The resource bundle to localize the root object, or null.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configure the TableView columns to use properties of the Person class
        tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tv_fn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tv_ln.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tv_dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        tv_major.setCellValueFactory(new PropertyValueFactory<>("major"));

        // Set the data for the TableView
        tv.setItems(data);

    }

    /**
     * Add a new record to the TableView.
     */
    @FXML
    protected void addNewRecord() {
        // Add a new Person object to the ObservableList
        data.add(new Person(
                data.size()+1,
                first_name.getText(),
                last_name.getText(),
                department.getText(),
                major.getText()
        ));
    }

    /**
     * Clear the input fields in the form.
     */
    @FXML
    protected void clearForm(){
        // Clear the input fields
        first_name.clear();
        last_name.clear();
        department.clear();
        major.clear();
    }

    /**
     * Close the application.
     */
    @FXML
    protected void closeApplication(){
        // Close the application
        System.exit(0);
    }

    // TODO: implement editRecord()

    /**
     * Edit a selected record in the TableView.
     */
    @FXML
    protected void editRecord() {
        // Edit a selected record in the TableView
        Person p = tv.getSelectionModel().getSelectedItem();
        int c = data.indexOf(p);
        Person p2 = new Person();
        p2.setId(c+1);
        p2.setFirstName(first_name.getText());
        p2.setLastName(last_name.getText());
        p2.setDept(department.getText());
        p2.setMajor(major.getText());
        data.remove(c);
        data.add(c, p2);
        tv.getSelectionModel().select(c);
    }

    /**
     * Delete a selected record from the TableView.
     */
    @FXML
    protected void deleteRecord() {
        // Delete a selected record from the TableView
        Person p = tv.getSelectionModel().getSelectedItem();
        data.remove(p);
    }

    /**
     * Show an image in an ImageView.
     */
    @FXML
    protected void showImage() {
        // Show an image in an ImageView
        File file = (new FileChooser()).showOpenDialog(img_view.getScene().getWindow());
        if(file != null){
            img_view.setImage(new Image(file.toURI().toString()));
        }
    }

    /**
     * Populate input fields with data from the selected item in the TableView.
     * @param mouseEvent The MouseEvent triggered by the user's interaction.
     */
    @FXML
    protected void selectedItemTV(MouseEvent mouseEvent){
        // Populate input fields with data from the selected item in the TableView
        Person p = tv.getSelectionModel().getSelectedItem();
        first_name.setText(p.getFirstName());
        last_name.setText(p.getLastName());
        department.setText(p.getDept());
        major.setText(p.getMajor());
    }
}
