package cy.ac.ucy.cs.epl231.IDs1016662_1011050.homework3;

/**
 * This class represents an edge of two nodes. Each edge created has two nodes
 * and the weight between them. The weight between them is calculated by the
 * constructor.
 *
 * @author mvasil17, nstavr04
 *
 */
public class Edge_1011050_1016662 {

    private double weight;

    private Node_1011050_1016662 node1;

    private Node_1011050_1016662 node2;

    public Edge_1011050_1016662(Node_1011050_1016662 node1, Node_1011050_1016662 node2) {
        this.node1 = node1;
        this.node2 = node2;
        weight = node1.getDistance(node2);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Node_1011050_1016662 getNode1() {
        return node1;
    }

    public void setNode1(Node_1011050_1016662 node1) {
        this.node1 = node1;
    }

    public Node_1011050_1016662 getNode2() {
        return node2;
    }

    public void setNode2(Node_1011050_1016662 node2) {
        this.node2 = node2;
    }

    public void print() {
        System.out.println("NODE: " + node1.getID() + " => " + node2.getID() + " NODE");
    }
}

