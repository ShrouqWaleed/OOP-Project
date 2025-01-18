public class Tickets {
    double TicketPrice;
    String TicketClass;
    String VehicleType;

    public Tickets( String ticketClass, String vehicleType) {
        TicketClass = ticketClass;
        VehicleType = vehicleType;
    }

    public Tickets() {
    }

    public double TotalTicketPrice(String VehicleType, String TicketClass){
        if (VehicleType.equals("Bus") && TicketClass.equals("Basic"))
            return 50.0;
        else if (VehicleType.equals("Bus") && TicketClass.equals("Standard"))
            return 80.0;
        else if (VehicleType.equals("Bus") && TicketClass.equals("Premium"))
            return 110.0;
        else if (VehicleType.equals("Mini Bus") && TicketClass.equals("Basic"))
            return 75.0;
        else if(VehicleType.equals("Mini Bus") && TicketClass.equals("Standard"))
            return 105.0;
        else if (VehicleType.equals("Mini Bus") && TicketClass.equals("Premium"))
            return 135.0;
        else if (VehicleType.equals("Limousine") && TicketClass.equals("Basic"))
            return 100.0;
        else if (VehicleType.equals("Limousine") && TicketClass.equals("Standard"))
            return 130.0;
        else if (VehicleType.equals("Limousine") && TicketClass.equals("Premium"))
            return 160.0;
        return -1;}

    public double getTicketPrice() {
        return TicketPrice;
    }

    public String getTicketClass() {
        return TicketClass;
    }

    public String getVehicleType() {
        return VehicleType;
    }
}
