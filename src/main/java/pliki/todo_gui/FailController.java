package pliki.todo_gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FailController {

    @FXML
    private Label labelForError;


    public void closeWindow(ActionEvent event){

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

    }

    public void reasonOfFail(String reason){

        labelForError.setText(reason);

    }

}
