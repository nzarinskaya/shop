package servlet;

import command.GeneralCommand;
import controller.AccountController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    private final AccountController accountController = new AccountController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GeneralCommand command = accountController.getCommand(req);
        command.init(req,resp);
        command.process();

        String view = accountController.getView(req);
        req.getRequestDispatcher(view).forward(req,resp);
}
}
