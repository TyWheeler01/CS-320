import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    // Method to add an appointment
    public boolean addAppointment(Appointment appointment) {
        if (appointment == null || appointments.containsKey(appointment.getAppointmentId())) {
            return false; // Return false if appointment is null or ID is not unique
        }
        appointments.put(appointment.getAppointmentId(), appointment);
        return true; // Return true if added successfully
    }

    // Method to delete an appointment by ID
    public boolean deleteAppointment(String appointmentId) {
        if (appointmentId == null || !appointments.containsKey(appointmentId)) {
            return false; // Return false if ID is invalid or appointment doesn't exist
        }
        appointments.remove(appointmentId);
        return true; // Return true if deleted successfully
    }

    // Method to get an appointment by ID
    public Appointment getAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
        return appointments.get(appointmentId); // Return the appointment or null if not found
    }

    // Method to update an appointment (currently only description for simplicity)
    public void updateAppointment(String appointmentId, String newDescription) {
        Appointment appointment = getAppointment(appointmentId);
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment not found");
        }
        // Create a new appointment with the updated description
        Appointment updatedAppointment = new Appointment(
            appointment.getAppointmentId(),
            appointment.getAppointmentDate(),
            newDescription
        );
        appointments.put(appointmentId, updatedAppointment);
    }
}
