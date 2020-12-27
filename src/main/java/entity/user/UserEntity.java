package entity.user;

import entity.AbstractEntity;
import entity.goods.GoodsEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserEntity extends AbstractEntity {
    @Column (name = "login")
    private String login;

    @Column (name = "password")
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id_fk", referencedColumnName = "id")
    private List<GoodsEntity> goods;  // ?allGoods;

    public UserEntity() {
    }

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
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


    }
}
