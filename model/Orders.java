package model;

import connection.ConnectorToDB;
import dao.CustomerDAO;
import dao.ProductDAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Mara
 *
 * Orders is the corresponding
 * class for the 'orders' table
 * from the database
 */

public class Orders {

    private int id;
    private String customer;
    private String product;
    private int quantity;

    public Orders(int id, String customer, String product, int quantity) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setClient(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }
    public Double getPrice() throws SQLException {
        Connection con = ConnectorToDB.getConnection();
        ProductDAO dao = new ProductDAO(con);
        Product p = dao.searchName(this.getProduct());
        return p.getPrice();
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


