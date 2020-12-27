package entity.goods;

import entity.AbstractEntity;
import entity.IEntity;
import entity.user.UserEntity;

import javax.persistence.*;

@Entity
@Table(name ="goods")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class GoodsEntity extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private String price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id_fk", referencedColumnName = "id")
    private UserEntity user;

    public GoodsEntity() {
    }

    public GoodsEntity(String name, String description, String price) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public GoodsEntity(Long id,String name, String description, String price, Long timestamp) {
        super(id, timestamp);
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public Long getId() {
        return id;
    }
}
