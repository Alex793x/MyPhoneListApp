import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Comparator;

public class FileWriter {

    // This method writes our phonebook to a file.
    public void writeToPhoneBookFile(PhoneBook phoneBook) {

        /* By adding the Buffered writer to try block reference section,
        *  Then the whenever try-catch block is finished it automatically closes the writer .*/
        try(BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("phonebook.txt"))) {
            phoneBook.getPhoneBook().entrySet().stream()
                    .sorted(Comparator.comparing(set -> set.getKey().getFirstName()))
                    .forEach(set -> {
                /*
                * For each element within our HashMap we are writing fields from contact to file,
                * then we when contact fields has been written, we add associated number.
                * */
                try {
                    writer.write(set.getKey().getFirstName() + ";");
                    writer.write(set.getKey().getLastName() + ";");
                    writer.write(set.getKey().getEmail() + ";");
                    writer.write(set.getValue());                   // Phone number
                    writer.newLine();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } // End of inner try-catch block
            });

        } catch (IOException e) {
            System.out.println("Something went wrong with writing to file - phonebook.txt");
        } // End of outer try-catch block
    } // End of writeToPhonebookFile method
}
