
/**
 * This class is representing the edges that connect two nodes together and their weight
 *
 * @author mvasil17, nstavr04
 *
 */
public class Edge {

    private double weight;

    private Node node1;

    private Node node2;

    public Edge(Node node1, Node node2) {
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

    public Node getNode1() {
        return node1;
    }

    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    public Node getNode2() {
        return node2;
    }

    public void setNode2(Node node2) {
        this.node2 = node2;
    }
}

