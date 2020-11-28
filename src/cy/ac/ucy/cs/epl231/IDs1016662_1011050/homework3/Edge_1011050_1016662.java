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
    /**
     * This field represents the weight of the two nodes. This value is calculated
     * by the constructor.
     */
    private double weight;

    /**
     * The first node that belongs to that edge.
     */
    private Node_1011050_1016662 node1;

    /**
     * The second node that belongs to that edge.
     */
    private Node_1011050_1016662 node2;

    /**
     * This is the constructor of the edge. In this method the weight is
     * constructed.
     *
     * @param node1 the first node that belongs to the edge
     * @param node2 the second node that belongs to the edge
     */
    public Edge_1011050_1016662(Node_1011050_1016662 node1, Node_1011050_1016662 node2) {
        this.node1 = node1;
        this.node2 = node2;
        weight = node1.getDistance(node2);
    }

    /**
     * This is a getter method. It returns the weight of the edge.
     *
     * @return the weight of edge
     */
    public double getWeight() {
        return weight;
    }

    /**
     * This is a setter method. It sets the weight of the edge.
     *
     * @param weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * This is a getter method that returns the first node that belongs to the edge.
     *
     * @return node the first node
     */
    public Node_1011050_1016662 getNode1() {
        return node1;
    }

    /**
     * This is a setter method. It sets the first node.
     *
     * @param node1
     */
    public void setNode1(Node_1011050_1016662 node1) {
        this.node1 = node1;
    }

    /**
     * This is a getter method that returns the second node that belongs to the
     * edge.
     *
     * @return node the second node
     */
    public Node_1011050_1016662 getNode2() {
        return node2;
    }

    /**
     * This is a setter method. It sets the second node.
     */
    public void setNode2(Node_1011050_1016662 node2) {
        this.node2 = node2;
    }

    /**
     * This method is used like the toString of the edge.
     */
    public void print() {
        System.out.println("NODE: " + node1.getID() + " => " + node2.getID() + " NODE");
    }
}

