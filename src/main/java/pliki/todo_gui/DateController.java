package pliki.todo_gui;


import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;


import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;


import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
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

    //Set & GET
    public void setDate(LocalDate dateOfActivity){
        date = dateOfActivity;
    }

    public LocalDate getDate(){
        return chooseDate.getValue();
    }


    public boolean validator(LocalDate date){

       try {
               if (date.toString().matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}")){
                   setDate(date);
                   return true;
               } else {
                   return false;
               }
       }catch(Exception e){
           return false;
       }

    }


    public void confirmDate(ActionEvent event) throws IOException {

        if(validator(chooseDate.getValue())){

            forErrorStage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewMenu.fxml"));
            root = loader.load();
            scene = new Scene(root);
            node = (Node) event.getSource();
            stage = (Stage) node.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            ActivityController menuController = loader.getController();
            menuController.setWelcome(nameOfUser.getText(), date);
            menuController.createEmptyList();
            menuController.showActions();

        }else{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewFail.fxml"));
            root = loader.load();
            scene = new Scene(root);
            forErrorStage.setScene(scene);
                forErrorStage.setResizable(false);
                forErrorStage.setTitle("Błąd");
                forErrorStage.setAlwaysOnTop(true);
            forErrorStage.show();

            FailController failController = loader.getController();
            failController.reasonOfFail("Zły format daty, spróbuj użyć menu kalendarza");

        }


    }

}



