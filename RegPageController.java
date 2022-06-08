package com.example.demoex;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;



public class RegPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField birthDay;

    @FXML
    private CheckBox checkBoxFemale;

    @FXML
    private CheckBox checkBoxMale;

    @FXML
    private TextField email;

    @FXML
    private TextField idNumber;

    @FXML
    private TextField name;

    @FXML
    private TextField phoneNumber;

    @FXML
    private PasswordField password;

    @FXML
    private Button regNextPageButton;

    @FXML
    private Label errorLabel;

    @FXML
    private Button sighUpPage;

    @FXML
    void initialize() {

        sighUpPage.setOnAction(actionEvent -> {
            sighUpPage.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Authorization.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });


        regNextPageButton.setOnAction(actionEvent -> {

            signUpNewUser();

        });
    }

    private void signUpNewUser() {


        DatabaseHandler dbHandler = new DatabaseHandler();

        String nameUser = name.getText();
        String genderUser = "";
        if (checkBoxMale.isSelected())
            genderUser = "Мужской";
        else
            genderUser = "Женский";
        String birthday = birthDay.getText();
        String emailUser = email.getText();
        String phoneUser = phoneNumber.getText();
        String passwordUser = password.getText();

        User user = new User(nameUser, genderUser, birthday, emailUser, phoneUser, passwordUser);


        dbHandler.sighUpUser(user);

        }
    }

