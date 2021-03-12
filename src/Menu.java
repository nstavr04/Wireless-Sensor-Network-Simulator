
import java.util.LinkedList;
import java.util.Scanner;

public final class Menu {

    private static int option;

    static Scanner scan = new Scanner(System.in);

    public Menu() {
        option = -1;
    }


    // The option cant be something else. It is always 1-6. (we check it at main)
    public static void decideOperation(Graph graph, BFS bfs, String fileName) {

        LinkedList<Node> list;

        switch (option) {
            case 1:
                graph.createMST();
                System.out.println("The MST has been calculated succesfully.");
                break;

            case 2:
                Node node02 = null;
                list = graph.getHashTable()[Graph.hashFunction(2, graph.getLength())];

                if (list == null) {
                    System.out.println("Fire Department with ID 02 does not exist WSNS");
                    return;
                }
                for (Node listNode : list) {
                    if (listNode.getID() == 2) {
                        node02 = listNode;
                        break;
                    }
                }

                if(node02 == null){
                    System.out.println("Fire Department with ID 02 does not exist WSNS");
                    return;
                }

                //Doing bfs starting from the node with ID 02
                bfs.PrintBfs(graph.mst.getEdges(), node02);
                break;

            case 3:
                System.out.println("Enter new node elements: (ID coordinatesX coordinatesY temperature)");
                Node insertedNode = new Node(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
                graph.insertNode(insertedNode);
                graph.createMST();
                break;

            case 4:
                System.out.println("Give node ID you want to delete: ");
                int idDel = scan.nextInt();
                Node nodeDel = null;
                list = graph.getHashTable()[Graph.hashFunction(idDel,
                        graph.getLength())];

                if (list == null) {
                    System.out.println("This ID does not exist.");
                    return;
                }

                for (Node listNode : list) {
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
                System.out.print("Give fire department ID: ");
                int idFireS = scan.nextInt();

                list = graph.getHashTable()[Graph.hashFunction(idFireS, graph.getLength())];
                Node nodeFireS = null;

                if (list == null) {
                    System.out.println("This ID does not exist.");
                    return;
                }

                for (Node listNode : list) {
                    if (listNode.getID() == idFireS) {
                        nodeFireS = listNode;
                        break;
                    }
                }

                if(nodeFireS == null){
                    System.out.println("This ID does not exist");
                    return;
                }

                if(!nodeFireS.isStation()){
                    System.out.println("This is not a fire department ID.");
                    return;
                }

                MST.DFS(graph.mst.getEdges(), idFireS);
                break;

            case 6:
                //File name needs to be correct
                graph.updateFile(fileName);
                System.out.println("Terminating program.");
                break;

            default:
                System.out.println("Should never be inside this.");
                break;

        }
    }


    // Getter method
    public static int getOption() {
        return option;
    }

    // Setter method
    public static void setOption(int option) {
        Menu.option = option;
    }


    public static void printOptions() {
        System.out.println("1) Calculation of MST of graph");
        System.out.println("2) Print and not calculation of MST of the graph");
        System.out.println("3) Enter new node(ID, coordinates, temperature)");
        System.out.println("4) Remove node(ID)");
        System.out.println("5) Update fire department A for the highest temperature of the network");
        System.out.println("6) Exit");
        System.out.println("Please select an opperand.");
    }
}
