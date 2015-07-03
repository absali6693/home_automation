package com.thinking.machines.automation.pl;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.model.*;
import com.thinking.machines.automation.components.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//import com.thinking.machines.automation.pl.*;
public class MenuPanel extends JPanel implements ActionListener
{
private JMenuBar menuBar;
private JMenu masterMenu;
private JMenu utilityMenu;
private JMenu exitMenu;
private JMenuItem areaTypeMenuItem;
private JMenuItem electronicUnitMenuItem;
private JMenuItem editAdministratorInformationMenuItem;
private JMenuItem backUpMenuItem;
private JMenuItem restoreMenuItem;
private JMenuItem exitMenuItem;

private int count;

public MenuPanel()
{
initComponents();
}
public void initComponents()
{
this.menuBar=new JMenuBar();

this.masterMenu=new JMenu("Master");
this.utilityMenu=new JMenu("Utility");
this.exitMenu=new JMenu("Exit");

this.areaTypeMenuItem=new JMenuItem("Area Type");
this.electronicUnitMenuItem=new JMenuItem("Electronic Unit");
this.editAdministratorInformationMenuItem=new JMenuItem("Edit Administrator Information");
this.backUpMenuItem=new JMenuItem("Back-up");
this.restoreMenuItem=new JMenuItem("Restore");
this.exitMenuItem=new JMenuItem("Exit");

this.masterMenu.add(this.areaTypeMenuItem);

AreaTypeModel areaTypeModel=new AreaTypeModel();
count=areaTypeModel.getRowCount();

this.masterMenu.add(this.electronicUnitMenuItem);
this.masterMenu.add(this.editAdministratorInformationMenuItem);

if(count==0)
{
this.electronicUnitMenuItem.setEnabled(false);
}

this.utilityMenu.add(this.backUpMenuItem);
this.utilityMenu.add(this.restoreMenuItem);

this.exitMenu.add(this.exitMenuItem);

this.menuBar.add(this.masterMenu);
this.menuBar.add(this.utilityMenu);
this.menuBar.add(this.exitMenu);

this.setLayout(new BorderLayout());
this.add(menuBar,BorderLayout.NORTH);

this.addListeners();
this.setBorder(BorderFactory.createLineBorder(Color.black));
}
public void addListeners()
{
this.areaTypeMenuItem.addActionListener(this);
this.electronicUnitMenuItem.addActionListener(this);
this.editAdministratorInformationMenuItem.addActionListener(this);
this.backUpMenuItem.addActionListener(this);
this.restoreMenuItem.addActionListener(this);
this.exitMenuItem.addActionListener(this);
}
public void actionPerformed(ActionEvent event)
{
if(event.getSource()==this.areaTypeMenuItem)
{
SwingUtilities.getWindowAncestor(this).dispose();
AreaTypeUI areaTypeUI=new AreaTypeUI();
}
if(event.getSource()==this.electronicUnitMenuItem)
{
SwingUtilities.getWindowAncestor(this).dispose();
ElectronicUnitUI electronicUnitUI=new ElectronicUnitUI();
}
if(event.getSource()==this.editAdministratorInformationMenuItem)
{
SwingUtilities.getWindowAncestor(this).dispose();
EditAdministratorInformationUI editAdministratorInformationUI=new EditAdministratorInformationUI();
}
if(event.getSource()==this.backUpMenuItem)
{
SwingUtilities.getWindowAncestor(this).dispose();
BackupDataUI backupDataUI=new BackupDataUI();
}
if(event.getSource()==this.restoreMenuItem)
{
SwingUtilities.getWindowAncestor(this).dispose();
RestoreDataUI restoreDataUI=new RestoreDataUI();
}
if(event.getSource()==this.exitMenuItem)
{
//SwingUtilities.getWindowAncestor(this).dispose();
System.exit(0);
}
}
public Dimension getSize()
{
return new Dimension(550,400);
}
}