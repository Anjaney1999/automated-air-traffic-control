/*
The following class will deal with all the front-end aspects of the application.
It will instantiate an ATC object and call various methods from the object to perform various tasks like:
(1) Adding an airplane
(2) Adding a waypoint
(3) Getting the location of an airplane
(4) Getting the status of an airplane
(5) Finding an alternate route for the airplane

Note: the above list does not include all the features that the ATC object will be providing
 */
package Frontend;

import Backend.JavaFiles.*;
import Ertsys._eSystem;
import com.jfoenix.controls.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javafx.util.StringConverter;
import org.controlsfx.control.Notifications;

import java.awt.*;
import java.io.File;
import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;


public class Simulation extends Application
{
  //list of alphatebets(used when creating waypoints)
  private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
  //variables that will be used as switches, to determine what a particular button does
  private boolean waypointsBeingAdded = false;
  private boolean permissiblePathBeingAdded = false;
  private boolean simulationStarted = false;
  //the unique id that is used to identify different airplanes and waypoints in the backend
  //is also used to uniquely identify a Group if the id corresponds to a waypoint, and an
  //object of type AirplaneFrontEnd if the id corresponds to an Airplane
  private Map<String, Group> waypoints = new HashMap<>();
  private Map<String, AirplaneFrontEnd> airplanes = new HashMap<>();
  //A separate map is used for airplanes that ar  added during simulation. This is done becasuse
  //the simulation runs on a separate thread and adding to a map while iterating through its keys
  //is not permitted
  private Map<String, AirplaneFrontEnd> airplanesAddedDuringSimulation = new HashMap<>();
  //the variable below is an object that represents the backend of the ATC system
  private ATC atc;
  //size of the tracked region
  private int size = 0;
  //global time
  private int time = 0;

  private String simulationType = "manual";
  private int numberOfAirplanes = 0;
  //when altering the path of an airplane, the sequence of waypoints that make up the new path are stored here
  private List<String> currentPath = new ArrayList<>();
  //when adding an edge between 2 waypoints, the waypoints are temporarily stored here
  private List <String> currentPermissibleEdge = new ArrayList<>();
  //the main application is split into 2 parts
  private HBox parentLayout = new HBox();
  //the primary pane contains the tracked region, the set of buttons and the information pane
  private VBox primaryPane = new VBox();
  private Pane trackedRegion = new Pane();
  //contains the set of buttons and the information pane
  private HBox controlAndMonitorPane = new HBox();
  private Pane informationPane = new Pane();
  //contains list of airplanes in the tracked region and a pane for adding a new airplane
  private VBox secondaryPane = new VBox();
  //pane displaying the list of airplanes in the tracked region
  private VBox trackedAirplanesPane = new VBox();
  //set of buttons
  private Pane actionsPane = new Pane();
  //information regarding the actions taken by the user or
  // various statistics taken during the simulation phase are printed here
  private ScrollPane scrollableInfoPane = new ScrollPane();
  private ScrollPane informationScrollPane = new ScrollPane();
  //to retain information regarding the airplanes that have been added, waypoints that have been added and efficiently
  //keep them speratated, variables are used to store the text that will be printed on the informationScrollPane
  private Label airplaneInformationLabel = new Label();
  private Label waypointInformationLabel = new Label();
  private Label edgeInformationLabel = new Label();
  private Label statisticsLabel = new Label();
  private double minAltitude = 10000;
  private double maxAltitude = 12000;
  //buttons
  private JFXButton simulate = new JFXButton();
  private JFXButton addAirplane = new JFXButton();
  private JFXButton addWaypoint = new JFXButton();
  private JFXButton addPath = new JFXButton();
  private JFXButton resetSimulation = new JFXButton();
  private JFXButton initializeButton = new JFXButton("Initialize");
  Stage stage = new Stage();
  //Atomic variables will be used to prevent concurrent access to variables
  private AtomicReference<String> alterAirplanePath = new AtomicReference<String>("null");
  private AtomicBoolean newAirplanesDuringSimulation = new AtomicBoolean(false);
  private AtomicBoolean airplanesBeingAdded = new AtomicBoolean(false);
  private AtomicBoolean pathBeingAltered = new AtomicBoolean(false);
  private AtomicReference<String> automaticallyAlterAirplanePath = new AtomicReference<>("null");
  private Slider speedSlider = new Slider(0, 5, 0);
  Timeline timer = new Timeline(new KeyFrame(Duration.seconds(1), event ->
  {
    updateFrontEnd();
  }));
  Label coordinates = new Label();

  public void setSize(int newSize)
  {
    size = newSize;
  }

  public void initializeSpeedSlider()
  {
    speedSlider.setMin(0);
    speedSlider.setMax(5);
    speedSlider.setSnapToTicks(true);
    speedSlider.setValue(2);
    speedSlider.setMinorTickCount(0);
    speedSlider.setMajorTickUnit(1);
    speedSlider.setSnapToTicks(true);
    speedSlider.setShowTickMarks(true);
    speedSlider.setShowTickLabels(true);
    speedSlider.setTranslateX(320);
    speedSlider.setTranslateY(30);
    speedSlider.setLabelFormatter(new StringConverter<Double>() {
      @Override
      public String toString(Double n) {
        if (n < 0.5) return "Very slow";
        if (n < 1.5) return "Slow";
        if (n < 2.5) return "Medium";
        if (n < 3.5) return "Fast";
        if (n < 4.5) return "V Fast";
        else return "V.V Fast";
      }

      @Override
      public Double fromString(String s) {
        switch (s) {
          case "Very slow":
            return 0d;
          case "Slow":
            return 1d;
          case "Medium":
            return 2d;
          case "Fast":
            return 3d;
          case "V fast":
            return 4d;
          case "V.V fast":
            return 5d;
          default:
            return 2d;
        }
      }
    });
    speedSlider.setMinWidth(200);
  }

  //The method below initializes the tracked region by setting its size and adding lines and labels
  //to make the application easier to use
  public void initializeTrackedRegion()
  {
    coordinates.setLayoutX(685);
    coordinates.setLayoutY(780);
    trackedRegion.setOnMouseMoved(new EventHandler<MouseEvent>()
    {
      @Override public void handle(MouseEvent event) {
        if(size != 0)
        {
          coordinates.setText("(" + Math.round(event.getX() * size / 800) + ", " +
                  Math.round(size - (event.getY() * size) / 800) + ")");
        }
      }
    });
    Label north = new Label("North");
    north.setLayoutX(380);
    north.setLayoutY(0);
    Label south = new Label("South");
    south.setLayoutX(380);
    south.setLayoutY(780);
    Label east = new Label("East");
    east.setLayoutX(778);
    east.setLayoutY(400);
    east.setRotate(90);
    Label west = new Label("West");
    west.setLayoutX(0);
    west.setLayoutY(400);
    west.setRotate(-90);
    trackedRegion.setId("trackedRegion");
    trackedRegion.getChildren().add(north);
    trackedRegion.getChildren().add(south);
    trackedRegion.getChildren().add(east);
    trackedRegion.getChildren().add(west);
    trackedRegion.getChildren().add(coordinates);
    trackedRegion.setMinSize(800, 800);
    trackedRegion.setMaxSize(800, 800);
    trackedRegion.setPrefSize(800, 800);

    for (int i = 0; i <= 80; i++)
    {
      Line horizontalLine = new Line();
      horizontalLine.setStartX(0);
      horizontalLine.setStartY(10 * i);
      horizontalLine.setEndX(trackedRegion.getMaxWidth());
      horizontalLine.setEndY(10 * i);
      horizontalLine.setStroke(Color.LIGHTGREY);
      horizontalLine.setStrokeWidth(0.5);
      horizontalLine.toBack();

      trackedRegion.getChildren().add(horizontalLine);
    }
    for (int i = 0; i <= 80; i++)
    {
      Line verticalLine = new Line();
      verticalLine.setStartX(10 * i);
      verticalLine.setStartY(0);
      verticalLine.setEndX(10 * i);
      verticalLine.setEndY(trackedRegion.getMaxHeight());
      verticalLine.setStroke(Color.LIGHTGREY);
      verticalLine.setStrokeWidth(0.5);
      verticalLine.toBack();
      trackedRegion.getChildren().add(verticalLine);
    }
    north.toFront();
    south.toFront();
    east.toFront();
    west.toFront();
    coordinates.toFront();
  }

  public void initializeInformationLabel(Label label, String title, String message)
  {
    if(label.getText().isEmpty())
      label.setText(title + "\n" + message);
    label.setStyle("-fx-border-width: 0.5;" + "-fx-border-radius: 5;" + "-fx-padding: 8 15 2 15;" + "-fx" +
            "-spacing: 15;");
    informationScrollPane.setContent(label);
    label.setWrapText(true);
    label.setTextAlignment(TextAlignment.JUSTIFY);
    label.setMaxWidth(500);
  }

  public void setInfoPaneText(String message, String messageType, String informationFor)
  {
    informationScrollPane.setFitToHeight(false);
    informationScrollPane.setFitToWidth(false);
    informationScrollPane.setPrefSize(553, 166);
    informationPane.getChildren().add(informationScrollPane);
    informationScrollPane.toBack();
    String title = "----------------------------------" + messageType + "----------------------------------";
    //4 different types of information that can be displayed on the information pane
    if(informationFor.equals("waypoint"))
    {
      initializeInformationLabel(waypointInformationLabel, title, message);
    }
    else if(informationFor.equals("airplane"))
    {
      initializeInformationLabel(airplaneInformationLabel, title, message);
    }
    else if(informationFor.equals("simulate"))
    {
      initializeInformationLabel(statisticsLabel, title, message);
    }
    else if(informationFor.equals("path"))
    {
      initializeInformationLabel(edgeInformationLabel, title, message);
    }
  }

  public void resetInfoPaneText()
  {
    informationPane.getChildren().remove(informationScrollPane);
  }

  public void appendMonitorPaneText(String message)
  {
    Label label = (Label) informationScrollPane.getContent();
    label.setText(label.getText() + "\n---------------------------------------------\n" + message);

  }

  public void updateMonitorPaneText(String message)
  {
    Label label = (Label) informationScrollPane.getContent();
    label.setText("---------------------------------------------\n" + message);
  }

  //code from: https://stackoverflow.com/questions/26854301/how-to-control-the-javafx-tooltips-delay
  //to change the delay for tooltips
  public static void hackTooltipStartTiming(Tooltip tooltip)
  {
    try
    {
      Field fieldBehavior = tooltip.getClass().getDeclaredField("BEHAVIOR");
      fieldBehavior.setAccessible(true);
      Object objBehavior = fieldBehavior.get(tooltip);

      Field fieldTimer = objBehavior.getClass().getDeclaredField("activationTimer");
      fieldTimer.setAccessible(true);
      Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);

      objTimer.getKeyFrames().clear();
      objTimer.getKeyFrames().add(new KeyFrame(new Duration(300)));
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  //Eventer handler for adding waypoints to the region
  public EventHandler addWaypointToRegionEvent()
  {
    return new EventHandler<MouseEvent>()
    {
      public void handle(MouseEvent event)
      {
        Random random = new Random();
        //make sure add Waypoint button has been pressed
        if (waypointsBeingAdded)
        {
          //make sure id is unique
          String id;
          do
          {
            id = Character.toString(alphabet.charAt(random.nextInt(alphabet.length())));
          }
          while (!atc.idIsUnique(_eSystem._lString(id), (char) 0));

          //add waypoint to both waypoints and the backend ATC system
          if(((event.getX() * size) / 800) <= size && ((event.getX() * size) / 800) >= 0 && ((event.getY() * size) / 800) <= size &&
                  ((event.getY() * size) / 800) >= 0)
          {
            if (atc.isValidWaypointLocation((event.getX() * size) / 800, size - (event.getY() * size) / 800))
            {
              setCursorColour(Color.LIGHTGREEN, Color.BLACK);
              atc.addWaypoint(_eSystem._lString(id), (char) 0, (event.getX() * size) / 800,
                      size - (event.getY() * size) / 800);
              Group waypoint = new Group();
              waypoint.setLayoutX(event.getX());
              waypoint.setLayoutY(event.getY());
              waypoint.getChildren().add(new Circle(10, Color.GRAY));
              waypoint.setOnMouseClicked(appendToNewPath(waypoint));
              waypoint.setId(id);
              trackedRegion.getChildren().add(waypoint);
              waypoints.put(id, waypoint);
              Tooltip waypointToolTip = new Tooltip();
              hackTooltipStartTiming(waypointToolTip);
              //include tooltip to show information about waypoint
              waypointToolTip.setText("ID: " + waypoint.getId() + "\n" + "Location: " +
                      _eSystem._lJavaString(atc.getWaypointLocation(_eSystem._lString(id), (char) 0)));
              Tooltip.install(waypoint, waypointToolTip);
              appendMonitorPaneText("Added waypoint " + "\"" + id + "\"" + " at " + (event.getX() * size) / 800 + ", " +
                      (size - (event.getY() * size) / 800));
            } else
            {
              setCursorColour(Color.RED, Color.BLACK);
            }
          }
          else
            setCursorColour(Color.RED, Color.BLACK);
        }
      }
    };
  }

  //Button which when pressed, waypoints can be added to the region
  //All other buttons must be disabled when this button has been pressed
  public EventHandler addWaypointButtonEvent()
  {
    return new EventHandler<ActionEvent>()
    {
      @Override public void handle(ActionEvent event) {
        waypointsBeingAdded = !waypointsBeingAdded;
        if (waypointsBeingAdded == false)
        {
          resetInfoPaneText();
          addWaypoint.setText("Add Waypoint");
          trackedRegion.setCursor(Cursor.DEFAULT);
          resetSimulation.setDisable(false);
          permissiblePathBeingAdded = false;
          airplanesBeingAdded.set(false);
          if(simulationType.equals("manual"))
            addAirplane.setDisable(false);
          simulationStarted = false;

          if(waypoints.size() > 1)
          {
            addPath.setDisable(false);
          }
          if(airplanes.size() > 0 || simulationType.equals("automatic"))
          {
            simulate.setDisable(false);
          }
          informationPane.getChildren().clear();
        } else
        {
          resetInfoPaneText();
          setInfoPaneText("Add waypoints by clicking at a particular " +
                  "point on the tracked region: ", "Information", "waypoint");
          addWaypoint.setText("Finish");
          resetSimulation.setDisable(true);
          simulate.setDisable(true);
          addPath.setDisable(true);
          addAirplane.setDisable(true);
          permissiblePathBeingAdded = false;
          airplanesBeingAdded.set(false);
          simulationStarted = false;
        }
      }
    };
  }

  //change cursor into a circle that has a radius equivalent to the minimum distance
  //required between every waypoint
  public void setCursorColour(Color largeCircle, Color smallCircle)
  {
    actionsPane.getChildren().clear();
    Group group = new Group();
    Circle circle = new Circle();
    double defaultX = 3840.0;
    double defaultY = 2160.0;
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    circle.setRadius((10000 * 800 / size) * 2 * Math.max(width / defaultX, height / defaultY));
    circle.setOpacity(0.5);
    circle.setFill(largeCircle);
    Circle circle1 = new Circle();
    circle1.setRadius(8);
    circle1.setOpacity(1);
    circle1.setFill(smallCircle);
    group.getChildren().add(circle1);
    group.getChildren().add(circle);
    group.setManaged(true);
    SnapshotParameters sp = new SnapshotParameters();
    sp.setFill(Color.TRANSPARENT);
    Image image = group.snapshot(sp, null);

    trackedRegion.setCursor(new ImageCursor(image, ((10000 * 800 / size) * 2) * Math.max(width / defaultX, height / defaultY),
            ((10000 * 800 / size) * 2) * Math.max(width / defaultX, height / defaultY)));
  }

  //if waypoints are being added, then change cursor to translucent circle
  public EventHandler cursorEnteredTrackRegionEvent()
  {
    return new EventHandler<MouseEvent>()
    {
      @Override public void handle(MouseEvent event) {
        if (waypointsBeingAdded == true)
        {
          setCursorColour(Color.LIGHTGREEN, Color.BLACK);
        }
        else
        {
          trackedRegion.setCursor(Cursor.DEFAULT);
        }
      }
    };
  }

  //change cursor back to normal once the tracked region has been exited

  public EventHandler cursorExitedTrackedRegionEvent()
  {
    return new EventHandler<MouseEvent>()
    {
      @Override public void handle(MouseEvent event) {
        trackedRegion.setCursor(Cursor.DEFAULT);
        coordinates.setText("");
      }
    };
  }
  //method that returns the coordinates of terminal points
  //given the side and a point on the side

  public double[] getTerminalPoint(String side, double point)
  {
    switch (side)
    {
      case "North":
        return new double[]{point, size};
      case "South":
        return new double[]{point, 0};
      case "East":
        return new double[]{size, point};
      case "West":
        return new double[]{0, point};
      default:
        return new double[]{};
    }
  }
  //returns the path of an airplane

  public String getPath(int i)
  {
    if(currentPath.size() == 0)
      return "";
    if (i < (currentPath.size() - 1))
      return currentPath.get(i) + "->" + getPath(i + 1);
    else
      return currentPath.get(i) + "->";
  }
  public EventHandler addAirplaneButtonEvent()
  {
    return new EventHandler()
    {
      @Override public void handle(Event event) {
        airplanesBeingAdded.set(true);
        resetWaypoints();
        pathBeingAltered.set(false);
        currentPath.clear();
        alterAirplanePath.set("null");
        if(simulationStarted == false)
        {
          resetInfoPaneText();
          setInfoPaneText("Add airplanes by completing the form on the right:",
                  "Information", "airplane");
        }
        addAirplane.setDisable(true);
        simulate.setDisable(true);
        if(informationPane.getChildren().contains(speedSlider))
          informationPane.getChildren().remove(speedSlider);
        addPath.setDisable(true);
        addWaypoint.setDisable(true);
        resetSimulation.setDisable(true);
        waypointsBeingAdded = false;
        permissiblePathBeingAdded = false;
        VBox content = new VBox();
        content.setPadding(new Insets(0, 0, 0, 45));
        content.setSpacing(10);
        Label idLabel = new Label("Airplane ID");
        Label entryPointLabel = new Label("Entry point");
        Label exitPointLabel = new Label("Exit point");
        Label entrySide = new Label("Entry side");
        Label exitSide = new Label("Exit side");
        Label altitudeLabel = new Label("Altitude");
        Label timeLabel = new Label("Time");
        ObservableList<String> options = FXCollections.observableArrayList("North", "South", "East", "West");
        final ComboBox entrySideComboBox = new ComboBox(options);
        final ComboBox exitSideComboBox = new ComboBox(options);
        TextField id = new TextField();
        TextField entryPoint = new TextField();
        TextField exitPoint = new TextField();
        TextField altitude = new TextField();
        TextField airplaneEnteringTime = new TextField();
        HBox buttons = new HBox();
        buttons.setSpacing(5);
        buttons.setPadding(new Insets(0, 0, 0, 15));
        Button cancel = new Button("Cancel");
        cancel.setOnAction(new EventHandler<ActionEvent>()
        {
          @Override public void handle(ActionEvent event) {
            if(simulationStarted == false && timer.getStatus() == Animation.Status.STOPPED)
            {
              airplanesBeingAdded.set(false);
              if(simulationType.equals("manual"))
                addAirplane.setDisable(false);
              waypointsBeingAdded = false;
              simulationStarted = false;
              actionsPane.getChildren().remove(0);
              if (atc.getNumberOfWaypoints() > 1)
              {
                addPath.setDisable(false);
              }
              if(airplanes.size() > 0 || simulationType.equals("automatic"))
                simulate.setDisable(false);
              resetSimulation.setDisable(false);
              addWaypoint.setDisable(false);
              resetWaypoints();
            }
            else
            {
              if(simulationType.equals("manual"))
                addAirplane.setDisable(true);
              addWaypoint.setDisable(true);
              actionsPane.getChildren().remove(0);
              airplanesBeingAdded.set(false);
              resetSimulation.setDisable(false);
              simulate.setDisable(false);
              if(!informationPane.getChildren().contains(speedSlider))
                informationPane.getChildren().add(speedSlider);
            }
          }
        });
        cancel.setPadding(new Insets(4, 4, 4, 4));

        Button add = new Button("Add Airplane");
        add.setPadding(new Insets(4, 10, 4, 10));

        buttons.getChildren().add(cancel);
        buttons.getChildren().add(add);
        buttons.setAlignment(Pos.CENTER);

        GridPane gp = new GridPane();
        content.getChildren().add(gp);
        content.getChildren().add(buttons);
        GridPane.setHalignment(gp, HPos.CENTER);
        gp.setAlignment(Pos.CENTER);
        gp.setId("form");
        gp.setHgap(10);
        gp.setVgap(5);
        gp.setAlignment(Pos.CENTER);
        gp.add(idLabel, 0, 0);
        gp.add(id, 1, 0);

        gp.add(entrySide, 0, 1);
        gp.add(entrySideComboBox, 1, 1);
        gp.add(entryPointLabel, 0, 2);
        gp.add(entryPoint, 1, 2);

        gp.add(exitSide, 0, 3);
        gp.add(exitSideComboBox, 1, 3);
        gp.add(exitPointLabel, 0, 4);
        gp.add(exitPoint, 1, 4);

        gp.add(timeLabel, 0, 6);
        gp.add(airplaneEnteringTime, 1, 6);

        gp.add(altitudeLabel, 0, 7);
        gp.add(altitude, 1, 7);

        actionsPane.getChildren().clear();
        actionsPane.getChildren().add(content);

        add.setOnAction(new EventHandler<ActionEvent>()
        {
          @Override public void handle(ActionEvent event) {
            if (id.getText().isEmpty())
            {
              showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                      "Enter valid id");
              return;
            }
            try
            {
              Double num = Double.parseDouble(entryPoint.getText());

              if (num.doubleValue() < 0 || num.doubleValue() > size)
              {
                showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                        "Enter a valid entry point");
                return;
              }
            } catch (NumberFormatException e)
            {
              showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                      "Enter a valid entry point");
              return;
            }
            try
            {
              Double num = Double.parseDouble(exitPoint.getText());
              if (num.doubleValue() < 0 || num.doubleValue() > size)

              {
                showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                        "Enter a valid exit point");
                return;
              }
            } catch (NumberFormatException e)
            {
              showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                      "Enter a valid exit point");
              return;
            }
            try
            {
              Integer num = Integer.parseInt(airplaneEnteringTime.getText());
              if (num.intValue() < 0)
              {
                showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                        "Enter a valid time");
                return;
              }
            } catch (NumberFormatException e)
            {
              showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                      "Enter a valid time");
              return;
            }
            try
            {
              Double num = Double.parseDouble(altitude.getText());
              if (num.doubleValue() < 8000 || num.doubleValue() > 12000)
              {
                showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                        "Enter a valid altitude");
                return;
              }
            } catch (NumberFormatException e)
            {
              showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                      "Enter a valid altitude");
              return;
            }
            if (entrySideComboBox.getSelectionModel().isEmpty() ||
                    entrySideComboBox.getValue().toString().isEmpty())
            {
              showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                      "Select an entry side");
              return;
            }
            if (exitSideComboBox.getSelectionModel().isEmpty() ||
                    exitSideComboBox.getValue().toString().isEmpty())
            {
              showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                      "Select an exit side");
              return;
            }
            if (airplanes.containsKey(id.getText()) ||
                    airplanesAddedDuringSimulation.containsKey(id.getText()))
            {
              showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                      "ID is not unique");
              return;
            }
            if (entrySideComboBox.getValue().toString().matches(exitSideComboBox.getValue().toString()))
            {
              showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                      "The entry side and exit side must be different");
              return;
            }
            double[] startingCoordinates =
                    getTerminalPoint(entrySideComboBox.getValue().toString(),
                            Double.parseDouble(entryPoint.getText()));
            double[] endingCoordinates =
                    getTerminalPoint(exitSideComboBox.getValue().toString(),
                            Double.parseDouble(exitPoint.getText()));

            if (startingCoordinates.length == 2 && endingCoordinates.length == 2 && !(startingCoordinates[0] == endingCoordinates[0] &&
                    startingCoordinates[1] == endingCoordinates[1]))
            {
              if(simulationStarted == false)
              {
                airplanes.put(id.getText(),
                        new AirplaneFrontEnd(id.getText(),
                                Integer.parseInt(airplaneEnteringTime.getText()), startingCoordinates,
                                endingCoordinates, Double.parseDouble(altitude.getText()), size));
                airplanes.get(id.getText()).setPath(currentPath);
                resetWaypoints();
              }
              else
              {
                airplanesAddedDuringSimulation.put(id.getText(),
                        new AirplaneFrontEnd(id.getText(),
                                Integer.parseInt(airplaneEnteringTime.getText()), startingCoordinates,
                                endingCoordinates, Double.parseDouble(altitude.getText()), size));
                airplanesAddedDuringSimulation.get(id.getText()).setPath(currentPath);
                resetWaypoints();
                newAirplanesDuringSimulation.set(true);
              }
            } else
            {
              showAlert(Alert.AlertType.ERROR, gp.getScene().getWindow(), "Error!",
                      "Unknown error");
              return;
            }
            Notifications.create().darkStyle().text("Successfully added airplane " + "\"" +
                    id.getText() + "\"").title("SUCCESS").position(Pos.CENTER).hideAfter(Duration.seconds(1.5)).showInformation();

            appendMonitorPaneText("Added airplane " + "\"" + id.getText() + "\":\n" + "entry point: " +
                    startingCoordinates[0] + ", " + startingCoordinates[1] + "\n" + "exit point: " +
                    endingCoordinates[0] + ", " + endingCoordinates[1] + "\n" + "time of arrival: " +
                    airplaneEnteringTime.getText() +
                    "\n" + "path: " + "source->" + getPath(0) + "target");
            currentPath.clear();
          }
        });
      }
    };
  }

  //this method deals with any feature that involves clicking wayoints like:
  //1) setting a path for an airplane
  //2) adding an edge between a pair of waypoints

  public EventHandler appendToNewPath(Group waypoint)
  {
    return new EventHandler()
    {
      @Override public void handle(Event event) {
        Circle circle = (Circle) waypoint.getChildren().get(0);
        if (airplanesBeingAdded.get()  | !alterAirplanePath.get().equals("null"))
        {
          if(!currentPath.contains(waypoint.getId()))
          {
            currentPath.add(waypoint.getId());
            circle.setFill(Color.GREY);
            Label label = new Label(currentPath.size() + "");
            label.setTextFill(Color.WHITE);
            label.setTranslateX(-3.7);
            label.setTranslateY(-9);
            label.toFront();
            label.setTranslateZ(100.0);
            waypoint.getChildren().add(label);
          }
        }
        if(permissiblePathBeingAdded)
        {
          if(currentPermissibleEdge.size() == 0)
          {
            currentPermissibleEdge.add(waypoint.getId());
            circle.setFill(Color.RED);
          }
          else if(currentPermissibleEdge.size() == 1)
          {
            if(!currentPermissibleEdge.get(0).equals(waypoint.getId()))
            {
              currentPermissibleEdge.add(waypoint.getId());

              if (atc.isWaypointInTrackedRegion(_eSystem._lString(currentPermissibleEdge.get(0)), (char) 0) &&
                      atc.isWaypointInTrackedRegion(_eSystem._lString(currentPermissibleEdge.get(1)), (char) 0))
              {

                if (!atc.containsEdge(_eSystem._lString(currentPermissibleEdge.get(0)), (char) 0,
                        _eSystem._lString(currentPermissibleEdge.get(1)), (char) 0))
                {
                  circle.setFill(Color.BLUE);
                  Line line = new Line();
                  line.toBack();
                  line.setTranslateZ(-10);
                  line.setStartX(waypoints.get(currentPermissibleEdge.get(0)).getLayoutX());
                  line.setStartY(waypoints.get(currentPermissibleEdge.get(0)).getLayoutY());

                  line.setEndX(waypoint.getLayoutX());
                  line.setEndY(waypoint.getLayoutY());

                  trackedRegion.getChildren().add(line);

                  line.setStroke(Color.GREEN);
                  line.setStrokeWidth(0.5);

                  atc.addPermissibleEdge(_eSystem._lString(currentPermissibleEdge.get(0)), (char) 0,
                          _eSystem._lString(waypoint.getId()), (char) 0);

                  appendMonitorPaneText("Added an edge between " + currentPermissibleEdge.get(0) + ", " + currentPermissibleEdge.get(1));

                  resetWaypoints();
                }
              }
              currentPermissibleEdge.clear();
            }
          }
          else
          {
            currentPermissibleEdge.clear();
          }
        }
      }
    };
  }
  //this method create a image of an airplane surrounded by a ring of length 5km

  public Group createAirplaneOnTrackedRegion(String id)
  {
    Group group = new Group();
    Label label = new Label("ID: " + id);
    label.setTranslateY(-35);
    label.setTranslateX(-10);
    Circle circle = new Circle();
    circle.setRadius(5000* 800 / size);
    circle.setFill(Color.TRANSPARENT);
    circle.setStroke(Color.GREEN);
    ImageView plane = new ImageView("plane.png");
    plane.setFitWidth(40);
    plane.setFitHeight(40);
    plane.toFront();
    group.toFront();
    group.setTranslateZ(100);
    group.setLayoutX(airplanes.get(id).getStartCoordinates()[0] * 800 / size);
    group.setLayoutY(800 - airplanes.get(id).getStartCoordinates()[1] * 800 / size);
    plane.setTranslateX(-20);
    plane.setTranslateY(-20);
    Rotate rotation = new Rotate();
    rotation.setPivotX(20);
    rotation.setPivotY(20);
    plane.getTransforms().add(rotation);
    group.getChildren().add(plane);
    group.getChildren().add(circle);
    group.getChildren().add(label);
    group.setManaged(true);
    group.toBack();
    trackedRegion.getChildren().add(group);
    return group;
  }
  //sets the angle of an airplane to point to its next waypoint or its target
  //desination if its route size is 1

  public void setAngle(String id)
  {
    String heading = _eSystem._lJavaString(atc.getCurrentPathVector(_eSystem._lString(id), (char) 0));
    if (!heading.equals("null"))
    {
      String coordinates[] = heading.split(",");
      if (coordinates.length == 2)
      {
        double x = Double.parseDouble(coordinates[0]);
        double y = Double.parseDouble(coordinates[1]);
        double angle = 0;
        if (x >= 0 && y >= 0)
        {
          angle = -1 * Math.toDegrees(Math.atan(y / x));
        } else if (x >= 0 && y < 0)
        {
          angle = -1 * Math.toDegrees(Math.atan(y / x));
        } else if (x < 0 && y < 0)
        {
          angle = 180 - Math.toDegrees(Math.atan(y / x));
        } else if (x < 0 && y >= 0)
        {
          angle = 180 - Math.toDegrees(Math.atan(y / x));
        }
        Rotate rotation = new Rotate();
        rotation.setPivotX(20);
        rotation.setPivotY(20);
        rotation.setAngle(angle);
        Group plane = (Group) airplanes.get(id).getPlane();
        ImageView planeImage = (ImageView) plane.getChildren().get(0);
        planeImage.getTransforms().remove(0);
        planeImage.getTransforms().add(rotation);
      }
    }
  }
  //creates a line that passes through all of the waypoints an airplane will visit.
  //if the route size is 1, then a line is created that passes through the airplane's current location to its destination

  public void changePath(String id)
  {
    List<String> path = airplanes.get(id).getPath();
    String pathStarting[];
    String pathEnding[];
    if (path.size() != 0)
    {
      if (path.size() == 1)
      {
        airplanes.get(id).setPathLines(path.get(0),airplanes.get(id).getStartCoordinates()[0],
                airplanes.get(id).getStartCoordinates()[1], airplanes.get(id).getEndCoordinates()[0],
                airplanes.get(id).getEndCoordinates()[1]);
        trackedRegion.getChildren().add(airplanes.get(id).getPathLines(path.get(0)));
      }
      else if (path.size() >= 2)
      {
        pathEnding = _eSystem._lJavaString(atc.getWaypointLocation(_eSystem._lString(path.get(0)), (char) 0))
                .split(",");
        if (pathEnding.length == 2)
        {
          airplanes.get(id).setPathLines(path.get(0), airplanes.get(id).getStartCoordinates()[0],
                  airplanes.get(id).getStartCoordinates()[1], Double.parseDouble(pathEnding[0]),
                  Double.parseDouble(pathEnding[1]));
          trackedRegion.getChildren().add(airplanes.get(id).getPathLines(path.get(0)));
          atc.updateAirplanePath(_eSystem._lString(id), (char) 0, _eSystem._lString(path.get(0)), (char) 0);
        }
        for (int i = 1; i < path.size() - 1; i++)
        {
          atc.updateAirplanePath(_eSystem._lString(id), (char) 0, _eSystem._lString(path.get(i)), (char) 0);
          pathStarting =
                  _eSystem._lJavaString(atc.getWaypointLocation(_eSystem._lString(path.get(i - 1)), (char) 0))
                          .split(",");
          pathEnding = _eSystem._lJavaString(atc.getWaypointLocation(_eSystem._lString(path.get(i)), (char) 0))
                  .split(",");
          if (pathStarting.length == 2 && pathEnding.length == 2)
          {
            airplanes.get(id).setPathLines(path.get(i), Double.parseDouble(pathStarting[0]),
                    Double.parseDouble(pathStarting[1]), Double.parseDouble(pathEnding[0]),
                    Double.parseDouble(pathEnding[1]));
            trackedRegion.getChildren().add(airplanes.get(id).getPathLines(path.get(i)));
            airplanes.get(id).getPathLines(path.get(i)).toBack();
          }
        }
        pathStarting = _eSystem._lJavaString(
                atc.getWaypointLocation(_eSystem._lString(path.get(path.size() - 2)), (char) 0)).split(",");
        if (pathStarting.length == 2)
        {
          airplanes.get(id)
                  .setPathLines("target", Double.parseDouble(pathStarting[0]), Double.parseDouble(pathStarting[1]),
                          airplanes.get(id).getEndCoordinates()[0], airplanes.get(id).getEndCoordinates()[1]);
          trackedRegion.getChildren().add(airplanes.get(id).getPathLines("target"));
          airplanes.get(id).getPathLines("target").toBack();
        }
      }
    }
    setAngle(id);
  }
  //this is the method that will be repeated called on a separate thread at intervals of 0.5s

  public boolean updateFrontEnd()
  {
    if(simulationType.equals("automatic") && airplanes.size() < numberOfAirplanes)
    {
      do
      {
        SecureRandom rand = new SecureRandom();
        String id;
        do
        {
          id = Character.toString(alphabet.charAt(rand.nextInt(alphabet.length())));
        }
        while (!atc.idIsUnique(_eSystem._lString(id), (char) 0) && airplanes.containsKey(id));

        List<String> sides = new ArrayList<String>();
        sides.add("North");
        sides.add("South");
        sides.add("East");
        sides.add("West");

        int entryPoint = rand.nextInt(size);
        int exitPoint = rand.nextInt(size);
        Double bound = maxAltitude + 1 - minAltitude;
        int temp = bound.intValue();
        double altitude = rand.nextInt(temp) + minAltitude;

        String selectedEntrySide;
        String selectedExitSide;

        do
        {
          selectedEntrySide = sides.get(rand.nextInt(sides.size()));
          selectedExitSide = sides.get(rand.nextInt(sides.size()));
        }
        while (selectedEntrySide.equals(selectedExitSide));

        double[] startingCoordinates = getTerminalPoint(selectedEntrySide, entryPoint);
        double[] endingCoordinates = getTerminalPoint(selectedExitSide, exitPoint);
        if (!(startingCoordinates[0] == endingCoordinates[0] && startingCoordinates[1] == endingCoordinates[1]))
        {
          airplanes.put(id, new AirplaneFrontEnd(id, 0, startingCoordinates, endingCoordinates, altitude, size));
          airplanes.get(id).setPath(currentPath);
          currentPath.clear();
        }
      }
      while(airplanes.size() < numberOfAirplanes);
    }
    if (airplanes.size() != 0)
    {
      //if the time of entry has been passed, then add the airplane to the ATC object
      for (String id : airplanes.keySet())
      {
        double[] startCoordinates = airplanes.get(id).getStartCoordinates();
        double[] endCoordinates = airplanes.get(id).getEndCoordinates();
        double altitude = airplanes.get(id).getAltitude();
        if (airplanes.get(id).getTime() <= time && airplanes.get(id).getTime() >= 0)
        {
          atc.addAirplane(_eSystem._lString(id), (char) 0, 200, startCoordinates[0], startCoordinates[1], endCoordinates[0],
                  endCoordinates[1], altitude);
          if(atc.isAirplaneInTrackedRegion(_eSystem._lString(id),(char)0))
          {
            airplanes.get(id).setTime(-1);
            airplanes.get(id).setInfo(createAirplaneInfoPane(id));
            airplanes.get(id).setExtraInfo(createExtraAirplaneInfoPane(id));
            airplanes.get(id).setPlane(createAirplaneOnTrackedRegion(id));
            changePath(id);
            setAngle(id);
          }
        }
      }
      //the following method carries out ALL backend operations like updating an airplanes location
      //calculating its status, finding potential collisions, dealing with potential collisions and
      //removing airplanes that have reached their targets or have crashed
      atc.step();
      //list to hold airplanes that have been removed by the backend program
      List<String> airplanesToRemove = new ArrayList<String>();
      //update lines represeting every airplane's path,
      //update every airplane's location
      //update every airplanes's altitude
      //update every airplane's status
      //update every airplane's direction(if needed)
      for (String id : airplanes.keySet())
      {
        if (atc.isAirplaneInTrackedRegion(_eSystem._lString(id), (char) 0))
        {
          Group airplane = (Group) airplanes.get(id).getPlane();
          String currentCoordinates[] =
                  _eSystem._lJavaString(atc.getAirplaneLocation(_eSystem._lString(id), (char) 0)).split(",");
          airplane.setLayoutX(Double.parseDouble(currentCoordinates[0]) * 800 / size);
          airplane.setLayoutY(800 - Double.parseDouble(currentCoordinates[1]) * 800 / size);
          if ((!_eSystem._lJavaString(atc.getHeading(_eSystem._lString(id), (char) 0)).equals(airplanes.get(id).getPath().get(0))))
          {
            trackedRegion.getChildren().remove(airplanes.get(id).getPathLines(airplanes.get(id).getPath().get(0)));
            airplanes.get(id).getPath().remove(0);
            Line line = airplanes.get(id).getPathLines(airplanes.get(id).getPath().get(0));
            String coordinates[] =
                    _eSystem._lJavaString(atc.getAirplaneLocation(_eSystem._lString(id), (char) 0)).split(",");
            if (coordinates.length == 2)
            {
              line.setStartX(Double.parseDouble(coordinates[0]) * 800 / size);
              line.setStartY(800 - Double.parseDouble(coordinates[1]) * 800 / size);
            }
            setAngle(id);
          } else
          {
            Line line = airplanes.get(id).getPathLines(airplanes.get(id).getPath().get(0));
            line.toBack();
            String coordinates[] = _eSystem._lJavaString(atc.getAirplaneLocation(_eSystem._lString(id),
                    (char) 0)).split(",");
            if (coordinates.length == 2)
            {
              line.setStartX(Double.parseDouble(coordinates[0]) * 800 / size);
              line.setStartY(800 - Double.parseDouble(coordinates[1]) * 800 / size);
            }
          }
          Pane infoPane = (Pane) airplanes.get(id).getInfo();
          Label altitudeLabel = (Label) infoPane.getChildren().get(1);
          Label actionLabel = (Label) infoPane.getChildren().get(2);
          actionLabel.setText("Action: " + _eSystem._lJavaString(atc.getAirplaneAction(
                  _eSystem._lString(id), (char) 0)));
          altitudeLabel.setText("Altitude: " + (long)(Math.round(atc.getAirplaneAltitude(_eSystem._lString(id),
                  (char) 0) * 100.0) / 100.0));

          String location = _eSystem._lJavaString(atc.getAirplaneLocation(
                  _eSystem._lString(id), (char) 0));
          String style = "-fx-border-width: 0.5;" + "-fx-border-radius: 5;" + "-fx-padding: 0 10 0 10;" + "-fx-spacing: 2;";

          if (_eSystem._lJavaString(atc.getAirplaneStatus(_eSystem._lString(id), (char) 0)).equals("green"))
          {
            Circle circle = (Circle) ((Group) airplanes.get(id).getPlane()).getChildren().get(1);
            circle.setStroke(Color.GREEN);
            infoPane.setStyle(style + "-fx-border-color: rgb(60,179,113)");
          } else if (_eSystem._lJavaString(atc.getAirplaneStatus(_eSystem._lString(id), (char) 0)).equals("orange"))
          {
            Circle circle = (Circle) ((Group) airplanes.get(id).getPlane()).getChildren().get(1);
            circle.setStroke(Color.ORANGE);
            infoPane.setStyle(style + "-fx-border-color: rgb(255,165,0)");
          } else if (_eSystem._lJavaString(atc.getAirplaneStatus(_eSystem._lString(id), (char) 0)).equals("red"))
          {
            Circle circle = (Circle) ((Group) airplanes.get(id).getPlane()).getChildren().get(1);
            circle.setStroke(Color.RED);
            infoPane.setStyle(style + "-fx-border-color: rgb(255,0,0)");
          }

          try
          {
            String coordinates[] = location.split(",");
            Double x = Double.parseDouble(coordinates[0]);
            Double y = Double.parseDouble(coordinates[1]);
            Label locationLabel = (Label) infoPane.getChildren().get(3);
            locationLabel.setText("Location: " + Math.round(x) + ", " + Math.round(y));
          } catch (Exception e)
          {
            System.out.println("ERROR");
          }

          Pane extraInfo = (Pane) airplanes.get(id).getExtraInfo();
          if(_eSystem._lJavaString(atc.getAirplaneAction(_eSystem._lString(id), (char) 0)).equals("elevating"))
          {
            ImageView plane = (ImageView) extraInfo.getChildren().get(0);
            plane.getTransforms().clear();
            plane.getTransforms().add(Rotate.rotate(10,50,50));
          }
          else if(_eSystem._lJavaString(atc.getAirplaneAction(_eSystem._lString(id), (char) 0)).equals("descending"))
          {
            ImageView plane = (ImageView) extraInfo.getChildren().get(0);
            plane.getTransforms().clear();
            plane.getTransforms().add(Rotate.rotate(-10,50,50));
          }
          else
          {
            ImageView plane = (ImageView) extraInfo.getChildren().get(0);
            plane.getTransforms().clear();
            plane.getTransforms().add(Rotate.rotate(0,0,0));
          }
          Label idLable = (Label) extraInfo.getChildren().get(1);
          idLable.setText("ID: " + id);
          Label ceilingLable = (Label) extraInfo.getChildren().get(2);
          ceilingLable.setText("Ceiling: " + Math.round(atc.getAirplaneCeiling(_eSystem._lString(id),(char)0) * 100.0) / 100.0);

          Label floorLable = (Label) extraInfo.getChildren().get(3);
          floorLable.setText("Floor: " + Math.round(atc.getAirplaneFloor(_eSystem._lString(id),(char)0) * 100.0) / 100.0);
        } else
        {
          if(airplanes.get(id).getTime() < time)
          {
            airplanesToRemove.add(id);
            trackedRegion.getChildren().remove(airplanes.get(id).getInfo());
            trackedRegion.getChildren().remove(airplanes.get(id).getPlane());
            trackedRegion.getChildren().remove(airplanes.get(id).getPathLines("target"));
            trackedAirplanesPane.getChildren().remove(airplanes.get(id).getInfo());
          }
        }
      }
      //alter path during simulation
      if (pathBeingAltered.get() == true && !alterAirplanePath.get().equals("null") && currentPath.size() > 0 &&
              atc.isAirplaneInTrackedRegion(_eSystem._lString(alterAirplanePath.get()),(char)0) &&
              airplanes.containsKey(alterAirplanePath.get()))
      {
        airplanes.get(alterAirplanePath.get()).path.clear();
        airplanes.get(alterAirplanePath.get()).setPath(currentPath);
        String coordinates[] = _eSystem._lJavaString(atc.getAirplaneLocation(_eSystem._lString(alterAirplanePath.get()),
                (char) 0)).split(",");
        if (coordinates.length == 2)
        {
          for (Line line : airplanes.get(alterAirplanePath.get()).pathLines.values())
          {
            trackedRegion.getChildren().remove(line);
          }
          airplanes.get(alterAirplanePath.get()).pathLines.clear();
          airplanes.get(alterAirplanePath.get()).setStartCoordinates(Double.parseDouble(coordinates[0]),
                  Double.parseDouble(coordinates[1]));
          atc.deleteAirplanePath(_eSystem._lString(alterAirplanePath.get()), (char) 0);
          changePath(alterAirplanePath.get());
          currentPath = new ArrayList<String>();
          alterAirplanePath.set("null");
          pathBeingAltered.compareAndSet(true, false);
        }
      } else if (!automaticallyAlterAirplanePath.get().equals("null"))
      {
        //set new path after carrying out dikstras algorithm
        if(atc.isAirplaneInTrackedRegion(_eSystem._lString(automaticallyAlterAirplanePath.get()),(char)0) &&
                airplanes.containsKey(automaticallyAlterAirplanePath.get()))
        {
          atc.findShortestPath(_eSystem._lString(automaticallyAlterAirplanePath.get()), (char) 0);
          List<String> path = new ArrayList<>();

          String initial = "target";
          while (true)
          {
            initial = _eSystem._lJavaString(atc.getOrigin(_eSystem._lString(initial), (char) 0));

            if (initial.equals("NaN") || initial.equals("source"))
              break;
            else
              path.add(initial);
          }

          Collections.reverse(path);

          String coordinates[] =
                  _eSystem._lJavaString(atc.getAirplaneLocation(_eSystem._lString(automaticallyAlterAirplanePath.get()), (char) 0)).split(",");
          if (coordinates.length == 2)
          {
            for (Line line : airplanes.get(automaticallyAlterAirplanePath.get()).pathLines.values())
            {
              trackedRegion.getChildren().remove(line);
            }
            airplanes.get(automaticallyAlterAirplanePath.get()).path.clear();
            airplanes.get(automaticallyAlterAirplanePath.get()).pathLines.clear();
            airplanes.get(automaticallyAlterAirplanePath.get()).setPath(path);
            airplanes.get(automaticallyAlterAirplanePath.get()).setStartCoordinates(Double.parseDouble(coordinates[0]),
                    Double.parseDouble(coordinates[1]));
            atc.deleteAirplanePath(_eSystem._lString(automaticallyAlterAirplanePath.get()), (char) 0);
            changePath(automaticallyAlterAirplanePath.get());
            automaticallyAlterAirplanePath.set("null");
          }
          atc.resetPriorityQueue();
        }
      }
      airplanes.keySet().removeAll(airplanesToRemove);
      airplanesToRemove.clear();
    }
    if(!alterAirplanePath.get().equals("null") && (!atc.isAirplaneInTrackedRegion(_eSystem._lString(alterAirplanePath.get()),(char)0) ||
            !airplanes.containsKey(alterAirplanePath.get())))
    {
      resetWaypoints();
      pathBeingAltered.set(false);
      currentPath.clear();
      alterAirplanePath.set("null");
    }
    if(newAirplanesDuringSimulation.get())
    {
      airplanesAddedDuringSimulation.forEach(airplanes::putIfAbsent);
      airplanesAddedDuringSimulation.clear();
      newAirplanesDuringSimulation.set(false);
    }
    if(airplanesBeingAdded.get() == false)
    {
      resetInfoPaneText();
      setInfoPaneText("Simulation", "information", "simulate");
      updateMonitorPaneText("Time: " + time + "\nNumber of waypoints in region: " +
              atc.getNumberOfWaypoints() + "\nNumber of " +
              "airplanes in region: " + atc.getNumberOfAirplanes() +
              "\nNumber of collisions: " + atc.getNoOfCrashes() +
              "\nAverage time an airplane is conflicted: " +  Math.round((atc.getAverageTimeConflicted()) * 100.0) / 100.0 +
              "\nAverage percentage of time conflicted: " +
              Math.round((atc.getPercentageOfTimeConflicted2() * 100) * 10000.0) / 10000.0 +
              "%" +
              "\nAverage (duration conflicted)/(duration horizontally conflicted): " +
              Math.round((atc.getPercentageOfTimeConflicted1() * 100) * 10000.0) / 10000.0 + "%" +
              "\nNumber of potential collision detected: " + atc.getNumberOfPotentialCollisions() +
              "\nPotential collisions:\n" + _eSystem._lJavaString(atc.printCollisions()));
    }
    else
    {
      resetInfoPaneText();
      setInfoPaneText("Add airplanes by completing the form on the right:",
              "Information", "airplane");
    }

    if(speedSlider.getValue() == 0)
    {
      timer.setRate(0.25);
    }
    else if(speedSlider.getValue() == 1)
    {
      timer.setRate(0.5);
    }
    else if(speedSlider.getValue() == 2)
    {
      timer.setRate(1);
    }
    else if(speedSlider.getValue() == 3)
    {
      timer.setRate(2);
    }
    else if(speedSlider.getValue() == 4)
    {
      timer.setRate(4);
    }
    else if(speedSlider.getValue() == 5)
    {
      timer.setRate(6);
    }

    else
    {
      timer.setRate(0.25);
    }

    if(airplanesBeingAdded.get() == false && !simulationType.equals("automatic"))
    {
      addAirplane.setDisable(false);
    }
    time = time + 1;
    return true;
  }
  public EventHandler simulateButtonEvent()
  {
    return new EventHandler()
    {
      @Override public void handle(Event event2) {
        if(simulationStarted == false)
        {
          if(simulationType.equals("automatic"))
            addAirplane.setDisable(true);
          addWaypoint.setDisable(true);
          addPath.setDisable(true);
          resetInfoPaneText();
          if(airplanesBeingAdded.get() == false)
          {
            setInfoPaneText("Simulation", "information", "simulate");
            updateMonitorPaneText("Time: " + time + "\nNumber of waypoints in region: " +
                    atc.getNumberOfWaypoints() + "\nNumber of " +
                    "airplanes in region: " + atc.getNumberOfAirplanes() +
                    "\nNumber of collisions: " + atc.getNoOfCrashes() +
                    "\nAverage time an airplane is conflicted: " +  Math.round((atc.getAverageTimeConflicted()) * 100.0) / 100.0 +
                    "\nAverage percentage of time conflicted: " +
                    Math.round((atc.getPercentageOfTimeConflicted2() * 100) * 10000.0) / 10000.0 +
                    "%" +
                    "\nAverage (duration conflicted)/(duration horizontally conflicted): " +
                    Math.round((atc.getPercentageOfTimeConflicted1() * 100) * 10000.0) / 10000.0 +
                    "%" +
                    "\nNumber of potential collision detected: " + atc.getNumberOfPotentialCollisions() +
                    "\nPotential collisions:\n" + _eSystem._lJavaString(atc.printCollisions()));
          }
          timer.setCycleCount(Timeline.INDEFINITE);
          timer.play();
          simulate.setText("Pause");
          if(!informationPane.getChildren().contains(speedSlider))
            informationPane.getChildren().add(speedSlider);
          speedSlider.toFront();
          simulationStarted = true;
        }
        else
        {
          timer.pause();
          simulationStarted = false;
          informationPane.getChildren().remove(speedSlider);
          simulate.setText("Resume");
          //resetInfoPaneText();
        }
      }
    };
  }

  //reset the colour of the wayoint and remove any label on the waypoint

  public void resetWaypoints()
  {
    for (String waypointId : waypoints.keySet())
    {
      Circle circle = (Circle) waypoints.get(waypointId).getChildren().get(0);
      circle.setFill(Color.GREY);

      if(waypoints.get(waypointId).getChildren().size() == 2)
        waypoints.get(waypointId).getChildren().remove(1);
    }
  }

  public Pane createExtraAirplaneInfoPane(String id)
  {
    VBox pane = new VBox();
    if(atc.isAirplaneInTrackedRegion(_eSystem._lString(id),(char)0))
    {
      pane.setStyle("-fx-border-width: 0.5;" + "-fx-border-radius: 5;" + "-fx-padding: 70 0 30 145;" + "-fx-spacing: 3;");
      ImageView plane = new ImageView("planeSideView.png");
      plane.setFitWidth(100);
      plane.setFitHeight(100);
      Rotate rotation = new Rotate();
      rotation.setAngle(0);
      rotation.setPivotX(50);
      rotation.setPivotY(50);
      plane.getTransforms().add(rotation);
      Label idLabel = new Label("ID: " + id);
      idLabel.setFont(Font.font("Arial", FontWeight.BOLD,15));
      idLabel.setUnderline(true);
      idLabel.setTranslateX(24);
      Label ceiling = new Label("Ceiling: " + Math.round(atc.getAirplaneCeiling(_eSystem._lString(id),(char)0) * 100.0) / 100.0);
      ceiling.setTranslateX(6);
      Label floor = new Label("Floor: " +  Math.round(atc.getAirplaneFloor(_eSystem._lString(id),(char)0) * 100.0) / 100.0);
      floor.setTranslateX(6);

      pane.getChildren().addAll(plane, idLabel, ceiling, floor);
    }
    return pane;
  }
  //create detailed airplane info

  public Pane createAirplaneInfoPane(String id)
  {
    Long altitude = (long)(Math.round(atc.getAirplaneAltitude(_eSystem._lString(id), (char) 0) * 100.0) / 100.0);
    String location = _eSystem._lJavaString(atc.getAirplaneLocation(_eSystem._lString(id), (char) 0));
    String status = _eSystem._lJavaString(atc.getAirplaneStatus(_eSystem._lString(id), (char) 0));
    VBox pane = new VBox();
    Label idLabel = new Label("ID: " + id);
    Label altitudeLabel =
            new Label("Altitude: " + altitude);
    Label actionLabel =
            new Label("Action: " + _eSystem._lJavaString(atc.getAirplaneAction(_eSystem._lString(id),(char)0)));
    Label locationLabel = new Label("Location: " + location);
    pane.getChildren().addAll(idLabel, altitudeLabel, actionLabel, locationLabel);
    String style = "-fx-border-width: 0.5;" + "-fx-border-radius: 5;" + "-fx-padding: 30 50 30 50;" + "-fx-spacing: 2;";
    pane.setMaxWidth(360);
    if (status.matches("green"))
      pane.setStyle(style + "-fx-border-color: rgb(60,179,113)");
    else if (status.matches("orange"))
      pane.setStyle(style + "-fx-border-color: rgb(255,255,0)");
    else
      pane.setStyle(style + "-fx-border-color: rgb(220,20,60)");

    ContextMenu contextMenu = new ContextMenu();
    MenuItem item1 = new MenuItem("Manually set new path");
    MenuItem item2 = new MenuItem("Automatically find alternate path");
    MenuItem item3 = new MenuItem("Abort path change");

    item1.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        if(alterAirplanePath.get().equals("null"))
        {
          alterAirplanePath.compareAndSet("null", id);
          if(contextMenu.getItems().contains(item2))
            contextMenu.getItems().remove(item2);
        }
        else
        {
          if(currentPath.size() > 0)
            pathBeingAltered.compareAndSet(false, true);
          resetWaypoints();
          item1.setText("Set new path");
          if(!contextMenu.getItems().contains(item2))
            contextMenu.getItems().add(item2);
          item1.setDisable(false);
          if(contextMenu.getItems().contains(item3))
            contextMenu.getItems().remove(item3);
        }
      }
    });
    item2.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        if(automaticallyAlterAirplanePath.get().equals("null"))
        {
            automaticallyAlterAirplanePath.compareAndSet("null", id);
        }
      }
    });

    item3.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        alterAirplanePath.set("null");
        pathBeingAltered.set(false);
        contextMenu.getItems().remove(item3);
        resetWaypoints();
        currentPath.clear();
        item1.setDisable(false);
        if(!contextMenu.getItems().contains(item2))
          contextMenu.getItems().add(item2);
        item1.setText("Set new path");
      }
    });
    contextMenu.getItems().clear();
    contextMenu.getItems().addAll(item1, item2);
    pane.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>()
    {
      @Override public void handle(ContextMenuEvent event) {
        if(waypoints.size() > 0)
        {
          if (alterAirplanePath.get().equals("null") || alterAirplanePath.get().equals(id))
          {
            contextMenu.show(pane, event.getScreenX(), event.getScreenY());

            if (currentPath.size() != 0)
            {
              item1.setDisable(false);
              item1.setText("Confirm change in path");
              contextMenu.getItems().add(1, item3);
            } else if (currentPath.size() == 0 && alterAirplanePath.get().equals(id))
            {
              item1.setDisable(true);
              contextMenu.getItems().add(1, item3);
            }
          }
        }
        else
        {
          item1.setDisable(true);
          item2.setDisable(true);
        }
      }
    });
    pane.setOnMouseClicked(new EventHandler<MouseEvent>()
    {
      @Override public void handle(MouseEvent event) {
        if(airplanesBeingAdded.get() == false)
        {
          actionsPane.getChildren().clear();
          actionsPane.getChildren().add(airplanes.get(id).getExtraInfo());
        }
      }
    });
    trackedAirplanesPane.getChildren().add(pane);
    return pane;

  }
  private EventHandler reset()
  {
    return new EventHandler()
    {
      @Override public void handle(Event event) {
        trackedRegion.getChildren().clear();
        initializeTrackedRegion();
        initializeButton.setDisable(false);
        informationPane.getChildren().clear();
        addWaypoint.setDisable(true);
        addAirplane.setDisable(true);
        trackedAirplanesPane.getChildren().clear();
        simulate.setDisable(true);
        simulate.setText("Start simulation");
        simulationStarted = false;
        timer.stop();
        atc = null;
        airplanes.clear();
        waypoints.clear();
        actionsPane.getChildren().clear();
        addPath.setText("Add a path");
        permissiblePathBeingAdded = false;
        addPath.setDisable(true);
        resetWaypoints();
        waypointInformationLabel = new Label();
        airplaneInformationLabel = new Label();
        statisticsLabel = new Label();
        edgeInformationLabel = new Label();
        alterAirplanePath.set("null");
        automaticallyAlterAirplanePath.set("null");
        pathBeingAltered.set(false);
        minAltitude = 10000;
        maxAltitude = 12000;
        timer = new Timeline(new KeyFrame(Duration.seconds(1), eventA ->
        {
          updateFrontEnd();
        }));
        size = 0;
        time = 0;
        numberOfAirplanes = 0;
        actionsPane.getChildren().clear();
        simulationType = "manual";
      }
    };
  }

  private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
  }

  public EventHandler addPathButtonEvent()
  {
    return new EventHandler()
    {
      @Override public void handle(Event event) {
        if(!permissiblePathBeingAdded && waypoints.size() != 0)
        {
          permissiblePathBeingAdded = true;
          addAirplane.setDisable(true);
          simulate.setDisable(true);
          addWaypoint.setDisable(true);
          addPath.setText("Finish");
          resetInfoPaneText();
          setInfoPaneText(
                  "Add an edge between waypoints by clicking them one after another",
                  "Information", "path");
        }
        else
        {
          permissiblePathBeingAdded = false;
          addPath.setText("Add a path");
          if(!simulationType.equals("automatic"))
          {
            addAirplane.setDisable(false);
          }
          if(airplanes.size() != 0 || simulationType.equals("automatic"))
            simulate.setDisable(false);
          addWaypoint.setDisable(false);
          resetWaypoints();
          resetInfoPaneText();
        }
      }
    };
  }

  public void initializeSimulation()
  {
    HBox hBox1 = new HBox();
    VBox vBox1 = new VBox();
    VBox vBox2 = new VBox();
    Label altitudeRange = new Label("Select initial altitude bounds: ");
    TextField min = new TextField("10000");
    TextField max = new TextField("12000");
    min.setMaxWidth(50);
    max.setMaxWidth(50);
    vBox1.getChildren().addAll(altitudeRange, min, max);
    vBox1.setVisible(false);
    vBox1.setSpacing(5);
    VBox pane = new VBox();
    pane.setSpacing(10);
    final ToggleGroup group1 = new ToggleGroup();
    Label size = new Label("Select region size: ");
    RadioButton rb1 = new RadioButton("50km");
    rb1.setToggleGroup(group1);
    rb1.setUserData("50");
    rb1.setSelected(true);
    RadioButton rb2 = new RadioButton("100km");
    rb2.setToggleGroup(group1);
    rb2.setUserData("100");
    vBox2.getChildren().addAll(size, rb1, rb2);
    vBox2.setSpacing(10);
    hBox1.getChildren().addAll(vBox2, vBox1);
    pane.getChildren().add(hBox1);
    Label type = new Label("Select simulation type: ");
    final ToggleGroup group2 = new ToggleGroup();
    RadioButton rb3 = new RadioButton("Manual");
    rb3.setUserData("manual");
    rb3.setToggleGroup(group2);
    rb3.setSelected(true);
    RadioButton rb4 = new RadioButton("Automatic");
    rb4.setUserData("automatic");
    rb4.setToggleGroup(group2);
    pane.getChildren().add(type);
    pane.getChildren().add(rb3);
    pane.getChildren().add(rb4);
    Label label = new Label();
    ComboBox comboBox = new ComboBox();
    pane.getChildren().add(label);
    pane.getChildren().add(comboBox);
    label.setVisible(false);
    comboBox.setVisible(false);
    rb4.selectedProperty().addListener(new ChangeListener<Boolean>()
    {
      @Override public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if(rb4.isSelected())
        {
          label.setText("Number of airplanes in tracked region:");
          ObservableList<String> options =
                  FXCollections.observableArrayList(
                          "5",
                          "6",
                          "7",
                          "8",
                          "9",
                          "10",
                          "15",
                          "20"
                  );
          comboBox.setItems(options);
          comboBox.getSelectionModel().selectFirst();
          label.setVisible(true);
          comboBox.setVisible(true);
          vBox1.setVisible(true);
          vBox2.setTranslateX(-50);
        }
        else
        {
          label.setVisible(false);
          comboBox.setVisible(false);
          vBox1.setVisible(false);
          vBox2.setTranslateX(0);
        }
      }
    });
    Button confirmButton = new Button("Confirm");
    confirmButton.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override public void handle(ActionEvent event) {

        if(!min.getText().isEmpty() && !min.getText().equals("") && !max.getText().isEmpty() && !max.getText().equals(""))
        {
          try {
            double minValue = Double.parseDouble(min.getText());
            double maxValue = Double.parseDouble(max.getText());
            if(minValue <= maxValue && maxValue >= 8000 && maxValue <= 12000 && minValue >= 8000 && minValue <= 12000)
            {
              maxAltitude = maxValue;
              minAltitude = minValue;
            }
            else
            {
              showAlert(Alert.AlertType.ERROR, trackedRegion.getScene().getWindow(), "Error!",
                      "Enter valid altitude bounds");
              return;
            }

          } catch(NumberFormatException e){
            showAlert(Alert.AlertType.ERROR, trackedRegion.getScene().getWindow(), "Error!",
                    "Enter valid altitude bounds");
            return;
          }
        }
        if(group1.getSelectedToggle().getUserData().equals("100"))
        {
          atc = new ATC(100000, 100000);
          setSize(100000);
        }
        else if(group1.getSelectedToggle().getUserData().equals("50"))
        {
          atc = new ATC(50000, 50000);
          setSize(50000);
        }

        if(group2.getSelectedToggle().getUserData().equals("manual"))
        {
          addAirplane.setDisable(false);
          simulationType = "manual";
        }
        else if(group2.getSelectedToggle().getUserData().equals("automatic"))
        {
          simulationType = "automatic";
          addAirplane.setDisable(true);
          numberOfAirplanes = Integer.parseInt(comboBox.getValue().toString());
          simulate.setDisable(false);
        }

        initializeButton.setDisable(true);
        addWaypoint.setDisable(false);
        actionsPane.getChildren().clear();
      }
    });
    confirmButton.setTranslateX(18);
    confirmButton.setPadding(new Insets(5,20, 5, 20));
    pane.getChildren().add(confirmButton);
    pane.setPadding(new Insets(20,0,20,100));

    actionsPane.getChildren().add(pane);
  }

  public void initializeControlAndMonitorPane()
  {
    controlAndMonitorPane.setId("controlAndMonitorPane");

    VBox buttons = new VBox();
    buttons.setId("buttons");

    HBox childButtons1 = new HBox();
    childButtons1.setId("childButtons1");

    simulate.setText("Start Simulation");
    simulate.setId("simulate");
    simulate.setOnAction(simulateButtonEvent());
    simulate.setDisable(true);


    initializeButton.setId("initializeButton");
    initializeButton.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override public void handle(ActionEvent event) {
        initializeButton.setDisable(true);
        initializeSimulation();
      }
    });
    childButtons1.getChildren().add(initializeButton);
    childButtons1.getChildren().add(simulate);
    buttons.getChildren().add(childButtons1);
    HBox childButtons2 = new HBox();
    childButtons2.setId("childButtons2");

    addPath.setText("Add a Path");
    addPath.setId("addPath");
    addPath.setOnAction(addPathButtonEvent());
    addPath.setDisable(true);

    addWaypoint.setText("Add Waypoint");
    addWaypoint.setId("addWaypoint");
    addWaypoint.setDisable(true);
    addWaypoint.setOnAction(addWaypointButtonEvent());
    childButtons2.getChildren().add(addPath);
    childButtons2.getChildren().add(addWaypoint);
    buttons.getChildren().add(childButtons2);

    HBox childButtons3 = new HBox();
    childButtons3.setId("childButtons3");

    resetSimulation.setText("Reset");
    resetSimulation.setId("resetSimulation");
    resetSimulation.setOnAction(reset());

    addAirplane.setText("Add Airplane");
    addAirplane.setId("addAirplane");
    addAirplane.setOnAction(addAirplaneButtonEvent());
    addAirplane.setDisable(true);
    childButtons3.getChildren().add(resetSimulation);
    childButtons3.getChildren().add(addAirplane);
    buttons.getChildren().add(childButtons3);

    controlAndMonitorPane.getChildren().add(buttons);

    informationPane.setId("monitorPane");
    controlAndMonitorPane.getChildren().add(informationPane);
  }

  @Override public void start(Stage primaryStage) throws Exception
  {
    stage = primaryStage;
    primaryPane.setId("primaryPane");
    parentLayout.getChildren().add(primaryPane);
    secondaryPane.setId("secondaryPane");
    parentLayout.getChildren().add(secondaryPane);

    initializeTrackedRegion();
    primaryPane.getChildren().add(trackedRegion);

    initializeControlAndMonitorPane();
    primaryPane.getChildren().add(controlAndMonitorPane);

    trackedAirplanesPane.setId("trackedAirplanesPane");
    scrollableInfoPane.setContent(trackedAirplanesPane);
    scrollableInfoPane.setId("scrollableInfoPane");
    secondaryPane.getChildren().add(scrollableInfoPane);

    actionsPane.setId("actionsPane");
    secondaryPane.getChildren().add(actionsPane);

    trackedRegion.setOnMouseEntered(cursorEnteredTrackRegionEvent());
    trackedRegion.setOnMouseExited(cursorExitedTrackedRegionEvent());
    trackedRegion.setOnMouseClicked(addWaypointToRegionEvent());

    initializeSpeedSlider();

    Scene scene = new Scene(parentLayout, 1200, 1000);
    scene.getStylesheets().add(getClass().getResource("stylesheet.css").toString());
    primaryStage.setResizable(false);
    primaryStage.setScene(scene);
    primaryStage.show();

  }


  public static void main(String[] args)
  {
    Application.launch(args);
  }
}
