package cy.ac.ucy.cs.epl231.IDs1016662_1011050.homework3;

import java.util.Scanner;
import java.io.*;

// Input at the commnd line must take first D, then FileName
public class MainClass_1011050_1016662 {
    public static void main(String[] args) {

        //Hash table has a starting size of 5
        Graph_1011050_1016662 graph = new Graph_1011050_1016662(5, Integer.parseInt(args[0]));

        graph.readNodes(args[1]);       // Insert all the nodes from the file

        Scanner scan = new Scanner(System.in);
        String optionStr;

        BFS_1011050_1016662 bfs = new BFS_1011050_1016662();


        do {

            Menu_1011050_1016662.printOptions();
            optionStr = scan.next();

            while (optionStr.length() != 1 || optionStr.charAt(0) < '1' || optionStr.charAt(0) > '6') {     // check if user gave a right answer
                System.out.println("Please enter a valid number. Choose between 1-6");
                optionStr = scan.next();
            }

            int option = Integer.parseInt(optionStr);

            // set option at menu
            Menu_1011050_1016662.setOption(option);

            // deciding the operation
            Menu_1011050_1016662.decideOperation(graph, bfs, args[1]);


        } while (Menu_1011050_1016662.getOption() != 6);

        System.out.println("Program terminated");
    }
}
