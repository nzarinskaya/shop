package command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

public abstract class Action {
    protected HttpServletRequest req;
    protected HttpServletResponse resp;

    public Action(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        this.req = servletRequest;
        this.resp = servletResponse;

    }

    public Action() {
    }

    public abstract void process(ExpressionContext ec);
}
