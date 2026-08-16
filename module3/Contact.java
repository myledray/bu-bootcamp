public class Contact {
    
    // Give it two private String fields: name and phone.  
    private String name;
    private String phoneNumber;

    // Write a constructor that takes both fields.
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Write getters: getName() and getPhoneNumber().  
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }

    // Override toString to return something
    @Override
    public String toString() {
        return name + " | Phone Number: " + phoneNumber;
    }
}
