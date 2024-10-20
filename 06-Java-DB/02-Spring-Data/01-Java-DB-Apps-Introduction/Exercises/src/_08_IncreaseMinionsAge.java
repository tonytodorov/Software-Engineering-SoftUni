import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class _08_IncreaseMinionsAge {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", "root", "Tonytodorov431");

        int[] id = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String placeholders = String.join(", ", Arrays.stream(id)
                .mapToObj(i -> "?")
                .toArray(String[]::new));

        String updateQuery = "UPDATE minions SET age = age + 1, name = LOWER(name) WHERE id IN (" + placeholders + ");";
        PreparedStatement updateAge = connection.prepareStatement(updateQuery);

        for (int i = 0; i < id.length; i++) {
            updateAge.setInt(i + 1, id[i]);
        }

        updateAge.executeUpdate();

        PreparedStatement getMinionsInformation = connection.prepareStatement("SELECT name, age FROM minions;");

        ResultSet result = getMinionsInformation.executeQuery();

        while (result.next()) {
            System.out.printf("%s %d%n",
                    result.getString("name"),
                    result.getInt("age"));
        }
    }
}
