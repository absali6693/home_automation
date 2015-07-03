package com.thinking.machines.automation.interfaces;
import com.thinking.machines.automation.exceptions.*;
import java.util.*;
public interface ElectronicUnitDAOInterface
{
public String FILE_NAME="ElectronicUnit.data";
public void add(ElectronicUnitInterface electronicUnit) throws  DAOException;
public void update(ElectronicUnitInterface electronicUnit) throws  DAOException;
public void remove(int code) throws  DAOException;
public ArrayList<ElectronicUnitInterface> get() throws  DAOException;
public ElectronicUnitInterface get(int code) throws  DAOException;
public boolean exists(int code) throws  DAOException;
public int getCount() throws  DAOException;
public int getNextCode() throws  DAOException;
public ArrayList<ElectronicUnitInterface> getByAreaType(String name) throws DAOException;
}