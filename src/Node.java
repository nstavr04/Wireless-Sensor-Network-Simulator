import java.awt.*;
import java.util.LinkedList;

// This class is using java's Point class. API:
// https://docs.oracle.com/javase/7/docs/api/java/awt/Point.html
public class Node {

    private final int ID;
    private Point coordinates;
    private int temperature;

    private LinkedList<Node> neighbors;


    public Node(int ID, Point coordinates, int temperature) {
        this.ID = ID;
        this.coordinates = new Point(coordinates);  // Copy constructor
        this.temperature = temperature;
        neighbors = new LinkedList<Node>();
    }


    public Node(int ID, int coordinateX, int coordinateY, int temperature) {
        this.ID = ID;
        coordinates = new Point(coordinateX, coordinateY);
        this.temperature = temperature;
        neighbors = new LinkedList<Node>();
    }


    // this method returns the distance d between two nodes
    public double getDistance(Node otherNode) {
        return (this.coordinates.distance(otherNode.coordinates));
    }

    /**
     * This method returns true if a node is a station. False otherwise.
     *
     * @return true if node is station
     */
    public boolean isStation() {
        return this.ID >= 1 && this.ID <= 9;
    }

    /* ******************
    //SETTERS AND GETTERS
    ****************** */
    // WE WILL NEVER NEED SOME OF THEM //

    public LinkedList<Node> getNeighbors() { return neighbors; }

    public int getID() {
        return ID;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public int getCoordinateX(){ return (int)coordinates.getX(); }

    public int getCoordinateY(){ return (int)coordinates.getY(); }

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
