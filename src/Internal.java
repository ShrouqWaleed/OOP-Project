import java.time.LocalDate;
import java.time.LocalTime;

class InternalTrip extends TripDetails {

    private static final String CITY = "Alexandria"; 
    private double tripPrice;  

  public InternalTrip(String driverName, String carPlate, String destination, LocalTime time, LocalDate date, Tickets tripTicket) {
        super(driverName, carPlate, destination.toUpperCase(), time, date, calculatePrice(destination), tripTicket); // Pass calculated price directly
    }

    

    public static double calculatePrice(String destination) {
        switch (destination.toUpperCase()) {
            case "KILO 21":
                return 80.0;
            case "BAB SHARQ ABO QEEIR":
                return 75.0;
            case "COLLEGE OF ENGINEERING ABO QEEIR":
                return 60.0;
            case "EL IBRAHIMIYA":
                return 55.0;
            case "NAFAQ SPORTING":
                return 50.0;
            case "CLEOPATRA ABO QEEIR":
                return 45.0;
            case "SEEDY GABER":
                return 40.0;
            case "STANLY":
                return 35.0;
            case "GLEEM":
                return 30.0;
            case "SAN STEFNO":
                return 25.0;
            default:
                System.out.println("Warning: Unknown internal destination. Using default price of 20 EGP.");
                return 0;
        }
    }
}