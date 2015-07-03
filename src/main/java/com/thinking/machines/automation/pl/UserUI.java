package com.thinking.machines.automation.pl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
public class UserUI extends JFrame
{
private UserPanel uPanel;
private Container container;
UserUI()
{
//setDefaultCloseOperation(EXIT_ON_CLOSE);
initComponents();
}
public void initComponents()
{
AdministratorDAO administratorDAO=new AdministratorDAO();
AdministratorInterface administrator=null;
try
{
administrator=administratorDAO.get();
}catch(DAOException daoException)
{
System.out.println(daoException);
}
this.setTitle(GlobalResources.APPLICATION_TITLE+"("+administrator.getUsername()+")");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.APPLICATION_ICON)).getImage());

addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent ev)
{
MenuUI menuUI=new MenuUI();
}
});


this.uPanel=new UserPanel();
this.container=getContentPane();
this.container.setLayout(null);
this.uPanel.setBounds(10,10,this.uPanel.getSize().width,this.uPanel.getSize().height);
this.container.add(this.uPanel);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
this.setSize(this.uPanel.getSize().width+40,this.uPanel.getSize().height+60);
this.setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
this.setVisible(true);
}
public static void main(String gg[])
{
UserUI uUI=new UserUI();
}
}
