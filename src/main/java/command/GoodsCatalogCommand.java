package command;

import repositoriy.AllGoodsRepository;
import repositoriy.GoodsRepository;

import javax.servlet.ServletException;
import java.io.IOException;

public class GoodsCatalogCommand extends GeneralCommand{
    private final GoodsRepository goodsRepository = AllGoodsRepository.getInstance_();
    @Override
    @SuppressWarnings("unchecked")
    public void process() {
        req.setAttribute("allGoods",goodsRepository.getAll());
    }
}
