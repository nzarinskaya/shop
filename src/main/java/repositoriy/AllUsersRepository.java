package repositoriy;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class AllUsersRepository implements UserRepository{
    private static final List<User> users = new ArrayList<>();
    AllUsersRepository allUsersRepository = getInstance();

    private AllUsersRepository() {
    }

    public static class AllUserRepositoryHolder{
        public static final AllUsersRepository HOLDER_INSTANCE = new AllUsersRepository();
    }

    public static AllUsersRepository getInstance(){
        return AllUserRepositoryHolder.HOLDER_INSTANCE;
    }

    private AtomicLong doId = new AtomicLong(1);

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public Optional<User> getById(long userId) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        user.setId(doId.getAndIncrement());
        users.add(user);
        return user;
    }
}
