package service.user.impl;

import dao.impl.orm.user.UserOrmDAO;
import dao.user.UserDAO;
import entity.user.User;
import service.user.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserOrmDAO();

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }
}
