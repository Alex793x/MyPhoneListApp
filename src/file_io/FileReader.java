package file_io;

import application_modules.Contact;
import application_modules.PhoneBook;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {

    // This method reads every line from our list, and adds contact name and phone number to our phonebook
    public void readFile(PhoneBook phoneBook) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader("phonebook.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(";");      // Splits the line into tokens for contact info and phoneNum
                String firstName = tokens[0];
                String lastName = tokens[1];
                String email = tokens[2];
                String phoneNum = tokens[3];

                phoneBook.getPhoneBook().put(new Contact(firstName, lastName, email), phoneNum);
            } // End of while loop

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } // End of try-catch block
    } // End of readFile method

}
