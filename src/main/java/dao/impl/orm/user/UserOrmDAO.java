package dao.impl.orm.user;

import dao.impl.orm.ORMAbstractDAO;
import dao.user.UserDAO;
import entity.user.UserEntity;

public class UserOrmDAO extends ORMAbstractDAO<UserEntity> implements UserDAO {

    @Override
    protected String getAllQuery() {
        return "FROM UserEntity";
    }

    @Override
    protected Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }
}
