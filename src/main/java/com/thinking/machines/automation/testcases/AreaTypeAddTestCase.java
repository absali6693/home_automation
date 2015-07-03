package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
public class AreaTypeAddTestCase
{
public static void main(String gg[])
{
try
{
AreaType areaType=new AreaType("Kitchen");
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
areaTypeDAO.add(areaType);
System.out.println("Kitchen added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
AreaType areaType=new AreaType("Dinning Room");
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
areaTypeDAO.add(areaType);
System.out.println("Dinning Room added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
AreaType areaType=new AreaType("Balcony");
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
areaTypeDAO.add(areaType);
System.out.println("Balcony added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}
try
{
AreaType areaType=new AreaType("Bathroom");
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
areaTypeDAO.add(areaType);
System.out.println("Balcony added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
AreaType areaType=new AreaType("BedRoom");
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
areaTypeDAO.add(areaType);
System.out.println("BALCONY added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
AreaType areaType=new AreaType("Hall");
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
areaTypeDAO.add(areaType);
System.out.println("Dinning Room added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
AreaType areaType=new AreaType("GuestRoom");
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
areaTypeDAO.add(areaType);
System.out.println("Dinning Room added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
AreaType areaType=new AreaType("DrawingRoom");
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
areaTypeDAO.add(areaType);
System.out.println("Dinning Room added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

}
}