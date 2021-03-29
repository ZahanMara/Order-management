package dao;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import model.Product;

/**
 *
 * @author Mara
 *
 * ProductDAO : database access (for table Product)
 *
 * insert, delete, update, find object Product in the database
 * get all the products drom the database
 */

public class ProductDAO extends AbstractDAO<Product> {

    private Statement ProductStatement;

    public ProductDAO(Connection conn) {
        try {
            this.ProductStatement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertNewProduct(Product myProd) {
        Insert(myProd); // ABSTRACT METHOD
    }

    public void DeleteProduct(Product myProd)
    {
        if(myProd != null)
            delete(myProd); // ABSTRACT METHOD
    }

    public void UpdateProductForInserting(String name, int quantity) throws SQLException { // 10 cat se adauga
        Product myNewProduct = searchName(name); // 5 cat era
        myNewProduct.setQuantity(myNewProduct.getQuantity() + quantity); // 5 + 10 total
        Update(myNewProduct); // GENERIC METHOD
    }

    public void UpdateProductForSubstraction(String name, int quantity) throws SQLException { // 10 cat se adauga
        Product myNewProduct = searchName(name); // 5 cat era
        myNewProduct.setQuantity(myNewProduct.getQuantity() - quantity); // 5 + 10 total
        Update(myNewProduct); // GENERIC METHOD
    }


    public ArrayList<Product> getProductsList() throws SQLException {
        ResultSet rs = ProductStatement.executeQuery("SELECT * FROM fruitshop.product");

        ArrayList<Product> ProductList = new ArrayList<Product>();
        while (rs.next()) {
            Product newProd = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price"));
            ProductList.add(newProd);
        }
        return ProductList;
    }

    public Product searchName(String name) throws SQLException {
        Product myProd = null;

        ArrayList<Product> ProductList = getProductsList();
        for (Product current : ProductList) {
            if (current.getName().equals(name)) {
                myProd = current;
                break;
            }
        }
        return myProd;
    }

}
