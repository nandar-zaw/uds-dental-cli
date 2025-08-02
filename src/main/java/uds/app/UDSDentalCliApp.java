package uds.app;

import org.json.JSONArray;
import uds.dto.AppointmentDTO;
import uds.service.AppointmentService;

public class UDSDentalCliApp {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar uds-dental-cli.jar <year> <quarter>");
            System.out.println("Example: java -jar uds-dental-cli.jar 2025 1");
            return;
        }

        int year;
        int quarter;

        try {
            year = Integer.parseInt(args[0]);
            quarter = Integer.parseInt(args[1]);

            if (quarter < 1 || quarter > 4) {
                System.out.println("Quarter must be between 1 and 4.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Year and quarter must be integers.");
            return;
        }

        AppointmentDTO[] filteredAppointments = AppointmentService.getAppointmentsInQuarterOfYear(year, quarter);

        JSONArray json = new JSONArray();
        for (AppointmentDTO dto : filteredAppointments) {
            json.put(dto.toJSON());
        }

        System.out.println(json.toString(2)); // Pretty-print JSON
    }
}