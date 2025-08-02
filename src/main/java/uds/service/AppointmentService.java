package uds.service;

import uds.dao.AppointmentDAO;
import uds.dto.AppointmentDTO;
import uds.dto.PatientDTO;
import uds.model.Appointment;
import uds.model.Patient;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

public class AppointmentService {
    AppointmentDAO appointmentDAO;

    public AppointmentService() {
        this.appointmentDAO = AppointmentDAO.getInstance();
    }

    public static AppointmentDTO[] getAppointmentsInQuarterOfYear(int year, int quarter) {
        AppointmentDAO dao = new AppointmentDAO();
        Appointment[] appointments = dao.loadAppointments();

        AppointmentDTO[] appointmentDTOs = new AppointmentDTO[appointments.length];
        for (int i = 0; i < appointments.length; i++) {
            Patient p = appointments[i].getPatient();
            PatientDTO pDTO = new PatientDTO(
                    p.getFirstName(),
                    p.getLastName(),
                    p.getPhoneNumber(),
                    p.getDateOfBirth()
            );

            appointmentDTOs[i] = new AppointmentDTO(
                    appointments[i].getAppointmentId(),
                    appointments[i].getAppointmentDate(),
                    appointments[i].getAppointmentTime(),
                    pDTO
            );
        }

        int startMonth = (quarter - 1) * 3 + 1;
        int endMonth = startMonth + 2;

        return Arrays.stream(appointmentDTOs)
                .filter(a -> {
                    LocalDate date = a.appointmentDate();
                    return date.getYear() == year &&
                            date.getMonthValue() >= startMonth &&
                            date.getMonthValue() <= endMonth;
                })
                .sorted((a1, a2) -> a2.appointmentDate().compareTo(a1.appointmentDate()))
                .toArray(AppointmentDTO[]::new);
    }

}
