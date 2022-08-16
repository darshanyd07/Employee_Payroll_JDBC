package com.bridgelabz.EmployeePayroll;
import java.io.DataInputStream;
import java.sql.*;

public class Employee_Payroll
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("----------SQL Operations------------");
            Class.forName("com.mysql.cj.jdbc.Driver");
            DataInputStream d = new DataInputStream(System.in);
            String dbURL = "jdbc:mysql://localhost/payroll_service";
            String username = "root";
            String password = "yuktadarsh";
            Connection conn = DriverManager.getConnection(dbURL,username,password);
            Statement stmt = conn.createStatement();
            System.out.println("Connection successful :-"+conn);

            System.out.println("Enter Table Name ");
            String table = d.readLine();
            String sql = "select * from "+table+";";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("E_name     E_Address        E_City        E-State         E_Phone             Email                         E_Salary ");
            System.out.println("-----------------------------");
            while (rs.next())
            {
                String ename = rs.getString("name");
                String eAddress = rs.getString("address");
                String ecity = rs.getString("city");
                String estate = rs.getString("state");
                String email = rs.getString("email");
                double ephone = rs.getDouble("phone_number");
                int esalary = rs.getInt("salary");


                System.out.println(ename+   "        " +eAddress+  "         "   +ecity+  "      "+estate+  "         "+ephone+  "       "
                           +email+"              " +esalary   );
            }
            System.out.println("-----------------------------");
            System.out.println("Display Table  Successfully");
            System.out.println("-----------------------------");
            System.exit(0);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

}
