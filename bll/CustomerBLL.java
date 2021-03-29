package bll;

import connection.ConnectorToDB;
import dao.CustomerDAO;
import model.Customer;
import presentation.ReportCustomer;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Zahan Mara
 *
 * CustomerBLL class manages the operations made on customers
 * process data about customers
 *
 */

public class CustomerBLL {

    Connection con = ConnectorToDB.getConnection();
    private ReportCustomer repCust = new ReportCustomer();
    private int countC = 1;
    private static int idC = 0;

    public int getLastIDc() {
        idC++;
        return idC;
    }

    public void insertCustomer(String name, String address)
    {
        CustomerDAO dao = new CustomerDAO(con);
        dao.insertNewCustomer(new Customer(getLastIDc(), name, address));
    }

    public void reportClient() {
        //repCust.createCustomerReport("clientReport" + countC + ".pdf");
        countC++;
    }

    public void deleteClient(String name) {
        CustomerDAO dao = new CustomerDAO(con);
        try {
            dao.DeleteCustomer(dao.searchName(name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
