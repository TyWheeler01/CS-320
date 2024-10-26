import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("12345", "Ty", "Wheeler", "1234567890", "100 Boston Street, MA 02771 USA");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("12345"));
    }

    @Test
    void testAddContactWithDuplicateId() {
        Contact contact1 = new Contact("12345", "Ty", "Wheeler", "1234567890", "100 Boston Street, MA 02771 USA");
        Contact contact2 = new Contact("12345", "Luna", "Walkden", "0987654321", "10 Wood Avenue, RI 02993 USA");

        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2); // Should throw exception due to duplicate ID
        });
    }

    @Test
    void testDeleteContact() {
        Contact contact = new Contact("54321", "Peter", "Finch", "0987654321", "10 Wood Avenue, RI 02993 USA");
        contactService.addContact(contact);
        contactService.deleteContact("54321");
        assertNull(contactService.getContact("54321"));
    }

    @Test
    void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("00000"); // No contact with this ID exists
        });
    }

    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact("12345", "Ty", "Wheeler", "1234567890", "100 Boston Street, MA 02771 USA");
        contactService.addContact(contact);
        contactService.updateFirstName("12345", "Luna");
        assertEquals("Luna", contactService.getContact("12345").getFirstName());
    }

    @Test
    void testUpdateLastName() {
        Contact contact = new Contact("12345", "Ty", "Wheeler", "1234567890", "100 Boston Street, MA 02771 USA");
        contactService.addContact(contact);
        contactService.updateLastName("12345", "Walkden");
        assertEquals("Walkden", contactService.getContact("12345").getLastName());
    }

    @Test
    void testUpdatePhoneNumber() {
        Contact contact = new Contact("12345", "Ty", "Wheeler", "1234567890", "100 Boston Street, MA 02771 USA");
        contactService.addContact(contact);
        contactService.updatePhoneNumber("12345", "0987654321");
        assertEquals("0987654321", contactService.getContact("12345").getPhone());
    }

    @Test
    void testUpdateAddress() {
        Contact contact = new Contact("12345", "Ty", "Wheeler", "1234567890", "100 Boston Street, MA 02771 USA");
        contactService.addContact(contact);
        contactService.updateAddress("12345", "10 Wood Avenue, RI 02993 USA");
        assertEquals("10 Wood Avenue, RI 02993 USA", contactService.getContact("12345").getAddress());
    }

    @Test
    void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("99999", "Peter"); // Contact with ID 99999 does not exist
        });
    }
}
