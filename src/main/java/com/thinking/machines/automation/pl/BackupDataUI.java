package com.thinking.machines.automation.pl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
public class BackupDataUI extends JFrame
{
private BackupDataPanel backupDataPanel;
private Container container;
BackupDataUI()
{
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
this.backupDataPanel=new BackupDataPanel();
this.container=getContentPane();
this.container.setLayout(null);
this.backupDataPanel.setBounds(10,10,this.backupDataPanel.getSize().width,this.backupDataPanel.getSize().height);
this.container.add(this.backupDataPanel);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
this.setSize(this.backupDataPanel.getSize().width+40,this.backupDataPanel.getSize().height+60);
this.setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
this.setVisible(true);

addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent ev)
{
MenuUI menuUI=new MenuUI();
}
});


}
public static void main(String gg[])
{
BackupDataUI backupDataUI=new BackupDataUI();
}

}