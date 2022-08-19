package com.bridgelabz.EmployeePayroll;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.*;

import static com.bridgelabz.EmployeePayroll.TestCustomException.validate;

public class Employee_Payroll
{
    public static void main(String[] args)throws SQLException, IOException, SQL_Exception, ClassNotFoundException
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


            System.out.println("You want Update Some Records");
            String upa_sta = d.readLine();

            if( upa_sta.equals("yes"))
            {
                System.out.println("How Many Rows You Want Update ? ");
                int upa_num = Integer.parseInt(d.readLine());
                for(int y = 0;y < upa_num;y++)
                {
                    System.out.println("Enter You Want Update Salary ");
                    double salary = Integer.parseInt( d.readLine());

                    System.out.println("Enter You Want that update Name    ");
                    String up_name = d.readLine();

                    String update = "update  employee_payroll   set salary  = "+salary+"  where name = '" +up_name+"';";
                    stmt.executeUpdate(update);
                    System.out.println("Update Record Successfully");
                }

            }
            else if(upa_sta.equals("no"))
            {
                System.out.println("Ok Darsh....");


            }

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
            validate();
            System.exit(0);
        }
        catch (SQL_Exception e)
        {
            System.out.println("Caught the exception");
            System.out.println("Exception occured: " + e);
        }

    }

}
