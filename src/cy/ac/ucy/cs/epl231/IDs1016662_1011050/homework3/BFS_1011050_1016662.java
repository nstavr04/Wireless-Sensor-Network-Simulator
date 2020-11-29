package cy.ac.ucy.cs.epl231.IDs1016662_1011050.homework3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This method is used for the second option of the menu. Prints all
 * the MST tree using the BFS algorithm. This object uses only one class
 * that implement the printing of the tree given as a parameter.
 *
 * @author mvasil17, nstavr04
 */
public class BFS_1011050_1016662 {
    /**
     * This method prints the given tree using the BFS algorithm.
     * It uses a queue.
     *
     * @param list  the list that represents the mst tree
     * @param start the starting node
     * @param graph the graph that the mst belongs to
     */
    public void PrintBfs(ArrayList<Edge_1011050_1016662> list, Node_1011050_1016662 start, Graph_1011050_1016662 graph) {
        Node_1011050_1016662[] array = null;
        ArrayList<Edge_1011050_1016662> listCopy = (ArrayList<Edge_1011050_1016662>) list.clone();

        Queue<Integer> queue = new LinkedList<>();
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
            int counter = 0;
            for (int i = 0; i < length; i++) {
                if (listCopy.get(counter).getNode1().getID() == v) {
                    queue.add(listCopy.get(counter).getNode2().getID());
                    listCopy.remove(listCopy.get(counter));
                    counter--;
                } else if (listCopy.get(counter).getNode2().getID() == v) {
                    queue.add(listCopy.get(counter).getNode1().getID());
                    listCopy.remove(listCopy.get(counter));
                    counter--;
                }
                counter++;
            }
        }

    }
}