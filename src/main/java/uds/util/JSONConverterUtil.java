package uds.util;

import org.json.JSONArray;
import uds.dto.AppointmentDTO;

import java.util.Arrays;

public class JSONConverterUtil {
    public static String convertAppointmentArrayToJSON(AppointmentDTO[] appointments) {
        JSONArray jsonArray = new JSONArray();
        Arrays.stream(appointments).forEach(appointment -> {
            jsonArray.put(appointment.toJSON());
        });
        return jsonArray.toString(2);
    }
}
