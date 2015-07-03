package com.thinking.machines.automation.pl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
public class AreaTypeUI extends JFrame
{
private AreaTypePanel areaTypePanel;
private Container container;
AreaTypeUI()
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


this.areaTypePanel=new AreaTypePanel();
this.container=getContentPane();
this.container.setLayout(null);
this.areaTypePanel.setBounds(10,10,this.areaTypePanel.getSize().width,this.areaTypePanel.getSize().height);
this.container.add(this.areaTypePanel);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
this.setSize(this.areaTypePanel.getSize().width+40,this.areaTypePanel.getSize().height+60);
this.setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
this.setVisible(true);
}
public static void main(String gg[])
{
AreaTypeUI areaTypeUI=new AreaTypeUI();
}
}