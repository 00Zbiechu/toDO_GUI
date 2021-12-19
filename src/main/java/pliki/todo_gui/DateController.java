package pliki.todo_gui;


import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class DateController {

    @FXML
    Text nameOfUser;

    public void displayName(String username){
        nameOfUser.setText(username);
    }

}
