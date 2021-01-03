package service.goods.impl;

import converter.IConverter;
import converter.goods.GoodsConverter;
import dao.goods.GoodsDAO;
import dao.impl.orm.goods.GoodsOrmDAO;
import entity.goods.Goods;
import service.dto.GoodsDTO;
import service.goods.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    private GoodsDAO goodsDAO = new GoodsOrmDAO();
    private IConverter<Goods,GoodsDTO> converter = new GoodsConverter();
    @Override
    public List<GoodsDTO> getAllGoods() {
        return converter.convertAll(goodsDAO.getAll());
    }
}
