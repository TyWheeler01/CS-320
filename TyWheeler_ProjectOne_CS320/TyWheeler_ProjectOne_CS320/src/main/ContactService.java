import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Method to add a contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact with this ID already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Method to get a contact by ID
    public Contact getContact(String contactId) {
        return contacts.get(contactId); // Returns null if the contact doesn't exist
    }

    // Method to delete a contact
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact does not exist.");
        }
        contacts.remove(contactId);
    }

    // Method to update the first name of a contact
    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = getContact(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact does not exist.");
        }
        contact.setFirstName(newFirstName); // This will throw if newFirstName is invalid
    }

    // Method to update the last name of a contact
    public void updateLastName(String contactId, String newLastName) {
        Contact contact = getContact(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact does not exist.");
        }
        contact.setLastName(newLastName); // This will throw if newLastName is invalid
    }

    // Method to update the phone number of a contact
    public void updatePhoneNumber(String contactId, String newPhone) {
        Contact contact = getContact(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact does not exist.");
        }
        contact.setPhone(newPhone); // This will throw if newPhone is invalid
    }

    // Method to update the address of a contact
    public void updateAddress(String contactId, String newAddress) {
        Contact contact = getContact(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact does not exist.");
        }
        contact.setAddress(newAddress); // This will throw if newAddress is invalid
    }
}
