package com.bridgelabz.EmployeePayroll;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.*;

import static com.bridgelabz.EmployeePayroll.TestCustomException.validate;

public class Employee_Payroll
{
    public static void main(String[] args) throws SQLException, IOException, SQL_Exception, ClassNotFoundException
    {
        try{
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
            System.out.println("Id   E_name   E_age   E_Salary    E_city");
            System.out.println("-----------------------------");
            while (rs.next())
            {
                int eid = rs.getInt("Id");
                String ename = rs.getString("Name");
                int eage = rs.getInt("Age");
                Double esalary = rs.getDouble("Salary");
                String ecity = rs.getString("City");

                System.out.println(+eid+"   "+ename+"   "+eage+"   " +esalary+  "    " +ecity   );
            }
            System.out.println("-----------------------------");
            System.out.println("Display Table  Successfully");
            System.out.println("-----------------------------");
            validate();
            System.exit(0);
        }catch (SQL_Exception e)
        {
            System.out.println("Caught the exception");
            System.out.println("Exception occured: " + e);
        }



    }

}
