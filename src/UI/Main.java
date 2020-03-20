package UI;

import Entities.DBConnection;
import Entities.Driver;
import Entities.Vehicle;
import Entities.Citation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    //MAIN MENU BUTTONS:
   private Button btnShowCitations = new Button("View All Citations");
   private Button btnShowDrivers = new Button("View All Drivers");
   private Button btnShowVehicles = new Button("View All Vehicles");
   private Button btnCreateNewCitation = new Button("Create New Citation");
   private Button btnCreateNewDriver = new Button("Create New Driver");
   private Button btnCreateNewVehicle = new Button("Create New Vehicle");


   //Tables for viewing the database information
   private TableView showCitationsTable = new TableView();
   //private VBox showCitationsTableVBox = new VBox(showCitationsTable);

   private TableView showDriversTable = new TableView();
    //private VBox showDriversTableVBox = new VBox(showVehiclesTable);

    private TableView showVehiclesTable = new TableView();
    //private VBox showVehiclesTableVbox = new Vbox(show


    //NEW CITATION BUTTONS AND TEXT FIELDS:
    private TextField newCitationDate = new TextField();
    private TextField newCitationFine = new TextField();
    private CheckBox isPaid = new CheckBox("Paid? (Check if yes.)");
    private HBox isPaidHBox = new HBox(isPaid);
    private TextField newCitationOfficerID = new TextField();
    private TextField newCitationDriverID = new TextField();
    private TextField newCitationLicense = new TextField();
    private TextField newCitationMake = new TextField();
    private CheckBox isStolen = new CheckBox("Stolen? (Check if yes.)");
    private HBox isStolenHBox = new HBox(isStolen);
    private CheckBox isRegistered = new CheckBox("Registered? (Check if yes.)");
    private HBox isRegisteredHbox = new HBox(isRegistered);
    private CheckBox isWanted = new CheckBox("Wanted? (Check is yes.)");
    private HBox isWantedHbox = new HBox(isWanted);
    private Button newCitationSave = new Button("Save");


    //NEW DRIVER BUTTONS AND TEXT FIELDS
    private TextField newDriverName = new TextField();
    private CheckBox isSuspended = new CheckBox("Driver Suspended? (Check if yes.)");
    private HBox isSuspendedHBox = new HBox(isSuspended);
    private CheckBox isRevoked = new CheckBox("License Revoked? (Check if yes.) ");
    private HBox isRevokedHBox = new HBox(isRevoked);
    private TextField newDriverBirthday = new TextField();
    private Button newDriverSave = new Button("Save");

    //NEW VEHICLE BUTTONS AND TEXT FIELDS



    @Override
    public void start(Stage primaryStage) throws IOException {

        //Create the environment itself.
        GridPane panel = new GridPane();
        panel.setHgap(5);
        panel.setVgap(5);

        //Display all the buttons, and make a lable above those buttons.
        panel.add(new Label("Sault Ste. Marie Traffic Citations"), 2, 0);
        panel.add(btnShowCitations, 0, 1);
        panel.add(btnShowDrivers, 0, 2);
        panel.add(btnShowVehicles, 0 ,3);

        panel.add(btnCreateNewCitation, 3, 1);
        panel.add(btnCreateNewDriver, 3, 2);
        //panel.add(btnCreateNewVehicle, 3, 3);

        btnShowCitations.setPrefWidth(150);
        btnShowDrivers.setPrefWidth(150);
        btnShowVehicles.setPrefWidth(150);
        btnCreateNewCitation.setPrefWidth(150);
        btnCreateNewDriver.setPrefWidth(150);
        btnCreateNewVehicle.setPrefWidth(150);



        //Event handlers for when the buttons are pushed:
        //These are event handlers for viewing data from the database.
        btnShowCitations.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane showCitationsPane = new GridPane();
                Stage stage = new Stage();
                stage.setTitle("Traffic Citations");
                showCitationsPane.add(showCitationsTable, 0, 0);
                showCitationsTable.setPrefWidth(450);


                stage.setScene(new Scene(showCitationsPane, 450, 300));
                stage.show();
            }
        });


        btnShowVehicles.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane showVehiclesPane = new GridPane();
                Stage stage = new Stage();
                stage.setTitle("All Vehicles");
                showVehiclesPane.add(showVehiclesTable, 0, 0);
                showVehiclesTable.setPrefWidth(450);


                stage.setScene(new Scene(showVehiclesPane, 450, 300));
                stage.show();
            }
        });

        btnShowDrivers.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane showDriversPane = new GridPane();
                Stage stage = new Stage();
                stage.setTitle("Show Drivers");
                showDriversPane.add(showDriversTable, 0, 0);
                showDriversTable.setPrefWidth(450);


                stage.setScene(new Scene(showDriversPane, 450, 300));
                stage.show();
            }
        });

        //These event handlers are for adding new entities to the DB.
        btnCreateNewCitation.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane newCitationsPane = new GridPane();
                Stage stage = new Stage();

                newCitationsPane.add(new Label("Create New Citation: "), 0, 0);
                newCitationsPane.add(new Label("Date of Offense: "), 0, 2);
                newCitationsPane.add(newCitationDate, 1 , 2);
                newCitationDate.setPrefWidth(150);

                newCitationsPane.add(new Label("Fine Amount: "), 0, 3);
                newCitationsPane.add(newCitationFine, 1, 3);
                newCitationFine.setPrefWidth(150);

                newCitationsPane.add(isPaidHBox, 1, 4);

                newCitationsPane.add(new Label("Officer ID Number: "), 0, 5);
                newCitationsPane.add(newCitationOfficerID, 1, 5);
                newCitationOfficerID.setPrefWidth(150);


                newCitationsPane.add(new Label("Driver ID Number: "), 0, 7);
                newCitationsPane.add(newCitationDriverID, 1, 7);
                newCitationDriverID.setPrefWidth(150);

                newCitationsPane.add(new Label("Vehicle License: "), 0, 8);
                newCitationsPane.add(newCitationLicense, 1, 8);
                newCitationLicense.setPrefWidth(150);

                newCitationsPane.add(new Label("Vehicle Make: "), 0, 9 );
                newCitationsPane.add(newCitationMake, 1, 9);
                newCitationMake.setPrefWidth(150);

                newCitationsPane.add(isStolenHBox, 1, 10);
                newCitationsPane.add(isRegisteredHbox, 1, 11);
                newCitationsPane.add(isWantedHbox, 1, 12);
                
                newCitationsPane.add(newCitationSave, 1, 17);


                newCitationsPane.setVgap(5);
                newCitationsPane.isResizable();
                stage.setResizable(false);
                stage.setTitle("Create New Citation");
                stage.setScene(new Scene(newCitationsPane, 390, 450));
                stage.show();
            }
        });

        newCitationSave.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //ATTN Matt: This is the save button for a new citation that you will need to manipulate for saving to a database.
            }
        });


        btnCreateNewDriver.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane newDriversPane = new GridPane();
                Stage stage = new Stage();

                newDriversPane.add(new Label("Create New Driver"), 0, 0);
                newDriversPane.add(new Label("Driver Name: "), 0, 2);
                newDriversPane.add(newDriverName, 1, 2);
                newDriverName.setPrefWidth(150);

                newDriversPane.add(isSuspendedHBox, 1, 3);

                newDriversPane.add(isRevokedHBox, 1, 4);

                newDriversPane.add(new Label("Driver birth date: "),0 , 5);
                newDriversPane.add(newDriverBirthday, 1, 5);
                newDriverBirthday.setPrefWidth(150);

                newDriversPane.add(newDriverSave, 1, 6);

                newDriversPane.setVgap(5);
                stage.setResizable(false);
                stage.setTitle("Create New Driver");
                stage.setScene(new Scene(newDriversPane, 325, 350));
                stage.show();
            }
        });

        newDriverSave.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //ATTN Matt: This is the save button for a new driver that you will need to manipulate for saving to a database.
            }
        });




        panel.setAlignment(Pos.TOP_CENTER);

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Traffic Citations - Sault Ste. Marie");
        primaryStage.setScene(new Scene(panel, 500, 300));
        primaryStage.setResizable(false);

        primaryStage.show();


    }


    public static void main(String[] args) {
        // Establish DB Connection
        DBConnection db = new DBConnection();

        /*
         * Querying All Drivers
         */
        ArrayList<Driver> drivers = db.queryAllDrivers();
        for (Driver driver : drivers) {
            System.out.println();
            System.out.println("Name: " + driver.getName());
            System.out.println("Birthday: " + driver.getBirthday());
            System.out.println("ID: " + driver.getId());
            System.out.println("Revoked: " + (driver.getRevoked() == 1 ? "Revoked" : "Clear"));
            System.out.println("Suspended: " + (driver.getSuspended() == 1 ? "Suspended" : "Clear"));
            System.out.println("License: " + driver.getLicense());
            System.out.println();
        }

        /*
         * Querying All Vehicles
         */
        ArrayList<Vehicle> vehicles = db.queryAllVehicles();
        for (Vehicle vehicle : vehicles) {
            System.out.println();
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("License: " + vehicle.getLicense());
            System.out.println("Vehicle ID: " + vehicle.getId());
            System.out.println("Stolen: " + (vehicle.getStolen() == 1 ? "Stolen" : "Clear"));
            System.out.println("Registered: " + (vehicle.getRegistered() == 1 ? "Registered" : "Clear"));
            System.out.println("Wanted: " + (vehicle.getWanted() == 1 ? "Wanted" : "Clear"));
            System.out.println("Driver ID: " + vehicle.getDriverId());
            System.out.println();
        }

        /*
         * Querying All Citations
         * - this method returns
         */
        ArrayList<Citation> citations = db.queryAllCitations();
        for (Citation citation : citations) {

        }

        Application.launch();
    }
}
