package com.thinking.machines.automation.testcases;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
import java.util.*;
public class AreaTypeGetTestCase
{
public static void main(String gg[])
{
try
{
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
ArrayList<AreaTypeInterface> areaTypes;
areaTypes=areaTypeDAO.get();
int i;
for(i=0;i<areaTypes.size();i++)
{
System.out.println(areaTypes.get(i).getName());
}
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}