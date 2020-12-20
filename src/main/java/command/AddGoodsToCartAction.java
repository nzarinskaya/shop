package command;

import jdk.jshell.spi.ExecutionControl;
import model.Goods;
import repositoriy.AllGoodsRepository;
import repositoriy.GoodsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/add")
public class AddGoodsToCartAction extends Action {
    private final GoodsRepository goodsRepository = AllGoodsRepository.getInstance_();


    @Override
    public String getNameAction() {
        return nameAction;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void process(ExpressionContext ec) throws ExecutionControl.NotImplementedException, ServletException, IOException {
        String nameAction = "addGoodsToCartAction" ;
        ec.getReq().getSession().setAttribute("nameAction",nameAction);


        long goodsId = Long.parseLong(ec.getReq().getParameter("goodsId"));
        Optional<Goods> goods = goodsRepository.getById(goodsId);

        if(goods.isPresent()) {
            List<Goods> cart = new ArrayList<>();
            cart.add(goods.get());

            ec.getReq().getSession().setAttribute("cart",cart);
            ec.getReq().setAttribute("allGoods",goodsRepository.getAll());
            ec.getReq().getRequestDispatcher("/jsp/cart.jsp").forward(ec.getReq(), ec.getResp());
        }
    }
}
