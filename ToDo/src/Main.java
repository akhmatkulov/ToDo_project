import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int stepcode = 100;
        while (stepcode != 0){
            System.out.println("1. Register,  2. Login ");
            stepcode = scannerInt.nextInt();
            if(stepcode == 1){
                register();
            }else if(stepcode == 2){
                login();
            }
            else{
                System.out.println("Error... please try again.");
            }
        }
    }

    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);
    static List<User> users = new ArrayList<>();

    public static void register(){
        System.out.println("Enter your username: ");
        String username = scannerStr.nextLine();
        System.out.println("Enter your password: ");
        String password = scannerStr.nextLine();
        User user = new User(username, password);
        users.add(user);
        System.out.println("Registration is successful!");
    }

    public static void login(){
        System.out.println("Enter your username: ");
        String username = scannerStr.nextLine();
        System.out.println("Enter your password: ");
        String password = scannerStr.nextLine();
        System.out.println(username + "\t successfully added!");
    }
}