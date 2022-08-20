package com.bridgelabz.EmployeePayroll;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.*;

public class Employee_Payroll
{
    public static void main(String[] args) throws IOException {
        DataInputStream  d = new DataInputStream(System.in);
        try {
            System.out.println("----------SQL Operations------------");
            String dbURL = "jdbc:mysql://localhost/payroll_service";
            System.out.println("DataBase Has Connected");
            String username = "root";
            String password = "yuktadarsh";
            Connection conn = DriverManager.getConnection(dbURL,username,password);
            Statement stmt = conn.createStatement();
            System.out.println("Do You Want To Add New Empolyee Detail ? ");
            String in_sta = d.readLine();
            if( in_sta.equals("yes"))
            {
                System.out.println("How Many Employees Detilas You Want To Add ? ");
                int num = Integer.parseInt(d.readLine());

                for( int i = 0 ; i<num;i++)
                {
                    System.out.println("Enter Id");
                    int Id = Integer.parseInt(d.readLine());

                    System.out.println("Enter Employee Name ");
                    String Name = d.readLine();

                    System.out.println("Enter Address ");
                    String Address = d.readLine();

                    System.out.println("Enter City ");
                    String City = d.readLine();


                    System.out.println("Enter Zip-Code");
                    int zip = Integer.parseInt(d.readLine());

                    System.out.println("Enter Phone Number");
                    int phone = Integer.parseInt(d.readLine());

                    System.out.println("Setting the AutoCommit value as FALSE");
                    conn.setAutoCommit(false);
                    boolean autoCommit = conn.getAutoCommit();
                    System.out.println("AutoCommit value of the Connection = "+ autoCommit);

                    String inserT ="insert into Employees  values("+Id+",'"+Name+"','"+Address+"','"+City+"',"+zip+","+phone+");";
                    PreparedStatement st = conn.prepareStatement(inserT);
                    st.execute();
                    System.out.println("Employee "+Name+ "  Insert Records Successfully");
                }

            }
            else if(in_sta.equals("no"))
            {
                System.out.println("Ok Darsh....");
            }

            System.out.println("You want Update Some Records");
            String upa_sta = d.readLine();

            if( upa_sta.equals("yes"))
            {
                System.out.println("How Many Rows You Want Update ? ");
                int upa_num = Integer.parseInt(d.readLine());
                for(int y = 0;y < upa_num;y++)
                {
                    System.out.println("Enter You Want Update Name ");
                    String up_name = d.readLine();

                    System.out.println("Enter You Want that update Id    ");
                    int up_id = Integer.parseInt(d.readLine());

                    String update = "update Employees  set Name  = '"+up_name+"'  where Id = " +up_id+";";
                    stmt.executeUpdate(update);
                    System.out.println("Update Record Successfully");
                }

            }
            else if(upa_sta.equals("no"))
            {
                System.out.println("Ok Darsh....");


            }

            System.out.println("You want Delete Employee Records");
            String del_sta = d.readLine();

            if( del_sta.equals("yes"))
            {
                System.out.println("How Many Employee Records You Want  Delete ? ");
                int del_num = Integer.parseInt(d.readLine());

                for(int j = 0;j < del_num;j++)
                {
                    System.out.println("Enter delete Employee  ID you want to delete ");
                    int del_id = Integer.parseInt(d.readLine());
                    String delete = " delete from Employees where Id  = "+del_id+"";
                    stmt.executeUpdate(delete);
                    System.out.println("Delete Employee Record Successfully");
                }
            }
            else if(del_sta.equals("no"))
            {
                System.out.println("Ok Darsh....");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }




    }
}
