package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
public class ElectronicUnitRemoveTestCase
{
public static void main(String gg[])
{
try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
electronicUnitDAO.remove(12);
System.out.println("Fan removed.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
electronicUnitDAO.remove(21);
System.out.println("LED removed.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}