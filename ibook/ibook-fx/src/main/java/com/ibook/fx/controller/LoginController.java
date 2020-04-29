package com.ibook.fx.controller;

import com.ibook.fx.entity.User;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class LoginController implements Initializable {

    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfPassword;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnLogin;

    private User user = new User();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfUsername.textProperty().bindBidirectional(user.usernameProperty());
        tfPassword.textProperty().bindBidirectional(user.passwordProperty());
    }

    @FXML
    public void login(ActionEvent actionEvent) {
        System.out.println(user.getUsername() + "-" + user.getPassword());
    }

    public void reset(ActionEvent actionEvent) {
        tfUsername.clear();
        tfPassword.clear();
    }
}