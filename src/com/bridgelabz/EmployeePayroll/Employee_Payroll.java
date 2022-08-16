package com.bridgelabz.EmployeePayroll;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Employee_Payroll
{
    public static void main(String[] args)
    {
        try {
            System.out.println("----------SQL Operations------------");
            Class.forName("com.mysql.cj.jdbc.Driver");
            DataInputStream d = new DataInputStream(System.in);
            String dbURL = "jdbc:mysql://localhost/payroll_service";
            String username = "root";
            String password = "yuktadarsh";
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            Statement stmt = conn.createStatement();
            System.out.println("Connection successful :-" + conn);

            System.out.println("Enter You Want Update Salary ");
            double salary = Integer.parseInt( d.readLine());

            System.out.println("Enter You Want that update Name    ");
            String up_name = d.readLine();

            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE employee_payroll SET salary = ? WHERE name = ?");

            ps.setDouble(1, salary);
            ps.setString(2, up_name);
            ps.executeUpdate();
            System.out.println(salary+"Updated Succesfully");
            ps.close();


        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
