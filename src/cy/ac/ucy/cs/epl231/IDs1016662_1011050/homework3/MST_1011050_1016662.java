package cy.ac.ucy.cs.epl231.IDs1016662_1011050.homework3;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * This class is used to create the mst of a graph given . This i a helping
 * class .
 *
 * @author mvasil17, nstavr04
 *
 */
public class MST_1011050_1016662{
    /**
     * This is the list of edges that represents the mst tree.
     *
     * @author mvasil17, nstavr04
     */
    private ArrayList<Edge_1011050_1016662> edges = new ArrayList<Edge_1011050_1016662>();

    /**
     * This is the constructor of the mst tree.
     *
     * @param graph whos mst is going to be created
     *
     * @author Ioanna Theophilou
     */
    public MST_1011050_1016662(Graph_1011050_1016662 graph) {
        Prim(graph);
    }

    /**
     * This is the algorithm used to create the mst tree.
     *
     * Mst tree is created using the prim algorithm.
     *
     * @param graph the graph given as parameter
     *
     * @author Ioanna Theophilou
     */
    public void Prim(Graph_1011050_1016662 graph) {

        Node_1011050_1016662 ids[] = new Node_1011050_1016662[graph.getVertices()];
        int count = 0;
        for (int i = 0; i < graph.getLength(); i++)
            for (Node_1011050_1016662 node : graph.getHashTable()[i]) {

                ids[count] = node;
                count++;

            }
        boolean[] visited = new boolean[graph.getVertices()];

        for (int i = 0; i < graph.getVertices(); i++)
            visited[i] = false;

        int[] closest = new int[graph.getVertices()];
        for (int i = 0; i < graph.getVertices(); i++)
            closest[i] = -1;

        double[] distance = new double[graph.getVertices()];
        // initializing to infinity
        Arrays.fill(distance, Double.MAX_VALUE);    // A method to initialize all the distance table

        int ind = 0;
        visited[ind] = true;
        Edge_1011050_1016662 edge = null;
        for (int i = 0; i < graph.getVertices(); i++) {
            Node_1011050_1016662 v = ids[ind];
            for (Node_1011050_1016662 w : v.getNeighbors()) {
                int pos = position(w, ids);
                if (pos == -1)
                    continue;
                edge = new Edge_1011050_1016662(v, w);
                if (edge.getWeight() < distance[pos]) {
                    distance[pos] = (int) edge.getWeight();
                    closest[pos] = ind;
                }

            }
            ind = minVertex(graph, visited, distance);
            if (ind == -1)
                break;
            visited[ind] = true;
            edges.add(new Edge_1011050_1016662(v, ids[ind]));
        }

    }

    /**
     * This is a helpful method that given a node, and the array finds the place
     * that the node is in the array given as a parameter.
     *
     * @param findMe the node to be found
     * @param id     the array that has the node
     * @return the position of node in the id array
     *
     * @author mvasil17, nstavr04
     */
    public static int position(Node_1011050_1016662 findMe, Node_1011050_1016662 id[]) {
        if (findMe != null && id != null)
            for (int i = 0; i < id.length; i++) {
                if (id[i] != null)
                    if (findMe.getID() == id[i].getID()) {

                        return i;
                    }
            }
        return -1;
    }

    /**
     * This is the getter method that returns the list of edges meaning the mst
     * tree.
     *
     * @return the mst tree
     *
     * @author mvasil17, nstavr04
     */
    public ArrayList<Edge_1011050_1016662> getEdges() {
        return edges;
    }

    /**
     * This is a setter method that sets the mst.
     *
     * @author mvasil17, nstavr04
     * @param edges
     */
    public void setEdges(ArrayList<Edge_1011050_1016662> edges) {
        this.edges = edges;
    }

    /**
     * This is the method that returns the minimum among all distances. It is used
     * by the prim algorithm.
     *
     * @param graph
     * @param visited
     * @param distance
     *
     * @author mvasil17, nstavr04
     * @return
     */
    public int minVertex(Graph_1011050_1016662 graph, boolean visited[], double[] distance) {
        int min = -1;
        double minimum = Double.MAX_VALUE;
        for (int i = 0; i < graph.getVertices(); i++) {
            if (visited[i] == true)
                continue;// skip nodes already in MST
            if (distance[i] < minimum) {
                min = i;
                minimum = distance[i];
            }
        }
        return min; // Return the minimum among all distances
    }

    /**
     *
     * @param list   the mst tree
     * @param starts the starting point
     *
     * @author mvasil17, nstavr04
     */
    public static void DFS(ArrayList<Edge_1011050_1016662> list, int starts) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Edge_1011050_1016662> listCopy = (ArrayList<Edge_1011050_1016662>) list.clone();
        stack.push(starts);
        int maxTemp=-1;
        while (!stack.isEmpty() && listCopy.size() != 0) {

            for (int i = 0; i < listCopy.size(); i++) {
                if (listCopy.get(i).getNode1().getID() == stack.peek()) {
                    stack.push(listCopy.get(i).getNode2().getID());
                    listCopy.remove(listCopy.get(i));
                    break;
                }
                if (listCopy.get(i).getNode2().getID() == stack.peek()) {
                    stack.push(listCopy.get(i).getNode1().getID());
                    listCopy.remove(listCopy.get(i));
                    break;
                }
                if (i == listCopy.size() - 1) {

                    if(listCopy.get(i).getNode1().getTemperature() >= maxTemp)
                        maxTemp = listCopy.get(i).getNode1().getTemperature();
                    if(listCopy.get(i).getNode2().getTemperature() >= maxTemp )
                        maxTemp = listCopy.get(i).getNode2().getTemperature();

                    stack.pop();
                }

            }

//            if (stack.peek() == starts)
//                break;

        }
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }

        System.out.println("Highest temperature: " + maxTemp);

    }

    /**
     * This method was only used to check resaults
     *
     * @param args
     *
     * @author mvasil17, nstavr04
     */
    public static void main(String args[]) {
        Graph_1011050_1016662 graph = new Graph_1011050_1016662(5, 500);
        graph.readNodes(args[0]);
        MST_1011050_1016662 mst = new MST_1011050_1016662(graph);

        for (int i = 0; i < mst.getEdges().size(); i++) {
            mst.getEdges().get(i).print();
        }
        DFS(mst.getEdges(), 1);
    }

}