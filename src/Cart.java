import java.util.ArrayList;   //This class is the cart that holds all added trips and tickets for the passenger
public class Cart {
    String paymentMethod;
    ArrayList<TripDetails> cartTrips=new ArrayList<>();
    ArrayList<Tickets> cartTickets=new ArrayList<>();

    public Cart(String paymentMethod, ArrayList<TripDetails> cartTrips, ArrayList<Tickets> cartTickets) {
        this.paymentMethod = paymentMethod;
        this.cartTrips = cartTrips;
        this.cartTickets = cartTickets;
    }

    public Cart() { 
        cartTrips = new ArrayList<>();
        cartTickets = new ArrayList<>();
    }

    public void addToCart(TripDetails trip) { //add trips to the cart
        cartTrips.add(trip);
    }

    public void addToCart(Tickets ticket) { //add tickets to the cart
        cartTickets.add(ticket);
    }

    public void removeFromCart(TripDetails trip) { // remove trips from the cart
        cartTrips.remove(trip);
    }

    public void removeFromCart(Tickets ticket) { //remove tickets from the cart
        cartTickets.remove(ticket);
    }

    public double getCartTotalPrice() {  //gets cart total price for all items added in the cart
        double totalPrice = 0.0;
        for (TripDetails trip : cartTrips) {
            totalPrice += trip.getTripPrice(); // Add internal/external trip price
            totalPrice += trip.getTripTicket().TotalTicketPrice(trip.getCarType(), trip.getCarClass()); // Add ticket price based on car type and class retrieved from trip
        }
        return totalPrice;
    }

    public boolean isEmpty() { //checks if the cart is empty
        return cartTrips.isEmpty() && cartTickets.isEmpty();
    }

    public void resetCart() { //reset cart and remove all items in it
        cartTrips.clear();
        cartTickets.clear();
    }

    public String getPaymentMethod() { 
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ArrayList<TripDetails> getCartTrips() { 
        return cartTrips;
    }

    public void setCartTrips(ArrayList<TripDetails> cartTrips) {
        this.cartTrips = cartTrips; 
    }

    public ArrayList<Tickets> getCartTickets() {
        return cartTickets;
    }

    public void setCartTickets(ArrayList<Tickets> cartTickets) {
        this.cartTickets = cartTickets;
    }

    // Additional methods

    public int getTotalTripCount() {
        return cartTrips.size();
    }

    public int getTotalTicketCount() {
        return cartTickets.size();
    }

    public String viewCartDetails() {
        StringBuilder cartDetails = new StringBuilder();
        if (isEmpty()) {
            cartDetails.append("Your cart is empty.\n");
        } else {
            cartDetails.append("**Trips:**\n");
            if (!cartTrips.isEmpty()) {
                for (TripDetails trip : cartTrips) {
                    cartDetails.append(trip.toString() + "\n"); // Use toString() from TripDetails class
                }
            } else {
                cartDetails.append("No trips in cart.\n");
            }

            cartDetails.append("**Tickets:**\n");
            if (!cartTickets.isEmpty()) {
                for (Tickets ticket : cartTickets) {
                    cartDetails.append(ticket.toString() + "\n"); // Use toString() from Tickets class
                }
            } else {
                cartDetails.append("No tickets in cart.\n");
            }
            cartDetails.append("**Total Price:** " + getCartTotalPrice() + "\n");
        }
        return cartDetails.toString();
    }
}
