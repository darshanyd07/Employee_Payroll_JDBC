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

                    System.out.println("Enter Age");
                    int Age = Integer.parseInt(d.readLine());

                    System.out.println("Enter Salary");
                    int Salary = Integer.parseInt(d.readLine());

                    System.out.println("Enter City ");
                    String City = d.readLine();

                    System.out.println("Enter DOB ");
                    String DOB = d.readLine();

                    System.out.println("Enter State ");
                    String State = d.readLine();

                    System.out.println("Enter is_active Or Not ");
                    int Check_Is_Active = Integer.parseInt(d.readLine());

                    System.out.println("Setting the AutoCommit value as FALSE");
                    conn.setAutoCommit(false);
                    boolean autoCommit = conn.getAutoCommit();
                    System.out.println("AutoCommit value of the Connection = "+ autoCommit);

                    String inserT ="insert into Employees  values("+Id+",'"+Name+"',"+Age+","+Salary+",'"+City+"',"+DOB+",'"+State+"',"+Check_Is_Active+");";
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
                    String delete = " update Employees  set is_active  = 0  where Id = " +del_id+";";
                    stmt.executeUpdate(delete);
                    System.out.println("Delete Employee Record Successfully");
                }
            }
            else if(del_sta.equals("no"))
            {
                System.out.println("Ok Darsh....");
            }

            System.out.println("You Want To Reterive Data ");
            String checker = d.readLine();
            if(checker.equals("yes"))
            {
                String table = d.readLine();
                String sql = "select * from Employee where is_active = 1 ;";
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
                    String Date = rs.getString("date_add");
                    int is_acive = rs.getInt("is_active");


                    System.out.println(+eid+"   "+ename+"   "+eage+"   " +esalary+  "    " +ecity+   "     "+Date+ "       "+is_acive  );
                }
                System.out.println("-----------------------------");
                System.out.println("Display Table  Successfully");
                System.out.println("-----------------------------");

            }else
            {
                System.out.println("Ok Bye Darsh.......");
            }


        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        System.exit(0);


    }
}
