package command;

import javax.servlet.http.HttpServletRequest;

public class Shop {
    private final ActionFactory actionFactory;

    public Shop(ActionFactory actionFactory) {
        this.actionFactory = actionFactory;
    }
    ExpressionContext ex;
     public Action choiceAction(ActionType type){
        Action action = actionFactory.createAction(type);
        action.process(ex);
        return action;
     }
}
