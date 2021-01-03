package dao.impl.orm.user;

import dao.impl.orm.ORMAbstractDAO;
import dao.user.UserDAO;
import entity.user.User;

public class UserOrmDAO extends ORMAbstractDAO<User> implements UserDAO {

    @Override
    protected String getAllQuery() {
        return "FROM User";
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
