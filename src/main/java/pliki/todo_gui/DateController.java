package pliki.todo_gui;


import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import java.time.LocalDate;



public class DateController {

    @FXML
    Text nameOfUser;

    @FXML
    DatePicker chooseDate;

    public void displayName(String username){
        nameOfUser.setText(username);
    }

    public void confirmDate(){

            LocalDate myDate = chooseDate.getValue();
            System.out.println(myDate);
    }

}
