package cy.ac.ucy.cs.epl231.IDs1016662_1011050.homework3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This method is used to create the second option of the menu that prints all
 * the MST tree using the breadth first search. This object uses only one class
 * that implement the printing of the tree given as a parameter.
 *
 * @since 30/04/20
 * @author Ioanna Theophilou (itheop02)
 * @version 1
 */
public class BFS_1011050_1016662 {
    /**
     * This is the only method of this class. This method prints the given tree
     * using the BFS method. This method uses a queue structure to save the values
     * needed.
     *
     * @param list  the list that represents the mst tree
     * @param start the starting node
     * @param graph the graph that the mst belongs to
     */
    public void PrintBfs(ArrayList<Edge_1011050_1016662> list, Node_1011050_1016662 start, Graph_1011050_1016662 graph) {
        Node_1011050_1016662 array[] = null;
        int count = 0;
        ArrayList<Edge_1011050_1016662> listCopy = (ArrayList<Edge_1011050_1016662>) list.clone();

        Queue<Integer> queue = new LinkedList<>();// tick
        queue.add(start.getID());
        queue.add(-1);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (v == -1) {
                if (!queue.isEmpty())
                    queue.add(-1);
                System.out.println();
                continue;
            }
            System.out.print(v + "  ");
            int length = listCopy.size();
            int c = 0;
            for (int i = 0; i < length; i++) {
                if (listCopy.get(c).getNode1().getID() == v) {
                    queue.add(listCopy.get(c).getNode2().getID());
                    listCopy.remove(listCopy.get(c));
                    c--;
                } else if (listCopy.get(c).getNode2().getID() == v) {
                    queue.add(listCopy.get(c).getNode1().getID());
                    listCopy.remove(listCopy.get(c));
                    c--;
                }
                c++;
            }
        }

    }

    /**
     * This method was only used to check results
     *
     * @param args
     */
    public static void main(String args[]) {
        Graph_1011050_1016662 graph = new Graph_1011050_1016662(5, 500);
        graph.readNodes(args[0]);
        // System.out.println(graph.vertices);
        // System.out.println(graph.edges);
        graph.createMST();
        BFS_1011050_1016662 bfs = new BFS_1011050_1016662();
        int id = 2;
        Node_1011050_1016662 node = null;
        LinkedList<Node_1011050_1016662> list = graph.getHashTable()[Graph_1011050_1016662.hashFunction(id, graph.getLength())];
        for (Node_1011050_1016662 inlist : list) {
            if (inlist.getID() == id) {
                node = inlist;
                break;
            }
        }

        bfs.PrintBfs(graph.mst.getEdges(), node, graph);
    }

}