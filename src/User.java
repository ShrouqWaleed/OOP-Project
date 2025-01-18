import java.util.UUID;

public class User {

     String Name;
   UUID ID=UUID.randomUUID();
private final String CustomerID;

    public User() {
        CustomerID = ID.toString();
    }

    public User(String name) {
        this.Name = name;
        CustomerID = ID.toString();
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public String getName() {
        return Name;
    }

    public UUID getID() {
        return ID;
    }
}
