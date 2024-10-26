public class Contact {

    // Fields for the contact information
    private final String contactId; // Unique identifier for the contact
    private String firstName; // First name of the contact
    private String lastName; // Last name of the contact
    private String phone; // Phone number of the contact
    private String address; // Address of the contact

    // Constructor for initializing the contact object
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate all fields according to the requirements
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name.");
        }
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be longer than 30 characters.");
        }

        // Initialize the fields if validation passes
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter for contact ID (not updatable)
    public String getContactId() {
        return contactId;
    }

    // Added getter for ID to match ContactService expectations
    public String getId() {
        return contactId; // Returns the contact ID for usage in other classes
    }

    // Getter for first name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name.");
        }
        this.firstName = firstName;
    }

    // Getter and setter for last name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name.");
        }
        this.lastName = lastName;
    }

    // Getter and setter for phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    // Getter and setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be longer than 30 characters.");
        }
        this.address = address;
    }

    // Override equals and hashCode for proper comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contact)) return false;
        Contact contact = (Contact) obj;
        return contactId.equals(contact.contactId);
    }

    @Override
    public int hashCode() {
        return contactId.hashCode();
    }
}
