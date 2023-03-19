package DB;

import java.sql.*;

public class SQLite {

    public static Connection connection = null;

    public SQLite() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
//            System.out.println("DB connected!");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public void insertAnimal(String animalType, String name, int age) {
        String sql = String.format("""
                INSERT INTO %s (name, age)
                VALUES
                ('%s', '%s');""", animalType, name, age);
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.printf("%s added!\n", animalType);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public void createTable(String tableName) {
        String sql = String.format("""
                CREATE TABLE IF NOT EXISTS %s(
                id INTEGER PRIMARY KEY,
                name TEXT NOT NULL,
                age INTEGER NOT NULL);""", tableName);
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
//            System.out.printf("Table %s created!\n", tableName);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int count(String table) {
        String sql = String.format("""
                SELECT COUNT(*) FROM %s;""", table);
        int result;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            result =  resultSet.getInt("COUNT(*)");
            resultSet.close();
            stmt.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            return 0;
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return result;
    }

    public void printAnimal(String table, int id) {
        String sql = String.format("""
                SELECT * FROM %s
                WHERE id = '%d';""", table, id);
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Age: " + resultSet.getString("age"));
            }
            resultSet.close();
            stmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public void removeAnimal(String table, int id) {
        String sql = String.format("""
                DELETE FROM %s
                WHERE id = %d;""", table, id);
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.printf("Animal with number %d was deleted!\n", id);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
