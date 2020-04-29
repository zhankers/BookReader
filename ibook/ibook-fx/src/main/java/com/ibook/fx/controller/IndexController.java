package com.ibook.fx.controller;

import com.ibook.fx.IBookFxMainx;
import com.ibook.fx.fxmlview.IndexFxmlView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class IndexController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private Label tx;

    private ResourceBundle resourceBundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resourceBundle = resources;
    }

    @FXML
    public void btnClick(ActionEvent actionEvent) {
        //tx.setText(resourceBundle.getString("helloWorld"));
        tx.setText("你好");
    }

    @FXML
    public void btnLoginClick(ActionEvent actionEvent) {
        IBookFxMainx.showView(IndexFxmlView.class);
    }
}