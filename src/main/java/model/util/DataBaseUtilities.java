package model.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author skuarch
 */
//**************************************************************************
public class DataBaseUtilities {

    //======================================================================
    public DataBaseUtilities() {
    }

    //==========================================================================
    public static void closeConnection(Connection connection) {
        try {

            if (connection != null) {
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection = null;
        }
    } // end closeConnection

    //==========================================================================
    public static void closeStatement(Statement statement) {
        try {

            if (statement != null) {
                statement.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement = null;
        }
    } // end closeStatement

    //==========================================================================
    public static void closeResultSet(ResultSet resultSet) {
        try {

            if (resultSet != null) {
                resultSet.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resultSet = null;
        }
    } // end closeStatement
} // end nested class DataBaseUtilities