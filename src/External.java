import java.time.LocalDate;
import java.time.LocalTime;

class ExternalTrip extends TripDetails {
    public ExternalTrip(String driverName, String carPlate, String destination, LocalTime time, LocalDate date, Tickets tripTicket) {
        super(driverName, carPlate, destination.toUpperCase(), time, date, calculatePrice(destination), tripTicket); // Pass calculated price directly
    }


        public static double calculatePrice(String destination) {
            switch (destination.toUpperCase()) {
                case "CAIRO":
                    return 700;
                case "MATROUH":
                    return 500;
                default:
                    System.out.println("Warning: Unknown external destination. Using default price of 0 EGP.");
                    return 0;
            }
        }
    }
