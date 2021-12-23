package pliki.todo_gui;

import javafx.fxml.FXML;
import javafx.scene.text.Text;


import java.time.LocalDate;

public class MenuController {

    //FXML
    @FXML
    Text hello;

    @FXML
    Text activity;


    public void setWelcome(String name,LocalDate date){
        hello.setText("Witaj użytkowniku "+name+", edytujesz ustawienia dla "+date);
    }



}
