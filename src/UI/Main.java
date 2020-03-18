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

   private Button btnShowCitations = new Button("View All Citations");
   private Button btnShowDrivers = new Button("View All Drivers");
   private Button btnShowVehicles = new Button("View All Vehicles");


   private Button btnCreateNewCitation = new Button("Create New Citation");
   private Button btnCreateNewDriver = new Button("Create New Driver");
   private Button btnCreateNewVehicle = new Button("Create New Vehicle");



    @Override
    public void start(Stage primaryStage) throws Exception{

        GridPane panel = new GridPane();
        panel.setHgap(5);
        panel.setVgap(5);

        panel.add(new Label("Sault Ste. Marie Traffic Citations"), 2, 0);
        panel.add(btnShowCitations, 0, 1);
        panel.add(btnShowDrivers, 0, 2);
        panel.add(btnShowVehicles, 0 ,3);

        panel.add(btnCreateNewCitation, 3, 1);
        panel.add(btnCreateNewDriver, 3, 2);
        panel.add(btnCreateNewVehicle, 3, 3);



        panel.setAlignment(Pos.TOP_CENTER);

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Traffic Citations - Sault Ste. Marie");
        primaryStage.setScene(new Scene(panel, 450, 300));
        primaryStage.setResizable(false);

        primaryStage.show();


    }


    public static void main(String[] args) {
        Application.launch();
    }
}
