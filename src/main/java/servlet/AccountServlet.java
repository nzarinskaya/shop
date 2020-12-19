package servlet;
import command.Action;
import command.ActionType;
import command.ExpressionContext;
import command.Shop;
import jdk.jshell.spi.ExecutionControl;
import repositoriy.AllGoodsRepository;
import repositoriy.GoodsRepository;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static command.ActionType.ADD_GOODS_TO_CART_ACTION;
import static command.ActionType.GOODS_CATALOG_ACTION;


@WebServlet("/shop/account")
public class AccountServlet extends HttpServlet {
    private final Shop shop = new Shop();
    private final GoodsRepository goodsRepository = AllGoodsRepository.getInstance_();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("allGoods",goodsRepository.getAll());

        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }

        ExpressionContext ec = new ExpressionContext(req,resp);

            Action action = shop.choiceAction(shop.getType(ec));


        try {
            action.process(ec);
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/jsp/account.jsp").forward(req,resp);
    }
}
