package gwenshop.com.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_image")
public class Product_Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "product_id")
    private int productId;

    @Column(name = "prod_image")
    private String image;
    public Product_Image(int productId, String image) {
        this.productId = productId;
        this.image = image;
    }

    public Product_Image() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
