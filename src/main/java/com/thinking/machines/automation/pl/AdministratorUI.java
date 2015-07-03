package com.thinking.machines.automation.pl;
import java.awt.*;
import javax.swing.*;
public class AdministratorUI extends JFrame
{
private AdministratorPanel administratorPanel;
private Container container;
public AdministratorUI()
{
setDefaultCloseOperation(EXIT_ON_CLOSE);
initComponents();
}
public void initComponents()
{
this.setTitle(GlobalResources.APPLICATION_TITLE+"("+GlobalResources.APPLICATION_USERNAME+")");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.APPLICATION_ICON)).getImage());
this.administratorPanel=new AdministratorPanel();
this.container=getContentPane();
this.container.setLayout(null);
this.administratorPanel.setBounds(10,10,this.administratorPanel.getSize().width,this.administratorPanel.getSize().height);
this.container.add(this.administratorPanel);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
this.setSize(this.administratorPanel.getSize().width+40,this.administratorPanel.getSize().height+60);
this.setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
this.setVisible(true);
}
public static void main(String gg[])
{
AdministratorUI administratorUI=new AdministratorUI();
}

}