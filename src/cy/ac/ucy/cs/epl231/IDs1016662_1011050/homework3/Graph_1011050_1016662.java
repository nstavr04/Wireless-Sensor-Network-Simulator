package cy.ac.ucy.cs.epl231.IDs1016662_1011050.homework3;

import java.io.*;
import java.util.*;

/**
 * This is the structure of the graph
 *
 * The structure is maid using a linked list of nodes that each list indicates
 * the index of a hash table. Using a hash function each node its saved to the
 * correct List of the table.
 *
 * @author mvasil17, nstavr04
 *
 */
public class Graph_1011050_1016662 {
    /**
     * This field indicates the number of vertices.
     */
    private int vertices = 0;// number of vertices

    /**
     * This field indicates the number of edges of the graph.
     */
    private int edges = 0; // number of edges

    /**
     * This field indicates the hash table described above.
     */
    private LinkedList<Node_1011050_1016662> hashTable[];

    /**
     * This field indicates the length of the graph.
     */
    private int length;

    /**
     * This field indicates the distance given by the user.
     */
    private int d;

    /**
     * This field indicates the mst tree created when asked by the user.
     */
    public MST_1011050_1016662 mst;

    // private ArrayList< Edge_1037638 > EdgesList;

    /**
     * This is a getter method . It returns the number of vertices.
     *
     * @return number of vertices
     * @author mvasil17, nstavr04
     */
    public int getVertices() {
        return vertices;
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
     * This is a getter method . It returns the number of edges.
     *
     * @return number of edges.
     * @author mvasil17, nstavr04
     */
    public int getEdges() {
        return edges;
    }

    /**
     * This is a getter method . It returns the hashTable.
     *
     * @return a list that indicates the hashTable.
     * @author mvasil17, nstavr04
     */
    public LinkedList<Node_1011050_1016662>[] getHashTable() {
        return hashTable;
    }

    /**
     * This is a setter method . It returns the hashTable.
     *
     * creates a list that indicates the hashTable.
     * @author mvasil17, nstavr04
     */
    public void setHashTable(LinkedList<Node_1011050_1016662>[] hashTable) {
        this.hashTable = hashTable;
    }

    /**
     * This is a setter method . It sets the number of edges.
     *
     * @author mvasil17, nstavr04
     */
    public void setEdges(int edges) {
        this.edges = edges;
    }

    /**
     * This is a getter method . It returns the number of the length of the
     * hashTable. This is the number of combs in the graph.
     *
     * @return length of the graph.
     * @author mvasil17, nstavr04
     */
    public int getLength() {
        return length;
    }

    /**
     * This is a setter method . It sets the length of the hashTable.
     *
     * @author mvasil17, nstavr04
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * This is a getter method . It returns the distance of the graph that is
     * actually the distance that the user gives as a parameter.
     *
     * @return the distance
     * @author mvasil17, nstavr04
     */
    public int getD() {
        return d;
    }

    /**
     * This is a setter method. It sets the distance.
     *
     * @param d
     *
     * @author mvasil17, nstavr04
     */
    public void setD(int d) {
        this.d = d;
    }

    /**
     * this is the constructor of the graph.
     *
     * @param length the length of the graph.
     * @param d      the distance set by the user.
     *
     * @author mvasil17, nstavr04
     */
    public Graph_1011050_1016662(int length, int d) {
        this.hashTable = new LinkedList[length];
        this.length = length;
        this.d = d;
        for (int i = 0; i < length; i++)
            hashTable[i] = new LinkedList<Node_1011050_1016662>();
    }

    /**
     * This is the method that is used for to read the file that is set from the
     * console.
     *
     * @param fileName the file name set from console.
     *
     * @author mvasil17, nstavr04
     */
    public void readNodes(String fileName) {
        FileReader_1011050_1016662 file = new FileReader_1011050_1016662();
        file.openFile(fileName);
        // int i = 0;
        try {
            Scanner fin;
            fin = new Scanner(new File(fileName));
            fin.useDelimiter("[^0-9]+"); // keep only digits.
            while (fin.hasNext()) {
                Node_1011050_1016662 node = new Node_1011050_1016662(fin.nextInt(), fin.nextInt(), fin.nextInt(), fin.nextInt());
//                System.out.println(node.getID() + " " +node.getCoordinateX() + " " + node.getCoordinateY() + " " + node.getTemperature());
                insertNode(node);
            }
        } catch (Exception e) {
            System.out.println("FILE NOT FOUND");
        }
//		System.out.println(length);
//		for (int i = 0; i < length; i++) {
//			//for (Node neigh : hashTable[i]) {
//				for(int j=0;j<hashTable[i].size();j++)
//				System.out.print(hashTable[i].get(j).getId()+ " ");
//			//}
//			System.out.println();
//		}

    }

    /**
     * This method is used to insert the nodes from the file. For each node a list
     * of its neighbors its calculated. If any list of nodes of the hashtable has
     * more than 20 nodes , a rehashing method is used.
     *
     * @param node the node to be inserted.
     *
     *
     * @author mvasil17, nstavr04
     */
    public void insertNode(Node_1011050_1016662 node) {
        vertices++;
        hashTable[hashFunction(node.getID(), length)].addFirst(node);
        for (int i = 0; i < length; i++)
            for (Node_1011050_1016662 neigh : hashTable[i]) {
                if (node.getDistance(neigh) < d && (node.getID() != neigh.getID())) {
                    node.getNeighbors().addFirst(neigh);// allagi
                    neigh.getNeighbors().addFirst(node);
                    edges++;
                    // Edge_1037638 edge = new Edge_1037638( node , neigh);
                    // EdgesList.add(edge);
                }
            }
        if (hashTable[hashFunction(node.getID(), length)].size() >= 20)
            rehash();
    }

    /**
     * This method is the one used for the removal of a node. In this method the
     * parameter indicates to the node to be removed.
     *
     * @param remove the node to be removed
     *
     * @author mvasil17, nstavr04
     */
    public void removeNode(Node_1011050_1016662 remove) {
        for (Node_1011050_1016662 node : remove.getNeighbors()) {
            LinkedList<Node_1011050_1016662> listCopy = (LinkedList<Node_1011050_1016662>) remove.getNeighbors().clone();
            for (int i = 0; i < listCopy.size(); i++) {
                if (remove == listCopy.get(i)) {
                    node.getNeighbors().remove(i);
                    break;
                }
            }
        }
        LinkedList<Node_1011050_1016662> listCopy2 = (LinkedList<Node_1011050_1016662>) hashTable[hashFunction(remove.getID(), length)];
        for (int i = 0; i < listCopy2.size(); i++) {
            if (remove == listCopy2.get(i)) {
                hashTable[hashFunction(remove.getID(), length)].remove(i);
                break;
            }
        }
    }

    /**
     * This method is the method that creates the MST tree of the graph.
     *
     * @author mvasil17, nstavr04
     */
    public void createMST() {
        this.mst = new MST_1011050_1016662(this);
//		for (int i = 0; i < mst.getEdges().size(); i++) {
//			mst.getEdges().get(i).print();
//		}
    }

    /**
     * This method is the method that after the user wants to terminate the program,
     * all the content of the graph goes to the starting file.
     *
     * @param s the name of the file
     *
     * @author mvasil17, nstavr04
     */
    public void updateFile(String s) {
        try (FileWriter writer = new FileWriter(s); BufferedWriter bw = new BufferedWriter(writer)) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < hashTable[i].size(); j++) {
                    if (hashTable[i].get(j) == null)
                        continue;
                    bw.write(hashTable[i].get(j).getID() + "\t" + "(" + hashTable[i].get(j).getCoordinateX() + ","
                            + hashTable[i].get(j).getCoordinateY() + ")" + "\t" + hashTable[i].get(j).getTemperature());
                    bw.newLine();
                } // 01 (42, 85) 30
            }
        } catch (IOException e) {
            System.out.println("Error with file");
        }
    }

    /**
     * This method is the rehashing method that each time that it is called it
     * creates a hash Table ten times bigger than before. This method its called
     * only if the list of nodes of an index of the hashtable has more than 20
     * nodes.
     *
     * @author mvasil17, nstavr04
     */
    private void rehash() {
        this.length *= 10;
        LinkedList<Node_1011050_1016662> hashTemp[] = hashTable;
        hashTable = new LinkedList[length];
        for (int i = 0; i < length; i++)
            hashTable[i] = new LinkedList<Node_1011050_1016662>();

        for (int i = 0; i < hashTemp.length; i++)
            for (Node_1011050_1016662 node : hashTemp[i])
                insertNode(node);
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
        return (int) (id % length);
    }

    /**
     * This method was only used to check resaults
     *
     * @param args
     *
     * @author mvasil17, nstavr04
     */
    public static void main(String args[]) {
        // FileReader_1037638 f = new FileReader_1037638();
        // f.openFile(args[0]);
        Graph_1011050_1016662 graph = new Graph_1011050_1016662(5, 500);
        graph.readNodes(args[0]);
        int id = 2;
        Node_1011050_1016662 node = null;
        LinkedList<Node_1011050_1016662> list = graph.getHashTable()[Graph_1011050_1016662.hashFunction(id, graph.getLength())];
        for (Node_1011050_1016662 inlist : list) {
            if (inlist.getID() == id) {
                node = inlist;
                break;
            }
        }
        graph.removeNode(node);
        for (int i = 0; i < graph.getLength(); i++) {
            // for (Node neigh : hashTable[i]) {
            for (int j = 0; j < graph.getHashTable()[i].size(); j++)
                System.out.print(graph.getHashTable()[i].get(j).getID() + " ");
            // }
            System.out.println();
        }
        graph.createMST();
        // System.out.println(graph.vertices);
        // System.out.println(graph.edges);
        // graph.createMST();
        /*
         * 821 1 12 2 42 353 123
         *
         * 821 1 12 42 353 123
         */

    }
}
