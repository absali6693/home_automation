package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
public class AreaTypeRemoveTestCase
{
public static void main(String gg[])
{
try
{
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
areaTypeDAO.remove("Room");
System.out.println("Room removed");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
areaTypeDAO.remove("Balcony");
System.out.println("Balcony removed");
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}