package command;

public class ActionFactory {
    public Action createAction(ActionType type){
        Action action = null;

        switch (type){
            case GOODS_CATALOG_ACTION:
                action = new GoodsCatalogAction(action.req, action.resp);
                break;
            case ADD_GOODS_TO_CART_ACTION:
                action = new AddGoodsToCartAction(action.req, action.resp);
                break;
        }
        return action;
    }
}