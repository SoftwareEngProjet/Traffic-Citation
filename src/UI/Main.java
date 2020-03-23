package UI;

import Entities.Citation;
import Entities.DBConnection;
import Entities.Driver;
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

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

import Entities.*;

public class Main extends Application {

    //MAIN MENU BUTTONS:
   private Button btndriverLookup = new Button("Driver Lookup");


   private Button btnCreateNewCitation = new Button("Create New Citation");
   private Button btnCreateNewDriver = new Button("Create New Driver");
   private Button btnCreateNewVehicle = new Button("Create New Vehicle");
   private Button btnCreateNewWarrant = new Button("Create New Warrant");
   private Button btnCreateNewTicket = new Button("Create New Ticket");
   private Button btnDrivingSchool = new Button("Driving School");


   //Tables for viewing the database information
   private TableView showCitationsTable = new TableView();
   //private VBox showCitationsTableVBox = new VBox(showCitationsTable);

   private TableView showDriversTable = new TableView();
    //private VBox showDriversTableVBox = new VBox(showVehiclesTable);

    private TableView showVehiclesTable = new TableView();
    //private VBox showVehiclesTableVbox = new Vbox(show

    private TextField driverLookupSearch = new TextField();

    //NEW CITATION BUTTONS AND TEXT FIELDS:
    private DatePicker newCitationDate = new DatePicker();
    private TextField newCitationFine = new TextField();
    private CheckBox isPaid = new CheckBox("Paid? (Check if yes.)");
    private HBox isPaidHBox = new HBox(isPaid);
    private TextField newCitationOfficerID = new TextField();
    private TextField newCitationDriverID = new TextField();
    private TextField newCitationVehicleID = new TextField();
//    private TextField newCitationLicense = new TextField();
//    private TextField newCitationMake = new TextField();
//    private CheckBox isStolen = new CheckBox("Stolen? (Check if yes.)");
//    private HBox isStolenHBox = new HBox(isStolen);
//    private CheckBox isRegistered = new CheckBox("Registered? (Check if yes.)");
//    private HBox isRegisteredHbox = new HBox(isRegistered);
//    private CheckBox isWanted = new CheckBox("Wanted? (Check is yes.)");
//    private HBox isWantedHbox = new HBox(isWanted);
    private Button newCitationSave = new Button("Save");


    //NEW DRIVER BUTTONS AND TEXT FIELDS
    private TextField newDriverName = new TextField();
    private CheckBox isSuspended = new CheckBox("Driver Suspended? (Check if yes.)");
    private HBox isSuspendedHBox = new HBox(isSuspended);
    private CheckBox isRevoked = new CheckBox("License Revoked? (Check if yes.) ");
    private HBox isRevokedHBox = new HBox(isRevoked);
    private DatePicker newDriverBirthday = new DatePicker();
    private TextField newDriverLicense = new TextField();
    private Button newDriverSave = new Button("Save");

    //NEW VEHICLE BUTTONS AND TEXT FIELDS
    private TextField newVehicleDriverID = new TextField();
    private TextField newVehicleLicense = new TextField();
    private TextField newVehicleMake = new TextField();
    private CheckBox vehicleIsStolen = new CheckBox("Stolen? (Check if yes.)");
    private HBox vehicleIsStolenHBox = new HBox(vehicleIsStolen);
    private CheckBox vehicleIsRegistered = new CheckBox("Registered? (Check if yes.)");
    private HBox vehicleIsRegisteredHbox = new HBox(vehicleIsRegistered);
    private CheckBox vehicleIsWanted = new CheckBox("Wanted? (Check is yes.)");
    private HBox vehicleIsWantedHbox = new HBox(vehicleIsWanted);
    private Button newVehicleSave = new Button("Save");

    //NEW WARRANT BUTTONS AND TEXT FIELDS:
    private DatePicker newWarrantDate = new DatePicker();
    private TextField newWarrantFine = new TextField();
    private CheckBox warrantIsPaid = new CheckBox("Paid? (Check if yes.)");
    private HBox warrantIsPaidHBox = new HBox(warrantIsPaid);
    private TextField newWarrantOfficerID = new TextField();
    private TextField newWarrantDriverID = new TextField();
    private TextField newWarrantDescription = new TextField();
    private Button newWarrantSave = new Button("Save");

    //NEW TICKET BUTTONS AND TEXT FIELDS
    private DatePicker newTicketDate = new DatePicker();
    private TextField newTicketFine = new TextField();
    private CheckBox ticketIsPaid = new CheckBox("Paid? (Check if yes.)");
    private HBox ticketIsPaidHBox = new HBox(ticketIsPaid);
    private TextField newTicketOfficerID = new TextField();
    private TextField newTicketDriverID = new TextField();
    private Button newTicketSave = new Button("Save");


    //DRIVING SCHOOL BUTTONS AND TEXT FIELDS
    private DatePicker firstDay = new DatePicker();
    private DatePicker secondDay = new DatePicker();
    private TextField schoolDriverID = new TextField();
    private Button drivingSchoolSave = new Button("Save");

    @Override
    public void start(Stage primaryStage) throws IOException {

        //Create the environment itself.
        GridPane panel = new GridPane();
        panel.setHgap(5);
        panel.setVgap(5);

        //Display all the buttons, and make a lable above those buttons.
        panel.add(new Label("Sault Ste. Marie Traffic Citations"), 2, 0);
        panel.add(btndriverLookup, 0, 1);
        panel.add(btnDrivingSchool,0, 2);

        panel.add(btnCreateNewCitation, 3, 1);
        panel.add(btnCreateNewDriver, 3, 2);
        panel.add(btnCreateNewVehicle, 3, 3);
        panel.add(btnCreateNewWarrant, 3, 4);
        panel.add(btnCreateNewTicket, 3, 5);

        btndriverLookup.setPrefWidth(150);
        btnDrivingSchool.setPrefWidth(150);
        btnCreateNewCitation.setPrefWidth(150);
        btnCreateNewDriver.setPrefWidth(150);
        btnCreateNewVehicle.setPrefWidth(150);
        btnCreateNewWarrant.setPrefWidth(150);
        btnCreateNewTicket.setPrefWidth(150);




        //Event handlers for when the buttons are pushed:
        //These are event handlers for viewing data from the database.
        btndriverLookup.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane driverLookupPane = new GridPane();
                Stage stage = new Stage();
                stage.setTitle("Driver Lookup");

                driverLookupPane.add(new Label("Search: "), 0, 2);
                driverLookupPane.add(driverLookupSearch, 0, 3);

                //Driver d = new lookupDriver(driverLookupSearch.getText());

                driverLookupPane.add(showCitationsTable, 0, 4);
                showCitationsTable.setPrefWidth(450);

                stage.setScene(new Scene(driverLookupPane, 450, 450));
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

                newCitationsPane.add(new Label("Vehicle ID: "), 0, 8);
                newCitationsPane.add(newCitationVehicleID, 1, 8);
                newCitationVehicleID.setPrefWidth(150);
                
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
                // gets the current date for date of offense
                System.out.println(newCitationDate.getValue());

                Offense offense = new Offense(
                        0,
                        new Date(Calendar.getInstance().getTime().getTime()),
                        new BigDecimal(newCitationFine.getText()),
                        (byte)((isPaid.isSelected())?1:0),
                        Integer.parseInt(newCitationOfficerID.getText()),
                        Integer.parseInt(newCitationDriverID.getText())
                );
                DBConnection db = new DBConnection();
                int offense_id = db.insertOffense(offense);
                Citation citation = new Citation(offense_id, Integer.parseInt(newCitationVehicleID.getText()));
                db.insertCitation(citation);
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

                newDriversPane.add(new Label("Driver License: "), 0, 6);
                newDriversPane.add(newDriverLicense, 1, 6);
                newDriverLicense.setPrefWidth(150);

                newDriversPane.add(newDriverSave, 1, 7);

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
                Driver driver = new Driver(
                        0,
                        newDriverName.getText(),
                        (byte)((isSuspended.isSelected())?1:0),
                        (byte)((isRevoked.isSelected())?1:0),
                        Date.valueOf(newDriverBirthday.getValue()),
                        newDriverLicense.getText());
                DBConnection db = new DBConnection();
                db.insertDriver(driver);
            }
        });

        btnCreateNewVehicle.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane newVehiclesPane = new GridPane();
                Stage stage = new Stage();

                newVehiclesPane.add(new Label("Create New Vehicle: "), 0, 0);


                newVehiclesPane.add(new Label("Driver ID Number: "), 0, 1);
                newVehiclesPane.add(newVehicleDriverID, 1, 1);
                newVehicleDriverID.setPrefWidth(150);

                newVehiclesPane.add(new Label("Vehicle License: "), 0, 2);
                newVehiclesPane.add(newVehicleLicense, 1, 2);
                newVehicleLicense.setPrefWidth(150);

                newVehiclesPane.add(new Label("Vehicle Make: "), 0, 3 );
                newVehiclesPane.add(newVehicleMake, 1, 3);
                newVehicleMake.setPrefWidth(150);

                newVehiclesPane.add(vehicleIsStolenHBox, 1, 4);
                newVehiclesPane.add(vehicleIsRegisteredHbox, 1, 5);
                newVehiclesPane.add(vehicleIsWantedHbox, 1, 6);

                newVehiclesPane.add(newVehicleSave, 1, 7);


                newVehiclesPane.setVgap(5);
                newVehiclesPane.isResizable();
                stage.setResizable(false);
                stage.setTitle("Create New Vehicle");
                stage.setScene(new Scene(newVehiclesPane, 390, 400));
                stage.show();
            }
        });

        newVehicleSave.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //ATTN Matt: This is the save button for a new vehicle that you will need to manipulate for saving to a database.
                Vehicle vehicle = new Vehicle(
                        0,
                        newVehicleLicense.getText(),
                        newVehicleMake.getText(),
                        (byte)((vehicleIsStolen.isSelected())?1:0),
                        (byte)((vehicleIsRegistered.isSelected())?1:0),
                        (byte)((vehicleIsWanted.isSelected())?1:0),
                        Integer.parseInt(newVehicleDriverID.getText())
                );
                DBConnection db = new DBConnection();
                db.insertVehicle(vehicle);
            }
        });

        btnCreateNewWarrant.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane newWarrantPane = new GridPane();
                Stage stage = new Stage();

                newWarrantPane.add(new Label("Create New Warrant"), 0, 0);

                newWarrantPane.add(new Label("Date of Offense: "), 0, 2);
                newWarrantPane.add(newWarrantDate, 1 , 2);
                newWarrantDate.setPrefWidth(150);

                newWarrantPane.add(new Label("Fine Amount: "), 0, 3);
                newWarrantPane.add(newWarrantFine, 1, 3);
                newWarrantFine.setPrefWidth(150);

                newWarrantPane.add(warrantIsPaidHBox, 1, 4);

                newWarrantPane.add(new Label("Officer ID Number: "), 0, 5);
                newWarrantPane.add(newWarrantOfficerID, 1, 5);
                newWarrantOfficerID.setPrefWidth(150);


                newWarrantPane.add(new Label("Driver ID Number: "), 0, 7);
                newWarrantPane.add(newWarrantDriverID, 1, 7);
                newWarrantDriverID.setPrefWidth(150);

                newWarrantPane.add(new Label("Offense Description: "),0 , 13);
                newWarrantPane.add(newWarrantDescription, 1, 13);
                newWarrantDescription.setPrefWidth(150);
                newWarrantDescription.setPrefHeight(65);


                newWarrantPane.add(newWarrantSave, 1, 14);

                newWarrantPane.setVgap(5);
                stage.setResizable(false);
                stage.setTitle("Create New Warrant");
                stage.setScene(new Scene(newWarrantPane, 375, 450));
                stage.show();
            }
        });

        newWarrantSave.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //ATTN Matt: This is the save button for a new warrant that you will need to manipulate for saving to a database.
            }
        });

        btnCreateNewTicket.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane newTicketPane = new GridPane();
                Stage stage = new Stage();

                newTicketPane.add(new Label("Create New Ticket"), 0, 0);


                newTicketPane.add(new Label("Date of Offense: "), 0, 2);
                newTicketPane.add(newTicketDate, 1 , 2);
                newTicketDate.setPrefWidth(150);

                newTicketPane.add(new Label("Fine Amount: "), 0, 3);
                newTicketPane.add(newTicketFine, 1, 3);
                newTicketFine.setPrefWidth(150);

                newTicketPane.add(ticketIsPaidHBox, 1, 4);

                newTicketPane.add(new Label("Officer ID Number: "), 0, 5);
                newTicketPane.add(newTicketOfficerID, 1, 5);
                newTicketOfficerID.setPrefWidth(150);


                newTicketPane.add(new Label("Driver ID Number: "), 0, 7);
                newTicketPane.add(newTicketDriverID, 1, 7);
                newTicketDriverID.setPrefWidth(150);

                newTicketPane.add(newTicketSave, 1, 13);

                newTicketPane.setVgap(5);
                stage.setResizable(false);
                stage.setTitle("Create New Ticket");
                stage.setScene(new Scene(newTicketPane, 275, 420));
                stage.show();
            }
        });

        newTicketSave.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //ATTN Matt: This is the save button for a new warrant that you will need to manipulate for saving to a database.

            }
        });

        btnDrivingSchool.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                GridPane drivingSchoolPane = new GridPane();
                Stage stage = new Stage();

                drivingSchoolPane.add(new Label("Driving School"), 0, 0);
                drivingSchoolPane.add(new Label("Day One: "), 0, 2);
                drivingSchoolPane.add(firstDay, 1, 2);
                firstDay.setPrefWidth(150);

                drivingSchoolPane.add(new Label("Day Two: "), 0, 3);
                drivingSchoolPane.add(secondDay,1, 3);

                drivingSchoolPane.add(new Label("Driver ID:"), 0, 4);
                drivingSchoolPane.add(schoolDriverID, 1, 4);

                drivingSchoolPane.add(drivingSchoolSave, 1, 5);

                drivingSchoolPane.setVgap(5);
                stage.setResizable(false);
                stage.setTitle("Create New Ticket");
                stage.setScene(new Scene(drivingSchoolPane, 275, 190));
                stage.show();
            }
        });

        drivingSchoolSave.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //ATTN Matt: This is the save button for a new warrant that you will need to manipulate for saving to a database.
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
        DBConnection db = new DBConnection();

        Driver d = db.lookupDriverRecord(5);

        System.out.println(d.getName());
        System.out.println(d.getBirthday());
        System.out.println(d.getId());
        System.out.println(d.getRevoked());
        System.out.println(d.getSuspended());
        System.out.println(d.getLicense());

        Application.launch();
    }
}
