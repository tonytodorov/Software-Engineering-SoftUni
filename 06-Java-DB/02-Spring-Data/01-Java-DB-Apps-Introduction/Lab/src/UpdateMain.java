import java.sql.*;

public class UpdateMain {

    public static void main(String[] args) throws SQLException {
        String user = "root";
        String pass = "Tonytodorov431";

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/soft_uni", user, pass);

        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE employees SET salary = salary * 2 WHERE employee_id = 1");

        int result = preparedStatement.executeUpdate();
        System.out.println(result);
    }
}
