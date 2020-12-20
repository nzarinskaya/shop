package repositoriy;

import jdk.jshell.spi.ExecutionControl;
import model.Goods;

import java.util.List;
import java.util.Optional;

public interface GoodsRepository {
    List<Goods> getAll() throws ExecutionControl.NotImplementedException;
    Optional<Goods> getById(long goodsId) throws ExecutionControl.NotImplementedException;
    Goods save(Goods goods) throws ExecutionControl.NotImplementedException;

}
