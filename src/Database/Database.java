package Database;

import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
  private Connection conn;

  public Database() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_oovp", "root", "");
      System.out.println("Succeedd");
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public ArrayList<Categories> getAllCategories() {
    ArrayList<Categories> categoriesList = new ArrayList<Categories>();

    try {

      Statement state = this.conn.createStatement();
      ResultSet rs = state.executeQuery("SELECT id, name FROM categories");

      while (rs.next()) {
        Categories category = new Categories();
        category.setName(rs.getString("name"));
        category.setId(rs.getString("id"));
        categoriesList.add(category);
      }

      return categoriesList;
    } catch (SQLException ex) {
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }

  public void addCategories(Categories category) {
    try {
      PreparedStatement preparedStatement = this.conn
          .prepareStatement("INSERT INTO categories (id, name) VALUES (?, ?)");
      preparedStatement.setString(1, category.getId());
      preparedStatement.setString(2, category.getName());
      preparedStatement.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public void deleteCategories(String id) {
    try {
      PreparedStatement ps = this.conn.prepareStatement("DELETE FROM categories WHERE id = ?");
      ps.setString(1, id);
      ps.executeUpdate();
      System.out.println("Success");
    } catch (SQLException ex) {
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void addProduct(Product product, InputStream imageFile) {
    try {
      PreparedStatement ps = this.conn
          .prepareStatement("INSERT INTO product (id, name, price, image) VALUES (?, ?, ?, ?)");
      ps.setString(1, product.getId());
      ps.setString(2, product.getName());
      ps.setString(3, Double.toString(product.getPrice()));
      ps.setBlob(4, imageFile);
      ps.executeUpdate();
      System.out.println("Success");
    } catch (SQLException ex) {
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public ArrayList<Product> getAllProducts() {
    ArrayList<Product> products = new ArrayList<>();
    try {
      PreparedStatement ps = this.conn.prepareStatement("SELECT id, name, image, price FROM product");
      ResultSet resultSet = ps.executeQuery();

      
      while (resultSet.next()) {
        String productId = resultSet.getString("id");
        String name = resultSet.getString("name");
        byte[] image = resultSet.getBytes("image");
        double price = resultSet.getDouble("price");

        // Create a Product object with retrieved data
        Product product = new Product(productId, name, price, image);
        products.add(product);
      }
      return products;
    } catch (SQLException ex) {
      // TODO: handle exception
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }

  public Product getProductById(String id) {
    try {
      PreparedStatement ps = this.conn.prepareStatement("SELECT id, name, image, price FROM product WHERE id = ?");
      ps.setString(1, id);
      ResultSet resultSet = ps.executeQuery();

      Product product = null;
      if (resultSet.next()) {

        String productId = resultSet.getString("id");
        String name = resultSet.getString("name");
        byte[] image = resultSet.getBytes("image");
        double price = resultSet.getDouble("price");

        // Create a Product object with retrieved data
        product = new Product(productId, name, price, image);
      }
      return product;
    } catch (SQLException ex) {
      // TODO: handle exception
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }

  public void addProductCategory(String productId, String categoryId) {
    try {
      PreparedStatement ps = this.conn
          .prepareStatement("INSERT INTO product_category (product_id, category_id) VALUES (?, ?)");
      ps.setString(1, productId);
      ps.setString(2, categoryId);
      ps.executeUpdate();
      System.out.println("Succedd to add product category");
    } catch (SQLException e) {
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
    }
  }
}
