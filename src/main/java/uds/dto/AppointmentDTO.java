package uds.dto;

import org.json.JSONObject;
import uds.model.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentDTO(
        int appointmentId,
        LocalDate appointmentDate,
        LocalTime appointmentTime,
        PatientDTO patient
) {
    public static AppointmentDTO fromAppointment(Appointment appointment, PatientDTO patientDTO) {
        return new AppointmentDTO(
                appointment.getAppointmentId(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime(),
                patientDTO
        );
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("appointmentId", appointmentId);
        json.put("appointmentDate", appointmentDate);
        json.put("appointmentTime", appointmentTime);
        json.put("patient", (patient != null) ? patient.toJSON() : "null");
        return json;
    }
}
