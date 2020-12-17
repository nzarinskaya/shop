package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExpressionContext {
    protected HttpServletRequest req;
    protected HttpServletResponse resp;

    public ExpressionContext(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        this.req = servletRequest;
        this.resp = servletResponse;
    }
}
