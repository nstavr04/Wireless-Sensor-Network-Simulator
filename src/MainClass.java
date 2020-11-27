import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        String optionStr;



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
