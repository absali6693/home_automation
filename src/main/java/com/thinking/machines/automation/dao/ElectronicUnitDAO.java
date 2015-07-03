package com.thinking.machines.automation.dao;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.interfaces.*;
import java.sql.*;
import java.util.*;
import java.io.*;
public class ElectronicUnitDAO implements ElectronicUnitDAOInterface
{
public void add(ElectronicUnitInterface electronicUnit) throws  DAOException
{

try
{
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
if(!(areaTypeDAO.exists(electronicUnit.getAreaType().getName()))) throw new DAOException("Area type "+electronicUnit.getAreaType().getName()+"does not exists.");
if(exists(electronicUnit.getCode())) throw new DAOException("Code:"+electronicUnit.getCode()+"already exists.");
Class.forName("org.sqlite.JDBC");
Connection connection;
connection=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("insert into electronic_unit values(?,?,?,?,?,?)");
preparedStatement.setInt(1,electronicUnit.getCode());
preparedStatement.setString(2,electronicUnit.getName());
preparedStatement.setString(3,electronicUnit.getControlName());
if(electronicUnit.isSwitchable())
{
preparedStatement.setString(4,"Y");
}
else preparedStatement.setString(4,"N");

if(electronicUnit.isControllable())
{
preparedStatement.setString(5,"Y");
}
else preparedStatement.setString(5,"N");

preparedStatement.setString(6,electronicUnit.getAreaType().getName());
preparedStatement.executeUpdate();
preparedStatement.close();
connection .close();
}catch(SQLException sqlException)
{
System.out.println("ElectronicUnitDAO:void add(ElectronicUnitInterface)"+sqlException.getMessage());//remove after testing
throw new DAOException("Unable to add"+sqlException.getMessage());
}
catch(Exception exception)
{
System.out.println("ElectronicUnitDAO:void add(ElectronicUnitInterface)"+exception.getMessage());//remove after testing
throw new DAOException("Unable to add"+exception.getMessage());
}






/*
int code;
try
{
AreaTypeDAO areaTypeDAO=new AreaTypeDAO();
if(!(areaTypeDAO.exists(electronicUnit.getAreaType().getName()))) throw new DAOException("Area type "+electronicUnit.getAreaType().getName()+"does not exists.");
if(exists(electronicUnit.getCode())) throw new DAOException("Code:"+electronicUnit.getCode()+"already exists.");
File file=new File(FILE_NAME);
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
randomAccessFile.seek(randomAccessFile.length());
randomAccessFile.writeBytes(electronicUnit.getCode()+"\n");
randomAccessFile.writeBytes(electronicUnit.getName()+"\n");
randomAccessFile.writeBytes(electronicUnit.getControlName()+"\n");
randomAccessFile.writeBytes(electronicUnit.getAreaType().getName()+"\n");
randomAccessFile.writeBytes(electronicUnit.isSwitchable()+"\n");
randomAccessFile.writeBytes(electronicUnit.isControllable()+"\n");
randomAccessFile.close();
}catch(IOException ioException)
{
System.out.println("ElectronicUnitDAO:void add(ElectronicUnitInterface)"+ioException.getMessage());//remove after testing
throw new DAOException("Unable to add"+ioException.getMessage());
}
catch(Exception exception)
{
System.out.println("ElectronicUnitDAO:void add(ElectronicUnitInterface)"+exception.getMessage());//remove after testing
throw new DAOException("Unable to add"+exception.getMessage());
}*/






}

public void update(ElectronicUnitInterface electronicUnit) throws  DAOException
{

if(!(exists(electronicUnit.getCode())))throw new DAOException("Invalid electronic unit.");
try
{
Class.forName("org.sqlite.JDBC");
Connection connection;
connection=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("update electronic_unit set name=?,control_name=?,is_switchable=?,is_controllable=?,area_type=? where code=?");
preparedStatement.setString(1,electronicUnit.getName());
preparedStatement.setString(2,electronicUnit.getControlName());

if(electronicUnit.isSwitchable())
{
preparedStatement.setString(3,"Y");
}
else preparedStatement.setString(3,"N");

if(electronicUnit.isControllable())
{
preparedStatement.setString(4,"Y");
}
else preparedStatement.setString(4,"N");

preparedStatement.setString(5,electronicUnit.getAreaType().getName());
preparedStatement.setInt(6,electronicUnit.getCode());
preparedStatement.executeUpdate();
preparedStatement.close();
connection .close();
}catch(SQLException sqlException)
{
System.out.println("AreaTypeDAO:void update(ElectronicUnitInterface)"+sqlException.getMessage());//remove after testing
}
catch(Exception exception)
{
System.out.println("AreaTypeDAO:void update(ElectronicUnitInterface)"+exception.getMessage());//remove after testing
}










/*if(!(exists(electronicUnit.getCode())))throw new DAOException("Invalid electronic unit.");
try
{
ArrayList<ElectronicUnitInterface> electronicUnits=get();
File file=new File(FILE_NAME);
file.delete();
RandomAccessFile randomAccessFile=new RandomAccessFile(new File(FILE_NAME),"rw");
int x=0;
while(x<electronicUnits.size())
{
if(electronicUnits.get(x).getCode()!=electronicUnit.getCode())
{
randomAccessFile.writeBytes(electronicUnits.get(x).getCode()+"\n");
randomAccessFile.writeBytes(electronicUnits.get(x).getName()+"\n");
randomAccessFile.writeBytes(electronicUnits.get(x).getControlName()+"\n");
randomAccessFile.writeBytes(electronicUnits.get(x).getAreaType().getName()+"\n");
randomAccessFile.writeBytes(electronicUnits.get(x).isSwitchable()+"\n");
randomAccessFile.writeBytes(electronicUnits.get(x).isControllable()+"\n");
}
else
{
randomAccessFile.writeBytes(electronicUnit.getCode()+"\n");
randomAccessFile.writeBytes(electronicUnit.getName()+"\n");
randomAccessFile.writeBytes(electronicUnit.getControlName()+"\n");
randomAccessFile.writeBytes(electronicUnit.getAreaType().getName()+"\n");
randomAccessFile.writeBytes(electronicUnit.isSwitchable()+"\n");
randomAccessFile.writeBytes(electronicUnit.isControllable()+"\n");
}
x++;
}
randomAccessFile.close();
}catch(IOException ioException)
{
System.out.println("AreaTypeDAO:void update(ElectronicUnitInterface)"+ioException.getMessage());//remove after testing
}
catch(Exception exception)
{
System.out.println("AreaTypeDAO:void update(ElectronicUnitInterface)"+exception.getMessage());//remove after testing
}*/
}

public void remove(int code) throws  DAOException
{
if(!(exists(code)))throw new DAOException("Invalid electronic unit.");
try
{
Class.forName("org.sqlite.JDBC");
Connection connection;
connection=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement prepareStatement;
prepareStatement=connection.prepareStatement("delete from electronic_unit where code="+code);
prepareStatement.executeUpdate();
prepareStatement.close();
connection .close();
}catch(SQLException sqlException)
{
System.out.println("AreaTypeDAO:void update(ElectronicUnitInterface)"+sqlException.getMessage());//remove after testing
}
catch(Exception exception)
{
System.out.println("AreaTypeDAO:void update(ElectronicUnitInterface)"+exception.getMessage());//remove after testing
}












/*if(!(exists(code)))throw new DAOException("Invalid electronic unit.");
try
{
ArrayList<ElectronicUnitInterface> electronicUnits=get();
File file=new File(FILE_NAME);
file.delete();
RandomAccessFile randomAccessFile=new RandomAccessFile(new File(FILE_NAME),"rw");
int x=0;
while(x<electronicUnits.size())
{
if(electronicUnits.get(x).getCode()!=code)
{
randomAccessFile.writeBytes(electronicUnits.get(x).getCode()+"\n");
randomAccessFile.writeBytes(electronicUnits.get(x).getName()+"\n");
randomAccessFile.writeBytes(electronicUnits.get(x).getControlName()+"\n");
randomAccessFile.writeBytes(electronicUnits.get(x).getAreaType().getName()+"\n");
randomAccessFile.writeBytes(electronicUnits.get(x).isSwitchable()+"\n");
randomAccessFile.writeBytes(electronicUnits.get(x).isControllable()+"\n");
}
x++;
}
randomAccessFile.close();
}catch(IOException ioException)
{
System.out.println("AreaTypeDAO:void remove(String)"+ioException.getMessage());//remove after testing
}
catch(Exception exception)
{
System.out.println("AreaTypeDAO:void remove(String)"+exception.getMessage());//remove after testing
}*/
}

public ArrayList<ElectronicUnitInterface> get() throws  DAOException
{
ArrayList<ElectronicUnitInterface> electronicUnits=new ArrayList<ElectronicUnitInterface>();
int vCode=0;
String vName=null;
String vControlName=null;
boolean vIsSwitchable=false;
boolean vIsControllable=false;
AreaType vAreaType=null;
ElectronicUnitInterface electronicUnit=null;
try
{
Class.forName("org.sqlite.JDBC");
Connection connection;
connection=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from electronic_unit");
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
while(resultSet.next())
{
vCode=resultSet.getInt("code");
vName=resultSet.getString("name").trim();
if(resultSet.getString("is_switchable").trim().equals("Y")) vIsSwitchable=true;
else vIsSwitchable=false;
if(resultSet.getString("is_controllable").trim().equals("Y"))
{
vControlName=resultSet.getString("control_name").trim();
 vIsControllable=true;
}
else vIsControllable=false;
vAreaType=new AreaType(resultSet.getString("area_type").trim());
electronicUnit=new ElectronicUnit(vCode,vName,vControlName,vAreaType,vIsSwitchable,vIsControllable);
electronicUnits.add(electronicUnit);
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
System.out.println("ElectronicUnitDAO:ArrayList<ElectronicUnitInterfaces>()"+sqlException.getMessage());
}
catch(Exception exception)
{
System.out.println("ElectronicUnitDAO:ArrayList<ElectronicUnitInterfaces> get()"+exception.getMessage());
}
if(electronicUnits.size()==0)
{
throw new DAOException("No records.");
}
return electronicUnits;








/*
ArrayList<ElectronicUnitInterface> electronicUnits=new ArrayList<ElectronicUnitInterface>();
try
{
File file=new File(FILE_NAME);
if(file.exists())
{
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()>0)
{
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
ElectronicUnitInterface electronicUnit=new ElectronicUnit();
electronicUnit.setCode(Integer.parseInt(randomAccessFile.readLine()));
electronicUnit.setName(randomAccessFile.readLine());
electronicUnit.setControlName(randomAccessFile.readLine());
electronicUnit.setAreaType(new AreaType(randomAccessFile.readLine()));
electronicUnit.setIsSwitchable(Boolean.parseBoolean(randomAccessFile.readLine()));
electronicUnit.setIsControllable(Boolean.parseBoolean(randomAccessFile.readLine()));
electronicUnits.add(electronicUnit);
}
}
randomAccessFile.close();
}
}catch(IOException ioException)
{
System.out.println("ElectronicUnitDAO:ArrayList<ElectronicUnitInterfaces>()"+ioException.getMessage());
}
catch(Exception exception)
{
System.out.println("ElectronicUnitDAO:ArrayList<ElectronicUnitInterfaces> get()"+exception.getMessage());
}
                          if(electronicUnits.size()==0)
                          {
                          throw new DAOException("No records.");
                          }
return electronicUnits;
*/
}

public ElectronicUnitInterface get(int code) throws  DAOException
{
int vCode=0;
String vName=null;
String vControlName=null;
boolean vIsSwitchable=false;
boolean vIsControllable=false;
AreaType vAreaType=null;
ElectronicUnitInterface electronicUnit=null;
try
{
Class.forName("org.sqlite.JDBC");
Connection connection;
connection=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from electronic_unit");
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
while(resultSet.next())
{
vCode=resultSet.getInt("code");
vName=resultSet.getString("name").trim();
if(resultSet.getString("is_switchable").trim()=="Y") vIsSwitchable=true;
if(resultSet.getString("is_controlable").trim()=="Y")
{
vControlName=resultSet.getString("control_name").trim();
 vIsControllable=true;
}
vAreaType=new AreaType(resultSet.getString("area_type").trim());
if(vCode==code)
{
resultSet.close();
preparedStatement.close();
connection.close();
electronicUnit=new ElectronicUnit(vCode,vName,vControlName,vAreaType,vIsSwitchable,vIsControllable);
break;
}
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
System.out.println("ElectronicUnitDAO:ArrayList<ElectronicUnitInterfaces>()"+sqlException.getMessage());
}
catch(Exception exception)
{
System.out.println("ElectronicUnitDAO:ArrayList<ElectronicUnitInterfaces> get()"+exception.getMessage());
}

return electronicUnit;
















/*
ArrayList<ElectronicUnitInterface> electronicUnits=new ArrayList<ElectronicUnitInterface>();
if(!(exists(code))) throw new DAOException("Invalid electronic unit.");
ElectronicUnitInterface electronicUnit=null;
try
{
File file=new File(FILE_NAME);
if(file.exists())
{
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()>0)
{
int vCode;
String vName;
String vControlName;
AreaTypeInterface vAreaType;
boolean vSwitchable;
boolean vControllable;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vCode=Integer.parseInt(randomAccessFile.readLine());
vName=randomAccessFile.readLine();
vControlName=randomAccessFile.readLine();
vAreaType=new AreaType(randomAccessFile.readLine());
vSwitchable=Boolean.parseBoolean(randomAccessFile.readLine());
vControllable=Boolean.parseBoolean(randomAccessFile.readLine());
if(vCode==code)
{
randomAccessFile.close();
electronicUnit=new ElectronicUnit(vCode,vName,vControlName,vAreaType,vSwitchable,vControllable);
break;
}
}
}
randomAccessFile.close();
}
}catch(IOException ioException)
{
System.out.println("ElectronicUnitDAO:ElectronicUnitInterface get(int code)"+ioException.getMessage());
throw new DAOException("Unable to get.");
}
catch(Exception exception)
{
System.out.println("ElectronicUnitDAO:ElectronicUnitInterface get(int code)"+exception.getMessage());
throw new DAOException("Unable to get.");
}
return electronicUnit;*/
}

public ArrayList<ElectronicUnitInterface> getByAreaType(String name) throws DAOException
{
AreaTypeDAOInterface areaTypeDAO=new AreaTypeDAO();
if(!areaTypeDAO.exists(name)) throw new DAOException("Invalid area type.");
ArrayList<ElectronicUnitInterface> electronicUnits=new ArrayList<ElectronicUnitInterface>();
ElectronicUnitInterface electronicUnit=null;
try
{
int vCode=0;
String vName=null;
String vControlName=null;
boolean vIsSwitchable=false;
boolean vIsControllable=false;
AreaType vAreaType=null;
Class.forName("org.sqlite.JDBC");
Connection connection;
connection=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from electronic_unit where area_type=?");
preparedStatement.setString(1,name);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
while(resultSet.next())
{
vCode=resultSet.getInt("code");
vName=resultSet.getString("name");
vIsSwitchable=((resultSet.getString("is_switchable").trim().equals("Y"))?true:false);
vIsControllable=((resultSet.getString("is_controllable").trim().equals("Y"))?true:false);
if(vIsControllable)
{
vControlName=resultSet.getString("control_name");
}
vAreaType=new AreaType(resultSet.getString("area_type"));
electronicUnit=new ElectronicUnit(vCode,vName,vControlName,vAreaType,vIsSwitchable,vIsControllable);
electronicUnits.add(electronicUnit);
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
System.out.println("ArrayList<ElectronicUnitUInterface> getByAreaType(String) "+sqlException.getMessage());
throw new DAOException("Unable to get.");
}
catch(Exception exception)
{
System.out.println("ArrayList<ElectronicUnitUInterface> getByAreaType(String) "+exception.getMessage());
throw new DAOException("Unable to get.");
}
if(electronicUnits.size()==0)
{
throw new DAOException("No records.");
}
return electronicUnits;



/*
ArrayList<ElectronicUnitInterface> electronicUnits=new ArrayList<ElectronicUnitInterface>();
try
{
File file=new File(FILE_NAME);
if(file.exists())
{
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()>0)
{
int vCode;
String vName;
String vControlName;
AreaTypeInterface vAreaType;
boolean vSwitchable;
boolean vControllable;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vCode=Integer.parseInt(randomAccessFile.readLine());
vName=randomAccessFile.readLine();
vControlName=randomAccessFile.readLine();
vAreaType=new AreaType(randomAccessFile.readLine());
vSwitchable=Boolean.parseBoolean(randomAccessFile.readLine());
vControllable=Boolean.parseBoolean(randomAccessFile.readLine());
if(vAreaType.getName().equalsIgnoreCase(name))
{
ElectronicUnitInterface electronicUnit=new ElectronicUnit(vCode,vName,vControlName,vAreaType,
vSwitchable,vControllable);
electronicUnits.add(electronicUnit);
}
}
}
randomAccessFile.close();
}
}catch(IOException ioException)
{
System.out.println("ElectronicUnitDAO:ElectronicUnitInterface get(String name)"+ioException.getMessage());
throw new DAOException("Unable to get.");
}
catch(Exception exception)
{
System.out.println("ElectronicUnitDAO:ElectronicUnitInterface get(String name)"+exception.getMessage());
throw new DAOException("Unable to get.");
}
if(electronicUnits.size()==0)
{
throw new DAOException();
}
return electronicUnits;
*/
}

public boolean exists(int code) throws  DAOException
{
try
{
int vCode=0;
Class.forName("org.sqlite.JDBC");
Connection connection;
connection=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from electronic_unit where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection .close();
return true;
}

while(resultSet.next())
{
vCode=resultSet.getInt("code");
if(vCode==code)
{
resultSet.close();
preparedStatement.close();
connection .close();
return true;
}
}
resultSet.close();
preparedStatement.close();
connection .close();
}catch(SQLException sqlException)
{
System.out.println("ElectronicUnitDAO:boolean exists(int)"+sqlException.getMessage());
}
catch(Exception exception)
{
System.out.println("ElectronicUnitDAO:boolean exists(int)"+exception.getMessage());
}
return false;


/*
try
{
File file=new File(FILE_NAME);
if(file.exists())
{
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()>0)
{
int vCode;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vCode=Integer.parseInt(randomAccessFile.readLine());
if(vCode==code)
{
randomAccessFile.close();
return true;
}
randomAccessFile.readLine();
randomAccessFile.readLine();
randomAccessFile.readLine();
randomAccessFile.readLine();
randomAccessFile.readLine();
}
}
randomAccessFile.close();
}
}catch(IOException ioException)
{
System.out.println("ElectronicUnitDAO:boolean exists(int)"+ioException.getMessage());
}
catch(Exception exception)
{
System.out.println("ElectronicUnitDAO:boolean exists(int)"+exception.getMessage());
}
return false;
*/
}

public int getCount() throws  DAOException
{
int count=0;
try
{
Class.forName("org.sqlite.JDBC");
Connection connection;
connection=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from electronic_unit");
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
while(resultSet.next())
{
count++;
}
resultSet.close();
preparedStatement.close();
connection .close();
}catch(SQLException sqlException)
{
System.out.println("ElectronicUnitDAO:boolean exists(int)"+sqlException.getMessage());
}
catch(Exception exception)
{
System.out.println("ElectronicUnitDAO:boolean exists(int)"+exception.getMessage());
}
return count;






/*
try
{
File file=new File(FILE_NAME);
if(file.exists())
{
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()>0)
{
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
randomAccessFile.readLine();
randomAccessFile.readLine();
randomAccessFile.readLine();
randomAccessFile.readLine();
randomAccessFile.readLine();
randomAccessFile.readLine();
count++;
}
}
randomAccessFile.close();
}
}catch(IOException ioException)
{
System.out.println("ElectronicUnitDAO:int getCount()"+ioException.getMessage());
}
catch(Exception exception)
{
System.out.println("ElectronicUnitDAO:int getCount()"+exception.getMessage());
}
return count;
*/
}

public int getNextCode() throws  DAOException
{
int nextCode=0;
try
{
Class.forName("org.sqlite.JDBC");
Connection connection;
connection=DriverManager.getConnection("jdbc:sqlite:homeauto.db");
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select max(code)+1 as code from electronic_unit");
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
resultSet.next();
nextCode=resultSet.getInt("mx");
resultSet.close();
preparedStatement.close();
connection .close();
}catch(SQLException sqlException)
{
System.out.println("ElectronicUnitDAO:boolean exists(int)"+sqlException.getMessage());
}
catch(Exception exception)
{
System.out.println("ElectronicUnitDAO:boolean exists(int)"+exception.getMessage());
}
return nextCode;



/*
int x=0;
ArrayList<ElectronicUnitInterface> electronicUnits=get();
while(x<electronicUnits.size())
{
if(electronicUnits.get(x).getCode()>count)
{
count=electronicUnits.get(x).getCode();
}
x++;
}
return ++count;
*/
}
}