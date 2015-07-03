package com.thinking.machines.automation.model;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
import javax.swing.table.*;
import javax.swing.*;
import java.util.*;
public class AreaTypeModel extends AbstractTableModel
{
private ArrayList<AreaTypeInterface> areaTypes;
private String title[]={"S.No.","Area"};
public AreaTypeModel()
{
try
{
AreaTypeDAOInterface areaTypeDAO=new AreaTypeDAO();
areaTypes=areaTypeDAO.get();
}catch(DAOException daoException)
{
areaTypes=new ArrayList<AreaTypeInterface>();
}
}
public int getColumnCount()
{
return title.length;
}
public int getRowCount()
{
return areaTypes.size();
}
public String getColumnName(int c)
{
return title[c];
}
public Object getValueAt(int row,int col)
{
if(col==0)
{
return new Integer(row+1);
}
if(col==1)
{
return areaTypes.get(row).getName();
}
return null;
}
public Class getColumnClass(int c)
{
try
{
if(c==0) return Class.forName("java.lang.Integer");
if(c==1) return Class.forName("java.lang.String");
}catch(Exception e)
{
System.out.println("com.thinking.machines.automation.model.AreaTypeModel:Class getColumnClass(int)"+
e.getMessage());//remove after testing
}
return null;
}
public boolean isCellEditable(int row,int col)
{
return false;
}
public void add(AreaTypeInterface areaType) throws DAOException
{
AreaTypeDAOInterface areaTypeDAO=new AreaTypeDAO();
areaTypeDAO.add(areaType);
areaTypes=areaTypeDAO.get();
}
public void remove(String name) throws DAOException
{
AreaTypeDAOInterface areaTypeDAO=new AreaTypeDAO();
areaTypeDAO.remove(name);
try
{
areaTypes=areaTypeDAO.get();
}catch(DAOException daoException)
{
areaTypes=new ArrayList<AreaTypeInterface>();
}
}
public int getSize()
{
return areaTypes.size();
}
public boolean exists(String name) throws DAOException
{
AreaTypeDAOInterface areaTypeDAO=new AreaTypeDAO();
return areaTypeDAO.exists(name);
}
public int getIndexOf(String name) throws DAOException
{
int i=0;
while(i<areaTypes.size())
{
if(areaTypes.get(i).getName().equalsIgnoreCase(name))
{
return i;
}
i++;
}
throw new DAOException("Invalid area type.");
}
public AreaTypeInterface getAreaTypeAt(int index) throws DAOException
{
if(index<0 || index>=areaTypes.size()) throw new DAOException();
return areaTypes.get(index);
}
}