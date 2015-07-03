package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
public class ElectronicUnitGetByCodeTestCase 
{
public static void main(String gg[])
{
try
{
ElectronicUnitInterface electronicUnit=new ElectronicUnit();
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
electronicUnit=electronicUnitDAO.get(456);
System.out.println(electronicUnit.getName());
System.out.println(electronicUnit.getControlName());
System.out.println(electronicUnit.getAreaType().getName());
System.out.println(electronicUnit.isSwitchable());
System.out.println(electronicUnit.isControllable());
}catch(DAOException daoException)
{
System.out.println(daoException);
}

try
{
ElectronicUnitInterface electronicUnit=new ElectronicUnit();
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
electronicUnit=electronicUnitDAO.get(21);
System.out.println(electronicUnit.getName());
System.out.println(electronicUnit.getControlName());
System.out.println(electronicUnit.getAreaType().getName());
System.out.println(electronicUnit.isSwitchable());
System.out.println(electronicUnit.isControllable());
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}