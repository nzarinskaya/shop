package dao.impl.orm.goods;

import dao.goods.GoodsDAO;
import dao.impl.orm.ORMAbstractDAO;
import entity.goods.GoodsEntity;

public class GoodsOrmDAO extends ORMAbstractDAO<GoodsEntity> implements GoodsDAO {
@Override
protected String getAllQuery() {
        return "FROM GoodsEntity";
        }

@Override
protected Class<GoodsEntity> getEntityClass() {
        return GoodsEntity.class;
    }
}
