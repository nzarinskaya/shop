package repositoriy;

import model.Goods;

import java.util.List;
import java.util.Optional;

public interface GoodsRepository {
    List<Goods> getAll();
    Optional<Goods> getById(long goodsId);
    Goods save(Goods goods);

}
