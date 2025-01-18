import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Passenger {

    private String Name;
    private String PhoneNumber;
    private String City;
    private int Age;
    private String Gender;
    // Optional field
    ArrayList<TripDetails> Trips;
     ArrayList<Tickets> BookedTickets;
     ArrayList<Tickets> CancelledTickets;
    private Cart cart = new Cart();
    private Tickets ticket;
    private Driver driver;

    public Passenger(String name, String phoneNumber, String city, int age, String gender, Driver driver) {
        this.Name = name;
        this.PhoneNumber = phoneNumber;
        this.City = city;
        this.Age = age;
        this.Gender = gender;
        this.driver = driver;
        cart = new Cart();
        Trips = new ArrayList<>();
        BookedTickets = new ArrayList<>();  }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getCity() {
        return City;
    }

    public int getAge() {
        return Age;
    }

    public String getGender() {
        return Gender;
    }
Scanner input=new Scanner(System.in);
    public String displayProfile(){
    return "Your Profile:"+"\n"+"Name:"+getName()+"\n"+"Phone Number:"+getPhoneNumber()+"\n"+"City:"+getCity()+"\n"+"Age:"+getAge()+"\n"+"Gender:"+getGender();}


    public void bookTrip(TripDetails selectedTrip) {
        if (cart != null) {
            cart.addToCart(selectedTrip);
        } else {
            System.out.println("Error adding trip to cart.");
        }

        if (Trips != null) {
            Trips.add(selectedTrip);
        } else {
            System.out.println("Error adding trip to passenger's list.");
        }
        if (selectedTrip.getListOfPassengers() != null) {
            selectedTrip.getListOfPassengers().add(this); 
        } else {
            System.out.println("Error adding passenger to trip.");
        }

        if (driver != null) {
            if (driver.getDriverName().equals(selectedTrip.getDriverName())) {
                driver.assignedTrips.add(selectedTrip); 
            } else {
                System.out.println("This trip is not assigned to the retrieved driver.");
            }
        } else {
            System.out.println("Error assigning trip to driver.");
        }
    }


    public void bookTicket(Tickets ticket) {
        if (ticket != null) {
            BookedTickets.add(ticket);
            cart.cartTickets.add(ticket);
        } else {
            System.out.println("Error: Trying to book a null ticket.");
        }
    }


        public void cancelTicket(Tickets ticket)  {
            if (BookedTickets != null) {
                BookedTickets.remove(ticket);
                cart.cartTickets.remove(ticket);
            } else {
                System.out.println("Error");
            }

            if (cart != null) {
                cart.removeFromCart(ticket);
            } else {
                System.out.println("Error");
            }

            if (CancelledTickets != null) {
                CancelledTickets.add(ticket);
            } else {
                System.out.println("Error");
            }
        }

    public String displayUpcomingTrips() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        String upcomingTrips = "";

        if (Trips.isEmpty()) {
            return "You have no upcoming trips.";
        }

        upcomingTrips += "Your Upcoming Trips:\n";
        for (TripDetails trip : Trips) {
            if (trip.getDate().isAfter(currentDate) ||
                    (trip.getDate().isEqual(currentDate) && trip.getTime().equals(currentTime))||trip.getDate().isEqual(currentDate)&&trip.getTime().isAfter(currentTime)) {
                // Upcoming trip based on date or same day with matching time
                upcomingTrips += "  Driver Name: " + trip.getDriverName() + "\n";
                upcomingTrips += "  Car Plate: " + trip.getCarPlate() + "\n";
                upcomingTrips += "  Destination: " + trip.getDestination() + "\n";
                upcomingTrips += "  Departure Time: " + trip.getTime() + "\n";
                upcomingTrips += "  Departure Date: " + trip.getDate() + "\n\n";
            }
        }

        return upcomingTrips.isEmpty() ? "No Upcoming Trips." : upcomingTrips;
    }
    public String displayPastTrips() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        String pastTrips = "";

        if (Trips.isEmpty()) {
            return "You have no past trips.";
        }

        pastTrips += "Your Past Trips:\n";
        for (TripDetails trip : Trips) {
            if (trip.getDate().isBefore(currentDate) ||
                    (trip.getDate().isEqual(currentDate) && trip.getTime().isBefore(currentTime))) {
                // Past trip based on date or same day with earlier time
                pastTrips += "  Driver Name: " + trip.getDriverName() + "\n";
                pastTrips += "  Car Plate: " + trip.getCarPlate() + "\n";
                pastTrips += "  Destination: " + trip.getDestination() + "\n";
                pastTrips += "  Departure Time: " + trip.getTime() + "\n";
                pastTrips += "  Departure Date: " + trip.getDate() + "\n\n";
            }
        }

        return pastTrips.isEmpty() ? "No Past Trips." : pastTrips;
    }
public void makePayment() {
    cart.viewCartDetails();
    double totalPrice = cart.getCartTotalPrice();

    System.out.printf("Your total trip cost is: " + cart.getCartTotalPrice() + "EGP\n");
    System.out.println("Payment Method (Visa/Cash): ");
    String paymentMethod = input.nextLine().toUpperCase();

    if (paymentMethod.equals("VISA")) {
      if (validateVisaInfo(input)) { // Call validation method with input object
        System.out.println("Payment Successful!");
      } else {
        System.out.println("Payment failed. Please check your Visa information.");
      }

    } else if (paymentMethod.equals("CASH")) {
      System.out.println("Cash payment selected. No further information required.");
    } else {
      System.out.println("Invalid payment method. Please choose Visa or Cash.");
    }

    System.out.println("Would you like a receipt (Yes/No)? ");
    String printReceipt = input.nextLine().toUpperCase();
    if (printReceipt.equals("YES")) {
      printReceipt(this, cart); 
    }
    if (paymentMethod.equals("VISA") && validateVisaInfo(input)) { // Check for successful validation before reset
      cart.resetCart();
    } else if (paymentMethod.equals("CASH")) {
      cart.resetCart();
    }
  }

  private boolean validateVisaInfo(Scanner input) {
    System.out.println("Enter Visa Card Number: ");
    String cardNumber = input.nextLine();
    System.out.println("Enter Expiration Date (MM/YY): ");
    String expiryDate = input.nextLine();
    System.out.println("Enter CVV: ");
    String cvv = input.nextLine();
    if (!isVisaCardNumberValid(cardNumber)) {
      System.out.println("Invalid Visa card number. Please enter a 16-digit number starting with 4.");
      return false;
    }

    if (!isExpiryDateValid(expiryDate)) {
      System.out.println("Invalid expiry date format. Please use MM/YY format.");
      return false;
    }

    if (!isCvvValid(cvv)) {
      System.out.println("Invalid CVV. Visa CVV is typically 3 or 4 digits.");
      return false;
    }

    return true;
  }

  private boolean isVisaCardNumberValid(String cardNumber) {
    if (cardNumber.length() != 16) {
      return false;
    }
    if (!cardNumber.startsWith("4")) {
      return false;
    }
    return true;
  }

  private boolean isExpiryDateValid(String expiryDate) {
    if (!expiryDate.matches("\\d{2}/\\d{2}")) {
      return false;
    }
    return true;
  }

  private boolean isCvvValid(String cvv) {
    return cvv.length() == 3 || cvv.length() == 4;
  }

   public void printReceipt(Passenger passenger, Cart cart) {
    System.out.println("==================== Receipt ====================");
    System.out.println("Passenger Name: " + passenger.getName());
    System.out.println("Passenger Phone Number: " + passenger.getPhoneNumber());
    System.out.println("Total Price: " + cart.getCartTotalPrice() + "EGP\n");
    if (cart.cartTrips.isEmpty()) {
      System.out.println("There are no trips in the cart.");
    } else {
      for (TripDetails trip : cart.cartTrips) {
        if (trip != null) { // Check if trip is not null before accessing methods
          System.out.println("  - Trip Details:");
          System.out.println("    - Driver Name: " + trip.getDriverName());
          System.out.println("    - Car Plate: " + trip.getCarPlate());
          System.out.println("    - Destination: " + trip.getDestination());
          System.out.println("    - Departure Time: " + trip.getTime());
          System.out.println("    - Departure Date: " + trip.getDate());
          System.out.println("    - Vehicle Type: " + trip.getCarType());
          System.out.println("    - Car Class: " + trip.getCarClass());
          System.out.println();
        }
      }
    }

    System.out.println("=================================================");
  
    }
    public Driver getDriver() {
        return driver;
    }
    public Passenger findPassengerForTrip(TripDetails trip) {
        if (Trips != null) {
            for (TripDetails myTrip : Trips) {
                if (myTrip.getDate().equals(trip.getDate()) &&
                        myTrip.getTime().equals(trip.getTime()) &&
                        myTrip.getDestination().equals(trip.getDestination())) {
                    return this;  }
            }
        }
        return null;
    }

    public void provideFeedback(TripDetails trip) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Rate your trip with " + trip.getDriverName() + " (1-5 stars): ");
        int rating = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter your feedback (optional): ");
        String feedback = scanner.nextLine();

        try {
            FileWriter writer = new FileWriter("feedback.txt", true);
            writer.write("Passenger: " + getName() + "\n");
            writer.write("Driver: " + trip.getDriverName() + "\n");
            writer.write("Rating: " + rating + "/5\n");
            writer.write("Feedback: " + feedback + "\n\n");
            writer.close();
            System.out.println("Feedback submitted successfully.");
        } catch (IOException e) {
            System.out.println("Error saving feedback: " + e.getMessage());
        }
    }

   public void displayAndBookTrips() {
  ArrayList<TripDetails> availableTrips = TripBroadcaster.getAvailableTrips();
  if (availableTrips.isEmpty()) {
    System.out.println("There are currently no available trips.");
    return;
  }

  System.out.println("Here are the available trips you can book:");
    

    System.out.println("Available Trips:");
    int tripCount = 1;
    for (TripDetails trip : availableTrips) {
      System.out.println("  Trip " + tripCount + ":");
      System.out.println("    - Driver Name: " + trip.getDriverName());
      System.out.println("    - Car Plate: " + trip.getCarPlate());
      System.out.println("    - Destination: " + trip.getDestination());
      System.out.println("    - Departure Time: " + trip.getTime());
      System.out.println("    - Departure Date: " + trip.getDate());
      System.out.println("    - Available Seats: " + trip.getAvailableSeats()); // Assuming availableSeats attribute in TripDetails
      System.out.println();
      tripCount++;
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of the trip you want to book (or 0 to exit): ");
    int tripChoice = Integer.parseInt(scanner.nextLine());

    if (tripChoice > 0 && tripChoice <= availableTrips.size()) {
      TripDetails selectedTrip = availableTrips.get(tripChoice - 1);
       bookTrip(selectedTrip);
    } else if (tripChoice == 0) {
      System.out.println("Exiting booking process.");
    } else {
      System.out.println("Invalid trip selection. Please choose a valid trip number.");
    }
  }
   public void viewAvailableTrips(Manager manager) {
    if (manager == null) {
      System.out.println("Error: Manager reference not set. Cannot view available trips.");
      return;
    }
   }}
    