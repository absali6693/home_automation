package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
public class ElectronicUnitAddTestCase
{
public static void main(String gg[])
{
try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
ElectronicUnitInterface electronicUnit=new ElectronicUnit(1,"Chandelier","None",new AreaType("Dinning Room"),true,false);
electronicUnitDAO.add(electronicUnit);
System.out.println("Electronic unit added.");
/*
System.out.println(electronicUnit.getCode()+"\n");
System.out.println(electronicUnit.getName()+"\n");
System.out.println(electronicUnit.getControlName()+"\n");
System.out.println(electronicUnit.getAreaType().getName()+"\n");
System.out.println(electronicUnit.isSwitchable()+"\n");
System.out.println(electronicUnit.isControllable()+"\n");
*/
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
AreaTypeInterface areaType=new AreaType("Kitchen");
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
ElectronicUnitInterface electronicUnit=new ElectronicUnit();
electronicUnit.setCode(2);
electronicUnit.setName("Fan");
electronicUnit.setControlName("Speed");
electronicUnit.setAreaType(areaType);
electronicUnit.setIsSwitchable(true);
electronicUnit.setIsControllable(true);
electronicUnitDAO.add(electronicUnit);
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
AreaTypeInterface areaType=new AreaType("Balcony");
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
ElectronicUnitInterface electronicUnit=new ElectronicUnit();
electronicUnit.setCode(3);
electronicUnit.setName("CFL");
electronicUnit.setControlName("Illumination");
electronicUnit.setAreaType(areaType);
electronicUnit.setIsSwitchable(true);
electronicUnit.setIsControllable(true);
electronicUnitDAO.add(electronicUnit);
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
ElectronicUnitInterface electronicUnit=new ElectronicUnit(4,"AC","Coolness",new AreaType("BedRoom"),true,true);
electronicUnitDAO.add(electronicUnit);
System.out.println("Electronic unit added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
ElectronicUnitInterface electronicUnit=new ElectronicUnit(5,"AC","Coolness",new AreaType("BathRoom"),true,true);
electronicUnitDAO.add(electronicUnit);
System.out.println("Electronic unit added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
ElectronicUnitInterface electronicUnit=new ElectronicUnit(6,"Tubelight","None",new AreaType("Hall"),true,false);
electronicUnitDAO.add(electronicUnit);
System.out.println("Electronic unit added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
ElectronicUnitInterface electronicUnit=new ElectronicUnit(7,"Fan","Speed",new AreaType("GuestRoom"),true,true);
electronicUnitDAO.add(electronicUnit);
System.out.println("Electronic unit added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
ElectronicUnitInterface electronicUnit=new ElectronicUnit(8,"Heater","Hotness",new AreaType("DrawingRoom"),true,true);
electronicUnitDAO.add(electronicUnit);
System.out.println("Electronic unit added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
ElectronicUnitInterface electronicUnit=new ElectronicUnit(9,"AC","Coolness",new AreaType("Dinning Room"),true,true);
electronicUnitDAO.add(electronicUnit);
System.out.println("Electronic unit added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
ElectronicUnitInterface electronicUnit=new ElectronicUnit(10,"Fan","Speed",new AreaType("Kitchen"),true,true);
electronicUnitDAO.add(electronicUnit);
System.out.println("Electronic unit added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
ElectronicUnitInterface electronicUnit=new ElectronicUnit(11,"CFL","None",new AreaType("BathRoom"),true,true);
electronicUnitDAO.add(electronicUnit);
System.out.println("Electronic unit added.");
}catch(DAOException daoException)
{
System.out.println(daoException);
}

}
}