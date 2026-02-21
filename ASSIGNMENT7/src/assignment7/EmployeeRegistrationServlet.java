package assignment7;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerEmployee")
public class EmployeeRegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee employee = new Employee(name, email, department, salary);

        String query = "INSERT INTO employees(name, email, department, salary) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getDepartment());
            preparedStatement.setDouble(4, employee.getSalary());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                request.setAttribute("employeeName", employee.getName());
                request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
                response.getWriter().println("Employee registration failed.");
            }
        } catch (SQLException exception) {
            throw new ServletException("Database error: " + exception.getMessage(), exception);
        }
    }
}
