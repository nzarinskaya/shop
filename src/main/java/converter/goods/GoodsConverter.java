package converter.goods;

import converter.AbstractConverter;
import entity.goods.Goods;
import service.dto.GoodsDTO;

public class GoodsConverter extends AbstractConverter<Goods, GoodsDTO> {
    @Override
    public GoodsDTO convert(Goods goods) {
        return new GoodsDTO(goods.getId(),goods.getName(),goods.getDescription(),goods.getPrice());
    }
}
