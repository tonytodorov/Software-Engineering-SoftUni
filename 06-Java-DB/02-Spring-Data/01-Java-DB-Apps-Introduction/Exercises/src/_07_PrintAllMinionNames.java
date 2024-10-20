import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _07_PrintAllMinionNames {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", "root", "Tonytodorov431");

        PreparedStatement statement = connection.prepareStatement("SELECT name FROM minions;");

        ResultSet result = statement.executeQuery();

        List<String> names = new ArrayList<>();

        while (result.next()) {
            String name = result.getString("name");
            names.add(name);
        }

        for (int i = 0; i < names.size() / 2; i++) {
            System.out.println(names.get(i));
            System.out.println(names.get(names.size() - 1 - i));
        }
    }
}
