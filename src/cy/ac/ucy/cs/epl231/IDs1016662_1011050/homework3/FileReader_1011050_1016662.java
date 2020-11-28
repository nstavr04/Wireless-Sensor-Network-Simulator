package cy.ac.ucy.cs.epl231.IDs1016662_1011050.homework3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used to make it easier to have access in a file.
 *
 * In this class , a private field is used to represent the file, each time the
 * user wants to access the file. There is no constructor for this class , but
 * there are 3 helpful method to open , read and close the file.
 *
 * @author mvasil17, nstavr04
 */
public class FileReader_1011050_1016662 {

    /**
     * This is the private field to help up have access to the file.
     */
    private Scanner fin;

    /**
     * This is the helpful method that helps having access to the File.
     *
     * @param FileName the string that refers to the file we want to access
     *
     * @author mvasil17, nstavr04
     */
    public void openFile(String FileName) {
        try {
            fin = new Scanner(new File(FileName));
        } catch (Exception e) {
            System.out.println("FILE NOT FOUND");
        }
    }

    /**
     * This is a helpful method.
     *
     * This method reads the file and transfers its content to a list of lists.
     * Every index of the list returned represents a list of each node and its
     * fields. So , every index represents a line of the file read.
     *
     * @return list : The list returned. (THIS METHOD IS NO LONGER USED BY THE
     *         PROGRAM !!!!! )
     * @author mvasil17, nstavr04
     */
    public ArrayList<ArrayList<Integer>> readFile() {
        ArrayList<ArrayList<Integer>> Mainlist = new ArrayList<ArrayList<Integer>>();

        int i = 0;
        fin.useDelimiter("[^0-9]+"); // keep only digits.
        while (fin.hasNext()) {
            Mainlist.add(new ArrayList<Integer>());
            Mainlist.get(i).add(fin.nextInt());
            Mainlist.get(i).add(fin.nextInt());
            Mainlist.get(i).add(fin.nextInt());
            Mainlist.get(i).add(fin.nextInt());
            i++;
        }

        return Mainlist;
    }

    /**
     * The helpful method that closes the file.
     *
     * @author mvasil17, nstavr04
     */
    public void closeFile() {
        fin.close();
    }

    /**
     * The main method was only used for debugging.
     *
     * @author mvasil17, nstavr04
     * @param args
     */
    public static void main(String[] args) {

        FileReader_1011050_1016662 f = new FileReader_1011050_1016662();
        f.openFile(args[0]);
        ArrayList<ArrayList<Integer>> Mainlist = f.readFile();
        System.out.println(Mainlist.size());
        for (ArrayList<Integer> integers : Mainlist) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        f.closeFile();
    }

}

