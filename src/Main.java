import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        Tickets ticket2=new Tickets("Basic","Limousine");
        Tickets ticket1=new Tickets("Premium","Limousine");
        ExternalTrip trip2=new ExternalTrip ("Osama","shd69","CAIRO",LocalTime.NOON,LocalDate.of(2024,9,3),ticket2);
Manager manger1=new Manager("Ajmed","345678","dsfs");
        Vehicle vehicle1=new Vehicle("Limousine","asjkdg68");
      InternalTrip trip1 = new InternalTrip("Mohamed", "sdajh5", "BAB SHARQ ABO QEEIR", LocalTime.NOON, LocalDate.of(2024, 12, 2), ticket1);
    

        Driver driver1 = new Driver("Mohamed","01155524719", trip1, vehicle1);  // Pass trip1 to the constructor


       // Driver driver1=new Driver("Mohamed","01155524719",trip1,vehicle1);
        Passenger passenger1=new Passenger("Ahmed","01155524719","Alex",40,"Female",driver1);
Passenger passenger2=new Passenger("Ali","98765465","Alex",20,"Male",driver1);



//       passeng er1.bookTrip(trip1);
//        passenger1.bookTrip(trip2);
//        passenger1.bookTicket(ticket1);
//      passenger1.bookTicket(ticket2);
//        passenger1.cancelTicket(ticket2);
       // System.out.println(passenger1.displayProfile());
//        try {
//            passenger1.makePayment("Visa");
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//     passenger1.bookTrip(trip1);
//        vehicle1.setType("bus");
//    driver1.addVehicle(vehicle1);
//      //  System.out.println(passenger1.displayUpcomingTrips());
////passenger1.makePayment();
//       driver1.displayAssignedTrips();
//        driver1.displayDriverProfile();
//        System.out.println(trip1.getPassengerDetails());
//      //  System.out.println(trip1.getListOfPassengers());
//     //   System.out.println(driver1.cancelTrip("sdajh5","Cairo",LocalTime.NOON,LocalDate.of(2024,12,2)));
       // driver1.assignTrip(trip1);
//        passenger1.bookTrip(trip1);
//       passenger1.bookTrip(trip2);
//passenger1.bookTicket(ticket1);
//passenger1.bookTicket(ticket2);
//vehicle1.setType("limousine");
////driver1.addVehicle(vehicle1);
//      //  driver1.assignTrip(trip1);
////driver1.displayDriverProfile();
//      //  System.out.println(trip1.getListOfPassengers()) <------
//
//       // System.out.println( passenger1.displayProfile());
//      //  driver1.displayDriverProfile();
//        //driver1.CancelTripDriver(trip1);
////TripDetails trip1=new TripDetails("Mohamed","sdajh5","Cairo",LocalTime.NOON,LocalDate.of(2024,12,2),400.0,ticket1);
//
//
//     //   System.out.println( driver1.getDriverName());
//    //    System.out.println(trip1.getDriverName());
////        System.out.println( passenger1.displayProfile());
//    //   driver1.cancelTripDriver( trip1);
////        System.out.println( passenger1.displayUpcomingTrips());
////        driver1.displayDriverProfile();
////driver1.addTripForPassenger(input,passenger1,ticket1);
////        driver1.displayDriverProfile();
// //  passenger1.applyFirstTripDiscount(660);
////passenger1.makePayment();
////passenger1.provideFeedback(trip2);
////passenger2.provideFeedback(trip1);
//        
//      //  System.out.println();
//trip1.bookTrip(passenger1);
//manger1.addTrip(trip1);
//passenger1.displayAndBookTrips();
//manger1.generateReport();


    }

}