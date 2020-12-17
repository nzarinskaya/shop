package service;

import model.User;
import repositoriy.AllUsersRepository;
import java.util.List;
import java.util.Optional;

public class UserService {

    public static UserService userService = new UserService();
    public AllUsersRepository allUsersRepository = AllUsersRepository.getInstance();

    public UserService(AllUsersRepository allUsersRepository) {
        this.allUsersRepository = allUsersRepository;
    }

    public UserService() {
    }
    public Optional<User> getUser(String login,String password){
        List<User> allUsers = allUsersRepository.getAll();
        return allUsers.stream().filter(u ->u.getLogin().equals(login)&&u.getPassword().equals(password)).findAny();
    }
}
