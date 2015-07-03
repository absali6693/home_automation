package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
import java.util.*;
public class hello
{
public static void main(String gg[])
{
try
{
ArrayList<ElectronicUnitInterface> electronicUnits;
ElectronicUnitDAOInterface electronicUnitDAO=new ElectronicUnitDAO();
electronicUnits=electronicUnitDAO.getByAreaType("Kitchen");
System.out.println("size"+electronicUnits.size());
for(int x=0;x<electronicUnits.size();x++)
{
System.out.println("code"+electronicUnits.get(x).getCode());
System.out.println("Name"+electronicUnits.get(x).getName());
System.out.println("Control name"+electronicUnits.get(x).getControlName());
System.out.println("Area type"+electronicUnits.get(x).getAreaType().getName());
System.out.println("switchable"+electronicUnits.get(x).isSwitchable());
System.out.println("controllable"+electronicUnits.get(x).isControllable());
}
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}