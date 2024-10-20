import java.sql.*;

public class _02_GetVillainsNames {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", "root", "Tonytodorov431");

        PreparedStatement statement = connection.prepareStatement(
                "SELECT v.name, COUNT(*) AS number_of_minions\n" +
                "FROM villains v\n" +
                "JOIN minions_villains mv\n" +
                "\tON v.id = mv.villain_id\n" +
                "JOIN minions m\n" +
                "\tON mv.minion_id = m.id\n" +
                "GROUP BY v.name\n" +
                "HAVING number_of_minions > 15\n" +
                "ORDER BY number_of_minions DESC;");

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            System.out.printf("%s %d%n",
                    result.getString("name"),
                    result.getInt("number_of_minions"));
        }
    }
}
