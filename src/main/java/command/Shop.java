package command;

public class Shop {
    private final ActionFactory actionFactory;

    public Shop(ActionFactory actionFactory) {
        this.actionFactory = actionFactory;
    }
     public Action choiceAction(ActionType type){
        Action action = actionFactory.createAction(type);
        action.process();
        return action;
     }
}
