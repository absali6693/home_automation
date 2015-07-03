package com.thinking.machines.automation.dao;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.interfaces.*;
import java.io.*;
public class AdministratorDAO implements AdministratorDAOInterface
{
public void set(AdministratorInterface administrator)throws DAOException
{
try
{
File file=new File(FILE_NAME);
file.delete();
File file1=new File(FILE_NAME);
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
/*if(randomAccessFile.length()>0)
{
randomAccessFile.close();
throw new DAOException("Cannot add asministrator without authencation.");
}*/
randomAccessFile.writeBytes(encrypt(administrator.getUsername())+"\n");
randomAccessFile.writeBytes(encrypt(administrator.getPassword())+"\n");
randomAccessFile.writeBytes(encrypt(administrator.getHintQuestion())+"\n");
randomAccessFile.writeBytes(encrypt(administrator.getHintAnswer())+"\n");
randomAccessFile.close();
}catch(IOException ioException)
{
System.out.println("AdministratorDAO:void set(AdministratorInterface administrator) "+ioException.getMessage());
throw new DAOException("Unable to set:"+ioException.getMessage());
}
catch(Exception exception)
{
System.out.println("AdministratorDAO:void set(AdministratorInterface administrator) "+exception.getMessage());
throw new DAOException("Unable to set:"+exception.getMessage());
}
}
public void set(AdministratorInterface administrator,String username,String password)throws DAOException
{
try
{
AdministratorInterface vAdministrator=get(username);
if(vAdministrator.getPassword().equals(password)==false)
{
throw new DAOException("Invalid username/password");
}
}catch(DAOException daoException)
{
throw daoException;
}
try
{
File file=new File(FILE_NAME);
file.delete();
}catch(Exception exception)
{
System.out.println("AdministratorDAO:void set(AdministratorInterface administrator,String username,String password) "+exception.getMessage());
}
}
public void remove(String username,String password) throws DAOException
{
try
{
AdministratorInterface vAdministrator=get(username);
if(vAdministrator.getPassword().equals(password)==false)
{
throw new DAOException("Invalid username/password");
}
}catch(DAOException daoException)
{
throw daoException;
}
try
{
File file=new File(FILE_NAME);
file.delete();
}catch(Exception exception)
{
System.out.println("AdministratorDAO:void set(AdministratorInterface administrator,String username,String password) "+exception.getMessage());
}
//set(administrator);

}
public AdministratorInterface get(String username) throws DAOException
{
AdministratorInterface administrator=null;
try
{
File file=new File(FILE_NAME);
if(file.exists())
{
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()>0)
{
String vUsername;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vUsername=decrypt(randomAccessFile.readLine());
if(vUsername.equals(username))
{
administrator=new Administrator();
administrator.setUsername(vUsername);
administrator.setPassword(decrypt(randomAccessFile.readLine()));
administrator.setHintQuestion(decrypt(randomAccessFile.readLine()));
administrator.setHintAnswer(decrypt(randomAccessFile.readLine()));
break;
}
randomAccessFile.readLine();
randomAccessFile.readLine();
randomAccessFile.readLine();
}
}
randomAccessFile.close();
} 
}catch(IOException ioException)
{
System.out.println("AdminidtratorDAO:AdministratorInterface get() "+ioException.getMessage());
throw new DAOException("Unable to get:"+ioException.getMessage());
}
catch(Exception exception)
{
System.out.println("AdminidtratorDAO:AdministratorInterface get() "+exception.getMessage());
throw new DAOException("Unable to get:"+exception.getMessage());
}
if(administrator==null)
{
throw new DAOException("Invalid username.");
}
return administrator;
}
private String encrypt(String data)
{
return data;
}
private String decrypt(String data)
{
return data;
}
public boolean isAdministratorSet() throws DAOException
{
File file=new File(FILE_NAME);
if(file.exists()==false)
{
return false;
}
else
{
try
{
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()>0) 
{
return true;
}
else 
{
return false;
}
}catch(IOException ioException)
{
System.out.println("AdminidtratorDAO:boolean isAdministratorSet()"+ioException.getMessage());
throw new DAOException(ioException.getMessage());
}
}
}

public AdministratorInterface get() throws DAOException
{
AdministratorInterface administrator=null;
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
administrator=new Administrator();
administrator.setUsername(decrypt(randomAccessFile.readLine()));
administrator.setPassword(decrypt(randomAccessFile.readLine()));
administrator.setHintQuestion(decrypt(randomAccessFile.readLine()));
administrator.setHintAnswer(decrypt(randomAccessFile.readLine()));
break;
}
randomAccessFile.readLine();
randomAccessFile.readLine();
randomAccessFile.readLine();
}
randomAccessFile.close(); 
}
}catch(IOException ioException)
{
System.out.println("AdminidtratorDAO:AdministratorInterface get() "+ioException.getMessage());
throw new DAOException("Unable to get:"+ioException.getMessage());
}
catch(Exception exception)
{
System.out.println("AdminidtratorDAO:AdministratorInterface get() "+exception.getMessage());
throw new DAOException("Unable to get:"+exception.getMessage());
}
if(administrator==null)
{
throw new DAOException("Invalid username.");
}
return administrator;
}


}