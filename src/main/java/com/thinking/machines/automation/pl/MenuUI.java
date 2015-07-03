package com.thinking.machines.automation.pl;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
public class MenuUI extends JFrame
{
private MenuPanel menuPanel;
private Container container;
public MenuUI()
{
setDefaultCloseOperation(EXIT_ON_CLOSE);
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

/*
addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent ev)
{
LoginUI loginUI=new LoginUI();
}
});
*/

this.menuPanel=new MenuPanel();
this.container=getContentPane();
this.container.setLayout(null);
this.menuPanel.setBounds(10,10,this.menuPanel.getSize().width,this.menuPanel.getSize().height);
this.container.add(this.menuPanel);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
this.setSize(this.menuPanel.getSize().width+40,this.menuPanel.getSize().height+60);
this.setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
this.setVisible(true);
}
public static void main(String gg[])
{
MenuUI menuUI=new MenuUI();
}

}