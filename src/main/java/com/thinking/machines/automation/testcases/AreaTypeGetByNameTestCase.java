package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
public class AreaTypeGetByNameTestCase 
{
public static void main(String gg[])
{
try
{
AreaTypeInterface areaType=new AreaType();
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
areaType=areaTypeDAO.get("KITCHEN");
System.out.println(areaType.getName());
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
AreaTypeInterface areaType=null;
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
areaType=areaTypeDAO.get("Room");
System.out.println(areaType.getName());
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}