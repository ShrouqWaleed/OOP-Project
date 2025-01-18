import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

//driver class , Shrouq Waleed part (23101402)


public class Driver extends User{
    private String PhoneNumber;
  private TripDetails AssignedTrips;
  private Vehicle DriverVehicle;
private Passenger passenger;
    ArrayList<TripDetails>assignedTrips=new ArrayList<>();
    ArrayList<Vehicle>DriverVehicles=new ArrayList<>();


   
public String getName(){
        return Name;
}
    public Vehicle getDriverVehicle() {
        return DriverVehicle;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public ArrayList<Vehicle> getDriverVehicles() {
        return DriverVehicles;
    }

    public Driver(String name, String phoneNumber, TripDetails assignedTrip, Vehicle vehicle) {
        super(name);
        this.PhoneNumber = phoneNumber;
        this.AssignedTrips = assignedTrip; 
        this.DriverVehicle = vehicle;
    }

    public void assignTrip(TripDetails trip) { //assign trip to the driver
    assignedTrips.add(trip);
}
  
    public void addVehicle(Vehicle vehicle) { //add vehicles
        DriverVehicles.add(vehicle);
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public String getDriverName(){
        return getName();
    }

    public void displayAssignedTrips() { //displat driver's assigned trips
        if (assignedTrips.isEmpty()) {
            System.out.println("You have no assigned trips.");
            return;
        }

        System.out.println("Your Assigned Trips:");
        for (TripDetails trip : assignedTrips) {
            System.out.println("    - Car Plate: " + trip.getCarPlate());
            System.out.println("    - Destination: " + trip.getDestination());
            System.out.println("    - Departure Time: " + trip.getTime());
            System.out.println("    - Departure Date: " + trip.getDate());
            System.out.println("    - Vehicle Type: " + trip.getCarType());
            System.out.println("    - Car Class: " + trip.getCarClass());
            System.out.println();
        }

    }


    public void displayDriverProfile() { //displays driver profile
        System.out.println("Driver Profile:");
        System.out.println("  - Name: " + getName()); // Inherit from User
        System.out.println("  - Phone Number: " + getPhoneNumber());
        System.out.println("  - ID: "+getCustomerID());
        System.out.println("");

        // **Display details of a maximum of 3 assigned trips**
        if (!assignedTrips.isEmpty()) {
            int count = 0;
            for (TripDetails trip : assignedTrips) {
                //  System.out.println("    - Car Plate: " + trip.getCarPlate());
                System.out.println("  - Assigned Trips: " + assignedTrips.size());
                System.out.println("    - Destination: " + trip.getDestination());
                System.out.println("    - Departure Time: " + trip.getTime());
                System.out.println("    - Departure Date: " + trip.getDate());
                System.out.println("    - Vehicle Type: " + trip.getCarType());
                System.out.println("    - Car Class: " + trip.getCarClass());
                System.out.println();
                count++;
                if (count == 3) {
                    break; // Terminate loop after displaying 3 trips
                }
            }
        }

        System.out.println("\n  Driver Vehicles:");
        if (!DriverVehicles.isEmpty()) {
            for (Vehicle vehicle : DriverVehicles) {
                System.out.println(vehicle.DisplayInfo()); // Use Vehicle's DisplayInfo method
                System.out.println();
            }
        } else {
            System.out.println("  No vehicles associated with this driver.");
        }}


            public void displayVehiclesSeparately() {
                System.out.println("Driver Vehicles:");
                if (!DriverVehicles.isEmpty()) {
                    for (Vehicle vehicle : DriverVehicles) {
                        System.out.println(vehicle.DisplayInfo()); 
                        System.out.println();
                    }
                } else {
                    System.out.println("  No vehicles associated with this driver.");
                }
            }

    public void cancelTripDriver(TripDetails trip) {  //driver cancel trip
        LocalDate currentDate = LocalDate.now();
        if (!assignedTrips.contains(trip)) {
            System.out.println("You can't cancel this trip. It's not assigned to you.");
            return; 
        }
        if (trip.getDate().isBefore(currentDate) ||
                (trip.getDate().isEqual(currentDate) && trip.getTime().isBefore(LocalTime.now()))) {
            System.out.println("You can't cancel this trip. It has already passed.");
            return; 
        }
        assignedTrips.remove(trip);
        if (trip.getListOfPassengers().isEmpty()) {
            System.out.println("No passengers booked for this trip. Cancelling trip.");
            return;
        }

        for (Passenger passenger : trip.getListOfPassengers()) {
            if (passenger != null) {
               if (passenger.BookedTickets != null) {
                    passenger.BookedTickets.remove(trip.getTripTicket());
                } else {
                    System.out.println("Error: Passenger " + passenger.getName() + " has no BookedTickets list."); // Assuming passenger has a name
                }
                passenger.Trips.remove(trip);
            } else {
                System.out.println("Error: Passenger information not found for a booked passenger on this trip.");
            }
        }

        System.out.println("Trip successfully cancelled.");
    }

}




