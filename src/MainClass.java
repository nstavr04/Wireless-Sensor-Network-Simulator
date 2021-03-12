
import java.util.Scanner;
import java.io.*;

// Input at the commnd line must take first D, then FileName
public class MainClass {
    public static void main(String[] args) {

        //Hash table has a starting size of 5
        Graph graph = new Graph(5, Integer.parseInt(args[0]));

        graph.readNodes(args[1]);       // Insert all the nodes from the file

        Scanner scan = new Scanner(System.in);
        String optionStr;

        BFS bfs = new BFS();


        do {

            Menu.printOptions();
            optionStr = scan.next();

            while (optionStr.length() != 1 || optionStr.charAt(0) < '1' || optionStr.charAt(0) > '6') {     // check if user gave a right answer
                System.out.println("Please enter a valid number. Choose between 1-6");
                optionStr = scan.next();
            }

            int option = Integer.parseInt(optionStr);

            // set option at menu
            Menu.setOption(option);

            // deciding the operation
            Menu.decideOperation(graph, bfs, args[1]);


        } while (Menu.getOption() != 6);

        System.out.println("Program terminated");
    }
}
