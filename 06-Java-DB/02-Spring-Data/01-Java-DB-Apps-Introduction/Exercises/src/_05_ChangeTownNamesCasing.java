import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _05_ChangeTownNamesCasing {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", "root", "Tonytodorov431");

        PreparedStatement statement = connection.prepareStatement("UPDATE towns\n" +
                "SET name = UPPER(name)\n" +
                "WHERE country = ?");

        String country = scanner.nextLine();
        statement.setString(1, country);

        int result = statement.executeUpdate();

        if (result != 0) {
            System.out.printf("%d town names were affected.%n", result);

            PreparedStatement selectStatement = connection.prepareStatement("SELECT name FROM towns\n" +
                    "WHERE country = ?;");

            selectStatement.setString(1, country);
            ResultSet cities = selectStatement.executeQuery();

            List<String> uppercaseCities = new ArrayList<>();

            while (cities.next()) {
                String city = cities.getString("name");
                uppercaseCities.add(city.toUpperCase());
            }

            System.out.println(uppercaseCities);
        } else {
            System.out.println("No town names were affected.");
        }
    }
}
