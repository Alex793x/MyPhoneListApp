package Controller;

import Handlers.PhoneBookHandler;
import application_modules.Menu;
import application_modules.PhoneBook;
import file_io.FileReader;
import file_io.FileWriter;
import utility_io.UI;

public class AppLogic {
    // Fields ----------------------------------------------
    UI ui = new UI();
    FileWriter fileWriter = new FileWriter();
    FileReader fileReader = new FileReader();
    PhoneBook phoneBook = new PhoneBook();
    PhoneBookHandler phoneBookHandler = new PhoneBookHandler();
    Menu headMenu = new Menu("Please Select", "MY PHONEBOOK", new String[]{
            "1. Add new contact",
            "2. Delete contact",
            "3. Lookup contact phone number",
            "4. Is contact added ?",
            "5. Print all contact names",
            "6. Print all contacts",
            "7. Change a contact info",
            "0. Exist app"
    });

    Menu subMenu = new Menu("Please select", "CHANGE CONTACT INFO", new String[] {
            "1. Change firstname",
            "2. Change lastname",
            "3. Change email",
            "4. Change phone number",
            "0. Return to Start"
    });

    // Application Run Logic -------------------------------
    public void runMenu() {
        boolean shouldRunMenu = true;                       // Switch for running menu
        fileReader.readFile(phoneBook);                     // Loads all data from file to app

        while (shouldRunMenu) {
            headMenu.printMenu();
            switch (ui.readInt()) {
                case 1 -> phoneBookHandler.addNewContact(ui, phoneBook);
                case 2 -> phoneBookHandler.deleteContact(ui, phoneBook);
                case 3 -> phoneBookHandler.searchNumByContact(ui, phoneBook);
                case 4 -> phoneBookHandler.contactExist(ui, phoneBook);
                case 5 -> phoneBookHandler.printContactNames(phoneBook);
                case 6 -> System.out.println(phoneBook);
                case 7 -> runSubMenu();
                case 0 -> shouldRunMenu = false;
                default -> System.out.println("Invalid input, please try again");
            } // End of switch case
            fileWriter.writeToPhoneBookFile(phoneBook);      // Writes all data from phonebook to file for every iteration.
        } // End of while loop
    } // End of runMenu method

    private void runSubMenu() {
        boolean shouldRunMenu = true;                       // Switch for running menu

        while (shouldRunMenu) {
            subMenu.printMenu();
            switch (ui.readInt()) {
                case 1 -> {
                    try {
                        phoneBookHandler.searchContact(ui, phoneBook).changeFirstName(ui);
                    } catch (NullPointerException e) {
                        System.out.println("Contact doesn't exist");
                    } // End of try-catch block
                } // End of case 1

                case 2 -> {
                    try {
                        phoneBookHandler.searchContact(ui, phoneBook).changeLastName(ui);
                    } catch (NullPointerException e) {
                        System.out.println("Contact doesn't exist");
                    } // End of try-catch block
                } // End of case 2

                case 3 -> {
                    try {
                        phoneBookHandler.searchContact(ui, phoneBook).changeEmail(ui);
                    } catch (NullPointerException e) {
                        System.out.println("Contact doesn't exist");
                    } // End of try-catch block
                } // End of case 3

                case 4 -> phoneBookHandler.changePhoneNumber(ui, phoneBook);
                case 0 -> shouldRunMenu = false;
                default -> System.out.println("Invalid input, please try again");
            } // End of switch case
        } // End of while loop
    } // End of runSubMenu method

}
