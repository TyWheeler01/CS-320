import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment("APPT1", new Date(System.currentTimeMillis() + 86400000), "Meeting with Ty Wheeler");
        assertTrue(appointmentService.addAppointment(appointment)); // Should return true
    }

    @Test
    public void testGetAppointment() {
        Appointment appointment = new Appointment("APPT1", new Date(System.currentTimeMillis() + 86400000), "Meeting with Ty Wheeler");
        appointmentService.addAppointment(appointment);
        Appointment fetchedAppointment = appointmentService.getAppointment("APPT1");
        assertEquals(appointment, fetchedAppointment); // Should match the added appointment
    }

    @Test
    public void testDeleteAppointment() {
        Appointment appointment = new Appointment("APPT1", new Date(System.currentTimeMillis() + 86400000), "Meeting with Ty Wheeler");
        appointmentService.addAppointment(appointment);
        assertTrue(appointmentService.deleteAppointment("APPT1")); // Should return true
        assertNull(appointmentService.getAppointment("APPT1")); // Verify it's deleted
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        assertFalse(appointmentService.deleteAppointment("NONEXISTENT")); // Should return false
    }

    @Test
    public void testGetNonExistentAppointment() {
        assertNull(appointmentService.getAppointment("NONEXISTENT")); // Should return null
    }

    @Test
    public void testAddDuplicateAppointment() {
        Appointment appointment1 = new Appointment("APPT1", new Date(System.currentTimeMillis() + 86400000), "Meeting with Ty Wheeler");
        Appointment appointment2 = new Appointment("APPT1", new Date(System.currentTimeMillis() + 86400000), "Another Meeting with Ty Wheeler");
        appointmentService.addAppointment(appointment1);
        assertFalse(appointmentService.addAppointment(appointment2)); // Should return false for duplicate
    }
}
