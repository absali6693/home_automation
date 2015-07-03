package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
public class ElectronicUnitExistsTestCase
{
public static void main(String gg[])
{
try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
System.out.println(electronicUnitDAO.exists(1));
System.out.println(electronicUnitDAO.exists(21));
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}