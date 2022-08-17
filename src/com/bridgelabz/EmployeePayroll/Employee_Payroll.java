package com.bridgelabz.EmployeePayroll;
import java.sql.*;

public class Employee_Payroll
{
    public static void main(String[] args)
    {
        try {
            String JdbcURL = "jdbc:mysql://localhost/payroll_service";
            String Username = "root";
            String password = "yuktadarsh";
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rst = null;
            String myQuery = "select  SUM(salary), AVG(salary), MAX(salary), MIN(salary)   from employee_payroll   group by Gender  ;";
            con = DriverManager.getConnection(JdbcURL, Username, password);
            System.out.println("Conne");
            pstmt = con.prepareStatement(myQuery);
            rst = pstmt.executeQuery();
            System.out.println("Sum\t\tAvg\t\tMax\t\tMin");
            while (rst.next())
            {
                System.out.print(rst.getString(1));
                System.out.print("\t\t" + rst.getString(2));
                System.out.print("\t\t" + rst.getString(3));
                System.out.println("\t\t" + rst.getString(4));
                System.out.println("  " + rst.getString(15));

            }
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
