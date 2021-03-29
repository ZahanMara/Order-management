package dao;

import model.Orders;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mara
 *
 * OrderDAO : database access (for table Orders)
 *
 * insert object Orders in the database
 * find all the orders from the database
 */

public class OrderDAO extends AbstractDAO<Orders>{

    private Statement OrderStatement;

    public OrderDAO(Connection conn) {
        try {
            this.OrderStatement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertNewOrder(Orders myOrd) {
        Insert(myOrd); // ABSTRACT METHOD
    }

    public ArrayList<Orders> getOrdersList() throws SQLException {
        ResultSet rs = OrderStatement.executeQuery("SELECT * FROM fruitshop.Orders");

        ArrayList<Orders> OrdersList = new ArrayList<Orders>();
        while (rs.next()) {
            Orders newOrd = new Orders(rs.getInt("id"), rs.getString("customer"), rs.getString("product"), rs.getInt("quantity"));
            OrdersList.add(newOrd);
        }
        return OrdersList;
    }
}
