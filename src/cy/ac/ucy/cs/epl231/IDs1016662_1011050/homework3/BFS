import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This method is used for the second option of the menu. Prints all
 * the MST tree using the BFS algorithm. This object uses only one class
 * that implement the printing of the tree given as a parameter
 *
 * @author mvasil17, nstavr04
 */
public class BFS {
    /**
     * This method prints the given tree using the BFS algorithm.
     * It uses a queue.
     *
     * @param list  the list that represents the mst tree
     * @param start the starting node
     */
    public void PrintBfs(ArrayList<Edge> list, Node start) {
        ArrayList<Edge> listCopy = (ArrayList<>) list.clone();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start.getID());
        queue.add(-1);  // used to know when to add a new line
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
