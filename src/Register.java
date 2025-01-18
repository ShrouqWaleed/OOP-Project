import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

    public class Register{
        protected static String name,password,phoneNumber,email,address;
        private final ArrayList<String> isNameExist = new ArrayList<>();
        private final ArrayList<String> isEmailExist = new ArrayList<>();
        private static int check;
        public Register() {
            isNameExist.add(0,"name");
            isEmailExist.add(0,"Email");

        }
        public Register(int check){
            Scanner sc = new Scanner(System.in);
            if (!(check == 1 || check == 2 || check ==3)){
                System.out.println("Enter your choice again");
                check = sc.nextInt();
            }
            Register.check = check;
            intro();
        }
        public static void intro(){
            System.out.println("Welcome to our company! sign up here");
            Username();
        }
        public static void Username(){
            Scanner sc = new Scanner(System.in);
            Register solve = new Register();
            System.out.print("-Please enter your preferred username here:");
            name = sc.nextLine();
            System.out.println();
            if (checkName(name)){
                System.out.println("Sorry, this username already exists, try another one");
                Username();
            }else {
                solve.isNameExist.add(name);
                System.out.println("Great! now to next step");
                Email();
            }
        }
        public static void Email(){
            Scanner sc = new Scanner(System.in);
            Register solve = new Register();
            System.out.print("-Please enter your email here:");
            email = sc.nextLine().toLowerCase();
            System.out.println();
            if (checkEmail(email)){
                System.out.println("Sorry,this email already exists, try another one");
                Email();
            }else {
                solve.isEmailExist.add(email);
                System.out.println("Next is password!");
                Password();
            }
        }
        public static void Password(){
            Scanner sc = new Scanner(System.in);
            System.out.println("-Please Enter your password here:");
            System.out.println("make sure your password has at least 6 characters, a capital letter, and a number");
            password = sc.nextLine();
            System.out.println();
            checkPassword(password);
            System.out.println("Almost there!");
            PhoneNumber();
        }
        public static void PhoneNumber(){
            Scanner sc = new Scanner(System.in);
            System.out.print("-Enter your phone number here: +20 ");
            phoneNumber = sc.nextLine();
            System.out.println();
            checkPhoneNumber(phoneNumber);
            System.out.print("Now, ");
            Address();

        }
        public static void Address(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your address");
            address = sc.nextLine();
            System.out.println();
            Check();
        }
        public static boolean checkName(String name){
            Register solve = new Register();
            return solve.isNameExist.contains(name);
        }
        public static boolean checkEmail(String email){
            Register solve = new Register();
            return solve.isEmailExist.contains(email);
        }

        public static void checkPassword(String password){
            while (!(password.length()>=6)){
                System.out.println("your password is less than 6-character long");
                Password();
            }
        }
        public static void checkPhoneNumber(String phoneNumber){
            while (!(phoneNumber.length()==10)){
                System.out.println("phone number should have 10 numbers");
                PhoneNumber();
            }
        }
        public static void Check(){
            switch (check){
                case 1: // user
                    SaveIntoFile1(name,email,password,address,phoneNumber);
                    break;
                case 2: //manager
                    SaveIntoFile2(name,email,password,address,phoneNumber);
                    break;
                case 3:// drivers
                    DriverRegestration.VehicleType();
                    break;
            }
        }

        public static void SaveIntoFile1(String name,String email,String password,String address,String phoneNumber){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt",true));
                writer.write(name+":"+email+":"+password+":"+address+":"+"+20"+phoneNumber+"\n");
                System.out.println("you have registered successfully!");
                writer.close();
            }catch (IOException e){
                System.out.println("Invalid");
            }
        }
        public static void SaveIntoFile2(String name,String email,String password,String address,String phoneNumber){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Managers.txt",true));
                writer.write(name+":"+email+":"+password+":"+address+":"+"+20"+phoneNumber+"\n");
                System.out.println("you have registered successfully!");
                writer.close();
            }catch (IOException e){
                System.out.println("Invalid");
            }
        }

        @Override
        public String toString() {
            return "Register{" +
                    "isNameExist=" + isNameExist +
                    ", isEmailExist=" + isEmailExist +
                    '}';
        }
    }

