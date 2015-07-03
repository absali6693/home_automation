package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
import java.util.*;
public class ElectronicUnitGetTestCase
{
public static void main(String gg[])
{
try
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
ArrayList<ElectronicUnitInterface> electronicUnits;
electronicUnits=electronicUnitDAO.get();
int i;
for(i=0;i<electronicUnits.size();i++)
{
System.out.println(electronicUnits.get(i).getCode());
System.out.println(electronicUnits.get(i).getName());
System.out.println(electronicUnits.get(i).getControlName());
System.out.println(electronicUnits.get(i).getAreaType().getName());
System.out.println(electronicUnits.get(i).isSwitchable());
System.out.println(electronicUnits.get(i).isControllable());
}
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}