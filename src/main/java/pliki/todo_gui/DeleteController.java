package pliki.todo_gui;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import javafx.stage.Stage;
import javafx.scene.Node;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class DeleteController {

    //FXML
    @FXML
    TextField numberToDelete;

    @FXML
    Label message;

    //GUI
    Stage stage;
    Node node;


    //Var
    byte deleteNumber;


    //Number SET & GET
    public void setDeleteNumber(byte deleteNumber){
        this.deleteNumber=deleteNumber;
    }
    public byte getDeleteNumber() {return deleteNumber;}


    public void deleteAction(ActionEvent event) {

        try {

            if(Integer.parseInt(numberToDelete.getText())>-1 && Integer.parseInt(numberToDelete.getText())<10) {

                setDeleteNumber((byte) Integer.parseInt(numberToDelete.getText()));

                node = (Node) event.getSource();
                stage = (Stage) node.getScene().getWindow();
                stage.close();

            }else{

                message.setText("Numer akcji musi się mieścić w zakresie [0-9]");

                }



        }catch (Exception e){
            message.setText("Coś poszło nie tak...");
        }

    }

}
