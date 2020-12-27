package action;

import java.io.IOException;
import javax.servlet.ServletException;
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
    public void process(ExpressionContext ec) throws ExecutionControl.NotImplementedException, ServletException, IOException {
//        String nameAction = "goodsCatalogAction";
//        ec.getReq().getSession().setAttribute("nameAction",nameAction);

        ec.getReq().setAttribute("allGoods",goodsRepository.getAll());
        ec.getReq().getRequestDispatcher("/jsp/account.jsp").forward(ec.getReq(), ec.getResp());
    }
}
