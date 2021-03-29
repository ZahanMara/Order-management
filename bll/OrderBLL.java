package bll;

import connection.ConnectorToDB;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Orders;
import presentation.ReportOrders;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Zahan Mara
 *
 * OrderBLL class manages the operations made on orders
 * process data about orders
 *
 */

public class OrderBLL {

    Connection con = ConnectorToDB.getConnection();
    private static int idO = 0;
    private ReportOrders repOrd = new ReportOrders();
    private int countO = 1; // count how many bills are made
    private int count = 1; // count how many "understock" messages are sent

    public int getLastIDo() {
        idO++;
        return idO;
    }

    public void reportOrder() {
        //repOrd.createOrdersReport("orderReport" + countO + ".pdf");
        countO++;
    }

    /**
     *
     * check if there are enough products in stock
     * if so, process the order as usual
     * if not, print an understock pdf
     *
     */
    public void processOrder(String name, String productName, int quantity) {
        ProductDAO daoP = new ProductDAO(con);
        try {
            if(quantity < daoP.searchName(productName).getQuantity())
            {
                OrderDAO dao = new OrderDAO(con);
                Orders newOrder = new Orders(getLastIDo(), name, productName, quantity);
                dao.insertNewOrder(newOrder);
                //repOrd.createBill("bill" + newOrder.getId() + ".pdf", newOrder);
                countO++;
                daoP.UpdateProductForSubstraction(productName, quantity);
            }
            else {
                //repOrd.createUnderStock("understock" + count + ".pdf", name, productName, quantity);
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
