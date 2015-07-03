package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
public class ElectronicUnitGetCountTestCase
{
public static void main(String gg[])
{
long count;
try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
count=electronicUnitDAO.getCount();
System.out.println("Number of areas:"+count);
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}