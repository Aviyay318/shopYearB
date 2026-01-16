package org.example.shopyearb.DataBase;

import jakarta.annotation.PostConstruct;
import org.example.shopyearb.Entity.Category;
import org.example.shopyearb.Entity.Product;
import org.example.shopyearb.Entity.User;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBManager {

    private static final String URL = "jdbc:mysql://localhost:3306/shopyearb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    private Connection connection;

    @PostConstruct
    public void connect() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("DB connected successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
               Category category = new Category(resultSet.getInt("id"),resultSet.getString("name"));
               categories.add(category);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return categories;
   }

   public List<Product> getProductsByCategoryId (int categoryId){
      List<Product> products = new ArrayList<>();
      String sql = "SELECT * FROM products WHERE category_id = ?";
      try(PreparedStatement ps  = connection.prepareStatement(sql)){
        ps.setInt(1,categoryId);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next())
        {
            Product product = new Product(resultSet.getInt("id"),
                    resultSet.getInt("price"),resultSet.getString("name"),resultSet.getString("color"),resultSet.getString("url"));
            products.add(product);
        }
      }catch (SQLException e){
          e.printStackTrace();
      }
      return products;
   }
























    public void insertUser(User user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






public boolean isProductExist(String name){
        boolean isExist = false;
      String sql = "SELECT name FROM products WHERE name= ?";
      try(PreparedStatement ps = this.connection.prepareStatement(sql)){
          ps.setString(1,name);
       ResultSet resultSet = ps.executeQuery();
       if (resultSet.next()){
           isExist = true;
       }
      }catch (SQLException e){
            e.printStackTrace();
      }
      return isExist;
}

public boolean addProduct(Product product){
        boolean successes = true;
        String sql = "INSERT INTO products(name, price,color,url,category_id) VALUES(?, ?, ?, ?, ?) ";
        try(PreparedStatement ps  = this.connection.prepareStatement(sql)){
            ps.setString(1,product.getName());
            ps.setInt(2,(int) product.getPrice());
            ps.setString(3, product.getColor());
            ps.setString(4, product.getUrl());
            ps.setInt(5,product.getCategory());
            ps.executeUpdate();

        }catch (SQLException e){
            successes = false;
        }
        return successes;
}

    public List<Category> getAllCategories2() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";
        try(PreparedStatement ps = this.connection.prepareStatement(sql)){
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Category category = new Category(resultSet.getInt("id"),resultSet.getString("name"));
                categories.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categories;
    }

    public boolean isUserExist(String username) {
        boolean isUserExist = false;
        String sql = "SELECT username FROM users WHERE username = ?";
        try(PreparedStatement ps =  this.connection.prepareStatement(sql)){
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                isUserExist = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return isUserExist;
    }

    public boolean addUser(User user) {
        boolean successes = true;
       String sql = "INSERT INTO users(username,password_hash,phone_number,email,gender) VALUES(?, ?, ?, ?, ?)" ;
       try(PreparedStatement ps = this.connection.prepareStatement(sql)){
         ps.setString(1, user.getUsername());
         ps.setString(2, user.getPassword());
         ps.setString(3, user.getPhoneNumber());
         ps.setString(4,user.getEmail());
         ps.setString(5, user.getGender());
         ps.executeUpdate();

       }catch (SQLException e){
           successes = false;
           e.printStackTrace();
       }
       return successes;
    }

    public boolean getUserByUsernameAndPassword(String username, String password) {
        boolean successes = false;
        String sql = "SELECT * FROM users WHERE username= ? AND password_hash = ?";
        try(PreparedStatement ps = this.connection.prepareStatement(sql)){
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                successes = true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return successes;
    }
}
