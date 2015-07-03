package com.thinking.machines.automation.main;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.pl.*;
import javax.swing.*;
public class Main
{
//public static void main(String gg[])
Main()
{
try
{
AdministratorDAOInterface administratorDAO=new AdministratorDAO();
if(administratorDAO.isAdministratorSet())
{
LoginUI loginUI=new LoginUI();
}
else
{
AdministratorUI administratorUI=new AdministratorUI();
}
}catch(DAOException daoException)
{
JOptionPane.showMessageDialog(null,daoException.getMessage());
}
}
}