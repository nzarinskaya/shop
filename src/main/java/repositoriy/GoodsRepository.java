package repositoriy;

import jdk.jshell.spi.ExecutionControl;
import entity.goods.Goods;

import java.util.List;
import java.util.Optional;

public interface GoodsRepository {
    List<Goods> getAll() throws ExecutionControl.NotImplementedException;
    Optional<Goods> getById(int goodsId) throws ExecutionControl.NotImplementedException;
    Goods save(Goods goods) throws ExecutionControl.NotImplementedException;

}
