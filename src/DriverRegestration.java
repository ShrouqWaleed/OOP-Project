import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DriverRegestration extends Register{
    public DriverRegestration(){
    }
    public static void VehicleType(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-Please Enter your vehicle type:");
        Vehicle.type = sc.nextLine();
        Vehicle.setType(Vehicle.type);
        LicensePlate();
    }
    public static void LicensePlate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-Please Enter your license plate:");
        Vehicle.licensePlate = sc.nextLine();
        SaveIntoFile3(name,email,password,address,Vehicle.type,Vehicle.licensePlate,phoneNumber);
    }
    public static void SaveIntoFile3(String name,String email,String password,String address,String vehicletype,String licensePlate,String phoneNumber){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Drivers.txt",true));
            writer.write(name+":"+email+":"+password+":"+address+":"+vehicletype+":"+licensePlate+":"+"+20"+phoneNumber+"\n");
            System.out.println("you have registered successfully!");
            writer.close();
        }catch (IOException e){
            System.out.println("Invalid");
        }
    }



}