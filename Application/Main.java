package Application;

import bll.CustomerBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import dao.ClearAllDAO;
import presentation.ReadFile;

/**
 * Main class
 *
 */
public class Main {


    public static void main(String[] args) {

        ClearAllDAO clearAll = new ClearAllDAO();
        clearAll.delete(); // delete all the data that was added before in the database & prepare it for a new test
        CustomerBLL bllCust = new CustomerBLL();
        ProductBLL bllProd = new ProductBLL();
        OrderBLL bllOrd = new OrderBLL();
        ReadFile file = new ReadFile(args[0], bllCust, bllProd, bllOrd);
        file.loadData();
    }
}



