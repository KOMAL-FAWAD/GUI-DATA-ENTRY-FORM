package com.example.demo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class UniversityDataEntryForm extends Application {

    private final ArrayList<Student> studentsList = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("University Data Entry Form");

        // Create a grid pane layout for the form
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);


        Label titleLabel = new Label("COMSATS University Data Entry Form");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setAlignment(Pos.CENTER);


        ImageView studentImageView = new ImageView();
        studentImageView.setFitWidth(120);
        studentImageView.setFitHeight(120);
        studentImageView.setPreserveRatio(true);
        studentImageView.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

        Button uploadButton = new Button("Upload Picture");
        uploadButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
            );
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                Image studentImage = new Image(selectedFile.toURI().toString());
                studentImageView.setImage(studentImage);
            }
        });

        VBox pictureBox = new VBox(10, studentImageView, uploadButton);
        pictureBox.setAlignment(Pos.CENTER);

        // Add form components
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);

        Label fatherNameLabel = new Label("Father Name:");
        TextField fatherNameField = new TextField();
        gridPane.add(fatherNameLabel, 0, 1);
        gridPane.add(fatherNameField, 1, 1);


        Label CNICLabel = new Label("CNIC:");
        TextField CNICField = new TextField();
        gridPane.add(CNICLabel, 0, 2);
        gridPane.add(CNICField, 1, 2);

        Label dobLabel = new Label("Date of Birth:");
        DatePicker dobPicker = new DatePicker();
        gridPane.add(dobLabel, 0, 3);
        gridPane.add(dobPicker, 1, 3);

        Label genderLabel = new Label("Gender:");
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleRadioButton = new RadioButton("Male");
        RadioButton femaleRadioButton = new RadioButton("Female");
        RadioButton otherRadioButton = new RadioButton("Other");
        maleRadioButton.setToggleGroup(genderGroup);
        femaleRadioButton.setToggleGroup(genderGroup);
        otherRadioButton.setToggleGroup(genderGroup);
        GridPane genderPane = new GridPane();
        genderPane.setHgap(10);
        genderPane.add(maleRadioButton, 0, 0);
        genderPane.add(femaleRadioButton, 1, 0);
        genderPane.add(otherRadioButton, 2, 0);
        gridPane.add(genderLabel, 0, 4);
        gridPane.add(genderPane, 1, 4);

        Label cityLabel = new Label("City");
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Lahore", "Vehari", "Wah", "Islamabad", "Karachi");
        cityComboBox.setPromptText("Select City");
        gridPane.add(cityLabel, 0, 5);
        gridPane.add(cityComboBox, 1, 5);

        Button saveButton = new Button("Save");
        gridPane.add(saveButton, 1, 6);
        GridPane.setMargin(saveButton, new Insets(10, 0, 0, 0));


        saveButton.setOnAction(event -> {
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String CNIC = CNICField.getText();
            String city = cityComboBox.getValue();
            String gender = null;
            if (maleRadioButton.isSelected()) {
                gender = "Male";
            } else if (femaleRadioButton.isSelected()) {
                gender = "Female";
            } else if (otherRadioButton.isSelected()) {
                gender = "Other";
            }
            String dob = (dobPicker.getValue() != null) ? dobPicker.getValue().toString() : "";

            if (name.isEmpty() || fatherName.isEmpty() || city == null || CNIC.isEmpty() || gender == null || dob.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill all fields!");
            } else {
                Student student = new Student(name, fatherName, CNIC, gender, dob, city);
                studentsList.add(student);

                showAlert(Alert.AlertType.INFORMATION, "Submission Successful",
                        "Data submitted successfully!\n\nName: " + name +
                                "\nFather Name: " + fatherName +
                                "\nCNIC: " + CNIC +
                                "\nGender: " + gender +
                                "\nDate of Birth: " + dob +
                                "\nCity: " + city );
            }
        });





        VBox root = new VBox(20);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(titleLabel, pictureBox, gridPane);


        Scene scene = new Scene(root, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
