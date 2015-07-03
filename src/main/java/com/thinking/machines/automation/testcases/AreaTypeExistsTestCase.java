package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
public class AreaTypeExistsTestCase
{
public static void main(String gg[])
{
try
{
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
System.out.println(areaTypeDAO.exists("Room"));
System.out.println(areaTypeDAO.exists("Balcony"));
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}