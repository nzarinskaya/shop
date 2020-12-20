package repositoriy;

import jdk.jshell.spi.ExecutionControl;
import model.Goods;

import java.util.List;
import java.util.Optional;

public class AllGoodsRepository implements GoodsRepository  {
     private AllGoodsRepository() {
    }
    public static class AllGoodsRepositoryHolder{
        public static final AllGoodsRepository HOLDER_INSTANCE_ = new AllGoodsRepository();
    }
    public static AllGoodsRepository getInstance_(){
        return AllGoodsRepositoryHolder.HOLDER_INSTANCE_;
    }

    public static final List<Goods> allGoods = List.of(
            new Goods("Christmas tree","The height of the tree is 2,0 meters","150$",1),
            new Goods("Garlands on the tree","The length of the garland is 10,0 meters","30$",2)
    );
    @Override
    public List<Goods> getAll() throws ExecutionControl.NotImplementedException {
        return allGoods;
    }

    @Override
    public Optional<Goods> getById(long goodsId)throws ExecutionControl.NotImplementedException {
        return allGoods.stream().filter(goods -> goods.getId() == goodsId).findAny();
    }

    @Override
    public Goods save(Goods goods)throws ExecutionControl.NotImplementedException {
        return null;
    }
}
