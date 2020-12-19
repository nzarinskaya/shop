package command;

import jdk.jshell.spi.ExecutionControl;
import repositoriy.AllGoodsRepository;
import repositoriy.GoodsRepository;


public class GoodsCatalogAction extends Action{
    private final GoodsRepository goodsRepository = AllGoodsRepository.getInstance_();
    String nameAction;

    @Override
    public String getNameAction() {
        return nameAction;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void process(ExpressionContext ec) throws ExecutionControl.NotImplementedException {
        String nameAction = "goodsCatalogAction";
        ec.req.getSession().setAttribute("nameAction",nameAction);

        ec.req.setAttribute("allGoods",goodsRepository.getAll());
    }
}
