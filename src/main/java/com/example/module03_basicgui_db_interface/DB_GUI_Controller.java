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
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class DB_GUI_Controller implements Initializable {

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tv_fn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tv_ln.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tv_dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        tv_major.setCellValueFactory(new PropertyValueFactory<>("major"));


        tv.setItems(data);
    }


    @FXML
    protected void addNewRecord() {
        data.add(new Person(
                data.size()+1,
                first_name.getText(),
                last_name.getText(),
                department.getText(),
                major.getText()
        ));
    }

    @FXML
    protected void clearForm(){
        first_name.clear();
        last_name.clear();
        department.clear();
        major.clear();
    }

    //TODO implement editRecord()
    @FXML
    protected void editRecord() {

    }

    @FXML
    protected void deleteRecord() {
        Person p = tv.getSelectionModel().getSelectedItem();
        data.remove(p);
    }


    @FXML
    protected void showImage() {
        // Create a FileChooser instance for selecting an image file.
        FileChooser fc = new FileChooser();

        // Set the title of the file chooser dialog.
        fc.setTitle("Choose an image");

        // Add file extension filters to restrict selection to image files with specific extensions.
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        // Show the file chooser dialog and wait for the user to select a file.
        File selectedFile = fc.showOpenDialog(null);

        // Check if a file was selected.
        if (selectedFile != null) {
            try {
                // Load the selected image file and display it in an ImageView component.
                // Convert the file's URI to a URL and create a JavaFX Image from it.
                img_view.setImage(new javafx.scene.image.Image(selectedFile.toURI().toURL().toString()));
            } catch (IOException e) {
                // Handle any IOException that might occur during image loading.
                e.printStackTrace();
            }
        }
        // set placeholder
        else {
            img_view.setImage(new Image("/src/main/resources/com/example/module03_basicgui_db_interface/profile.png"));
        }
    }

    // protected void showImage
}