import model.ToDo;
import model.User;
import service.ToDoService;
import service.UserService;

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
    static UserService userService = new UserService();
    static ToDoService toDoService = new ToDoService();

    private static void register(){
        System.out.print("Enter your username: ");
        String username = scannerStr.nextLine();
        System.out.print("Enter your password: ");
        String password = scannerStr.nextLine();
        User user = new User(username, password);
        userService.add(user);
        System.out.println("Registration is successful!");
    }

    private static void login(){
        System.out.println("Enter your username: ");
        String username = scannerStr.nextLine();
        System.out.println("Enter your password: ");
        String password = scannerStr.nextLine();
        User user = userService.login(username, password);
        if (user != null) {
            int stepCode = 10;
            while (stepCode != 0) {
                System.out.println("1. Add Todo,  2. Complete Todo,  3. List ToDos,  4. Other's ToDos.");
                stepCode = scannerInt.nextInt();
                if (stepCode == 1) {
                    addToDo(user);
                } else if (stepCode == 2) {
                    completeToDo(user);
                } else if (stepCode == 3) {
                    listTodos(user);
                } else if (stepCode == 4) {
                    othersToDos();
                }
            }
        } else {
            System.out.println("Your password or username is false.");
        }
    }

    private static void addToDo(User user) {
        System.out.print("Enter Todo: ");
        String toDo = scannerStr.nextLine();
        toDoService.add(new ToDo(user.getId(), toDo));
        System.out.println("ToDo is successfully added.");
    }

    private static void completeToDo(User user) {
        List<ToDo> toDoList = toDoService.getTodoByUserId(user.getId());
        int count = listTodos(user);
        if (count != 0) {
            int n = scannerInt.nextInt();
            toDoService.complete(toDoList.get(n - 1).getId());
            System.out.println("Operation is successful.");
        } else {
            System.out.println("Todos are not exist.");
        }
    }

    private static int listTodos(User user) {
        List<ToDo> toDoList = toDoService.getTodoByUserId(user.getId());
        int count = 0;
        for (ToDo toDo: toDoList) {
            System.out.println(count + 1 + ". " + toDo.getName() + "\t" + (toDo.isComplete() ? "Completed" : "Uncompleted"));
            count++;
        }
        return count;
    }

    private static void othersToDos() {
        System.out.print("Enter username: ");
        String username = scannerStr.nextLine();
        User user  = userService.getUserByUserName(username);
        int count = listTodos(user);
        if (count == 0) {
            System.out.println("ToDos are not exist.");
        }
    }

}