package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://localhost:3306/AwesomeBusiness";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "123456";

    public ProductServiceImpl() {
    }


    @Override
    public List<Product> findAll() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        Connection conn = null;
        Statement stmt = null;

        log("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


        log("Create query command SQL...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT id, code, name FROM Product";

        log("Excuting query command SQL...");
        ResultSet rs = stmt.executeQuery(sql);

        List<Product> products = new ArrayList<>();
        log("Collecting results...");
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setCode(rs.getString("code"));
            product.setName(rs.getString("name"));

            products.add(product);
        }
        log("Completed collect results. Reconnecting...");
        rs.close();
        stmt.close();
        conn.close();

        log("Success!");
        return products;
    }

    private void log(String message) {
        System.out.println("ProductServiceImpl: " + message);
    }


}
