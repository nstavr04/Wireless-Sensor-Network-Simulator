package cs.ac.ucy.cs.epl231.IDs1016662_1011050.homework3;

public class Menu {

    private int option;

    public Menu() {
        option = -1;
    }


    // The option cant be something else. It is always 1-6. (we check it at main)
    public void decideOperation() {
        switch (option) {
            case 1:
                //
                break;
            case 2:
                //
                break;
            case 3:
                //
                break;
            case 4:
                //
                break;
            case 5:
                //
                break;
            case 6:
                //
                break;
            default:
                System.out.println("Should never be inside this. cs.ac.ucy.cs.epl231.IDs1016662_1011050.homework3.Menu -> decideOperation");
                break;

        }
    }


    // Getter method
    public int getOption() {
        return option;
    }

    // Setter method
    public void setOption(int option) {
        this.option = option;
    }


    public void printOptions() {
        System.out.println("1) Ypoloogismos elaxistou gennitorikou grafou");
        System.out.println("2) Ektiposi (kai oxi ipologismos) tou elaxistou genitorikou dentrou tou grafou");
        System.out.println("3) Isagogi neou komvou(ID, coordinates, temperature)");
        System.out.println("4) Apoxorisi komvou(ID)");
        System.out.println("5) Enimerosi tou pirosvestikou kentrou A gia tin ipsiloteri thermokrasia tou diktiou");
        System.out.println("6) Exit");
        System.out.println("Please select an opperand.");
    }
}
