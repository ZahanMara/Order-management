package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Customer;

/**
 *
 * @author Mara
 *
 * CustomerDAO : database access (for table Customer)
 *
 * insert, delete, find object Customer in the database
 * get all the customers from the database
 */


public class CustomerDAO extends AbstractDAO<Customer> {

    private Statement CustomerStatement;

    public CustomerDAO(Connection conn) {
        try {
            this.CustomerStatement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertNewCustomer(Customer myCust) {
        Insert(myCust); // ABSTRACT METHOD
    }

    public void DeleteCustomer(Customer myCust)
    {
        if(myCust != null)
            delete(myCust); // ABSTRACT METHOD
    }

    public ArrayList<Customer> getCustomersList() throws SQLException {
        ResultSet rs = CustomerStatement.executeQuery("SELECT * FROM fruitshop.customer");

        ArrayList<Customer> CustomersList = new ArrayList<Customer>();
        while (rs.next()) {
            Customer newCust = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"));
            CustomersList.add(newCust);
        }
        return CustomersList;
    }

    public Customer searchName(String name) throws SQLException {
        Customer myCust = null;

        ArrayList<Customer> CustomersList = getCustomersList();
        for (Customer current : CustomersList) {
            if (current.getName().equals(name)) {
                myCust = current;
                break;
            }
        }
        return myCust;
    }
}