package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<User> users = new ArrayList<>();

    public void add(User user) {
        if (!has(user)) {
            users.add(user);
        }
    }

    public boolean has(User user) {
        for (User user1: users) {
            if (user1.getUsername().equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public User login(String username, String password) {
        User user = getUserByUserName(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByUserName(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

}
