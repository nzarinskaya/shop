package servlet;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static service.UserService.userService;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/signIn.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String id = req.getParameter("id");

        Optional<User> user = userService.getUser(login,password);

        if (user.isPresent()) {
            req.getSession().setAttribute("login", user.get().getLogin());
            req.getSession().setAttribute("authorized", "true");
            resp.sendRedirect("account");
        }else {
            req.setAttribute("signIn_error","Login or password is incorrect!");
            req.getRequestDispatcher("/jsp/signIn.jsp").forward(req, resp);
        }
    }
}
