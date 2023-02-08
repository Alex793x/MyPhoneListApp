package application_modules;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    // Fields ---------------------------------------------
    private final Map<Contact, String> phoneBook;

    // Constructor ----------------------------------------
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Getter ---------------------------------------------
    public Map<Contact, String> getPhoneBook() {
        return phoneBook;
    }


    // Print (ToString) -------------------------------------
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!phoneBook.isEmpty()) {

            /* This lambda expression is first of all sorting each setEntry to printed based on firstname A -> Z,
             * Then for each sorted setEntry appends contact info (firstname, lastname, email), phone number and lastly newline. */
            phoneBook.entrySet().stream()
                    .sorted(Comparator.comparing(set -> set.getKey().getFirstName()))
                    .forEach(set -> sb.append("----------------\n")
                            .append("Contact: ")
                            .append(set.getKey())
                            .append(", TEL: ")
                            .append(set.getValue())
                            .append("\n"));
        } // End of lambda expression
        return sb.toString();
    } // End of toString method

}
