package utility_io;

import java.util.*;

import static java.util.Map.entry;

public class UI {
    // Fields --------------------------------------------
    private final Scanner read;
    private final Map<String, String> countryNumCode;
    private final String[] validEmails;
    private final String[] validCountryCode;


    // Constructor ---------------------------------------
    public UI() {
        read = new Scanner(System.in);
        countryNumCode = new HashMap<>(Map.ofEntries(
                entry("United States", "1"),
                entry("United Kingdom", "44"),
                entry("Canada", "1"),
                entry("Australia", "61"),
                entry("France", "33"),
                entry("Germany", "49"),
                entry("Spain", "34"),
                entry("Italy", "39"),
                entry("Netherlands", "31"),
                entry("Switzerland", "41"),
                entry("China", "86"),
                entry("Japan", "81"),
                entry("South Africa", "27"),
                entry("Mexico", "52"),
                entry("Denmark", "45"),
                entry("Norway", "47"),
                entry("Finland", "358"),
                entry("Ireland", "353"),
                entry("Sweden", "46"),
                entry("Russia", "7"),
                entry("Belgium", "32"),
                entry("Austria", "43")
        ));

        validEmails = new String[]{"gmail", "hotmail", "yahoo", "mail", "mail", "live", "msn"};
        validCountryCode = new String[]{".dk", ".com", ".sv", ".nok", ".es", ".en", ".de"};
    }

    // Getter --------------------------------------------
    public Scanner getReader() {
        return read;
    }


    // Behaviors (Methods) --------------------------------

    // This method verifies that input is always of type int, if not throws error with msg.
    public int readInt() {
        while (true) {
            try {
                return Integer.parseInt(read.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, you need to enter a number");
            } // End of try-catch block
        } // End of while loop
    } // End of readInt method


    // This method verifies that the input doesn't contain any primitive datatype of int
    public String readLine() {
        while (true) {
            String readLine = read.nextLine();
            if (!readLine.matches(".*\\d.*")) {
                return readLine;
            } // End of if statement
            System.out.println("Please enter a valid name, without any numbers inside");
        } // End of while loop
    } // End of readLine method


    // This method verifies the user only enters a valid email of preference
    public String readEmail() {

        while (true) {
            System.out.print("Please enter contact email: ");
            String email = read.nextLine();
            if (email.contains("@")) {                                             // Validate email contains " @ "
                String[] emailValidation = email.split("@");                 // Split email for validation
                for (String provider : validEmails) {                              // Traverse available email providers
                    if (emailValidation[1].startsWith(provider)) {                 // Verify email contains email provider at end
                        for (String domain : validCountryCode) {                   // Traverse available domain providers
                            if (emailValidation[1].endsWith(provider + domain)) {  // Validate email contains domain provider at en
                                return email;
                            } // Enf of inner if statement
                        } // End of inner for-loop
                    } // End of outer if statement
                } // End of outer for-loop
            }
            System.out.println("\nYou've entered an invalid email address, here is your options");
            System.out.println("Valid email contributors: " + Arrays.toString(validEmails));
            System.out.println("Valid domains: " + Arrays.toString(validCountryCode) + "\n");
        } // End of while loop
    } // End of readEmail method

    // This method ensures we have a valid country code for each fictional phone number.
    public String readPhoneNumber() {
        List<String> countries = new ArrayList<>(countryNumCode.keySet());
        System.out.println("Please select country: ");

        int counter = 0;
        for (String country : countries) {
            System.out.println(counter + ": " + country);
            counter++;
        }

        String phoneNum = "+ " + countryNumCode.get(countries.get(read.nextInt())) + " "; // Gets countryCode from list
        System.out.print("Please enter phone number: ");
        phoneNum += read.next();
        read.nextLine();                    // Scanner bug ???????
        return phoneNum;
    } // End of readPhoneNumber
}
