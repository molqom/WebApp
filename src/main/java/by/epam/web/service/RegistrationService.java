package by.epam.web.service;

import by.epam.web.data.entity.Role;
import by.epam.web.data.entity.User;
import by.epam.web.data.repository.UserRepository;

public class RegistrationService {
    public boolean registration(String username, String password, String repeatPassword){

        UserRepository repository = UserRepository.getInstance();

        if(!password.equals(repeatPassword)){
            return false;
        }
        else if (repository.isUsernameExist(username)){
            return false;
        }
        else {
            User user = new User(repository.size(), username, password, Role.USER);
            repository.add(user);
            return true;
        }
    }
}
