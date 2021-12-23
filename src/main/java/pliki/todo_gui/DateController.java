package pliki.todo_gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;


public class DateController {

    //FXML
    @FXML
    Text nameOfUser;
    @FXML
    DatePicker chooseDate;

    //GUI
    Stage stage;
    //Must be created, to be closed if user will write correct answer
    Stage forErrorStage = new Stage();
    Scene scene;
    Parent root;
    Node node;

    //Var
    LocalDate date;



    public void displayName(String username){
        nameOfUser.setText(username);
    }



    public void setDate(LocalDate dateOfActivity){
        date = dateOfActivity;
    }



    public LocalDate getDate(){
        return chooseDate.getValue();
    }




    public void confirmDate(ActionEvent event) throws IOException {

        setDate(chooseDate.getValue());


            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewMenu.fxml"));
            root = loader.load();
            scene = new Scene(root);
            node = (Node) event.getSource();
            stage = (Stage) node.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            MenuController menuController = loader.getController();
            menuController.setWelcome(nameOfUser.getText(),date);



    }

}
