package AvishayDadon_GuyBenari;
import javax.swing.*;
import java.util.*;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(null);
        alert.setHeaderText("Do you see this message?");
        alert.setContentText(null);
        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");
        alert.getButtonTypes().setAll(yesButton, noButton);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == yesButton) {
            JOptionPane.showMessageDialog(null, "Grate");
        } else {
            JOptionPane.showMessageDialog(null, "OK");
        }
    }
}
