package com.thinking.machines.automation.interfaces;
import com.thinking.machines.automation.exceptions.*;
public interface AdministratorDAOInterface
{
public String FILE_NAME="administrator.data";
public void set(AdministratorInterface administrator)throws DAOException;
public void set(AdministratorInterface administrator,String username,String password)throws DAOException;
public void remove(String username,String password) throws DAOException;
public AdministratorInterface get(String username) throws DAOException;
public boolean isAdministratorSet() throws DAOException;
public AdministratorInterface get() throws DAOException;
}