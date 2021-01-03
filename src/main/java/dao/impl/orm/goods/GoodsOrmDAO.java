package dao.impl.orm.goods;

import dao.goods.GoodsDAO;
import dao.impl.orm.ORMAbstractDAO;
import entity.goods.Goods;

public class GoodsOrmDAO extends ORMAbstractDAO<Goods> implements GoodsDAO {
    @Override
    protected String getAllQuery() {
        return "FROM Goods";
    }

    @Override
    protected Class<Goods> getEntityClass() {
        return Goods.class;
    }
}
