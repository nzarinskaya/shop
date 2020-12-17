package command;

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

    public AddGoodsToCartAction(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super(servletRequest, servletResponse);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void process(){
        long goodsId = Long.parseLong(req.getParameter("goodsId"));
        Optional<Goods> goods = goodsRepository.getById(goodsId);

        if(goods.isPresent()) {
            List<Goods> cart = new ArrayList<>();
            cart.add(goods.get());

            req.getSession().setAttribute("cart",cart);
            req.setAttribute("allGoods",goodsRepository.getAll());
        }
    }
}
