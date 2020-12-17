package command;

import repositoriy.AllGoodsRepository;
import repositoriy.GoodsRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodsCatalogAction extends Action{
    private final GoodsRepository goodsRepository = AllGoodsRepository.getInstance_();

    public GoodsCatalogAction(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super(servletRequest, servletResponse);
    }

    public GoodsCatalogAction() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public void process(ExpressionContext ec) {
        req.setAttribute("allGoods",goodsRepository.getAll());
    }
}
