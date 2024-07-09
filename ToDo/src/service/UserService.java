package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<User> users = new ArrayList<>();

    public User getUserByUserName(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

}
