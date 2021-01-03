package entity.user;

import entity.AbstractEntity;
import entity.goods.Goods;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User extends AbstractEntity {

    @Column (name = "login")
    private String login;

    @Column (name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Goods> allGoods;

    public User() {
    }

    public User(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }
    public User(int id,String login, String password) {
        super(id);
        this.login = login;
        this.password = password;
    }

    public void addGoods(Goods goods){
        goods.setUser(this);
        allGoods.add(goods);
    }
    public void removeGoods(Goods goods){
        allGoods.remove(goods);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Goods> getAllGoods() {
        return allGoods;
    }

    public void setAllGoods(List<Goods> allGoods) {
        this.allGoods = allGoods;
    }
    @Override
    public int getId() {
        return id;
    }
}
