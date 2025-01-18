import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TripDetails {
    String DriverName;
    String CarPlate;
    String Destination;
    LocalTime Time;
    LocalDate Date;
    double TripPrice;
    Tickets TripTicket;
    //double price;
    private Passenger passenger;
    private ExternalTrip externalTrip;
    private InternalTrip internalTrip;
    
  private int totalCapacity ; 
  private int availableSeats; 


    ArrayList<Passenger> ListOfPassengers = new ArrayList<>();


   public TripDetails(String driverName, String carPlate, String destination, LocalTime time, LocalDate date, double tripPrice, Tickets tripTicket){
        this.DriverName = driverName;
        this.CarPlate = carPlate;
        this.Destination = destination;
        this.Time = time;
        this.Date = date;
        this.TripPrice = tripPrice;
        this.TripTicket = tripTicket;
          this.totalCapacity = getCapacityFromTicket(tripTicket);
  this.availableSeats = totalCapacity;
    }


    public Tickets getTripTicket() {
        return TripTicket;
    }

    public ArrayList<Passenger> getListOfPassengers() {
        return ListOfPassengers; 
    }

    public String getDriverName() {
        return DriverName;
    }

    public String getCarPlate() {
        return CarPlate;
    }

    public String getDestination() {
        return Destination;
    }

    public LocalTime getTime() {
        return Time;
    }

    public LocalDate getDate() {
        return Date;
    }
      public double getTripPrice() {
   
    if (this instanceof InternalTrip) {
      return ((InternalTrip) this).calculatePrice(getDestination()); 
    } else if (this instanceof ExternalTrip) {
      return ((ExternalTrip) this).calculatePrice(getDestination()); 
    } else {
      System.out.println("Warning: Unknown trip type. Using default price of 0 EGP.");
      return 0; 
    }
  }

    public String getCarType() {
        return TripTicket.getVehicleType();
    }

    public String getCarClass() {
        return TripTicket.getTicketClass();
    }

    public String getPassengerDetails() {
        if (ListOfPassengers != null && !ListOfPassengers.isEmpty()) {
            Passenger passenger = ListOfPassengers.get(0); 
            return "Passenger Name: " + passenger.getName() + "\n" +
                    "Phone Number: " + passenger.getPhoneNumber(); 
        } else {
            return "No passenger found for this trip.";
        }
    }


    public int getCapacity() {
        String vehicleType = getCarType(); 
        switch (vehicleType.toUpperCase()) {
            case "BUS":
                return 60;
            case "MINI BUS":
                return 40;
            case "LIMOUSINE":
                return 3;
            default:
                System.out.println("Warning: Unknown vehicle type in ticket. Using default capacity of 10.");
                return 10; 
        }
    }
    public void setTripPrice(double tripPrice) {
        TripPrice = tripPrice;
    }
    public int getAvailableSeats() {
    return availableSeats;
  }
  public boolean isBookable() {
    return availableSeats > 0;
  }

  public void bookTrip(Passenger passenger) {
    if (isBookable()) {
      ListOfPassengers.add(passenger);
      availableSeats--;
      System.out.println("Trip booked successfully! Remaining seats: " + availableSeats);
    } else {
      System.out.println("Sorry, there are no available seats for this trip.");
    }
  }
  private int getCapacityFromTicket(Tickets ticket) {
  String vehicleType = ticket.getVehicleType();
  switch (vehicleType.toUpperCase()) {
    case "BUS":
      return 60;
    case "MINI BUS":
      return 40;
    case "LIMOUSINE":
      return 3;
    default:
      System.out.println("Warning: Unknown vehicle type in ticket. Using default capacity of 10.");
      return 10;
  }
  }}

