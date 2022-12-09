package gwenshop.com.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "User")

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;
    @Column(name = "fullname")
    protected String fullname;
    @Column(name = "email")
    protected String email;
    @Column(name = "passwd")
    protected String passwd;
    @Column(name = "addr")
    protected String addr;
    @Column(name = "phonenumber")
    protected String phonenumber;

    @Column(name = "salary")
    private int salary;
    @Column(name = "roles")
    private String roles;
    @Column(name = "create_at")
    protected String create_at;
    @Column(name = "delete_at")
    protected String delete_at;
    public User(){}
    public User(String fullname, String email, String passwd, String addr, String phonenumber,int salary, String role, String create_at, String delete_at) {
        this.fullname = fullname;
        this.email = email;
        this.passwd = passwd;
        this.addr = addr;
        this.phonenumber = phonenumber;
        this.salary = salary;
        this.roles = role;
        this.create_at = create_at;
        this.delete_at = delete_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }


    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(String delete_at) {
        this.delete_at = delete_at;
    }
}
