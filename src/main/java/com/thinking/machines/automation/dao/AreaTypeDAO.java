package com.thinking.machines.automation.dao;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.interfaces.*;
import java.util.*;
import java.io.*;
import java.sql.*;
public class AreaTypeDAO implements AreaTypeDAOInterface
{
public void add(AreaTypeInterface areaType) throws DAOException
{
try
{
Class.forName("org.sqlite.JDBC");
Connection c;
c=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement ps;
ps=c.prepareStatement("insert into area_type values(?)");
ps.setString(1,areaType.getName());
ps.executeUpdate();
ps.close();
c.close();
}catch(SQLException sqlException)
{
System.out.println(sqlException);
}
catch(Exception exception)
{
System.out.println("AreaTypeDAO: void add(AreaTypeInterface) "+exception.getMessage());
throw new DAOException("Unable to add "+exception.getMessage());
}
}
public void remove(String name) throws DAOException
{
if(!(exists(name)))throw new DAOException("Invalid area type");
boolean removeAreaType=true;
Connection c=null;
PreparedStatement ps=null;
try
{
new ElectronicUnitDAO().getByAreaType(name);
removeAreaType=false;
System.out.println("hello");
throw new DAOException("Electronic unit exists against this area type:"+name);
}catch(DAOException daoException)
{
if(removeAreaType==false)
{
throw daoException;
}
}
try
{
Class.forName("org.sqlite.JDBC");

c=DriverManager.getConnection("jdbc:sqlite:homeauto.db");

ps=c.prepareStatement("delete from area_type where areatype=?");
ps.setString(1,name);
ps.executeUpdate();
ps.close();
c.close();
}catch(SQLException sqlException)
{
try
{
ps.close();
c.close();
}catch(SQLException sqlException1)
{
System.out.println(sqlException1);
}
System.out.println(sqlException);
}
catch(Exception exception)
{
System.out.println("AreaTypeDAO:void remove(String) "+exception.getMessage());
throw new DAOException("Unable to remove "+exception.getMessage());
}
}
public ArrayList<AreaTypeInterface> get() throws DAOException
{
ArrayList<AreaTypeInterface> areaTypes=new ArrayList<AreaTypeInterface>();
try
{
AreaTypeInterface areaType;
Class.forName("org.sqlite.JDBC");
Connection c;
c=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement ps;
ps=c.prepareStatement("select * from area_type");
ResultSet r;
r=ps.executeQuery();
while(r.next())
{
areaType=new AreaType(r.getString("areatype"));
areaTypes.add(areaType);
}
r.close();
ps.close();
c.close();
}catch(Exception exception)
{
System.out.println(exception);
}
if(areaTypes.size()==0)
{
//throw new DAOException("No records.");
}
return areaTypes;
}
public AreaTypeInterface get(String name) throws DAOException
{
if(!(exists(name))) throw new DAOException("Invalid area type.");
AreaTypeInterface areaType=null;
try
{
Class.forName("org.sqlite.JDBC");
Connection c;
c=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement ps;
ps=c.prepareStatement("select * from area_type where areatype=?");
ps.setString(1,name);
ResultSet r;
r=ps.executeQuery();
r.next();
areaType=new AreaType(r.getString("areatype"));
r.close();
ps.close();
c.close();
}catch(Exception exception)
{
System.out.println(exception);
}
return areaType;
}
public boolean exists(String name) throws DAOException
{
try
{
Class.forName("org.sqlite.JDBC");
Connection c;
c=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement ps;
ps=c.prepareStatement("select * from area_type where areatype=?");
ps.setString(1,name);
ResultSet r;
r=ps.executeQuery();
if(r.next())
{
r.close();
ps.close();
c.close();
return true;
}
r.close();
ps.close();
c.close();
}catch(Exception exception)
{
System.out.println(exception);
}
return false;
}
public long getCount() throws DAOException
{
long count=0;
try
{
Class.forName("org.sqlite.JDBC");
Connection c;
c=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement ps;
ps=c.prepareStatement("select * from area_type");
ResultSet r;
r=ps.executeQuery();
while(r.next())
{
count++;
}
}catch(Exception exception)
{
System.out.println("AreaTypeDAO:long getCounat()"+exception.getMessage());
}
return count;
}
}