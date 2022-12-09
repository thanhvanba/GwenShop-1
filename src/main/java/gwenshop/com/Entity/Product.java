package gwenshop.com.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "category_id")
    private int category_id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "prod_description")
    private String description;
    @Column(name = "amount")
    private int amount;
    @Column(name = "hot_product")
    private int hot;
    @Column(name = "price")
    private int price;
    @Column(name = "delete_at")
    private String delete_id;

    public Product(int category_id, String name, String description, int amount, int hot, int price, String delete_id) {
        this.category_id = category_id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.hot = hot;
        this.price = price;
        this.delete_id = delete_id;
    }
    public Product(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDelete_id() {
        return delete_id;
    }

    public void setDelete_id(String delete_id) {
        this.delete_id = delete_id;
    }
}
