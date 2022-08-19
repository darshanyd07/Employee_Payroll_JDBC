package com.bridgelabz.EmployeePayroll;

import java.sql.Connection;

public class TestCustomException
{
    static void validate () throws SQL_Exception
    {
        Connection con = null;
        String dbURL = null;
        if (dbURL == " jdbc:mysql://localhost/payroll_service")
        {
            throw new SQL_Exception("not valid Snyatx");
        }else
        {
            System.out.println("welcome To SQL Opertion");
        }
    }

}