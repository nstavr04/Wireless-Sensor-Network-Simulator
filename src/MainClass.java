import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        String optionStr;

        final int D = Integer.parseInt(args[0]);

        File newFile = new File(args[1]);
        Scanner fileScan = null;
        try {
            fileScan = new Scanner(newFile);
            while (fileScan.hasNextLine()) {


                String id = fileScan.next();
                String coordinateX = fileScan.next();
                String coordinateY = fileScan.next();
                int temperature = fileScan.nextInt();

//                System.out.println(coordinateX);
                coordinateX = coordinateX.substring(1, coordinateX.indexOf(","));
//                System.out.println(coordinateX);
//                System.out.println(coordinateY);
                coordinateY = coordinateY.substring(0, coordinateY.indexOf("]"));
//                System.out.println(coordinateY);



                // HERE WE HAVE TO ENTER THIS POINT TO THE GRAPH OR SOMEWHERE. (STORE IT)
//                Point


                System.out.println(id + " " + coordinateX + " " + coordinateY + " " + temperature);
            }
            fileScan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found Exception.");
            e.printStackTrace();
        }


        do {

            menu.printOptions();
            optionStr = scan.next();

            while (optionStr.length() != 1 || optionStr.charAt(0) < '0' || optionStr.charAt(0) > '6') {
                System.out.println("Please enter a valid number. Choose between 1-6");
                optionStr = scan.next();
            }

            int option = Integer.parseInt(optionStr);

            menu.setOption(option);

            menu.decideOperation();


        } while (menu.getOption() != 6);

        System.out.println("Program terminated");
        return;
    }
}
