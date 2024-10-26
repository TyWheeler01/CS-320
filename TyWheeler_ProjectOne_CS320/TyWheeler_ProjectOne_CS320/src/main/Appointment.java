import java.util.Date;

public class Appointment {
    private final String appointmentId; // Unique identifier for the appointment
    private final Date appointmentDate;  // Date of the appointment
    private String description;           // Description of the appointment

    // Constructor
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
        if (appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID cannot exceed 10 characters");
        }
        this.appointmentId = appointmentId;
        
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null");
        }
        this.appointmentDate = appointmentDate; // Validate date is not null
        this.description = description; // Allow null or empty descriptions
    }

    // Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate; // Added method to get the appointment date
    }

    public String getDescription() {
        return description;
    }

    // Setters for description (if needed)
    public void setDescription(String description) {
        this.description = description; // Allow null or empty descriptions
    }
}
