package com.bridgelabz.EmployeePayroll;
import java.sql.*;

public class Employee_Payroll
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("----------SQL Operations------------");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost/payroll_service";
            String username = "root";
            String password = "yuktadarsh";
            Connection conn = DriverManager.getConnection(dbURL,username,password);
            System.out.println("Connection successful :-"+conn);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

}
