package service;

import model.User;
import org.junit.Test;
import repositoriy.AllUsersRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class UserServiceTest {
    private AllUsersRepository allUsersRepositoryMock = mock(AllUsersRepository.class);
    private UserService testSubject = new UserService(allUsersRepositoryMock);

    @Test
    public void getUser(){
        String login = "test_login";
        String password = "test_password";

        given(allUsersRepositoryMock.getAll()).willReturn(List.of(new User(login,password,1)));

        Optional<User> user = testSubject.getUser(login,password);
        assertTrue(user.isPresent());
    }
    @Test
    public void getUserNotFound(){
        String login = "test_login";
        String password = "test_password";

        given(allUsersRepositoryMock.getAll()).willReturn(List.of(new User("not_that_login","not_that_password",1)));

        Optional<User> user = testSubject.getUser(login, password);
        assertTrue(user.isEmpty());
    }
}
