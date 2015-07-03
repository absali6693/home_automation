package com.thinking.machines.automation.pl;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.components.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.model.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.table.*;


public class UserPanel extends JPanel //implements ActionListener,ItemListener,DocumentListener,ListSelectionListener
{

private JLabel headingLabel;
private JButton helpButton;
private JLabel areaTypeLabel;
private JLabel electronicUnitLabel;

private Choice areaType; 
private Choice electronicUnit;

private AreaTypeDAOInterface areaTypeDAO;
private ArrayList<AreaTypeInterface> areaTypes;

private ElectronicUnitDAOInterface electronicUnitDAO;
private ArrayList<ElectronicUnitInterface> electronicUnits;

private ElectronicUnitModel electronicUnitModel;
private JTable electronicUnitTable;
private JScrollPane scrollPane;

public UserPanel()
{
System.out.println("Abbas");
initComponents();
System.out.println("Abbas");
}


public void initComponents()
{
this.setLayout(null);
headingLabel= new JLabel("Console");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,28));
this.headingLabel.setBounds(25,3,300,40);
this.add(this.headingLabel);

this.helpButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.HELP_ICON)));
this.helpButton.setBounds(this.getSize().width-36,2,34,34);
this.add(this.helpButton);

this.areaTypeLabel=new JLabel("Area Type");
this.areaTypeLabel.setFont(new Font("Times New Roman",Font.PLAIN,24));
this.areaTypeLabel.setBounds(25,50,150,30);
this.add(this.areaTypeLabel);

this.areaType=new Choice();
this.areaType.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.areaType.add("<All>");
areaTypeDAO=new AreaTypeDAO();
try
{
this.areaTypes=areaTypeDAO.get();
int x=0;
while(x<areaTypes.size())
{
this.areaType.add(areaTypes.get(x).getName());
x++;
}
}catch(DAOException daoException)
{
JOptionPane.showMessageDialog(this,daoException.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
}
this.areaType.setBounds(200,50,350,30);
this.add(this.areaType);

this.electronicUnitLabel=new JLabel("Electronic Unit");
this.electronicUnitLabel.setFont(new Font("Times New Roman",Font.PLAIN,24));
this.electronicUnitLabel.setBounds(25,90,150,30);
this.add(this.electronicUnitLabel);

this.electronicUnit=new Choice();
this.electronicUnit.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.electronicUnit.add("<All>");
electronicUnitDAO=new ElectronicUnitDAO();
try
{
electronicUnits=electronicUnitDAO.get();
int x=0;
while(x<electronicUnits.size())
{
this.electronicUnit.add(electronicUnits.get(x).getName());
x++;
}
}catch(DAOException daoException)
{
JOptionPane.showMessageDialog(this,daoException.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
}
this.electronicUnit.setBounds(200,90,350,30);
this.add(this.electronicUnit);

this.electronicUnitModel=new ElectronicUnitModel();
this.electronicUnitTable=new JTable(electronicUnitModel);

this.electronicUnitTable.getColumnModel().getColumn(0).setPreferredWidth(20);
this.electronicUnitTable.getColumnModel().getColumn(1).setPreferredWidth(20);
this.electronicUnitTable.getColumnModel().getColumn(2).setPreferredWidth(150);
this.electronicUnitTable.getColumnModel().getColumn(3).setPreferredWidth(150);
this.electronicUnitTable.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.electronicUnitTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
this.electronicUnitTable.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,24));
this.setElectronicUnitTableRowHeight();
this.scrollPane=new JScrollPane(electronicUnitTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
this.scrollPane.setBounds(25,140,550,250);
this.add(this.scrollPane);


this.setBorder(BorderFactory.createLineBorder(Color.black));
}
public Dimension getSize()
{
return new Dimension(600,550);
}
public void setElectronicUnitTableRowHeight()
{
for(int x=0;x<this.electronicUnitTable.getRowCount();x++)
{
this.electronicUnitTable.setRowHeight(x,35);
}
}
}