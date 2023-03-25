package DB;

import Core.Models.AnimalTypes;

import java.sql.*;
import java.util.ArrayList;

public class SQLite {

    public static Connection connection = null;

    public SQLite() {
        createCommandTable("commands");
        createAnimalTable("dogs");
        createAnimalTable("cats");
        createAnimalTable("hamsters");
        createAnimalTable("horses");
        createAnimalTable("camels");
        createAnimalTable("donkeys");
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

    public void learnCommand(AnimalTypes type, int id, String command) {
        String sql = String.format("""
                INSERT INTO commands (animal_type, animal_id, command)
                VALUES
                ('%s', %d, '%s');""", type, id, command);
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.printf("%s is learnt!\n", command);
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

    public void getCommands(AnimalTypes animalType, int id) {
        String sql = String.format("""
                SELECT command FROM commands
                WHERE animal_type = '%s' and animal_id = %d""", animalType, id);
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("Command: " + resultSet.getString("command"));
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

    public void insertAnimal(AnimalTypes type, String name, int age) {
        String table = "";
        switch (type) {
            case CAT -> table = "cats";
            case DOG -> table = "dogs";
            case HAMSTER -> table = "hamsters";
            case HORSE -> table = "horses";
            case CAMEL -> table = "camels";
            case DONKEY -> table = "donkeys";
        }
        String sql = String.format("""
                INSERT INTO %s (name, age)
                VALUES
                ('%s', '%s');""", table, name, age);
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.printf("%s added!\n", type);
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

    public void createAnimalTable(String tableName) {
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

    public void deleteCommandTable(String tableName) {
        String sql = String.format("""
                DROP TABLE %s;""", tableName);
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

    public void createCommandTable(String tableName) {
        String sql = String.format("""
                CREATE TABLE IF NOT EXISTS %s(
                id INTEGER PRIMARY KEY,
                animal_type TEXT NOT NULL,
                animal_id INTEGER NOT NULL,
                command TEXT NOT NULL);""", tableName);
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

    public int getMaxId(AnimalTypes type) {
        String table = "";
        switch (type) {
            case CAT -> table = "cats";
            case DOG -> table = "dogs";
            case HAMSTER -> table = "hamsters";
            case HORSE -> table = "horses";
            case CAMEL -> table = "camels";
            case DONKEY -> table = "donkeys";
        }
        String sql = String.format("""
                SELECT MAX(id) FROM %s""", table);
        int result;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            result =  resultSet.getInt("MAX(id)");
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


    public String getName(AnimalTypes type, int id) {
        String table = "";
        switch (type) {
            case CAT -> table = "cats";
            case DOG -> table = "dogs";
            case HAMSTER -> table = "hamsters";
            case HORSE -> table = "horses";
            case CAMEL -> table = "camels";
            case DONKEY -> table = "donkeys";
        }
        String sql = String.format("""
                SELECT name FROM %s
                WHERE id = %d""", table, id);
        String name;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            name =  resultSet.getString("name");
            resultSet.close();
            stmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return name;
    }

    public int getAge(AnimalTypes type, int id) {
        String table = "";
        switch (type) {
            case CAT -> table = "cats";
            case DOG -> table = "dogs";
            case HAMSTER -> table = "hamsters";
            case HORSE -> table = "horses";
            case CAMEL -> table = "camels";
            case DONKEY -> table = "donkeys";
        }
        String sql = String.format("""
                SELECT age FROM %s
                WHERE id = %d""", table, id);
        int age;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            age =  resultSet.getInt("age");
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
        return age;
    }

    public int count(AnimalTypes type) {
        String table = "";
        switch (type) {
            case CAT -> table = "cats";
            case DOG -> table = "dogs";
            case HAMSTER -> table = "hamsters";
            case HORSE -> table = "horses";
            case CAMEL -> table = "camels";
            case DONKEY -> table = "donkeys";
        }
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

    public void printAnimal(AnimalTypes type, int id) {
        String table = "";
        switch (type) {
            case CAT -> table = "cats";
            case DOG -> table = "dogs";
            case HAMSTER -> table = "hamsters";
            case HORSE -> table = "horses";
            case CAMEL -> table = "camels";
            case DONKEY -> table = "donkeys";
        }
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
            getCommands(type, id);
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

    public void removeAnimal(AnimalTypes type, int id) {
        String table = "";
        switch (type) {
            case CAT -> table = "cats";
            case DOG -> table = "dogs";
            case HAMSTER -> table = "hamsters";
            case HORSE -> table = "horses";
            case CAMEL -> table = "camels";
            case DONKEY -> table = "donkeys";
        }
        String sql = String.format("""
                DELETE FROM %s
                WHERE id = %d;
                DELETE FROM commands
                WHERE animal_id = %d and animal_type = %s""", table, id, id, type);
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

    public int getAnimalId(AnimalTypes type, int id) {
        String table = "";
        switch (type) {
            case CAT -> table = "cats";
            case DOG -> table = "dogs";
            case HAMSTER -> table = "hamsters";
            case HORSE -> table = "horses";
            case CAMEL -> table = "camels";
            case DONKEY -> table = "donkeys";
        }
        String sql = String.format("""
                SELECT id FROM %s
                WHERE id = %d;""", table, id);
        int result;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            result = resultSet.getInt("id");
            resultSet.close();
            stmt.close();
        } catch (SQLException | ClassNotFoundException e) {
//            System.err.println(e.getMessage());
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
}
