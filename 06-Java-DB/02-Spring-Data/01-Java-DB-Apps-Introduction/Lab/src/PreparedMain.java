import java.sql.*;
import java.util.Scanner;

public class PreparedMain {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        // Database connection

        String user = "root";
        String pass = "Tonytodorov431";

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", user, pass);

        // Statement with all columns

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT COUNT(*) FROM soft_uni.employees");

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int employeeCount = resultSet.getInt(1);

        System.out.println(employeeCount);

        // Statement with many columns

        PreparedStatement manyColumns = connection.prepareStatement(
                "SELECT employee_id, first_name, last_name FROM soft_uni.employees LIMIT 1");
        ResultSet manyColumnsResult = manyColumns.executeQuery();

        while (manyColumnsResult.next()) {
            System.out.printf("%d %s %s%n",
                    manyColumnsResult.getInt("employee_id"),
                    manyColumnsResult.getString("first_name"),
                    manyColumnsResult.getString("last_name"));
        }

        // Statement with parameter

        PreparedStatement statementWithParameter = connection.prepareStatement(
                "SELECT first_name, last_name FROM employees WHERE salary > ?");

        System.out.println("Enter salary:");
        String salary = scanner.nextLine();
        statementWithParameter.setDouble(1, Double.parseDouble(salary));

        ResultSet statementWithParameterResult = statementWithParameter.executeQuery();

        while (statementWithParameterResult.next()) {
            System.out.printf("%s %s%n",
                statementWithParameterResult.getString("first_name"),
                statementWithParameterResult.getString("last_name")
            );
        }
    }
}