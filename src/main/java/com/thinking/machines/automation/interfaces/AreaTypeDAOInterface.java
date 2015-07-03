package com.thinking.machines.automation.interfaces;
import com.thinking.machines.automation.exceptions.*;
import java.util.*;
public interface AreaTypeDAOInterface
{
public String FILE_NAME="AreaType.data";
public void add(AreaTypeInterface areaType) throws DAOException;
public void remove(String name) throws DAOException;
public ArrayList<AreaTypeInterface> get() throws DAOException;
public AreaTypeInterface get(String name) throws DAOException;
public boolean exists(String name) throws DAOException;
public long getCount() throws DAOException;
}