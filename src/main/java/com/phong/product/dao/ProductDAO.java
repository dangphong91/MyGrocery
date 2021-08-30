package com.phong.product.dao;

import com.phong.connectSQL.ConnecSQL;
import com.phong.product.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{

    private final ConnecSQL CONNECTSQL = new ConnecSQL();

    private static final String INSERT = "INSERT INTO products (name, type, price, inventory, img) " +
            "VALUES (?,?,?,?,?);";
    private static final String SELECT_ID = "SELECT * FROM products WHERE id=?;";
    private static final String SELECT_ALL = "SELECT * FROM products;";
    private static final String DELETE = "DELETE FROM products WHERE id=?;";
    private static final String UPDATE = "UPDATE products SET name=?,type=?,price=?,inventory=?,img=? WHERE id=?;";
    private static final String SEARCH = "SELECT * FROM products WHERE name LIKE ?;";
    private static final String SHOW_PRODUCT = "SELECT p.name AS nameProduct, p.price AS priceProduct, " +
            "d.hsd, d.img1, d.img2, d.img3, d.trademark, d.madein, d.type, d.volume, d.using, d.folder " +
            "FROM products p INNER JOIN descriptions d ON p.id=d.idProduct WHERE p.id=?;";
    private String SORT;
    private int count=1;

    public ProductDAO() {
    }

    @Override
    public void insertProduct(Product product) {
        System.out.println(INSERT);
        try (Connection connection = CONNECTSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)){
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getType());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getInventory());
            preparedStatement.setString(5, product.getImg());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        try (Connection connection = CONNECTSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int inventory = rs.getInt("inventory");
                String img = rs.getString("img");
                product = new Product(name, type, price, inventory, img);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = CONNECTSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int inventory = rs.getInt("inventory");
                String img = rs.getString("img");
                products.add(new Product(id, name, type, price, inventory, img));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = CONNECTSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)){
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() >0;
        }
        return rowDelete;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = CONNECTSQL.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getType());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getInventory());
            statement.setString(5, product.getImg());
            statement.setInt(6, product.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Product> searchProducts(String key) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = CONNECTSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH)) {
            preparedStatement.setString(1,("%"+key+"%"));
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int inventory = rs.getInt("inventory");
                String img = rs.getString("img");
                products.add(new Product(id, name, type, price, inventory, img));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    @Override
    public List<Product> sortProducts() {
        if (count%2==0) {
            SORT = "SELECT * FROM products ORDER BY price DESC";
        } else {
            SORT = "SELECT * FROM products ORDER BY price ASC";
        }
        List<Product> products = new ArrayList<>();
        try (Connection connection = CONNECTSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SORT)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int inventory = rs.getInt("inventory");
                String img = rs.getString("img");
                products.add(new Product(id, name, type, price, inventory, img));
            }
            count++;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    public Product showProduct(int id) {
        Product product = null;
        try (Connection connection = CONNECTSQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SHOW_PRODUCT)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("nameProduct");
                double price = rs.getDouble("priceProduct");
                int hsd = rs.getInt("hsd");
                String img1 = rs.getString("img1");
                String img2 = rs.getString("img2");
                String img3 = rs.getString("img3");
                String trademark = rs.getString("trademark");
                String madein = rs.getString("madein");
                String type = rs.getString("type");
                String volume = rs.getString("volume");
                String using = rs.getString("using");
                String folder = rs.getString("folder");
                product = new Product(name, type, price, hsd, img1, img2, img3, trademark, madein, volume, using, folder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
