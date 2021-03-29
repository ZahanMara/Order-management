package presentation;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import bll.*;

/**
 *
 * @author Mara
 *
 * ReadFile class goes through the entire input file and sends the accumulated information to the BLL classes for processing data
 */

public class ReadFile {

    private Path path;
    private CustomerBLL bllCust;
    private ProductBLL bllProd;
    private OrderBLL bllOrd;

    public ReadFile(String fileName, CustomerBLL bllC, ProductBLL bllP, OrderBLL bllO) {  // constructor which create the path to the desired file
        try {
            this.path = Paths.get(fileName);
            this.bllCust = bllC;
            this.bllProd = bllP;
            this.bllOrd = bllO;
        }
        catch(Exception e) {
            System.out.println("File not found!"); // if it does not find the file, it will print a warning
        }
    }

    // this method stores all the values given in the input text file within an array
    public void loadData() {
        try {
            Files.lines(path).forEach(line -> {  // this command reads the values separated by a comma (e.g. 2,30 -> Minimum and maximum arrival time
                List<String> values = Arrays.asList(line.split(" "));
                switch (values.get(0)) {

                    case "Insert": // DONE
                        if (values.get(1).equals("client:"))  // if the command is "Insert client"
                            bllCust.insertCustomer(values.get(2) + " " + values.get(3).substring(0, values.get(3).length() - 1), values.get(4));
                        else  // if the command is "Insert product"
                            bllProd.insertProduct(values.get(2).substring(0, values.get(2).length() - 1), Integer.parseInt(values.get(3).substring(0, values.get(3).length() - 1)), Float.parseFloat(values.get(4)));
                        break;

                    case "Report": // DONE
                        if (values.get(1).equals("client")) {
                            bllCust.reportClient(); // if the command is "Report client"
                        }
                        else if(values.get(1).equals("product")) {
                            bllProd.reportProduct(); // if the command is "Report product"
                        }
                        else {
                            bllOrd.reportOrder(); // if the command is "Report order"

                        }
                        break;

                    case "Delete": // DONE
                        if (values.get(1).equals("client:"))  // if the command is "Delete client"
                            bllCust.deleteClient(values.get(2) + " " + values.get(3).substring(0, values.get(3).length() - 1));
                        else // if the command is "Delete product"
                            bllProd.deleteProduct(values.get(2));
                        break;

                    case "Order:": // if the command is "Order"
                        bllOrd.processOrder(values.get(1) + " " + values.get(2).substring(0, values.get(2).length() - 1), values.get(3).substring(0, values.get(3).length() - 1), Integer.parseInt(values.get(4)));
                        break;
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

