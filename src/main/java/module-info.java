module pliki.todo_gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens pliki.todo_gui to javafx.fxml;
    exports pliki.todo_gui;
}