package com.thinking.machines.automation.pl;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.components.*;
import com.thinking.machines.automation.model.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;
public class ElectronicUnitPanel extends JPanel implements ActionListener,ItemListener,DocumentListener,ListSelectionListener
{
private int a=0;
private int count=0;
private  JLabel headingLabel;
private JButton helpButton;
private JLabel searchErrorLabel;
private JLabel searchLabel;
private JInputBox searchInputBox;
private JClearTextField clearSearchInputBox;
private JLabel areaTypeCaption;
private Choice type;

private AreaTypeDAOInterface areaTypeDAO;
private ArrayList<AreaTypeInterface> areaTypes1;
private ElectronicUnitModel electronicUnitModel;
private JLabel numberOfRecordsLabel;
private JTextField numberOfRecordsTextField;
private JTable electronicUnitTable;
private JScrollPane scrollPane;

private ElectronicUnitInterface electronicUnit;


private JButton upButton;
private JButton downButton;
private JButton addButton;
private JButton trashButton;
private JButton editButton;
private JButton cancelButton;
private ImageIcon upIcon;
private ImageIcon upBlurredIcon;
private ImageIcon downIcon;
private ImageIcon downBlurredIcon;
private ImageIcon addIcon;
private ImageIcon addBlurredIcon;
private ImageIcon saveIcon;
private ImageIcon saveBlurredIcon;
private ImageIcon trashIcon;
private ImageIcon trashBlurredIcon;
private ImageIcon editIcon;
private ImageIcon editBlurredIcon;
private ImageIcon updateIcon;
private ImageIcon cancelIcon;
private ImageIcon cancelBlurredIcon;

private JPanel detailsPanel;
private JLabel codeLabel;
private JTextField codeTextField;
private JLabel electronicUnitLabel;
private JTextField electronicUnitTextField;
private JLabel areaTypeLabel;
private ArrayList<AreaTypeInterface> areaTypes2;
private Choice areaTypeComboBox;
private JLabel areaTypeLabel1;
private JCheckBox controllable;
private JLabel controlNameLabel;
private JTextField controlNameTextField;
private JCheckBox switchable;


ElectronicUnitPanel()
{
initComponents();
}
public void initComponents()
{
this.setLayout(null);

this.headingLabel=new JLabel("Electronic Unit");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,22));
//this.headingLabel.setBackground(Color.blue);
//this.headingLabel.setForeground(Color.white);
//this.headingLabel.setOpaque(true);
this.helpButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.HELP_ICON)));



this.searchErrorLabel=new JLabel("   ");
this.searchErrorLabel.setFont(new Font("Times New Roman",Font.PLAIN,10));
this.searchErrorLabel.setForeground(Color.red);

this.searchLabel=new JLabel("Search");
this.searchLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.searchInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
this.searchInputBox.setFont(new Font("Times New Roman",Font.PLAIN,20));
this.clearSearchInputBox=new JClearTextField(searchInputBox);
areaTypeCaption=new JLabel("Area Type");
this.areaTypeCaption.setFont(new Font("Times New Roman",Font.PLAIN,22));
type=new Choice();
type.setFont(new Font("Times New Roman",Font.PLAIN,21));
type.add("<All>");
areaTypeDAO=new AreaTypeDAO();
try
{
areaTypes1=areaTypeDAO.get();
int x=0;
while(x<areaTypes1.size())
{
type.add(areaTypes1.get(x).getName());
x++;
}
}catch(DAOException daoException)
{
JOptionPane.showMessageDialog(this,daoException.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
}
//this.upButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.UP_ICON)));
//this.downButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.DOWN_ICON)));
this.electronicUnitModel=new ElectronicUnitModel();

this.numberOfRecordsLabel=new JLabel("Number of Records");
this.numberOfRecordsLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.numberOfRecordsTextField=new JTextField();
this.numberOfRecordsTextField.setText(String.valueOf(electronicUnitModel.getRowCount()));
this.numberOfRecordsTextField.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.numberOfRecordsTextField.setEditable(false);

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

this.headingLabel.setBounds(25,3,300,40);
this.helpButton.setBounds(this.getSize().width-36,2,34,34);
this.searchErrorLabel.setBounds(510,20,100,30);

this.searchLabel.setBounds(25,40,80,30);
this.searchInputBox.setBounds(110,40,445,30);
this.clearSearchInputBox.setBounds(562,40,32,32);
//this.upButton.setBounds(427,40,30,30);
//this.downButton.setBounds(460,40,30,30);

this.areaTypeCaption.setBounds(25,85,110,30);
this.type.setBounds(140,85,195,21);

this.numberOfRecordsLabel.setBounds(447,85,200,30);
this.numberOfRecordsTextField.setBounds(635,85,45,25);
this.scrollPane.setBounds(25,120,650,250);

this.add(this.headingLabel);
this.add(this.helpButton);
this.add(this.searchErrorLabel);
this.add(this.searchLabel);
this.add(this.searchInputBox);
this.add(this.clearSearchInputBox);
this.add(this.areaTypeCaption);
this.add(this.type);
//this.add(this.upButton);
//this.add(this.downButton);
this.add(this.numberOfRecordsLabel);
this.add(this.numberOfRecordsTextField);
this.add(this.scrollPane);


this.detailsPanel=new JPanel();
this.detailsPanel.setLayout(null);

this.codeLabel=new JLabel("Code");
this.codeLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.codeLabel.setBounds(20,20,110,30);
this.detailsPanel.add(this.codeLabel);

this.codeTextField=new JTextField();
this.codeTextField.setFont(new Font("Times New Roman",Font.PLAIN,20));
this.codeTextField.setBounds(135,20,130,30);
this.detailsPanel.add(this.codeTextField);

this.electronicUnitLabel=new JLabel("Electronic Unit");
this.electronicUnitLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.electronicUnitLabel.setBounds(300,20,140,30);
this.detailsPanel.add(this.electronicUnitLabel);

this.electronicUnitTextField=new JTextField();
this.electronicUnitTextField.setFont(new Font("Times New Roman",Font.PLAIN,20));
this.electronicUnitTextField.setBounds(445,20,170,30);
this.detailsPanel.add(this.electronicUnitTextField);



this.areaTypeLabel=new JLabel("Area Type");
this.areaTypeLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.areaTypeLabel.setBounds(20,60,100,30);
this.detailsPanel.add(this.areaTypeLabel);

this.areaTypeComboBox=new Choice();
this.areaTypeComboBox.setFont(new Font("Times New Roman",Font.PLAIN,20));
//this.areaTypeComboBox.add("<All>");
try
{
this.areaTypes2=this.areaTypeDAO.get();
int x=0;
while(x<areaTypes2.size())
{
this.areaTypeComboBox.add(areaTypes2.get(x).getName());
x++;
}
}catch(DAOException daoException)
{
JOptionPane.showMessageDialog(this,daoException.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
}
this.areaTypeComboBox.setBounds(135,60,200,25);
this.detailsPanel.add(this.areaTypeComboBox);
this.areaTypeComboBox.setVisible(false);

this.areaTypeLabel1=new JLabel("");
this.areaTypeLabel1.setFont(new Font("Times New Roman",Font.PLAIN,20));
this.areaTypeLabel1.setBounds(135,60,130,30);
this.detailsPanel.add(this.areaTypeLabel1);

this.controlNameLabel=new JLabel("Control Name");
this.controlNameLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.controlNameLabel.setBounds(300,100,150,30);
this.detailsPanel.add(controlNameLabel);
this.controlNameLabel.setVisible(false);

this.controlNameTextField=new JTextField();
this.controlNameTextField.setFont(new Font("Times New Roman",Font.PLAIN,20));
this.controlNameTextField.setBounds(445,100,170,30);
this.detailsPanel.add(this.controlNameTextField);
this.controlNameTextField.setVisible(false);

this.controllable=new JCheckBox("Controllable");
this.controllable.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.controllable.setBounds(20,100,170,30);
this.detailsPanel.add(this.controllable);
this.controllable.addItemListener(new ItemListener(){
public void itemStateChanged(ItemEvent event)
{
if(!(controllable.isSelected()))
{
controlNameLabel.setVisible(false);
controlNameTextField.setVisible(false);
}
else
{
controlNameLabel.setVisible(true);
controlNameTextField.setVisible(true);
}
}


});
this.controllable.setEnabled(false);	


this.switchable=new JCheckBox("Switchable");
this.switchable.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.switchable.setBounds(20,140,170,30);
this.detailsPanel.add(this.switchable);

this.switchable.setEnabled(false);
this.detailsPanel.setBounds(25,380,650,180);
this.detailsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Details"));
this.add(this.detailsPanel);


this.addIcon=new ImageIcon(this.getClass().getResource(GlobalResources.ADD_ICON));
this.addBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.ADD_BLURRED_ICON));
this.addButton=new JButton(addIcon);
this.addButton.setBounds(205,570,64,64);
this.add(this.addButton);



this.upIcon=new ImageIcon(this.getClass().getResource(GlobalResources.UP_ICON));
this.upBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.UP_BLURRED_ICON));
this.upButton=new JButton(upIcon);
this.upButton.setBounds(597,40,30,30);
this.add(this.upButton);

this.downIcon=new ImageIcon(this.getClass().getResource(GlobalResources.DOWN_ICON));
this.downBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.DOWN_BLURRED_ICON));
this.downButton=new JButton(downIcon);
this.downButton.setBounds(630,40,30,30);
this.add(this.downButton);


this.trashIcon=new ImageIcon(this.getClass().getResource(GlobalResources.TRASH_ICON));
this.trashBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.TRASH_BLURRED_ICON));
this.trashButton=new JButton(trashIcon);
this.trashButton.setBounds(272,570,64,64);
this.add(this.trashButton);

this.editIcon=new ImageIcon(this.getClass().getResource(GlobalResources.EDIT_ICON));
this.editBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.EDIT_BLURRED_ICON));
this.editButton=new JButton(editIcon);
this.editButton.setBounds(339,570,64,64);
this.add(this.editButton);

this.cancelIcon=new ImageIcon(this.getClass().getResource(GlobalResources.CANCEL_ICON));
this.cancelBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.CANCEL_BLURRED_ICON));
this.cancelButton=new JButton(cancelIcon);
this.cancelButton.setDisabledIcon(new ImageIcon(this.getClass().getResource(GlobalResources.CANCEL_BLURRED_ICON)));
this.cancelButton.setBounds(406,570,64,64);
this.cancelButton.setEnabled(false);
this.add(this.cancelButton);
this.addListeners();
this.setBorder(BorderFactory.createLineBorder(Color.black));
this.setEnableAll(false);

if(this.electronicUnitTable.getRowCount()==0)
{
this.editButton.setEnabled(false);
this.editButton.setDisabledIcon(editBlurredIcon);
this.trashButton.setEnabled(false);
this.trashButton.setDisabledIcon(trashBlurredIcon);
}


}

public void addListeners()
{
this.upButton.addActionListener(this);
this.downButton.addActionListener(this);
this.addButton.addActionListener(this);
this.trashButton.addActionListener(this);
this.editButton.addActionListener(this);
this.cancelButton.addActionListener(this);
this.searchInputBox.getDocument().addDocumentListener(this);
this.type.addItemListener(this);
this.electronicUnitTable.getSelectionModel().addListSelectionListener(this);
}

public void valueChanged(ListSelectionEvent event)
{
int oldSelectedRow=-1;
int currentSelectedRow=electronicUnitTable.getSelectedRow();
if(oldSelectedRow!=currentSelectedRow)
{
oldSelectedRow=currentSelectedRow;
try
{
if(a!=0)
{
this.searchInputBox.setText("");
return;
}





this.electronicUnit=this.electronicUnitModel.getElectronicUnitAt(currentSelectedRow);
this.electronicUnitTextField.setText(this.electronicUnit.getName());
this.codeTextField.setText(String.valueOf(this.electronicUnit.getCode()));
//this.areaTypeComboBox.select(this.electronicUnit.getAreaType().getName());
this.areaTypeLabel1.setText(this.electronicUnit.getAreaType().getName());



this.controllable.setSelected(this.electronicUnit.isControllable());
if(controllable.isSelected()==true)
{
this.controlNameLabel.setVisible(true);
this.controlNameTextField.setVisible(true);
this.controlNameTextField.setText(this.electronicUnit.getControlName());
}
else
{
this.controlNameLabel.setVisible(false);
this.controlNameTextField.setVisible(false);
}
this.switchable.setSelected(this.electronicUnit.isSwitchable());

this.setEnableAll(false);
}catch(DAOException daoException)
{

}
}
}

public void setEnableAll(boolean b)
{
if(b)
{
this.electronicUnitTextField.setEditable(true);
this.codeTextField.setEditable(true);
this.areaTypeLabel1.setVisible(false);
//this.areaTypeLabel1.setEnabled(false);
this.areaTypeComboBox.setVisible(true);
this.areaTypeComboBox.setEnabled(true);
this.controllable.setEnabled(true);
this.controlNameTextField.setEditable(true);
this.switchable.setEnabled(true);
}
else
{
this.electronicUnitTextField.setEditable(false);
this.codeTextField.setEditable(false);
this.areaTypeComboBox.setVisible(false);
this.areaTypeComboBox.setEnabled(false);
this.areaTypeLabel1.setVisible(true);
this.areaTypeLabel1.setEnabled(true);
this.controllable.setEnabled(false);
this.controlNameTextField.setEditable(false);
this.switchable.setEnabled(false);
}
}


public void upEnable(boolean b)
{
if(b)
{
this.searchInputBox.setEditable(true);
this.upButton.setEnabled(true);
this.upButton.setDisabledIcon(upIcon);
this.type.setEnabled(true);
this.downButton.setEnabled(true);
//this.clearSearchInputBox.setEnabled(true);
this.downButton.setDisabledIcon(downIcon);
this.electronicUnitTable.setEnabled(true);

}
else
{
this.searchInputBox.setEditable(false);
this.upButton.setEnabled(false);
this.upButton.setDisabledIcon(upIcon);
this.type.setEnabled(false);
this.downButton.setEnabled(false);
//this.clearSearchInputBox.setEnabled(false);
this.downButton.setDisabledIcon(downIcon);
this.electronicUnitTable.setEnabled(false);
}
}



public void itemStateChanged(ItemEvent ev)
{

String selectedAreaType=(String)type.getSelectedItem();
int selectedIndex=type.getSelectedIndex();
if(selectedIndex==0)
{
this.electronicUnitModel.setAreaType(null);
}
else
{
this.electronicUnitModel.setAreaType(selectedAreaType);
}

this.electronicUnitModel.fireTableDataChanged();
this.setElectronicUnitTableRowHeight();
this.electronicUnitTable.repaint();
this.numberOfRecordsTextField.setText(String.valueOf(electronicUnitModel.getRowCount()));
this.search(this.searchInputBox.getText());

this.emptyAll();
}

private void emptyAll()
{
this.electronicUnitTextField.setText("");
this.codeTextField.setText("");
//this.areaTypeComboBox.select(0);
this.areaTypeComboBox.setVisible(false);
this.areaTypeComboBox.setEnabled(false);
this.areaTypeLabel1.setVisible(true);
this.areaTypeLabel1.setText("");
this.controllable.setSelected(false);
this.controlNameTextField.setText("");
this.controlNameLabel.setVisible(false);
this.controlNameTextField.setVisible(false);
this.switchable.setSelected(false);
}



public void insertUpdate(DocumentEvent documentEvent)
{
//gets called when something gets inserted into the document
this.search(this.searchInputBox.getText().trim());
}
public void removeUpdate(DocumentEvent documentEvent)
{
//gets called when something gets remove from the document
this.search(this.searchInputBox.getText().trim());
if(this.searchInputBox.getText().trim().length()==0)
{
this.emptyAll();
}
}
public void changedUpdate(DocumentEvent documentEvent)
{
//gets called when a set or set of attributes change 
//In our application we don't want to do  anything in this case
}
private void search(String areaTypeName)
{
a=0;
if(areaTypeName.length()==0)
{
this.searchErrorLabel.setText("");
this.electronicUnitTable.clearSelection();
return;
}
for(int x=0;x<electronicUnitModel.getRowCount();x++)
{
if(((String)this.electronicUnitModel.getValueAt(x,2)).toUpperCase().startsWith(areaTypeName.toUpperCase()))
{
this.searchErrorLabel.setText("");
this.electronicUnitTable.setRowSelectionInterval(x,x);
this.electronicUnitTable.scrollRectToVisible(this.electronicUnitTable.getCellRect(x,x,false));
a=1;
return;
}
}
this.searchErrorLabel.setText("Not found");
this.electronicUnitTable.clearSelection();
this.emptyAll();
a=1;
}
public Dimension getSize()
{
return new Dimension(700,650);
}
public void setElectronicUnitTableRowHeight()
{
for(int x=0;x<this.electronicUnitTable.getRowCount();x++)
{
this.electronicUnitTable.setRowHeight(x,35);
}
}




private void searchDown(String electronicUnitName,int selectedRowIndex)
{
a=0;
int x;
for(x=selectedRowIndex;x<electronicUnitModel.getRowCount();x++)
{
if(((String)this.electronicUnitModel.getValueAt(x,2)).toUpperCase().startsWith(electronicUnitName.toUpperCase()))
{
this.searchErrorLabel.setText("");
this.electronicUnitTable.setRowSelectionInterval(x,x);
this.electronicUnitTable.scrollRectToVisible(this.electronicUnitTable.getCellRect(x,x,false));
return;
}
}
try
{
this.electronicUnit=electronicUnitModel.getElectronicUnitAt(x+1);
}catch(DAOException daoException)
{
return;
}
this.emptyAll();
a=1;
}


private void searchUp(String areaTypeName,int selectedRowIndex)
{
a=0;
int x;
for(x=selectedRowIndex;x>-1;x--)
{
if(((String)this.electronicUnitModel.getValueAt(x,2)).toUpperCase().startsWith(areaTypeName.toUpperCase()))
{
this.searchErrorLabel.setText("");
this.electronicUnitTable.setRowSelectionInterval(x,x);
this.electronicUnitTable.scrollRectToVisible(this.electronicUnitTable.getCellRect(x,x,false));
return;
}
}
try
{
this.electronicUnit=electronicUnitModel.getElectronicUnitAt(x-1);
}catch(DAOException daoException)
{
return;
}
this.emptyAll();
a=1;
}




public void actionPerformed(ActionEvent actionEvent)
{
if(actionEvent.getSource()==this.upButton)
{

int selectedRowIndex=electronicUnitTable.getSelectedRow();


this.searchUp(this.searchInputBox.getText(),selectedRowIndex-1);


}
if(actionEvent.getSource()==this.downButton)
{

int selectedRowIndex=electronicUnitTable.getSelectedRow();


this.searchDown(this.searchInputBox.getText(),selectedRowIndex+1);

}

if(actionEvent.getSource()==this.addButton)
{
count++;

this.searchInputBox.setText("");
if(count==1)
{
this.areaTypeComboBox.select(0);
try
{
this.electronicUnitTable.setRowSelectionInterval(0,0);
this.electronicUnitTable.scrollRectToVisible(this.electronicUnitTable.getCellRect(0,0,false));

this.electronicUnitTable.getSelectionModel().clearSelection();
}catch(Exception e)
{
}
this.emptyAll();
}




this.searchInputBox.setEditable(false);
this.upButton.setEnabled(false);
this.upButton.setDisabledIcon(upBlurredIcon);
this.type.setEnabled(false);
this.downButton.setEnabled(false);
//this.clearSearchInputBox.setEnabled(false);
this.downButton.setDisabledIcon(downBlurredIcon);
this.electronicUnitTable.setEnabled(false);
this.codeTextField.requestFocus();

ElectronicUnitInterface electronicUnit;
int vCode=0;
String vName;
String vControlName;
AreaTypeInterface vAreaType;
boolean vControllable;
boolean vSwitchable;

this.editButton.setEnabled(false);
this.editButton.setDisabledIcon(editBlurredIcon);
this.trashButton.setEnabled(false);
this.trashButton.setDisabledIcon(trashBlurredIcon);
this.cancelButton.setEnabled(true);

this.saveIcon=new ImageIcon(this.getClass().getResource(GlobalResources.SAVE_ICON));
//this.saveBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.SAVE_BLURRED_ICON));
this.addButton.setIcon(saveIcon);


this.setEnableAll(true);




if(this.type.getSelectedIndex()!=0)
{

this.areaTypeLabel1.setVisible(true);
this.areaTypeComboBox.select(this.type.getSelectedIndex()-1);
this.areaTypeComboBox.setVisible(false);
this.areaTypeComboBox.setEnabled(false);
this.areaTypeLabel1.setVisible(true);
this.areaTypeLabel1.setText(this.type.getSelectedItem().toString());

}




vName=this.electronicUnitTextField.getText().trim();



vAreaType=new AreaType(areaTypeComboBox.getSelectedItem());
vControllable=this.controllable.isSelected();
if(vControllable)
{
vControlName=this.controlNameTextField.getText().trim();
}
else
{
vControlName=null;
}
vSwitchable=this.switchable.isSelected();


if(count==2)
{
try
{

if(this.codeTextField.getText().trim().length()==0)
{
count--;
JOptionPane.showMessageDialog(this,"Code required.","Error",
JOptionPane.ERROR_MESSAGE);

return;
}
if(this.electronicUnitTextField.getText().trim().length()==0)
{
count--;
JOptionPane.showMessageDialog(this,"Electronic unit required.","Error",
JOptionPane.ERROR_MESSAGE);
this.electronicUnitTextField.requestFocus();
return;
}

if(vControllable)
{
if(this.controlNameTextField.getText().trim().length()==0)
{
count--;
JOptionPane.showMessageDialog(this,"Control name required.","Error",
JOptionPane.ERROR_MESSAGE);

this.controlNameTextField.requestFocus();
return;
}
}

try{
vCode=Integer.parseInt(this.codeTextField.getText().trim());
}catch(Exception e)
{


count--;
JOptionPane.showMessageDialog(this,"Error in Code.","Error",
JOptionPane.ERROR_MESSAGE);

return;

}


this.upEnable(true);
electronicUnit=new ElectronicUnit(vCode,vName,vControlName,vAreaType,vSwitchable,vControllable);
this.electronicUnitModel.add(electronicUnit);
if(this.type.getSelectedIndex()==0)
{
this.electronicUnitModel.fireTableDataChanged();
this.setElectronicUnitTableRowHeight();
this.electronicUnitTable.repaint();
}
//JOptionPane.showMessageDialog(this,"Electronic unit added.","Notification",
//JOptionPane.INFORMATION_MESSAGE);

this.numberOfRecordsTextField.setText(String.valueOf(electronicUnitModel.getRowCount()));
this.addButton.setIcon(addIcon);
this.editButton.setEnabled(true);
this.trashButton.setEnabled(true);
this.cancelButton.setEnabled(false);
this.emptyAll();

int x=electronicUnitModel.getRowCount();
this.electronicUnitTable.setRowSelectionInterval(x-1,x-1);
this.electronicUnitTable.scrollRectToVisible(this.electronicUnitTable.getCellRect(x-1,x-1,false));


}catch(DAOException daoException)
{
count--;
JOptionPane.showMessageDialog(this,daoException.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}






}
if(count==2) {count=0;

String selectedAreaType=(String)type.getSelectedItem();
int selectedIndex=type.getSelectedIndex();
if(selectedIndex==0)
{
this.electronicUnitModel.setAreaType(null);
}
else
{
this.electronicUnitModel.setAreaType(selectedAreaType);
}

this.electronicUnitModel.fireTableDataChanged();
this.setElectronicUnitTableRowHeight();
this.electronicUnitTable.repaint();

try
{
int a=electronicUnitModel.getRowCount();
this.electronicUnitTable.setRowSelectionInterval(a-1,a-1);
this.electronicUnitTable.scrollRectToVisible(this.electronicUnitTable.getCellRect(a-1,a-1,false));
}catch(Exception e)
{
}
this.numberOfRecordsTextField.setText(String.valueOf(electronicUnitModel.getRowCount()));
JOptionPane.showMessageDialog(this,"Electronic unit added.","Notification",
JOptionPane.INFORMATION_MESSAGE);

}


}
if(actionEvent.getSource()==this.trashButton)
{
int selectedRowIndex=electronicUnitTable.getSelectedRow();
if(selectedRowIndex==-1)
{
JOptionPane.showMessageDialog(this,"Select an electronic unit to delete.","Error",
JOptionPane.ERROR_MESSAGE);
return;
}
ElectronicUnitInterface electronicUnit=null;
try
{
electronicUnit=this.electronicUnitModel.getElectronicUnitAt(selectedRowIndex);
}catch(DAOException daoException)
{
//this case won't arise
}





int selection=JOptionPane.showConfirmDialog(this,"Delete:"+electronicUnit.getName()+
"?","confirmation",JOptionPane.YES_NO_OPTION);
if(selection==JOptionPane.YES_OPTION)
{

try
{
this.electronicUnitModel.remove(electronicUnit.getCode());
this.emptyAll();



this.setEnableAll(false);
this.electronicUnitModel.fireTableDataChanged();
this.setElectronicUnitTableRowHeight();
this.electronicUnitTable.repaint();
JOptionPane.showMessageDialog(this,"Electronic unit deleted.","Notification",
JOptionPane.INFORMATION_MESSAGE);
this.search(this.searchInputBox.getText());



String selectedAreaType=(String)type.getSelectedItem();
int selectedIndex=type.getSelectedIndex();
if(selectedIndex==0)
{
this.electronicUnitModel.setAreaType(null);
}
else
{
this.electronicUnitModel.setAreaType(selectedAreaType);
}

this.electronicUnitModel.fireTableDataChanged();
this.setElectronicUnitTableRowHeight();
this.electronicUnitTable.repaint();
this.numberOfRecordsTextField.setText(String.valueOf(electronicUnitModel.getRowCount()));
this.search(this.searchInputBox.getText());


this.numberOfRecordsTextField.setText(String.valueOf(electronicUnitModel.getRowCount()));
}catch(DAOException daoException)
{
count--;
JOptionPane.showMessageDialog(this,daoException.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}
}


return;
}





if(actionEvent.getSource()==this.editButton)
{
count++;
this.electronicUnitTextField.requestFocus();
this.electronicUnitTable.setEnabled(false);
int selectedRowIndex=electronicUnitTable.getSelectedRow();
if(selectedRowIndex==-1)
{
JOptionPane.showMessageDialog(this,"Select an electronic unit to edit.","Error",
JOptionPane.ERROR_MESSAGE);
count--;
this.electronicUnitTable.setEnabled(true);
this.searchInputBox.setEditable(true);
this.upButton.setEnabled(true);
this.upButton.setDisabledIcon(upIcon);
this.type.setEnabled(true);
this.downButton.setEnabled(true);
//this.clearSearchInputBox.setEnabled(true);
this.downButton.setDisabledIcon(downIcon);
return;
}

int x=electronicUnitTable.getSelectedRow();
if(count==1)
{
this.updateIcon=new ImageIcon(this.getClass().getResource(GlobalResources.UPDATE_ICON));
this.editButton.setIcon(updateIcon);
this.cancelButton.setEnabled(true);
this.addButton.setDisabledIcon(addBlurredIcon);
this.addButton.setEnabled(false);
this.trashButton.setEnabled(false);
this.trashButton.setDisabledIcon(trashBlurredIcon);
this.setEnableAll(true);
this.codeTextField.setEditable(false);
this.areaTypeComboBox.select(this.electronicUnit.getAreaType().getName());
this.searchInputBox.setEditable(false);
this.upButton.setEnabled(false);
this.upButton.setDisabledIcon(upBlurredIcon);
this.type.setEnabled(false);
this.downButton.setEnabled(false);
//this.clearSearchInputBox.setEnabled(false);
this.downButton.setDisabledIcon(downBlurredIcon);
ElectronicUnitInterface electronicUnit;
}



int vCode=0;
String vName;
String vControlName;
AreaTypeInterface vAreaType;
boolean vControllable;
boolean vSwitchable;
vControllable=this.controllable.isSelected();



try
{
if(this.electronicUnitTextField.getText().trim().length()==0)
{
count--;
JOptionPane.showMessageDialog(this,"Electronic unit required.","Error",
JOptionPane.ERROR_MESSAGE);
return;
}
if(vControllable)
{
if(this.controlNameTextField.getText().trim().length()==0)
{
count--;
JOptionPane.showMessageDialog(this,"Control name required.","Error",
JOptionPane.ERROR_MESSAGE);
return;
}
}
vName=this.electronicUnitTextField.getText().trim();
try{
vCode=Integer.parseInt(this.codeTextField.getText().trim());
}catch(Exception e)
{
}
vAreaType=new AreaType(areaTypeComboBox.getSelectedItem());
vControllable=this.controllable.isSelected();
if(vControllable)
{
vControlName=this.controlNameTextField.getText().trim();
}
else
{
vControlName=null;
}
vSwitchable=this.switchable.isSelected();
int a=electronicUnitTable.getSelectedRow();
this.searchInputBox.setText("");
this.electronicUnitTable.setRowSelectionInterval(a,a);
this.electronicUnitTable.scrollRectToVisible(this.electronicUnitTable.getCellRect(a,a,false));
this.setEnableAll(true);
this.codeTextField.setEditable(false);



if(count%2==0)
{
electronicUnit=new ElectronicUnit(vCode,vName,vControlName,vAreaType,vSwitchable,vControllable);
this.electronicUnitModel.update(electronicUnit);
this.electronicUnitModel.fireTableDataChanged();
this.setElectronicUnitTableRowHeight();
this.electronicUnitTable.repaint();
JOptionPane.showMessageDialog(this,"Electronic unit updated.","Notification",JOptionPane.INFORMATION_MESSAGE);


this.electronicUnitTable.setRowSelectionInterval(x,x);
this.electronicUnitTable.scrollRectToVisible(this.electronicUnitTable.getCellRect(x,x,false));

this.editButton.setIcon(editIcon);
this.addButton.setEnabled(true);
this.trashButton.setEnabled(true);
this.cancelButton.setEnabled(false);
//this.emptyAll();
this.upEnable(true);

}
}catch(DAOException daoException)
{
JOptionPane.showMessageDialog(this,daoException.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}

if(count==2) count=0;

}



if(actionEvent.getSource()==this.cancelButton)
{

this.editButton.setEnabled(true);
this.trashButton.setEnabled(true);
this.searchInputBox.setText("");
this.cancelButton.setEnabled(false);
this.addButton.setIcon(addIcon);
this.addButton.setEnabled(true);
this.editButton.setIcon(editIcon);
this.electronicUnitTable.setEnabled(true);
try
{
this.areaTypeLabel1.setText(this.electronicUnit.getAreaType().getName());
}catch(Exception exception)
{
}
this.searchInputBox.setEditable(true);

this.upButton.setEnabled(true);
this.upButton.setDisabledIcon(upIcon);
this.type.setEnabled(true);
this.downButton.setEnabled(true); 
//this.clearSearchInputBox.setEnabled(true);	
this.downButton.setDisabledIcon(downIcon);

this.setEnableAll(false);
this.emptyAll();
try
{
this.electronicUnit=this.electronicUnitModel.getElectronicUnitAt(electronicUnitTable.getSelectedRow());
this.electronicUnitTextField.setText(this.electronicUnit.getName());
this.codeTextField.setText(String.valueOf(this.electronicUnit.getCode()));
this.areaTypeComboBox.select(this.electronicUnit.getAreaType().getName());
this.areaTypeLabel1.setText(this.electronicUnit.getAreaType().getName());
this.controllable.setSelected(this.electronicUnit.isControllable());
if(controllable.isSelected()==true)
{
this.controlNameLabel.setVisible(true);
this.controlNameTextField.setVisible(true);
this.controlNameTextField.setText(this.electronicUnit.getControlName());
}
else
{
this.controlNameLabel.setVisible(false);
this.controlNameTextField.setVisible(false);
}
this.switchable.setSelected(this.electronicUnit.isSwitchable());

}catch(DAOException daoException)
{
}
count=0;
count=0;
}
}

}