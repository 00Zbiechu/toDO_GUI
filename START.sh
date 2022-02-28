#!/bin/bash
echo "Podaj sciezke do katalogu lib JavaFX"
read path
java --module-path $path --add-modules javafx.controls,javafx.fxml,javafx.graphics -jar toDO_GUI_v2.jar
