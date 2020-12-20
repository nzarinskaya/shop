package servlet;

import model.User;
import repositoriy.AllUsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        List<User> allUsers = AllUsersRepository.getInstance().getAll();
        Optional<User> users = allUsers.stream().filter(u -> u.getLogin().equals(login)).findAny();

        if (users.isPresent()) {
            req.setAttribute("equal_login_error", "This login exists already!");
            req.getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);
        } else {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);

            AllUsersRepository.getInstance().save(user);
            resp.sendRedirect("/shop/signIn");
        }
    }
}
