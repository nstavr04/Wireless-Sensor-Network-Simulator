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
    public static void decideOperation(Graph_1011050_1016662 graph, BFS_1011050_1016662 bfs, String fileName) {
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
                System.out.println("ENTER ID {space} X COORDINATE {space} Y COORDINATE {space} TEMPERATURE");
                Node_1011050_1016662 newnode = new Node_1011050_1016662(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
                graph.insertNode(newnode);
                graph.createMST();
                break;
            case 4:
                System.out.println("ENTER THE ID OF THE COMB THAT YOU WANT TO REMOVE");
                int ID = scan.nextInt();
                Node_1011050_1016662 node3 = null;
                LinkedList<Node_1011050_1016662> list3 = graph.getHashTable()[Graph_1011050_1016662.hashFunction(ID,
                        graph.getLength())];
                if (list3 == null) {
                    System.out.println("THERE IS NO SUCH ID ");
                    System.exit(0);
                }
                for (Node_1011050_1016662 inlist3 : list3) {
                    if (inlist3.getID() == ID) {
                        node3 = inlist3;
                        break;
                    }

                }
                graph.removeNode(node3);
                graph.createMST();
                break;
            case 5:
                System.out.print("SELECT STARTING POINT: ");
                int idstarts = scan.nextInt();
//                System.out.print("SELECT ENDING POINT: ");
//                int ends = scan.nextInt();
                Node_1011050_1016662 nodeStart = null;
                LinkedList<Node_1011050_1016662> list1 = graph.getHashTable()[Graph_1011050_1016662.hashFunction(idstarts,
                        graph.getLength())];
                if (list1 == null) {
                    System.out.println("THERE IS NO SUCH ID ");
                    System.exit(0);
                }
                for (Node_1011050_1016662 inlist1 : list1) {
                    if (inlist1.getID() == idstarts) {
                        nodeStart = inlist1;
                        break;
                    }
                }
//                Node_1011050_1016662 nodeEnds = null;
//                LinkedList<Node_1011050_1016662> list2 = graph.getHashTable()[Graph_1011050_1016662.hashFunction(ends,
//                        graph.getLength())];
//                if (list2 == null) {
//                    System.out.println("THERE IS NO SUCH ID ");
//                    System.exit(0);
//                }
//                for (Node_1011050_1016662 inlist2 : list2) {
//                    if (inlist2.getID() == ends) {
//                        nodeEnds = inlist2;
//                        break;
//                    }
//                }
                if (nodeStart.isStation()) {
                    MST_1011050_1016662.DFS(graph.mst.getEdges(), idstarts);
                } else {
                    System.out.println("Node must be a fire station");
                }
                break;
            case 6:
                graph.updateFile(fileName);
                System.out.println("EXIT !");
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
