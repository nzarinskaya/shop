package model;

public class User {
private String login;
private String password;
private long id;

    public User() {
    }

    public User(String login, String password, long id) {
        this.login = login;
        this.password = password;
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
