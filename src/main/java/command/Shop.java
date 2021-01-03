package command;

import static command.ActionType.ADD_GOODS_TO_CART_ACTION;
import static command.ActionType.GOODS_CATALOG_ACTION;

public class Shop{
     ActionFactory actionFactory = new ActionFactory();

    public ActionType getType(ExpressionContext ec)  {
        final String nameAction = (String) ec.getReq().getAttribute("nameAction");
        if("addGoodsToCartAction".equals(nameAction)) {
            return ADD_GOODS_TO_CART_ACTION;
        }
        if("goodsCatalogAction".equals(nameAction)) {
            return GOODS_CATALOG_ACTION;
        }
        return GOODS_CATALOG_ACTION;
    }
    public Action choiceAction(ActionType type)  {
        return actionFactory.createAction(type);
     }
}
