package com.thinking.machines.automation.model;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
import javax.swing.table.*;
import javax.swing.*;
import java.util.*;
public class ElectronicUnitModel extends AbstractTableModel
{
private ArrayList<ElectronicUnitInterface> electronicUnits;
private String title[]={"S.No.","Code","Electronic unit","Area type","Control name","Switchable","Controllable"};
private String areaTypeName;
public ElectronicUnitModel()
{
setAreaType(null);
/*
try
{
ElectronicUnitDAOInterface electronicUnitDAO=new ElectronicUnitDAO();
electronicUnits=electronicUnitDAO.get();
}catch(DAOException daoException)
{
electronicUnits=new ArrayList<ElectronicUnitInterface>();
}
*/
}
public int getColumnCount()
{
return 4;
//return title.length;
}
public int getRowCount()
{
return electronicUnits.size();
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
return electronicUnits.get(row).getCode();
}
if(col==2)
{
return electronicUnits.get(row).getName();
}
if(col==3)
{
return electronicUnits.get(row).getAreaType().getName();
}
if(col==4)
{
return electronicUnits.get(row).getControlName();
}
/*
if(col==5)
{
return electronicUnits.get(row).isSwitchable();
}
if(col==6)
{
return electronicUnits.get(row).isControllable();
}
*/
return null;
}
public Class getColumnClass(int c)
{
try
{
if(c==0) return Class.forName("java.lang.Integer");
if(c==1) return Class.forName("java.lang.Integer");
if(c==2) return Class.forName("java.lang.String");
if(c==3) return Class.forName("java.lang.String");
if(c==4) return Class.forName("java.lang.String");
if(c==5) return Class.forName("java.lang.Boolean");
if(c==6) return Class.forName("java.lang.Boolean");
}catch(Exception e)
{
System.out.println("com.thinking.machines.automation.model.ElectronicUnitModel:Class getColumnClass(int)"+
e.getMessage());//remove after testing
}
return null;
}
public boolean isCellEditable(int row,int col)
{
return false;
}
public void add(ElectronicUnitInterface electronicUnit) throws DAOException
{
ElectronicUnitDAOInterface electronicUnitDAO=new ElectronicUnitDAO();
electronicUnitDAO.add(electronicUnit);
electronicUnits=electronicUnitDAO.get();
}
public void remove(int code) throws DAOException
{
ElectronicUnitDAO electronicUnitDAO=new ElectronicUnitDAO();
electronicUnitDAO.remove(code);
try
{
electronicUnits=electronicUnitDAO.get();
}catch(DAOException daoException)
{
electronicUnits=new ArrayList<ElectronicUnitInterface>();
}
}
public void update(ElectronicUnitInterface electronicUnit) throws DAOException
{
ElectronicUnitDAOInterface electronicUnitDAO=new ElectronicUnitDAO();
electronicUnitDAO.update(electronicUnit);
electronicUnits=electronicUnitDAO.get();
}
public int getSize()
{
return electronicUnits.size();
}
public boolean exists(int code) throws DAOException
{
ElectronicUnitDAOInterface electronicUnitDAO=new ElectronicUnitDAO();
return electronicUnitDAO.exists(code);
}
public int getIndexOf(String name) throws DAOException
{
int i=0;
while(i<electronicUnits.size())
{
if(electronicUnits.get(i).getName().equalsIgnoreCase(name))
{
return i;
}
i++;
}
throw new DAOException("Invalid area type.");
}
public ElectronicUnitInterface getElectronicUnitAt(int index) throws DAOException
{
if(index<0 || index>=electronicUnits.size()) throw new DAOException();
return electronicUnits.get(index);
}
public void setAreaType(String areaTypeName)
{
ElectronicUnitDAOInterface electronicUnitDAO;
electronicUnitDAO=new ElectronicUnitDAO();
this.areaTypeName=areaTypeName;
if(areaTypeName==null)
{
try
{
electronicUnits=electronicUnitDAO.get();
}catch(DAOException daoException)
{
electronicUnits=new ArrayList<ElectronicUnitInterface>();
}
}
else
{
try
{
electronicUnits=electronicUnitDAO.getByAreaType(this.areaTypeName);
}catch(DAOException daoException)
{
electronicUnits=new ArrayList<ElectronicUnitInterface>();
}
}
}
}