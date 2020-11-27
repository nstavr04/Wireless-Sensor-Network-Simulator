import java.awt.*;

// This class is using java's Point class. API:
// https://docs.oracle.com/javase/7/docs/api/java/awt/Point.html
public class Node {

    private final int ID;
    private Point coordinates;
    private int temperature;


    public Node(int ID, Point coordinates, int temperature) {
        this.ID = ID;
        this.coordinates = new Point(coordinates);  // Copy constructor
        this.temperature = temperature;
    }


    public Node(int ID, int coordinateX, int coordinateY, int temperature) {
        this.ID = ID;
        coordinates = new Point(coordinateX, coordinateY);
        this.temperature = temperature;
    }


    // this method returns the distance d between two nodes
    public double getDistance(Node otherNode) {
        return (this.coordinates.distance(otherNode.coordinates));
    }

    /* ******************
    //SETTERS AND GETTERS
    ****************** */


    public int getID() {
        return ID;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int x, int y) {
        this.coordinates.setLocation(x, y);
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates.setLocation(coordinates);
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
