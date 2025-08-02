package uds.dto;

import org.json.JSONObject;

import java.time.LocalDate;

public record PatientDTO(
        String firstName,
        String lastName,
        String phoneNumber,
        LocalDate dateOfBirth
) {
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("PhoneNumber", (phoneNumber != null) ? phoneNumber : "null");
        jsonObject.put("dateOfBirth", dateOfBirth);

        return jsonObject;
    }
}
