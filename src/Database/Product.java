package Database;

import java.util.ArrayList;

public class Product {
  private String id;
  private String productName;
  private Double price;
  private ArrayList<Categories> categories = new ArrayList<Categories>();
  private byte[] image;
  private String createdAt;

  public Product() {
  }

  public Product(String name, Double price, ArrayList<Categories> categories, byte[] image) {
    this.categories = categories;
    this.productName = name;
    this.price = price;
    this.image = image;
  }

  public Product(String id, String name, Double price, byte[] image) {
    this.id = id;
    this.productName = name;
    this.price = price;
    this.image = image;
  }

  public Product(String id, String name, Double price) {
    this.id = id;
    this.productName = name;
    this.price = price;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.productName = name;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public void addCategory(Categories category) {
    this.categories.add(category);
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.productName;
  }

  public Double getPrice() {
    return this.price;
  }

  public byte[] getImage() {
    return this.image;
  }

  public String getCreatedAt() {
    return this.createdAt;
  }

  public ArrayList<Categories> getCategories() {
    return this.categories;
  }

}