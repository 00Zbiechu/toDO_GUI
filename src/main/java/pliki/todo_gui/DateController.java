package pliki.todo_gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import java.time.LocalDate;

import java.io.IOException;


public class DateController {

    @FXML
    Text nameOfUser;

    @FXML
    DatePicker chooseDate;

    public void displayName(String username){
        nameOfUser.setText(username);
    }

    public void confirmDate(ActionEvent event) throws IOException{

            LocalDate myDate = chooseDate.getValue();
            System.out.println(myDate);
    }

}
