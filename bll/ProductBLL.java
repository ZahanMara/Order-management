package bll;

import connection.ConnectorToDB;
import dao.ProductDAO;
import model.Product;
import presentation.ReportProduct;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Zahan Mara
 *
 * ProductBLL class manages the operations made on products
 * process data about products
 *
 */

public class ProductBLL {

    Connection con = ConnectorToDB.getConnection();
    private ReportProduct repProd = new ReportProduct();
    private int countP = 1;
    private static int idP = 0;

    public int getLastIDp() {
        idP++;
        return idP;
    }

    public void insertProduct(String productName, int quantity, double price)
    {
        ProductDAO dao = new ProductDAO(con);
        try {
            if(dao.searchName(productName) != null) dao.UpdateProductForInserting(productName, quantity); // of there is already this product in shop, just add quantity
            else dao.insertNewProduct(new Product(getLastIDp(), productName, quantity, price));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reportProduct() {
       // repProd.createProductReport("productReport" + countP + ".pdf");
        countP++;
    }

    public void deleteProduct(String productName) {
        ProductDAO dao = new ProductDAO(con);
        try {
            dao.DeleteProduct(dao.searchName(productName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
