package application_modules;
import java.util.Arrays;

public class Menu {
    // Fields -------------------------------------
    private final String[] menuItems;
    private final String leadText;
    private final String header;

    // Constructor --------------------------------
    public Menu(String leadText, String header, String[] menuItems) {
        this.leadText = leadText;
        this.header = header;
        this.menuItems = menuItems;
    }

    // Behaviors (Methods) --------------------------
    public void printMenu() {
        System.out.println(header);
        Arrays.stream(menuItems).forEach(System.out::println); //Prints each menuItem element
        System.out.println(leadText);
    }
}
