package Handlers;

import application_modules.Contact;
import application_modules.PhoneBook;
import utility_io.UI;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class PhoneBookHandler {

    // Behavior (Methods) --------------------------------------------

    // This method creates a new contact for our phonebook
    public void addNewContact(UI ui, PhoneBook phoneBook) {
        phoneBook.getPhoneBook().put(createContact(ui), ui.readPhoneNumber());
        System.out.println("Contact has been added");
    }

    // This method deletes a contact from our phonebook
    public void deleteContact(UI ui, PhoneBook phoneBook) {
        phoneBook.getPhoneBook().remove(searchContact(ui, phoneBook));
        System.out.println("Contact has been removed");
    } // End of deleteContact method

    /*
    * This method checks if phonebook has the contact we are looking up.
    * If contact isn't null and found, we return the value which is associated with contact, which is the phone number
    * If contact is null, when searching we return a print: Contact not found. */
    public void searchNumByContact(UI ui ,PhoneBook phoneBook) {
        Contact contact = searchContact(ui, phoneBook);
        System.out.println(contact != null ?
                phoneBook.getPhoneBook().get(contact) : "Contact not found");
    }


    // This method returns a boolean if contact exist in our phonebook
    public void contactExist(UI ui, PhoneBook phoneBook) {
        System.out.println(phoneBook.getPhoneBook().containsKey(searchContact(ui, phoneBook)));
    }

    // This method returns a contact if found, based on input, or null if contact doesn't exist
    public Contact searchContact(UI ui, PhoneBook phoneBook) {
        System.out.print("Please enter search parameter: ");
        String searchParameter = ui.readLine();

        List<Contact> possibleContactList = phoneBook.getPhoneBook().keySet().stream()
                .filter(searchParameters(searchParameter)).toList();

        if (possibleContactList.size() > 1) {
            int count = 0;
            for (Contact contact : possibleContactList) {
                System.out.println(count + ": " + contact);
                count++;
            } // End of for loop

            System.out.println("Please enter num of Contact you wish to lookUp");
            return possibleContactList.get(ui.readInt());
        }
        return possibleContactList.isEmpty() ? null : possibleContactList.get(0);
    } // End of searchContact method

    public void changePhoneNumber(UI ui, PhoneBook phoneBook) {
        Contact contact = searchContact(ui, phoneBook);
        if (contact != null) {
            phoneBook.getPhoneBook().put(contact, ui.readPhoneNumber());
        }
    }


    // This method prints every contact name from phonebook
    public void printContactNames(PhoneBook phoneBook) {
        phoneBook.getPhoneBook().keySet().stream()
                .sorted(Comparator.comparing(Contact::getFirstName))
                .forEach(System.out::println);

        System.out.println();
    }


    // -------------------- PRIVATE METHODS ----------------------------------

    // This method is returns a new created contact
    private Contact createContact(UI ui) {
        System.out.print("Please enter contact firstname: ");
        String firstName = ui.readLine();

        System.out.print("Please enter contact lastname: ");
        String lastName = ui.readLine();

        String email = ui.readEmail();

        return new Contact(firstName, lastName, email);
    } // End of createContact method


    /* This method is checking all possible search parameters associated with a contact
    * and is used as a filter for searchContact method. */
    private Predicate<Contact> searchParameters(String searchParameter) {
        return contact ->
                contact.getFirstName().equals(searchParameter) ||
                        contact.getLastName().equals(searchParameter) ||
                        contact.getEmail().equals(searchParameter);
    } // End of predicate method
}
