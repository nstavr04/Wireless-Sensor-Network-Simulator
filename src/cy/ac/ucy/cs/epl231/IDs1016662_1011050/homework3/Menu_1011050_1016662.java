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

        LinkedList<Node_1011050_1016662> list;

        switch (option) {
            case 1:
                graph.createMST();
                System.out.println("To elaxisto gennitoriko dentro tou grafou ipologistike epitixos.");
                break;

            case 2:
                Node_1011050_1016662 node02 = null;
                list = graph.getHashTable()[Graph_1011050_1016662.hashFunction(2, graph.getLength())];

                if (list == null) {
                    System.out.println("To pirosvestiko kentro me ID 02 den iparxei sto WSNS");
                    return;
                }
                for (Node_1011050_1016662 listNode : list) {
                    if (listNode.getID() == 2) {
                        node02 = listNode;
                        break;
                    }
                }

                if(node02 == null){
                    System.out.println("To pirosvestiko kentro me ID 02 den iparxei sto WSNS");
                    return;
                }

                //Doing bfs starting from the node with ID 02
                bfs.PrintBfs(graph.mst.getEdges(), node02, graph);
                break;

            case 3:
                System.out.println("Eisagete ta stoixeia tou neou kovmou: (ID coordinatesX coordinatesY temperature)");
                Node_1011050_1016662 insertedNode = new Node_1011050_1016662(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
                graph.insertNode(insertedNode);
                graph.createMST();
                break;

            case 4:
                System.out.println("Eisagete to ID tou kovmou pou thelete na diagrapsete: ");
                int idDel = scan.nextInt();
                Node_1011050_1016662 nodeDel = null;
                list = graph.getHashTable()[Graph_1011050_1016662.hashFunction(idDel,
                        graph.getLength())];

                if (list == null) {
                    System.out.println("This ID does not exist.");
                    return;
                }

                for (Node_1011050_1016662 listNode : list) {
                    if (listNode.getID() == idDel) {
                        nodeDel = listNode;
                        break;
                    }
                }

                if(nodeDel == null){
                    System.out.println("This ID does not exist.");
                    break;
                }

                graph.removeNode(nodeDel);
                graph.createMST();

                break;

            case 5:
                System.out.print("Dose ID pirosvestikou kentrou: ");
                int idFireS = scan.nextInt();

                if(idFireS < 1 || idFireS > 9){
                    System.out.println("To ID den einai pirosvestikos stathmos.");
                    return;
                }

                list = graph.getHashTable()[Graph_1011050_1016662.hashFunction(idFireS, graph.getLength())];
                Node_1011050_1016662 nodeFireS = null;

                if (list == null) {
                    System.out.println("This ID does not exist.");
                    return;
                }

                for (Node_1011050_1016662 listNode : list) {
                    if (listNode.getID() == idFireS) {
                        nodeFireS = listNode;
                        break;
                    }
                }

                if(nodeFireS == null){
                    System.out.println("This ID does not exist");
                    return;
                }

                MST_1011050_1016662.DFS(graph.mst.getEdges(), idFireS);
                break;

            case 6:
                //File name needs to be correct
                graph.updateFile(fileName);
                System.out.println("Terminating program.");
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
        System.out.println("1) Ypoloogismos elaxistou gennitorikou dentrou tou grafou");
        System.out.println("2) Ektiposi (kai oxi ipologismos) tou elaxistou genitorikou dentrou tou grafou");
        System.out.println("3) Isagogi neou komvou(ID, coordinates, temperature)");
        System.out.println("4) Apoxorisi komvou(ID)");
        System.out.println("5) Enimerosi tou pirosvestikou kentrou A gia tin ipsiloteri thermokrasia tou diktiou");
        System.out.println("6) Exit");
        System.out.println("Please select an opperand.");
    }
}
