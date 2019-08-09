package Frontend;

import Ertsys._eSystem;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.*;

public class AirplaneFrontEnd
{
  private String id;
  private Pane info = null;
  private Pane extraInfo = null;
  private Group plane = null;
  private double time;
  public List<String> path = new ArrayList<>();
  public Map<String, Line> pathLines = new HashMap<>();
  public double[] startCoordinates;
  public double[] endCoordinates;
  private double altitude;
  private int r;
  private int g;
  private int b;
  private int size;

  public AirplaneFrontEnd(String id, double time, double[] startCoordinates, double[] endCoordinates, double altitude, int size)
  {
    this.id = id;
    this.time = time;
    this.startCoordinates = startCoordinates;
    this.endCoordinates = endCoordinates;
    this.altitude = altitude;
    this.size = size;
    Random random = new Random();
    final int[] ints = random.ints(0, 15).distinct().limit(3).toArray();
    r = ints[0] * 10;
    g = ints[1] * 10;
    b = ints[2] * 10;
  }

  public void setInfo(Pane info)
  {
    this.info = info;
  }

  public  void setExtraInfo(Pane extraInfo)
  {
    this.extraInfo = extraInfo;
  }

  public void setPlane(Group plane)
  {
    this.plane = plane;
  }

  public void setStartCoordinates(double x, double y)
  {
    startCoordinates[0] = x;
    startCoordinates[1] = y;
  }

  public double getTime()
  {
    return time;
  }

  public Node getInfo()
  {
    return info;
  }

  public Node getExtraInfo()
  {
    return extraInfo;
  }

  public void setTime(double time)
  {
    this.time = time;
  }

  public void setPath(List<String> newPath)
  {
    this.path = new ArrayList<>(newPath);
    this.path.add("target");
  }

  public Node getPlane()
  {
    return plane;
  }


  public double getAltitude() {
    return altitude;
  }

  public List<String> getPath() {
    return path;
  }

  public Line getPathLines(String path) {
    return pathLines.get(path);
  }

  public void setPathLines(String path, double startX, double startY, double endX, double endY) {
    Line line = new Line();
    line.setStroke(Color.rgb(r, g, b));
    line.setStrokeWidth(0.8);
    line.setStartX(startX * 800 / size);
    line.setStartY(800 - startY * 800 / size);
    line.setEndX(endX * 800 / size);
    line.setEndY(800 - endY * 800 / size);
    line.setTranslateZ(-500);
    line.toBack();
    pathLines.put(path, line);
  }
  public void alterPathLines(String path, double startX, double startY)
  {
    if(pathLines.containsKey(path))
    {
      pathLines.get(path).setStartX(startX);
      pathLines.get(path).setStartY(startY);
    }
  }
  public void removePathLine(String path)
  {
    pathLines.remove(path);
  }

  public double[] getStartCoordinates() {
    return startCoordinates;
  }

  public void setStartCoordinates(double[] startCoordinates) {
    this.startCoordinates = startCoordinates;
  }

  public double[] getEndCoordinates() {
    return endCoordinates;
  }

  public void setEndCoordinates(double[] endCoordinates) {
    this.endCoordinates = endCoordinates;
  }
}
