package command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

public abstract class GeneralCommand {
    protected HttpServletRequest req;
    protected HttpServletResponse resp;

    public void init(HttpServletRequest servletRequest,HttpServletResponse servletResponse){
        this.req = servletRequest;
        this.resp = servletResponse;
    }
    public abstract void process() throws ServletException, IOException;
}
