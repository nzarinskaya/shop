package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExpressionContext {
    private HttpServletRequest req;
    private HttpServletResponse resp;

    public ExpressionContext(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        this.req = servletRequest;
        this.resp = servletResponse;
    }

    public HttpServletRequest getReq() {
        return req;
    }

    public HttpServletResponse getResp() {
        return resp;
    }
}
