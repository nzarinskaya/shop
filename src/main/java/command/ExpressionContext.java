package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExpressionContext {
    public HttpServletRequest req;
    public HttpServletResponse resp;

    public ExpressionContext(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        this.req = servletRequest;
        this.resp = servletResponse;
    }
}
