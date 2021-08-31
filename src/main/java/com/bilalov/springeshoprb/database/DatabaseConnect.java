package com.bilalov.springeshoprb.database;

import com.bilalov.springeshoprb.service.ProductService;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DatabaseConnect {

    private final String url;
    private final String username;
    private final String password;
    private int productId;
    private int userId;
    private int bucketId;

    public DatabaseConnect() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        url = "jdbc:postgresql://localhost:5432/shop";
        username = "postgres";
        password = "postgres";
        Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
    }

    public void removeFromBucket(String title, String username) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            try (Connection conn = DriverManager.getConnection(url, this.username, password)){
                String productTitle = "SELECT * FROM products where title='" + title + "';";
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(productTitle);
                if(rs1.next()) {
                    productId = (rs1.getInt("id"));
                    System.out.println(productId);
                    st1.close();
                    rs1.close();
                }
                String userName = "SELECT * FROM users where name='" + username + "';";
                Statement st2 = conn.createStatement();
                ResultSet rs2 = st2.executeQuery(userName);
                if(rs2.next()) {
                    userId = (rs2.getInt("id"));
                    System.out.println(userId);
                    st2.close();
                    rs2.close();
                }
                String bucket = "SELECT * FROM buckets where user_id='" + userId + "';";
                Statement st3 = conn.createStatement();
                ResultSet rs3 = st3.executeQuery(userName);
                if(rs3.next()) {
                    bucketId = (rs3.getInt("id"));
                    System.out.println(bucketId);
                    st3.close();
                    rs3.close();
                }

                String sql = "DELETE FROM buckets_products WHERE CTID in(SELECT CTID FROM buckets_products WHERE bucket_id =" + bucketId + " and product_id = " + productId +" limit 1)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                int rows = preparedStatement.executeUpdate();
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
}