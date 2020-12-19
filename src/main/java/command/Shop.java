package command;

import jdk.jshell.spi.ExecutionControl;
import servlet.AccountServlet;

import javax.servlet.http.HttpServletRequest;

import static command.ActionType.ADD_GOODS_TO_CART_ACTION;
import static command.ActionType.GOODS_CATALOG_ACTION;

public class Shop{
     ActionFactory actionFactory;

    public Shop(ActionFactory actionFactory) {
        this.actionFactory = actionFactory;
    }

    public Shop() {
    }
    public ActionType getType(ExpressionContext ec)  {
        if (ec.req.getParameter("nameAction").equals("addGoodsToCartAction")) {
            return GOODS_CATALOG_ACTION;
        }
        if (ec.req.getParameter("nameAction").equals("goodsCatalogAction")) {
            return ADD_GOODS_TO_CART_ACTION;
        }
        return null;
    }

    public Action choiceAction(ActionType type)  {
        Action action = actionFactory.createAction(type);
        return action;
     }
}
