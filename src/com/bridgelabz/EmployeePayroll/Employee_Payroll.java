package com.bridgelabz.EmployeePayroll;
import java.sql.*;

import static com.bridgelabz.EmployeePayroll.TestCustomException.validate;

public class Employee_Payroll
{
    public static void main(String[] args) {
        try {
            String JdbcURL = "jdbc:mysql://localhost/payroll_service";
            String Username = "root";
            String password = "yuktadarsh";
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rst = null;
            String myQuery = "select * from employee_payroll";
            con = DriverManager.getConnection(JdbcURL, Username, password);
            System.out.println("Conne");
            pstmt = con.prepareStatement(myQuery);
            rst = pstmt.executeQuery();
            System.out.println("Id\t\tName\t\tAge\t\tState");
            while (rst.next()) {
                System.out.print(rst.getString(1));
                System.out.print("\t\t" + rst.getString(2));
                System.out.print("\t\t" + rst.getString(3));
                System.out.println("\t\t" + rst.getString(4));
                validate ();
            }
        } catch (SQL_Exception | SQLException e)
        {
            System.out.println("Caught the exception");
            System.out.println("Exception occured: " + e);
        }
    }
}
