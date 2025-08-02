package uds.model;

import java.time.LocalDate;

public class Patient {
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private LocalDate dateOfBirth;

        public Patient(String firstName, String lastName, String phoneNumber, LocalDate dateOfBirth) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.dateOfBirth = dateOfBirth;
        }

        // Getters
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getPhoneNumber() { return phoneNumber; }
        public LocalDate getDateOfBirth() { return dateOfBirth; }


}
