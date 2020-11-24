package by.epam.web.data.repository;

import by.epam.web.data.entity.User;

import java.util.ArrayList;
import java.util.List;
//todo
public class UserRepository implements Repository {
    private static UserRepository INSTANCE;
    private List<User> users;

    private UserRepository() {
        this.users = new ArrayList<>();
    }
    public static UserRepository getInstance(){
        if (INSTANCE==null){
            INSTANCE = new UserRepository();
            return INSTANCE;
        }
        return INSTANCE;

    }
    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public boolean isUsernameExist(String username) {
        for (User user:users) {
            if (user.getUsername().equals(username)){
                return true;
            }
        };
        return false;
    }

    @Override
    public int size() {
        return users.size();
    }

    @Override
    public User getUserByUsername(String username) {
        for (User user:users) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
}
