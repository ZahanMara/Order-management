package dao;

import connection.ConnectorToDB;

import javax.swing.*;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Zahan Mara
 *
 * ClearAllDAO class deals with the deletion of all the previous data from the database
 * making space for the new data
 *
 */

public class ClearAllDAO {

    public void delete() {
        String tableCust = "customer";
        String tableProd = "product";
        String tableOrd = "orders";
        StringBuilder query1 = new StringBuilder();
        StringBuilder query2 = new StringBuilder();
        StringBuilder query3 = new StringBuilder();
        query1.append("Delete from ").append(tableCust);
        query2.append("Delete from ").append(tableProd);
        query3.append("Delete from ").append(tableOrd);

        try {
            Connection con = ConnectorToDB.getConnection();
            PreparedStatement prepDeleteStatement1 = con.prepareStatement(query1.toString());
            PreparedStatement prepDeleteStatement2 = con.prepareStatement(query2.toString());
            PreparedStatement prepDeleteStatement3 = con.prepareStatement(query3.toString());
            prepDeleteStatement1.executeUpdate();
            prepDeleteStatement2.executeUpdate();
            prepDeleteStatement3.executeUpdate();
            prepDeleteStatement1.close();
            prepDeleteStatement2.close();
            prepDeleteStatement3.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Exception when executing delete all data");
        }
    }
}
