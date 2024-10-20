import java.sql.*;
import java.util.Scanner;

public class DiabloUsers {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String user = "root";
        String password = "Tonytodorov431";

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/diablo", user, password);

        PreparedStatement statement = connection.prepareStatement(
                "SELECT first_name, last_name, COUNT(*) AS played_games\n" +
                "FROM users u\n" +
                "JOIN users_games ug\n" +
                "\tON u.id = ug.user_id\n" +
                "WHERE u.user_name = ?\n" +
                "GROUP BY u.id;\n");

        String name = scanner.nextLine();
        statement.setString(1, name);

        ResultSet result = statement.executeQuery();

        if (result.next()) {
            String fullName = result.getString("first_name") + " " +
                    result.getString("last_name");

            int numberOfGames = result.getInt("played_games");

            System.out.printf("User: %s%n", name);
            System.out.printf("%s has played %d games", fullName, numberOfGames);
        } else {
            System.out.println("No such user exists");
        }
    }
}
