package pl.sda.orange2.jdbc;

import pl.sda.orange2.jdbc.config.H2Config;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) {
        String className = TestConnection.class.getName();
        System.out.println("Current class name is: " + className);

        String query = """
                SELECT ID, NAME
                FROM TEST
                """;

        ResultSet queryResult = null;
        try {
//            Connection h2Connection = DriverManager.getConnection(H2Config.DB_URL,
//                    H2Config.USER,
//                    H2Config.PASSWORD);
            // we need jdbc driver (h2 dependency at pom)
            // connection gave us access to existing db
            var h2Connection = DriverManager.getConnection(H2Config.DB_URL,
                    H2Config.USER,
                    H2Config.PASSWORD);
            System.out.println("got connection: " + (h2Connection != null));

            // Statement is used to send queries to db with existing connection
            Statement queryStatement = h2Connection.createStatement();

            // ResultSet contains query result data as simple table
            // we need to iterate over result to got data
            queryResult = queryStatement.executeQuery(query);
            while (queryResult.next()) {
                System.out.println("id: " + queryResult.getInt(1));
                System.out.println("name: " + queryResult.getString(2));
            }
        } catch (SQLException exc) {
            System.out.println("got exception: " + exc);
            exc.printStackTrace();
        } finally {
            System.out.println("Finally I know it :)");
            if (queryResult != null) {
                try {
                    queryResult.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println("The end");
    }
}