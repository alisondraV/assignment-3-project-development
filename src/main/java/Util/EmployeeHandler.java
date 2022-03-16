package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class EmployeeHandler {
    private final Connection dbConnection;

    public EmployeeHandler() throws ClassNotFoundException {
        dbConnection = DBUtil.getConnection();
    }

    public void save(String userName, String password, String firstName, String lastName,
                     String emailAddress, Date hireDate) {
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(
                    "insert into employee (userName, password, firstName, lastName, emailAddress, hireDate) " +
                            "values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(5, emailAddress);
            preparedStatement.setDate(6, hireDate);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean findByEmployeeName(String userName) {
        try {
            PreparedStatement preparedStatement = dbConnection
                    .prepareStatement("select * from employee where username = ?");
            preparedStatement.setString(1, userName);

            ResultSet result = preparedStatement.executeQuery();
            if (result != null) {
                while (result.next()) {
                    if (result.getInt(1) == 1) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean findByLogin(String userName, String password) {
        try {
            PreparedStatement preparedStatement = dbConnection
                    .prepareStatement("select * from employee where username = ? and password = ? ");
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet result = preparedStatement.executeQuery();
            if (result != null) {
                while (result.next()) {
                    if (result.getString(1).equals(password)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}