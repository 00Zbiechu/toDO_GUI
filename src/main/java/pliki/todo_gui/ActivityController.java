package pliki.todo_gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.io.PrintWriter;


public class ActivityController {

    //FXML
    @FXML
    private Text hello;

    @FXML
    private TextArea activityList;

    @FXML
    private Label message;


    //GUI
    private final Stage newStage = new Stage();
    private Scene scene;
    private Parent root;


    //Var
    private final String[] actions= new String[10];
    private byte currentAction = 0;

    //Var for save
    private String name;
    private LocalDate date;


    public void addToCurrentAction(){

        this.currentAction++;

    }



    public void createEmptyList(){
        for(int i=0;i<10;i++){
            actions[i]=("["+i+"] ---------- [0:0]");
        }
    }

    public void clearList(){
        activityList.clear();
    }

    public void showActions(){
        for(int i=0;i<10;i++) {
            activityList.appendText(actions[i]+"\n");
        }
    }




    public void setWelcome(String name,LocalDate date){
        hello.setText("Witaj użytkowniku "+name+", edytujesz ustawienia dla "+date);
        this.name=name;
        this.date=date;

    }



    //ADD Scene
    public void switchAdd() throws IOException {

        message.setText("");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewAdd.fxml"));
        root = loader.load();
        scene = new Scene(root);
        newStage.setScene(scene);
            newStage.setResizable(false);
            newStage.setTitle("Dodaj aktywność");
            newStage.setAlwaysOnTop(true);
                AddController addController = loader.getController();
                loader.setController(addController);
        newStage.showAndWait();
                addNewAction(addController.getNewActionContent(),addController.getNewActionHour(),addController.getNewActionMinutes());
                clearList();
                showActions();
    }


    //Set add
    public void addNewAction(String newActions, String newHour, String newMinute){
        if(currentAction<10){
            actions[currentAction]=("["+currentAction+"] "+newActions+" ["+newHour+":"+newMinute+"]");
            addToCurrentAction();
        }else{
            message.setText("Maksymalna liczba operacji do dodania [10]");
        }
    }




    //Edit Scene
    public void switchEdit() throws IOException {

        message.setText("");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewEdit.fxml"));
        root = loader.load();
        scene = new Scene(root);
        newStage.setScene(scene);
            newStage.setResizable(false);
            newStage.setTitle("Edytuj aktywność");
            newStage.setAlwaysOnTop(true);
                EditController editController = loader.getController();
                loader.setController(editController);
        newStage.showAndWait();
                editNewAction(editController.getEditNumber(),editController.getEditActionContent(),editController.getEditActionHour(),editController.getEditActionMinutes());
                clearList();
                showActions();

    }

    //Set edit
    public void editNewAction(byte number, String newActions, String newHour, String newMinute){
        if(number>-1 && number<10){
            actions[number]=("["+number+"] "+newActions+" ["+newHour+":"+newMinute+"]");
        }else{
            message.setText("Nr wykracza poza zakres zadań [0-9]");
        }
    }






    //Delete Scene
    public void switchDelete() throws IOException {

        message.setText("");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewDelete.fxml"));
        root = loader.load();
        scene = new Scene(root);
        newStage.setScene(scene);
            newStage.setResizable(false);
            newStage.setTitle("Usuń aktywność");
            newStage.setAlwaysOnTop(true);
                DeleteController deleteController = loader.getController();
                loader.setController(deleteController);
        newStage.showAndWait();
                deleteNewAction(deleteController.getDeleteNumber());
                clearList();
                showActions();

    }

    //Set delete
    public void deleteNewAction(byte number){
        if(number>-1 && number<10){
            actions[number]=("["+number+"] ---------- [0:0]");
        }else{
            message.setText("Nr wykracza poza zakres zadań [0-9]");
        }
    }





    //Save Scene
    public void switchSave() throws IOException {

        message.setText("");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewSave.fxml"));
        root = loader.load();
        scene = new Scene(root);
        newStage.setScene(scene);
            newStage.setResizable(false);
            newStage.setTitle("Zapisz aktywności");
            newStage.setAlwaysOnTop(true);
                SaveController saveController = loader.getController();
                loader.setController(saveController);
        newStage.showAndWait();
                saveNewAction(saveController.getPathToFile(),name,date);

    }

    //Set save
    public void saveNewAction(String where,String name,LocalDate date){

        try{

            PrintWriter zapis = new PrintWriter(where+"Zadania.txt");
            zapis.println("Zadania dla użytkownika "+name+", ustawienia dla "+date+"\n");

            for(int i=0;i<10;i++){

                zapis.println(actions[i]+"\n");

            }

            zapis.close();

        }
        catch (Exception e){
            message.setText("Zapisywanie nie powiodło się");
        }

    }





}
