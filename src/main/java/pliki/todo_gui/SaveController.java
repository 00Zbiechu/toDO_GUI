package pliki.todo_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import javafx.stage.Stage;
import javafx.scene.Node;


public class SaveController {

    //FXML
    @FXML
    private TextField path;

    @FXML
    private Label message;

    //VAR
    private String pathToFile;


    //Content SET & GET
    public void setPath(String path){pathToFile=path;}

    public String getPathToFile(){return pathToFile;}




    public void saveAction(ActionEvent event){

        try{

            setPath(path.getText());

            Node node = (Node) event.getSource();
            //GUI
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

        }catch (Exception e){
            message.setText("Coś poszło nie tak...");
        }

    }

}
