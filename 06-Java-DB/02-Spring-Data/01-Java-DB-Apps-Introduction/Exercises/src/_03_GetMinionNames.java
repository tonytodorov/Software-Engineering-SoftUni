import java.sql.*;
import java.util.Scanner;

public class _03_GetMinionNames {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", "root", "Tonytodorov431");

        int villainId = scanner.nextInt();

        PreparedStatement villainStatement = connection.prepareStatement(
                "SELECT name FROM villains WHERE id = ?;");
        villainStatement.setInt(1, villainId);

        ResultSet villainResultSet = villainStatement.executeQuery();

        if (!villainResultSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
            connection.close();
            return;
        }

        String villainName = villainResultSet.getString("name");
        System.out.printf("Villain: %s%n", villainName);

        PreparedStatement minionsStatement = connection.prepareStatement(
                "SELECT m.name, m.age " +
                        "FROM minions m " +
                        "JOIN minions_villains mv ON m.id = mv.minion_id " +
                        "WHERE mv.villain_id = ?;");
        minionsStatement.setInt(1, villainId);

        ResultSet minionsResultSet = minionsStatement.executeQuery();

        int counter = 1;

        while (minionsResultSet.next()) {
            String minionName = minionsResultSet.getString("name");
            int minionAge = minionsResultSet.getInt("age");
            System.out.printf("%d. %s %d%n", counter++, minionName, minionAge);
        }

        minionsResultSet.close();
        minionsStatement.close();
        connection.close();
    }
}
