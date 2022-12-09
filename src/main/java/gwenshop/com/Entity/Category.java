package gwenshop.com.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vw_category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "amount")
    private int amount;
    @Column(name = "delete_at")
    private String delete_at;

    public Category(String name, int amount, String delete_at) {
        this.name = name;
        this.amount = amount;
        this.delete_at = delete_at;
    }

    public Category() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(String delete_at) {
        this.delete_at = delete_at;
    }
}
