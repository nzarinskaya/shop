package command;

import model.Goods;
import repositoriy.AllGoodsRepository;
import repositoriy.GoodsRepository;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PutTheGoodsInTheCartCommand extends GeneralCommand {
    private final GoodsRepository goodsRepository = AllGoodsRepository.getInstance_();
    @Override
    @SuppressWarnings("unchecked")
    public void process(){
        long goodsId = Long.parseLong(req.getParameter("goodsId"));
        Optional<Goods> goods = goodsRepository.getById(goodsId);

        if(goods.isPresent()) {
            List<Goods> cart = Optional.ofNullable
                    ((List<Goods>) req.getSession().getAttribute("cart")).orElse(new ArrayList<>());
            cart.add(goods.get());

            req.getSession().setAttribute("cart",cart);
            req.setAttribute("allGoods",goodsRepository.getAll());
        }
    }
}
