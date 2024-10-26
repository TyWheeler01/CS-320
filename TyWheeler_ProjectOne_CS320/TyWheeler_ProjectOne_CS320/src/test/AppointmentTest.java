import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
    private Appointment appointment;

    @BeforeEach
    public void setUp() {
        appointment = new Appointment("1", new Date(), "Initial Appointment"); // Setup with a valid appointment
    }

    @Test
    public void testGetAppointmentId() {
        assertEquals("1", appointment.getAppointmentId());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Initial Appointment", appointment.getDescription());
    }

    @Test
    public void testGetAppointmentDate() {
        assertNotNull(appointment.getAppointmentDate()); // Ensure appointment date is not null
    }

    @Test
    public void testSetDescription() {
        appointment.setDescription("Updated Appointment");
        assertEquals("Updated Appointment", appointment.getDescription());
    }

    @Test
    public void testAppointmentIdCannotBeNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(), "Some Description");
        });
        assertEquals("Appointment ID cannot be null", exception.getMessage());
    }

    @Test
    public void testAppointmentIdCannotExceedMaxLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", new Date(), "Some Description"); // 11 characters
        });
        assertEquals("Appointment ID cannot exceed 10 characters", exception.getMessage());
    }

    @Test
    public void testAppointmentDateCannotBeNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", null, "Some Description");
        });
        assertEquals("Appointment date cannot be null", exception.getMessage());
    }

    @Test
    public void testValidAppointmentCreation() {
        Appointment validAppointment = new Appointment("1234567890", new Date(), "Valid Appointment"); // 10 characters
        assertEquals("1234567890", validAppointment.getAppointmentId());
        assertNotNull(validAppointment.getAppointmentDate());
        assertEquals("Valid Appointment", validAppointment.getDescription());
    }
}
