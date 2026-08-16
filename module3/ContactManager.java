import java.util.*;

public class ContactManager {
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Alice", new Contact("Alice", "123-456-7890"));
        contacts.put("Bob", new Contact("Bob", "987-654-3210"));
        contacts.put("Charlie", new Contact("Charlie", "555-555-5555"));
 
        // Step 5: look up a contact 
        String searchName = "Myles";
        // retrieve the contact.  
        Contact foundContact = contacts.get(searchName);

        // If the result is null (name not found), print: Contact not found.  
        if (foundContact != null) {
            System.out.println("Contact: " + foundContact);
        } else {
            System.out.println("Contact not found.");
        }

 
        // Step 6: print sorted list 
        // Create an ArrayList from the HashMap’s values:  
        ArrayList<Contact> contactList = new ArrayList<>(contacts.values());
        // Sort it alphabetically by name using this one line: 
        contactList.sort((a, b) -> a.getName().compareTo(b.getName()));

        // header
        System.out.println("=== All Contacts===");
        // Loop through the sorted list and print each contact.  
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    } 
}
