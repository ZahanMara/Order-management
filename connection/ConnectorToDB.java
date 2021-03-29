package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zahan Mara
 *
 * ConnectorToDB realize the connection between the program and the database
 *
 */

public class ConnectorToDB {

    private static final Logger LOGGER = Logger.getLogger(ConnectorToDB.class.getName());
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/fruitshop";
    private static final String USER = "root";
    private static final String PASS = "root";

    private static ConnectorToDB singleInstance = new ConnectorToDB();

    private ConnectorToDB() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ERROR while trying to connect to DataBase!\n");
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "ERROR while trying to close the connection!\n");
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "ERROR while trying to close the statement!\n");
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "ERROR while trying to close the ResultSet!\n");
            }
        }
    }
}