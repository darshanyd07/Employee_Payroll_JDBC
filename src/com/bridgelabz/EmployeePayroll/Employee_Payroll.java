package com.bridgelabz.EmployeePayroll;
import java.sql.*;

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
            String myQuery = "select * from employee_payroll where Join_Date BETWEEN  '1999-01-14' AND  '1999-05-14';";
            con = DriverManager.getConnection(JdbcURL, Username, password);
            System.out.println("Conne");
            pstmt = con.prepareStatement(myQuery);
            rst = pstmt.executeQuery();
            System.out.println("Id\t\tName\t\tAge\t\tState\t\tJoin Date");
            while (rst.next()) {
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
