package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.security.MessageDigest;
import java.sql.*;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Hello World");


            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("An exception occurred!");
            alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(e.getMessage())));
            alert.showAndWait();
            System.out.println(e.getMessage());
        }
    }




    public static void main(String[] args) {
        launch(args);
    }
}
