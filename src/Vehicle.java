public class Vehicle {
    protected static String type,licensePlate;
    protected static int capacity;
    public Vehicle(String type,String licensePlate){
        Vehicle.type = type;
        Vehicle.licensePlate= licensePlate;
    }

    public static void setCapacity(int capacity) {
        Vehicle.capacity = capacity;
    }

    public static void setType(String type) {
        Vehicle.type = type;
        if (type.equalsIgnoreCase("Bus")){
            setCapacity(60);
        }else if (type.equalsIgnoreCase("MiniBus")){
            setCapacity(40);
        }else if (type.equalsIgnoreCase("Limousin")){
            setCapacity(3);
        }
    }

    public String DisplayInfo() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", liscencePlate='" + licensePlate + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public static String getType() {
        return type;
    }

    public static String getLicensePlate() {
        return licensePlate;
    }

    public static int getCapacity() {
        return capacity;
    }
    
}