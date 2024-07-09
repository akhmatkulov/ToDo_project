package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<User> users = new ArrayList<>();

    public User add(User user) {
        if (hasUser(user.getUsername())) {
            return null;
        }
        users.add(user);
        return user;
    }

    private boolean hasUser(String username) {
        for (User user : users) {
            if (user != null) {
                if (user.getUsername().equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    public User getUserByUserName(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public List<User> list() {
        return users;
    }

}
