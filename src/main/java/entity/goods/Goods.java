package entity.goods;

import entity.AbstractEntity;
import entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "goods")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Goods extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private String price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id_fk", referencedColumnName = "id")
    private User user;

    public Goods() {
    }
    public Goods(String name, String description, String price) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Goods(String name, String description, String price,int id) {
        super(id);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int getId() {
        return id;
    }
}
