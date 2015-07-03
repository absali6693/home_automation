package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
public class ElectronicUnitGetNextCodeTestCase
{
public static void main(String gg[])
{
try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
System.out.println("Next possible code of electronic unit:"+electronicUnitDAO.getNextCode());
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}