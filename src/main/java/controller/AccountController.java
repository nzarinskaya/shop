package controller;

import command.GeneralCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class AccountController {
    public GeneralCommand getCommand(HttpServletRequest req) {
        String commandName = Optional.ofNullable(req.getParameter("command")).orElse("GoodsCatalog");

        return createCommand(commandName);
    }

    public static final String getView(HttpServletRequest req) {
        return "/jsp/account.jsp";
    }
    private GeneralCommand createCommand(String command) {
        try {
            Class<?> commandClass = Class.forName(String.format("command.%sCommand", command));

            return commandClass.asSubclass(GeneralCommand.class).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

