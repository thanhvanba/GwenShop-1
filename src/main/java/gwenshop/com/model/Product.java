package gwenshop.com.model;

public class Product {
    private int product_id;
    private int category_id;
    private String prod_name;
    private String description;
    private String image;
    private int amount;
    private String hot_product;
    private float price;

    public Product (){ };

    public Product(int product_id, int category_id, String prod_name, String description, String image, int amount, String hot_product, float price) {
        this.product_id = product_id;
        this.category_id = category_id;
        this.prod_name = prod_name;
        this.description = description;
        this.image = image;
        this.amount = amount;
        this.hot_product = hot_product;
        this.price = price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getHot_product() {
        return hot_product;
    }

    public void setHot_product(String hot_product) {
        this.hot_product = hot_product;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
