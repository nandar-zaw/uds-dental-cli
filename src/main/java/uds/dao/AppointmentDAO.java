package uds.dao;

import uds.model.Appointment;
import uds.model.Patient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    public static AppointmentDAO INSTANCE = null;
    Appointment[] appointments;

    public AppointmentDAO() {
    }
    public static final AppointmentDAO getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new AppointmentDAO();
        }
        return INSTANCE;
    }

    public Appointment[] loadAppointments() {
        appointments = new Appointment[]{
                new Appointment(1, LocalDate.of(2025, 2, 28), LocalTime.of(10, 5),
                        new Patient("John", "Smith", "(641) 001-1234", LocalDate.of(1987, 1, 19))),
                new Appointment(2, LocalDate.of(2024, 12, 31), LocalTime.of(13, 45),
                        new Patient("Anna", "Jones", "(319) 716-1987", LocalDate.of(2001, 7, 26))),
                new Appointment(3, LocalDate.of(2025, 5, 4), LocalTime.of(14, 0),
                        new Patient("Carlos", "Jimenez", "(319) 098-7711", LocalDate.of(1969, 11, 5))),
                new Appointment(4, LocalDate.of(2025, 3, 16), LocalTime.of(11, 15),
                        new Patient("Albert", "Einstein", "(641) 119-6142", LocalDate.of(1955, 12, 28)))
        };
        return appointments;
    }
    public Appointment[] getAppointments() {
        if (appointments == null || appointments.length == 0) {
            appointments = loadAppointments();
        }
        return appointments;
    }

}
