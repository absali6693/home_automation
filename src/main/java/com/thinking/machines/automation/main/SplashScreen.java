package com.thinking.machines.automation.main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.pl.*;
import com.thinking.machines.automation.main.*;

interface Progressable
{
public void updateProgressBar(int e);
}

class SomeInitialTask extends Thread
{
private Progressable target;
SomeInitialTask(Progressable target)
{
this.target=target;
}
public void run()
{
for(int x=0;x<=50;x++)
{
try
{
Thread.sleep(150);
target.updateProgressBar(x);
}catch(InterruptedException e)
{
}
}
}
}

class SplashScreen1 extends JWindow implements Progressable
{
private JLabel label;
private JProgressBar pb;
SplashScreen1()
{
setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
label=new JLabel(new ImageIcon(this.getClass().getResource(GlobalResources.SPLASH_SCREEN)));
label.setBounds(0,0,600,650);
pb=new JProgressBar();
pb.setMinimum(0);
pb.setMaximum(50);
pb.setBounds(100,558,400,5);
pb.setStringPainted(false);

Container c=getContentPane();
c.setLayout(null);

c.add(pb);


c.add(label);
/*try{
setComponentZOrder(label,1);
setComponentZOrder(pb,3);
}catch(Exception e)
{
System.out.println("Abbas");
}*/
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
this.setSize(600,650);
this.setLocation(d.width/2-this.getWidth()/2,d.height/2-this.getHeight()/2);
this.setVisible(true);

}
public void updateProgressBar(int e)
{
pb.setValue(e);

//pb.setString((e*100/50)+"%");
}
}

class SplashScreen
{
public static void main(String gg[])
{
SplashScreen1 s=new SplashScreen1();
SomeInitialTask someInitialTask =new SomeInitialTask(s); 
s.setVisible(true);
someInitialTask.start();
try
{
someInitialTask.join();

}catch(InterruptedException e)
{
System.out.println(e);
}
/*try
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
}*/
s.dispose();
Main main = new Main();
}
}