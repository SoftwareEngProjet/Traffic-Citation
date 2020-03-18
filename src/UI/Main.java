package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;


public class Main extends Application {

    //private TextField



    @Override
    public void start(Stage primaryStage) throws Exception{

        GridPane panel = new GridPane();
        panel.setHgap(5);
        panel.setVgap(5);




        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Traffic Citations - Sault Ste. Marie");
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
