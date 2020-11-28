package cy.ac.ucy.cs.epl231.IDs1016662_1011050.homework3;

import java.util.Scanner;
import java.io.*;

// Input at the commnd line must take first D, then FileName
public class MainClass_1011050_1016662 {
    public static void main(String[] args) {

        Graph_1011050_1016662 graph = new Graph_1011050_1016662(5, Integer.parseInt(args[0]));

        graph.readNodes(args[1]);       // Insert all the nodes from the file

        Scanner scan = new Scanner(System.in);
        String optionStr;

        BFS_1011050_1016662 bfs = new BFS_1011050_1016662();
        int id;

        final int D = Integer.parseInt(args[0]);


/*
        // FILE READING. ASSUMES THAT FILE IS GIVEN AS A SECOND ARGUMENT
        File newFile = new File(args[1]);
        Scanner fileScan = null;
        try {
            fileScan = new Scanner(newFile);
            while (fileScan.hasNextLine()) {


                String id = fileScan.next();            // Read it as String because as int it deletes the first digit if zero
                String coordinateX = fileScan.next();
                String coordinateY = fileScan.next();
                int temperature = fileScan.nextInt();

//                System.out.println("coordinateX before: " + coordinateX);   // Just to check
//                System.out.println("coordinateY before: " + coordinateY);

                coordinateX = coordinateX.substring(1, coordinateX.indexOf(","));
                coordinateY = coordinateY.substring(0, coordinateY.indexOf("]"));

//                System.out.println("coordinateX after: " + coordinateX);    // Just to check
//                System.out.println("coordinateY after: " + coordinateY);

                if (id.startsWith("0")){    // It is a fireStation node
                    Node newNode = new Node(Integer.parseInt(id), Integer.parseInt(coordinateX), Integer.parseInt(coordinateY), temperature, true);
                }else{      // It is a computing node
                    Node newNode = new Node(Integer.parseInt(id), Integer.parseInt(coordinateX), Integer.parseInt(coordinateY), temperature, false);
                }


                // HERE WE HAVE TO ENTER THIS POINT TO THE GRAPH OR SOMEWHERE. (STORE IT)
//                Point


//                System.out.println(id + " " + coordinateX + " " + coordinateY + " " + temperature);   // Just to check it
            }
            fileScan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found Exception.");
            e.printStackTrace();
            System.exit(-1);
        }

 */


        do {

            Menu_1011050_1016662.printOptions();
            optionStr = scan.next();

            while (optionStr.length() != 1 || optionStr.charAt(0) < '1' || optionStr.charAt(0) > '6') {     // check if user gave a right answer
                System.out.println("Please enter a valid number. Choose between 1-6");
                optionStr = scan.next();
            }

            int option = Integer.parseInt(optionStr);

            Menu_1011050_1016662.setOption(option); // set option nat menu

            Menu_1011050_1016662.decideOperation(graph, bfs); // Decide and execute operation


        } while (Menu_1011050_1016662.getOption() != 6);

        System.out.println("Program terminated");
        return;
    }
}
