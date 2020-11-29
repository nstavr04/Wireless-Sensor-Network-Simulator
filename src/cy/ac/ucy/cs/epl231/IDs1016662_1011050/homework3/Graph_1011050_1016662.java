package cy.ac.ucy.cs.epl231.IDs1016662_1011050.homework3;

import java.io.*;
import java.util.*;

/**
 * This is the structure of the graph
 *
 * It is using a linked list of Nodes and each list indicates an index of a hash table.
 * Using a hash function each node its saved to the correct index of the table.
 *
 * @author mvasil17, nstavr04
 *
 */
public class Graph_1011050_1016662 {


    private int vertices = 0;

    private int edges = 0;

    /**
     * Hash table (see class description)
     */
    private LinkedList<Node_1011050_1016662>[] hashTable;

    private int length;

    /**
     * Distance given by the user.
     */
    private int d;

    /**
     * MST tree created when asked by the user.
     */
    public MST_1011050_1016662 mst;

    /**
     * Constructor of the graph.
     *
     * @param length the length of the graph.
     * @param dOfUser the distance set by the user.
     *
     * @author mvasil17, nstavr04
     */
    public Graph_1011050_1016662(int length, int dOfUser) {
        this.hashTable = new LinkedList[length];
        this.length = length;
        this.d = dOfUser;
        for (int i = 0; i < length; i++)
            hashTable[i] = new LinkedList<Node_1011050_1016662>();
    }

    /**
     * Read the file that is given (user parameter)
     *
     * @param fileName the file name set from console.
     *
     * @author mvasil17, nstavr04
     */
    public void readNodes(String fileName) {

        try {
            Scanner fileReader;
            fileReader = new Scanner(new File(fileName));
            fileReader.useDelimiter("[^0-9]+"); // keep only the digits of the file
            while (fileReader.hasNext()) {
                Node_1011050_1016662 node = new Node_1011050_1016662(fileReader.nextInt(), fileReader.nextInt(), fileReader.nextInt(), fileReader.nextInt());
//                System.out.println(node.getID() + " " +node.getCoordinateX() + " " + node.getCoordinateY() + " " + node.getTemperature());
                insertNode(node);
            }
        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }

    /**
     * Insert nodes from the file. For each node, a list of its neighbors is created. If any list of nodes of the hashtable has
     * 20 nodes , we use our rehashing method.
     *
     * @param node the node to be inserted.
     *
     * @author mvasil17, nstavr04
     */
    public void insertNode(Node_1011050_1016662 node) {
        vertices++;
        hashTable[hashFunction(node.getID(), length)].addFirst(node);
        for (int i = 0; i < length; i++)
            for (Node_1011050_1016662 neigh : hashTable[i]) {
                if (node.getDistance(neigh) < d && (node.getID() != neigh.getID())) {
                    node.getNeighbors().addFirst(neigh);
                    neigh.getNeighbors().addFirst(node);
                    edges++;
                }
            }
        //Rehashing if a linked list of any hash table slot goes beyond 20 elements
        if (hashTable[hashFunction(node.getID(), length)].size() > 20)
            rehash();
    }

    /**
     * This method removes a node.
     *
     * @param removeNode the node to be removed
     *
     * @author mvasil17, nstavr04
     */
    public void removeNode(Node_1011050_1016662 removeNode) {
        for (Node_1011050_1016662 node : removeNode.getNeighbors()) {
            LinkedList<Node_1011050_1016662> listCopy = (LinkedList<Node_1011050_1016662>) removeNode.getNeighbors().clone();
            for (int i = 0; i < listCopy.size(); i++) {
                if (removeNode == listCopy.get(i)) {
                    node.getNeighbors().remove(i);
                    break;
                }
            }
        }
        LinkedList<Node_1011050_1016662> listCopy2 = hashTable[hashFunction(removeNode.getID(), length)];
        for (int i = 0; i < listCopy2.size(); i++) {
            if (removeNode == listCopy2.get(i)) {
                hashTable[hashFunction(removeNode.getID(), length)].remove(i);
                break;
            }
        }
    }

    /**
     * Creates the MST of the graph.
     *
     * @author mvasil17, nstavr04
     */
    public void createMST() {
        this.mst = new MST_1011050_1016662(this);
    }

    /**
     * Getter method . Returns number of vertices.
     *
     * @return number of vertices
     * @author mvasil17, nstavr04
     */
    public int getVertices() {
        return this.vertices;
    }

    /**
     * This is a setter method . It sets the number of vertices.
     *
     * @author mvasil17, nstavr04
     */
    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    /**
     * Getter method . Returns the number of edges.
     *
     * @return number of edges.
     * @author mvasil17, nstavr04
     */
    public int getEdges() {
        return this.edges;
    }

    /**
     * Getter method . Returns the hashTable.
     *
     * @return a list that indicates the hashTable.
     * @author mvasil17, nstavr04
     */
    public LinkedList<Node_1011050_1016662>[] getHashTable() {
        return this.hashTable;
    }

    /**
     * Setter method.
     *
     * Creates a list that indicates the hashTable.
     *
     * @author mvasil17, nstavr04
     */
    public void setHashTable(LinkedList<Node_1011050_1016662>[] hashTable) {
        this.hashTable = hashTable;
    }

    /**
     * Setter method . Sets the number of edges.
     *
     * @author mvasil17, nstavr04
     */
    public void setEdges(int edges) {
        this.edges = edges;
    }

    /**
     * Getter method . Returns the length of the hashTable.
     * This is the number of combs in the graph.
     *
     * @return length of the graph.
     * @author mvasil17, nstavr04
     */
    public int getLength() {
        return length;
    }

    /**
     * Setter method . Sets the length of the hashTable.
     *
     * @author mvasil17, nstavr04
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Getter method . It returns the distance of the graph (user parameter)
     *
     * @return the distance
     * @author mvasil17, nstavr04
     */
    public int getD() {
        return d;
    }

    /**
     * Setter method. Sets the distance.
     *
     * @param d
     *
     * @author mvasil17, nstavr04
     */
    public void setD(int d) {
        this.d = d;
    }

    /**
     * Updates the file and enters back the new nodes. (user input file)
     *
     * @param fileName the name of the file
     *
     * @author mvasil17, nstavr04
     */
    public void updateFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(writer)) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < hashTable[i].size(); j++) {
                    if (hashTable[i].get(j) == null)
                        continue;
                    bw.write(hashTable[i].get(j).getID() + "\t" + "[" + hashTable[i].get(j).getCoordinateX() + ", "
                            + hashTable[i].get(j).getCoordinateY() + "]" + "\t" + hashTable[i].get(j).getTemperature() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error with file");
        }
    }

    /**
     * Rehashing method. It creates a hash Table ten times bigger than before. This method it called
     * only if the list of nodes of an index of the hashtable has more than 20 nodes.
     *
     * @author mvasil17, nstavr04
     */
    private void rehash() {
        this.length *= 10;
        LinkedList<Node_1011050_1016662>[] hashTemp = hashTable;
        hashTable = new LinkedList[length];
        for (int i = 0; i < length; i++)
            hashTable[i] = new LinkedList<Node_1011050_1016662>();

        for (LinkedList<Node_1011050_1016662> node_1011050_1016662s : hashTemp) {
            for (Node_1011050_1016662 node : node_1011050_1016662s) {
                insertNode(node);
            }
        }
    }

    /**
     * This is the hash function used to tell the index of the hashtable that a node
     * will insert on that list.
     *
     * @param id     the id of the node
     * @param length the length of the graph.
     * @return the index of the hashtable
     *
     * @author mvasil17, nstavr04
     */
    public static int hashFunction(int id, int length) {
        return (id % length);
    }

}
