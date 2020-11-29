package cy.ac.ucy.cs.epl231.IDs1016662_1011050.homework3;

import java.util.*;
import java.lang.*;;

/**
 * This class is used to create the mst of a graph given.
 *
 * @author mvasil17, nstavr04
 */
public class MST_1011050_1016662 {
    /**
     * This is the list of the edges that represent the mst tree.
     */
    private ArrayList<Edge_1011050_1016662> edges = new ArrayList<Edge_1011050_1016662>();

    /**
     * This is the constructor of the mst tree.
     *
     * @param graph whose mst is going to be created
     * @author mvasil17, nstavr04
     */
    public MST_1011050_1016662(Graph_1011050_1016662 graph) {
        Prim(graph);    //Run Prim's algorithm to construct the MST tree
    }

    /**
     * This is the algorithm used to create the mst tree.
     * Mst is created using the prim algorithm.
     *
     * @param graph the graph given as parameter
     * @author mvasil17, nstavr04
     */
    private void Prim(Graph_1011050_1016662 graph) {

        int counter = 0;
        Node_1011050_1016662[] idsTable = new Node_1011050_1016662[graph.getVertices()];

        for (int i = 0; i < graph.getLength(); i++) {
            for (Node_1011050_1016662 node : graph.getHashTable()[i]) {
                idsTable[counter] = node;
                counter++;
            }
        }

        counter=0;

        boolean[] visited = new boolean[graph.getVertices()];

        Arrays.fill(visited, false);

        Node_1011050_1016662[] closestD = new Node_1011050_1016662[graph.getVertices()];

        Arrays.fill(closestD, null);    // A method to initialize all the distance table

        double[] distance = new double[graph.getVertices()];

        Arrays.fill(distance, Double.MAX_VALUE);    // A method to initialize all the distance table to infinity

        for(int i=0;i<graph.getLength();i++){
            for(int j=0;j<graph.getHashTable()[i].size();j++){
                if(graph.getHashTable()[i].get(j) != null){
                    idsTable[counter] = graph.getHashTable()[i].get(j);
                    closestD[counter] = graph.getHashTable()[i].get(j);
                    counter++;
                }
            }

        }


        int index = 0;
        visited[index] = true;
        Node_1011050_1016662 v = idsTable[index];

        for (int i = 0; i < graph.getVertices(); i++) {

            for (Node_1011050_1016662 w : v.getNeighbors()) {
                int pos = position(w, idsTable);
                if (pos == -1)
                    continue;
                Edge_1011050_1016662 edge = new Edge_1011050_1016662(v, w);
                if (edge.getWeight() < distance[pos] && edge.getWeight() < graph.getD()) {
                    distance[pos] = (int)edge.getWeight();
                    closestD[pos] = v;
                }

            }
            index = minVertex(graph, visited, distance);
            if (index == -1)
                break;
            visited[index] = true;
            edges.add(new Edge_1011050_1016662(idsTable[index], closestD[index]));
            v = idsTable[index];
        }

    }


    /**
     * @param list   the mst tree
     * @param starts the starting point
     * @author mvasil17, nstavr04
     */
    public static void DFS(ArrayList<Edge_1011050_1016662> list, int starts) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Edge_1011050_1016662> listCopy = (ArrayList<Edge_1011050_1016662>) list.clone();
        stack.push(starts);
        int maxTemp = -1;
        while (!stack.isEmpty() && listCopy.size() != 0) {

            for (int i = 0; i < listCopy.size(); i++) {
                if (listCopy.get(i).getNode1().getID() == stack.peek()) {
                    stack.push(listCopy.get(i).getNode2().getID());

                    if (listCopy.get(i).getNode2().getTemperature() >= maxTemp)
                        maxTemp = listCopy.get(i).getNode2().getTemperature();

                    listCopy.remove(listCopy.get(i));
                    break;
                }
                if (listCopy.get(i).getNode2().getID() == stack.peek()) {
                    stack.push(listCopy.get(i).getNode1().getID());

                    if (listCopy.get(i).getNode1().getTemperature() >= maxTemp)
                        maxTemp = listCopy.get(i).getNode1().getTemperature();

                    listCopy.remove(listCopy.get(i));
                    break;
                }
                if (i == listCopy.size() - 1) {

                    stack.pop();
                }

            }

        }
        System.out.println("Highest temperature: " + maxTemp);
    }


    /**
     * This is a helpful method that given a node, and the array finds the place
     * that the node is in the array given as a parameter.
     *
     * @param NodeTBF the node to be found
     * @param id     the array that has the node
     * @return the position of node in the id array
     * @author mvasil17, nstavr04
     */
    private static int position(Node_1011050_1016662 NodeTBF, Node_1011050_1016662[] id) {
        if (NodeTBF != null && id != null)
            for (int i = 0; i < id.length; i++) {
                if (id[i] != null)
                    if (NodeTBF.getID() == id[i].getID()) {

                        return i;
                    }
            }
        return -1;
    }

    public void setEdges(ArrayList<Edge_1011050_1016662> edges) {
        this.edges = edges;
    }

    public ArrayList<Edge_1011050_1016662> getEdges() {
        return edges;
    }

    /**
     * This method returns the minimum distance. (Part of Prim)
     *
     * @param graph our graph
     * @param visited the array with the visited nodes (T/F)
     * @param distance the array with the distances
     * @return min The minimum distance
     * @author mvasil17, nstavr04
     */
    public int minVertex(Graph_1011050_1016662 graph, boolean[] visited, double[] distance) {
        int min = -1;
        double minimum = Double.MAX_VALUE;
        for (int i = 0; i < graph.getVertices(); i++) {
            if (visited[i])
                continue;   // Skip nodes that are already in ours MST
            if (distance[i] < minimum) {
                min = i;
                minimum = distance[i];
            }
        }
        return min; // Return the minimum distance
    }
}