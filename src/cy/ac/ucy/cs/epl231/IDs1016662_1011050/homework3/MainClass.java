package cy.ac.ucy.cs.epl231.IDs1016662_1011050.homework3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Input at the commnd line must take first D, then FileName
public class MainClass {
    public static void main(String[] args) {



        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        String optionStr;


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

            menu.printOptions();
            optionStr = scan.next();

            while (optionStr.length() != 1 || optionStr.charAt(0) < '0' || optionStr.charAt(0) > '6') {     // check if user gave a right answer
                System.out.println("Please enter a valid number. Choose between 1-6");
                optionStr = scan.next();
            }

            int option = Integer.parseInt(optionStr);

            menu.setOption(option); // set option nat menu

            menu.decideOperation(); // Decide and execute operation

        } while (menu.getOption() != 6);

        System.out.println("Program terminated");
        return;
    }
}
