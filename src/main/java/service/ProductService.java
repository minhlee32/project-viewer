package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> findAll() throws ClassNotFoundException, SQLException;
}
