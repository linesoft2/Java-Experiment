package top.linesoft.biptstudy.user;

public class User {
    public int id;
    public String name;
    public String gender;

    protected User(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}