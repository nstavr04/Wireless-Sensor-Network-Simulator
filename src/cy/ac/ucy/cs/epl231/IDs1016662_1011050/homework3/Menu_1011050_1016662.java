package cy.ac.ucy.cs.epl231.IDs1016662_1011050.homework3;

import java.util.LinkedList;
import java.util.Scanner;

public final class Menu_1011050_1016662 {

    private static int option;

    static Scanner scan = new Scanner(System.in);

    public Menu_1011050_1016662() {
        option = -1;
    }


    // The option cant be something else. It is always 1-6. (we check it at main)
    public static void decideOperation(Graph_1011050_1016662 graph, BFS_1011050_1016662 bfs) {
        switch (option) {
            case 1:

                graph.createMST();
                System.out.println("MST CALCULATED!");

                break;
            case 2:


//                System.out.print("SELECT STARTING POINT: ");
//                id = scan.nextInt();
                int id=2;
                Node_1011050_1016662 node = null;
                LinkedList<Node_1011050_1016662> list = graph.getHashTable()[Graph_1011050_1016662.hashFunction(id, graph.getLength())];
                if (list == null) {
                    System.out.println("THERE IS NO SUCH ID");
                    System.exit(0);
                }
                for (Node_1011050_1016662 inlist : list) {
                    if (inlist.getID() == id) {
                        node = inlist;
                        break;
                    }
                }
                bfs.PrintBfs(graph.mst.getEdges(), node, graph);
                break;
            case 3:
                //
                break;
            case 4:
                //
                break;
            case 5:
                //
                break;
            case 6:
                //
                break;
            default:
                System.out.println("Should never be inside this. cs.ac.ucy.cs.epl231.IDs1016662_1011050.homework3.Menu -> decideOperation");
                break;

        }
    }


    // Getter method
    public static int getOption() {
        return option;
    }

    // Setter method
    public static void setOption(int option) {
        Menu_1011050_1016662.option = option;
    }


    public static void printOptions() {
        System.out.println("1) Ypoloogismos elaxistou gennitorikou grafou");
        System.out.println("2) Ektiposi (kai oxi ipologismos) tou elaxistou genitorikou dentrou tou grafou");
        System.out.println("3) Isagogi neou komvou(ID, coordinates, temperature)");
        System.out.println("4) Apoxorisi komvou(ID)");
        System.out.println("5) Enimerosi tou pirosvestikou kentrou A gia tin ipsiloteri thermokrasia tou diktiou");
        System.out.println("6) Exit");
        System.out.println("Please select an opperand.");
    }
}
