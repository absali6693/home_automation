package com.thinking.machines.automation.pl;
import java.awt.*;
import javax.swing.*;
public class LoginUI extends JFrame
{
private LoginPanel loginPanel;
private Container container;
public LoginUI()
{
setDefaultCloseOperation(EXIT_ON_CLOSE);
initComponents();
}
public void initComponents()
{
this.setTitle(GlobalResources.APPLICATION_TITLE);//+"("+GlobalResources.APPLICATION_USERNAME+")");
this.setIconImage(new ImageIcon(this.getClass().getResource(GlobalResources.APPLICATION_ICON)).getImage());
this.loginPanel=new LoginPanel();
this.container=getContentPane();
this.container.setLayout(null);
this.loginPanel.setBounds(10,10,this.loginPanel.getSize().width,this.loginPanel.getSize().height);
this.container.add(this.loginPanel);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
this.setSize(this.loginPanel.getSize().width+40,this.loginPanel.getSize().height+60);
this.setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
this.setVisible(true);
}
public static void main(String gg[])
{
LoginUI loginUI=new LoginUI();
}

}