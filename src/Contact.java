public class Contact {
    // Fields --------------------------------------------------
    private String firstName;
    private String lastName;
    private String email;

    // Constructor ----------------------------------------------
    public Contact(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    // Getter ----------------------------------------------------
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }

    // Behaviors (Methods) ---------------------------------------

    // This method changes contacts firstname
    public void changeFirstName(UI ui) {
        System.out.print("Please enter new firstname: ");
        firstName = ui.readLine().substring(0,1).toUpperCase();

        System.out.println("Firstname has been changed to: " + firstName);
    }

    // This method changes contacts lastname
    public void changeLastName(UI ui) {
        System.out.print("Please enter new lastname: ");
        lastName = ui.readLine();

        System.out.println("Lastname has been changed to: " + lastName);
    }

    // This method changed contacts email-address
    public void changeEmail(UI ui) {
        System.out.print("Please enter new email: ");
        email = ui.readEmail();

        System.out.println("Email has been change to: " + email);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Email: " + email;
    }
}
