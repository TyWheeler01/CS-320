import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("12345", "Ty", "Wheeler", "1234567890", "100 Boston Street, MA 02771 USA");
    }

    @Test
    void testContactCreation() {
        assertAll("contact",
            () -> assertEquals("12345", contact.getContactId()),
            () -> assertEquals("Ty", contact.getFirstName()),
            () -> assertEquals("Wheeler", contact.getLastName()),
            () -> assertEquals("1234567890", contact.getPhone()),
            () -> assertEquals("100 Boston Street, MA 02771 USA", contact.getAddress())
        );
    }

    @Test
    void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Ty", "Wheeler", "1234567890", "100 Boston Street, MA 02771 USA");
        });
    }

    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Ty", "Wheeler", "1234567890", "100 Boston Street, MA 02771 USA");
        });
    }

    @Test
    void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Wheeler", "1234567890", "100 Boston Street, MA 02771 USA");
        });
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "LunaWalkdenIsTooLong", "Walkden", "0987654321", "10 Wood Avenue, RI 02993 USA");
        });
    }

    @Test
    void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ty", null, "1234567890", "100 Boston Street, MA 02771 USA");
        });
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Luna", "WalkdenIsWayTooLong", "0987654321", "10 Wood Avenue, RI 02993 USA");
        });
    }

    @Test
    void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ty", "Wheeler", null, "100 Boston Street, MA 02771 USA");
        });
    }

    @Test
    void testPhoneMustBeExactly10Digits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ty", "Wheeler", "123456789", "100 Boston Street, MA 02771 USA");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ty", "Wheeler", "12345678901", "100 Boston Street, MA 02771 USA");
        });
    }

    @Test
    void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Ty", "Wheeler", "1234567890", null);
        });
    }

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Peter", "Finch", "1234567890", "This address is way too long and exceeds the 30 character limit.");
        });
    }

    // Removed the test for setContactId() since contactId is final and cannot be updated
}
