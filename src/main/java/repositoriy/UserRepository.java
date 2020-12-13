package repositoriy;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();
    Optional<User>getById(long userId);
    User save(User user);
}
