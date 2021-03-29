package dao;
import java.awt.JobAttributes;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import connection.ConnectorToDB;
import model.Customer;

/**
 *
 * @author Zahan Mara
 *
 * Abstract class for general operations
 *
 *
 * insert, delete and update an "object" into the database
 */
public class AbstractDAO<T> {


    public void Insert(Object object) {
        String table = object.getClass().getSimpleName();
        StringBuilder query = new StringBuilder();
        StringBuilder values = new StringBuilder();

        query.append("Insert into ").append(table).append(" (");

        Field[] all = object.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < all.length - 1; i++)
            {
                all[i].setAccessible(true);
                query.append(all[i].getName());
                query.append(", ");
                Object value = all[i].get(object);
                String fieldType = all[i].getType().getSimpleName();

                if (fieldType.equals("String"))
                    values.append("\"").append(value).append("\"");
                else
                    values.append(value);
                values.append(", ");
            }

            int lastFieldIndex = all.length - 1;
            all[lastFieldIndex].setAccessible(true);
            query.append(all[lastFieldIndex].getName());
            Object value = all[lastFieldIndex].get(object);
            String fieldType = all[lastFieldIndex].getType().getSimpleName();
            if (fieldType.equals("String"))
                values.append("\"").append(value).append("\"");
            else
                values.append(value);

            query.append(") values (").append(values).append(" )");
            System.out.println(query);
        } catch (Exception e) {
            System.out.println("Error at inserting");
        }
        try {
            Connection conn = ConnectorToDB.getConnection();
            PreparedStatement prepInsertStatement = conn.prepareStatement(query.toString());
            prepInsertStatement.executeUpdate();
            conn.close();
            prepInsertStatement.close();
            // "Record created succesfully!
        } catch (Exception e) {
            System.out.println("Exception when executing insert query");
        }
    }


    public void delete(Object object) {
        String table = object.getClass().getSimpleName();
        StringBuilder query = new StringBuilder();
        query.append("Delete from ").append(table).append(" where ");
        Field[] all = object.getClass().getDeclaredFields();
        Field firstField = all[0];
        firstField.setAccessible(true);
        String fieldName = firstField.getName();
        query.append(fieldName).append(" = ");
        try {
            Object value = firstField.get(object);
            query.append(value);
        } catch (Exception e) {
            System.out.println("Error at geting id value");
        }
        System.out.println(query);
        try {
            Connection con = ConnectorToDB.getConnection();
            PreparedStatement prepDeleteStatement = con.prepareStatement(query.toString());
            prepDeleteStatement.executeUpdate();
            con.close();
            prepDeleteStatement.close();
        } catch (Exception e) {
            System.out.println("Exception when executing delete query");
        }
    }

    public void Update(Object object) {
        String table = object.getClass().getSimpleName();
        StringBuilder query = new StringBuilder();
        query.append("update fruitshop.").append(table).append(" set ");
        Field[] all = object.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < all.length - 1; i++) {
                all[i].setAccessible(true);
                query.append(all[i].getName());
                query.append(" = ");
                Object value = all[i].get(object);
                String fieldType = all[i].getType().getSimpleName();
                if (fieldType.equals("String"))
                    query.append("\"").append(value).append("\"");
                else
                    query.append(value);
                query.append(", ");
            }
        } catch (Exception e) {
            System.out.println("Error at updating");
        }
        int lastFieldIndex = all.length - 1;
        all[lastFieldIndex].setAccessible(true);
        query.append(all[lastFieldIndex].getName());
        query.append(" = ");
        try {
            Object value = all[lastFieldIndex].get(object);
            String fieldType = all[lastFieldIndex].getType().getSimpleName();
            if (fieldType.equals("String"))
                query.append("\"").append(value).append("\"");
            else
                query.append(value);
        } catch (Exception e) {
            System.out.println("Error at updating");
        }

        query.append(" where ");
        Field firstField = all[0];
        firstField.setAccessible(true);
        String fieldName = firstField.getName();

        query.append(fieldName).append(" = ");

        try {
            Object value = firstField.get(object);
            query.append(value);
        } catch (Exception e) {
            System.out.println("Error at geting id value");
        }
        try {
            System.out.println(query);
            Connection con = ConnectorToDB.getConnection();
            PreparedStatement prepUpdateStatement = con.prepareStatement(query.toString());
            prepUpdateStatement.executeUpdate();
            con.close();
            prepUpdateStatement.close();
        } catch (Exception e) {
            System.out.println("Exception when executing update query");
        }
    }

}