package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;
import java.util.ArrayList;

public class Controller {
    @FXML private ComboBox<String> comboBox;
    @FXML private TextField mytext;




    public void getNames(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://ahmadatypon-Virtualbox:3306/testDB", "root", "root");
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from names");

            ArrayList<String> names = new ArrayList<>();
            while (rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
                names.add(rs.getString(2));
            }
            con.close();
            comboBox.getItems().clear();
            for(String s:names)
                comboBox.getItems().add(s);


        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("An exception occurred!");
            alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(e.getMessage())));
            alert.showAndWait();
            System.out.println(e.getMessage());
        }
    }

    public void insetName(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://ahmadatypon-Virtualbox:3306/testDB", "root", "root");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into names(name) value('"+mytext.getText()+"')");
            con.close();
            getNames(event);



        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("An exception occurred!");
            alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(e.getMessage())));
            alert.showAndWait();
            System.out.println(e.getMessage());
        }
    }

}
