package command;

import java.io.IOException;
import javax.servlet.ServletException;
import jdk.jshell.spi.ExecutionControl;

public abstract class Action {
    String nameAction;

    public String getNameAction() {
        return nameAction;
    }

    public abstract void process(ExpressionContext ec)
        throws ExecutionControl.NotImplementedException, ServletException, IOException;

}
