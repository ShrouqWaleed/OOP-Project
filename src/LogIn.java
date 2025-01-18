
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LogIn {
    private static String name,password,email;
    private static int check;
    public LogIn(int check){
        Scanner sc = new Scanner(System.in);
        if (!(check == 1 || check == 2 || check ==3)){
            System.out.println("Enter your choice again");
            check = sc.nextInt();
        }
        LogIn.check = check;
        Intro();
    }
    public static void Intro(){
        System.out.println("Welcome again!\n");
        System.out.println("Would you like to login with:");
        Choice();
    }
    public static void Choice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1)Username?\n2)Email?");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                Username();
                break;
            case 2:
                Email();
                break;
            default:
                System.out.println("Invalid, please try again");
        }
    }
    public static void Username(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username");
        name = sc.nextLine();
        System.out.println();
        Password();
    }
    public static void Email(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your Email");
        email = sc.nextLine();
        System.out.println();
        Password();
    }
    public static void Password(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter password");
        password = sc.nextLine();
        System.out.println();
        Check();
    }
    public static void Check(){
        switch (check){
            case 1://user
                isInfoCorrect1();
                break;
            case 2: //manger
                isInfoCorrect2();
                break;
            case 3: // drivers
                isInfoCorrect3();
                break;
        }
    }
    public static void isInfoCorrect1(){
        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("Users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] split2 = line.split(":");
                if ((split2[0].equals(name) || split2[1].equalsIgnoreCase(email)) && split2[2].equals(password)){
                    found = true;
                    System.out.println("Successfully logged in!");
                    break;
                }
            }
            if (!found){
                System.out.println("Incorrect Username or password!");
                System.out.println();
                Choice();
            }
        } catch (IOException ex) {
            System.out.println("Error!");
        }
    }
    public static void isInfoCorrect2(){
        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("Managers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] split2 = line.split(":");
                if ((split2[0].equals(name) || split2[1].equalsIgnoreCase(email)) && split2[2].equals(password)){
                    found = true;
                    System.out.println("Successfully logged in!");
                    break;
                }
            }
            if (!found){
                System.out.println("Incorrect Username or password!");
                System.out.println();
                Choice();
            }
        } catch (IOException ex) {
            System.out.println("Error!");
        }
    }
    public static void isInfoCorrect3(){
        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("Drivers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] split2 = line.split(":");
                if ((split2[0].equals(name) || split2[1].equalsIgnoreCase(email)) && split2[2].equals(password)){
                    found = true;
                    System.out.println("Successfully logged in!");
                    break;
                }
            }
            if (!found){
                System.out.println("Incorrect Username or password!");
                System.out.println();
                Choice();
            }
        } catch (IOException ex) {
            System.out.println("Error!");
        }
    }

}