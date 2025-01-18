
import java.util.ArrayList;
public class TripBroadcaster {
     private static ArrayList<TripDetails> availableTrips = new ArrayList<>();

  public static void addTrip(TripDetails trip) {
    availableTrips.add(trip);
  }

  public static ArrayList<TripDetails> getAvailableTrips() {
    return new ArrayList<>(availableTrips);
  }
   public static void cancelTrip(TripDetails trip) {
    availableTrips.remove(trip);
  }
    
}
