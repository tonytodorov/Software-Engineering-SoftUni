import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class _06_RemoveVillain {

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", "root", "Tonytodorov431");

        int villainId = Integer.parseInt(reader.readLine());

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT name FROM villains WHERE id = ?");
        preparedStatement.setInt(1, villainId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            System.out.println("No such villain was found");
        } else {
            String villainName = resultSet.getString("name");

            preparedStatement = connection.prepareStatement(
                    "DELETE FROM minions_villains WHERE villain_id = ?");
            preparedStatement.setInt(1, villainId);
            int deletedCount = preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(
                    "DELETE FROM villains WHERE id = ?");
            preparedStatement.setInt(1, villainId);
            preparedStatement.executeUpdate();

            System.out.printf("%s was deleted%n", villainName);
            System.out.printf("%d minions released%n", deletedCount);
        }
    }
}
