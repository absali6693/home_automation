package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
public class ElectronicUnitUpdateTestCase
{
public static void main(String gg[])
{
try
{
AreaTypeInterface areaType=new AreaType("Drawing Room");
ElectronicUnitInterface electronicUnit=new ElectronicUnit(21,"LED","Illumination",areaType,true,true);
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
electronicUnitDAO.update(electronicUnit);
System.out.println("Electronic unit of code 21 updated.");
}catch(DAOException  daoException)
{
System.out.println(daoException);
}

try
{
AreaTypeInterface areaType=new AreaType("Bathroom");
ElectronicUnitInterface electronicUnit=new ElectronicUnit(22,"LED","Illumination",areaType,true,true);
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
electronicUnitDAO.update(electronicUnit);
System.out.println("Electronic unit of code 22 updated.");
}catch(DAOException  daoException)
{
System.out.println(daoException);
}
}
}