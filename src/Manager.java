import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Manager extends User {
    
  private String ManagerName;
  private String PhoneNumber;
  private String City;
  Passenger passenger;
  Driver driver;
  Vehicle cars;


  public Manager(String managerName, String PhoneNumber, String city) {
    this.ManagerName = managerName;
    this.PhoneNumber = PhoneNumber;
    this.City = city;
  }

  public boolean addTrip(TripDetails tripDetails) { //This methos allows manager to add trips so that any passenge can book it untill its capacity is full
    if (tripDetails == null) {
      System.out.println("Error: Invalid trip details provided.");
      return false;
    }
    TripBroadcaster.addTrip(tripDetails);

    System.out.println("Trip added successfully.");
    return true;
  }

public boolean cancelTrip(TripDetails tripDetails) { //This methos allows manager to add trips so that any passenge can book it untill its capacity is full
    if (tripDetails == null) {
      System.out.println("Error: Invalid trip details provided.");
      return false;
    }
    TripBroadcaster.cancelTrip(tripDetails);

    System.out.println("Trip added successfully.");
    return true;
  }

public void generateReport() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<User> drivers =  new ArrayList<>();
        ArrayList<TripDetails> trips =  new ArrayList<>();

        System.out.println("====================================================");
        System.out.println("               Trip Management Report               ");
        System.out.println("====================================================");

        // Report section 1: Vehicles
        System.out.println("\n** Vehicles:**");
        if (vehicles.isEmpty()) {
            System.out.println("  No vehicles found.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println("  - Plate Number: " + vehicle.getLicensePlate());
                System.out.println("    - Capacity: " + vehicle.getCapacity());
                System.out.println(); // Add a line break between vehicles
            }
        }
        System.out.println("\n** Drivers (Employees):");
        if (drivers.isEmpty()) {
            System.out.println("  No drivers found.");
        } else {
            for (User driver : drivers) {
                System.out.println("  - Name: " + driver.getName());
                System.out.println("    - Employee ID: " + driver.getID());
                System.out.println(); // Add a line break between drivers
            }
        }
        System.out.println("\n** Trips:**");
        if (trips.isEmpty()) {
            System.out.println("  No trips found.");
        } else {
            for (TripDetails trip : trips) {
                System.out.println("  - Driver Name: " + trip.getDriverName());
                System.out.println("  - Car Plate: " + trip.getCarPlate());
                System.out.println("  - Destination: " + trip.getDestination());
                System.out.println("  - Departure Time: " + trip.getTime());
                System.out.println("  - Departure Date: " + trip.getDate());
                System.out.println("  - Available Seats: " + trip.getAvailableSeats());
                System.out.println(); 
            }
        }

        System.out.println("====================================================");
    }
    public void displayManagerProfile() {
        System.out.println("=============================================");
        System.out.println("               Manager Profile                ");
        System.out.println("=============================================");
        System.out.println("  - Name: " + Name);
        System.out.println("  - Phone Number: " + PhoneNumber);
        System.out.println("  - City: " + City);
        System.out.println("=============================================");
    }
    
    public void saveToFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(Name + "\n");
        writer.write(PhoneNumber + "\n");
        writer.write(City + "\n");
        writer.close();
        System.out.println("Manager information saved to file: " + filename);
    }

    public static Manager readFromFile(String filename) throws IOException {
        FileReader reader = new FileReader("Mnagerinfo.txt");
        Scanner scanner = new Scanner(reader);
        String name = scanner.nextLine();
        String phone = scanner.nextLine();
        String city = scanner.nextLine();
        scanner.close();
        return new Manager(name, phone, city);
    }
}

   
