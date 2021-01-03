package repositoriy;

import entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();
    Optional<User>getById(int userId);
    User save(User user);
}
