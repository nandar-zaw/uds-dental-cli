package uds.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Patient patient;

    public Appointment(int id, LocalDate date, LocalTime time, Patient patient) {
        this.appointmentId = id;
        this.appointmentDate = date;
        this.appointmentTime = time;
        this.patient = patient;
    }

    // Getters
    public int getAppointmentId() { return appointmentId; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public LocalTime getAppointmentTime() { return appointmentTime; }
    public Patient getPatient() { return patient; }
}

