package com.thinking.machines.automation.pl;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.components.*;
import com.thinking.machines.automation.model.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AreaTypePanel extends JPanel implements ActionListener,DocumentListener
{
private JButton helpButton;
private AreaTypeModel areaTypeModel;
private JLabel headingLabel;
private JTable areaTypeTable;
private JScrollPane scrollPane;
private JLabel searchErrorLabel;
private JLabel searchLabel;
private JInputBox searchInputBox;
private JClearTextField clearSearchInputBox;
private JLabel areaTypeLabel;
private JInputBox areaTypeInputBox;
private JClearTextField clearAreaTypeInputBox;
private JButton saveButton;
private JButton trashButton;
private ImageIcon saveIcon,saveBlurredIcon;
public AreaTypePanel()
{
initComponents();
}
public void initComponents()
{
this.saveIcon=new ImageIcon(this.getClass().getResource(GlobalResources.SAVE_ICON));
this.saveBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.SAVE_BLURRED_ICON));
this.helpButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.HELP_ICON)));
this.headingLabel=new JLabel("Area Type");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,28));
this.searchErrorLabel=new JLabel("   ");
this.searchErrorLabel.setFont(new Font("Times New Roman",Font.PLAIN,10));
this.searchErrorLabel.setForeground(Color.red);
this.searchLabel=new JLabel("Search");
this.searchLabel.setFont(new Font("Times New Roman",Font.PLAIN,24));
this.searchInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
this.searchInputBox.setFont(new Font("Times New Roman",Font.PLAIN,24));
this.clearSearchInputBox=new JClearTextField(searchInputBox);
this.areaTypeModel=new AreaTypeModel();
this.areaTypeTable=new JTable(areaTypeModel);
this.areaTypeTable.getColumnModel().getColumn(0).setPreferredWidth(20);
this.areaTypeTable.getColumnModel().getColumn(1).setPreferredWidth(330);
this.areaTypeTable.setFont(new Font("Times New Roman",Font.PLAIN,24));
this.areaTypeTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
this.areaTypeTable.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,24));
this.setAreaTypeTableRowHeight();
this.scrollPane=new JScrollPane(areaTypeTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
this.areaTypeLabel=new JLabel("Area Type");
this.areaTypeLabel.setFont(new Font("Times New Roman",Font.PLAIN,24));
this.areaTypeInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
this.areaTypeInputBox.setFont(new Font("Times New Roman",Font.PLAIN,24));
this.clearAreaTypeInputBox=new JClearTextField(areaTypeInputBox);
this.saveButton=new JButton(saveIcon);
this.saveButton.setDisabledIcon(saveBlurredIcon);
this.trashButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.TRASH_ICON)));
this.setLayout(null);
this.headingLabel.setBounds(25,3,300,40);
this.helpButton.setBounds(this.getSize().width-36,2,34,34);
this.searchErrorLabel.setBounds(460,25,100,30);
this.searchLabel.setBounds(25,50,80,40);
this.searchInputBox.setBounds(115,50,390,40);
this.clearSearchInputBox.setBounds(505,50,34,34);
this.scrollPane.setBounds(25,100,500,400);
this.areaTypeLabel.setBounds(25,500,200,30);
this.areaTypeInputBox.setBounds(25,535,485,40);
this.clearAreaTypeInputBox.setBounds(505,535,34,34);
this.saveButton.setBounds(this.getSize().width/2-66,578,64,64);
this.saveButton.setEnabled(false);
this.trashButton.setBounds(this.getSize().width/2,578,64,64);
this.add(this.headingLabel);
this.add(this.helpButton);
this.add(this.searchErrorLabel);
this.add(this.searchLabel);
this.add(this.searchInputBox);
this.add(this.clearSearchInputBox);
this.add(this.scrollPane);
this.add(this.areaTypeLabel);
this.add(this.areaTypeInputBox);
this.add(this.clearAreaTypeInputBox);
this.add(this.saveButton);
this.add(this.trashButton);
this.addListeners();
this.setBorder(BorderFactory.createLineBorder(Color.black));
}
public void addListeners()
{
this.saveButton.addActionListener(this);
this.trashButton.addActionListener(this);
this.searchInputBox.getDocument().addDocumentListener(this);
this.areaTypeInputBox.getDocument().addDocumentListener(new DocumentListener(){
public void insertUpdate(DocumentEvent documentEvent)
{
AreaTypePanel.this.setButtonState();
}
public void removeUpdate(DocumentEvent documentEvent)
{
AreaTypePanel.this.setButtonState();
}
public void changedUpdate(DocumentEvent documentEvent)
{
AreaTypePanel.this.setButtonState();
}
});
}
public Dimension getSize()
{
return new Dimension(550,650);
}
public void actionPerformed(ActionEvent event)
{
if(event.getSource()==this.trashButton)
{
int selectedRowIndex=this.areaTypeTable.getSelectedRow();
if(selectedRowIndex==-1)
{
JOptionPane.showMessageDialog(this,"Select an area type to delete.","Error",
JOptionPane.ERROR_MESSAGE);
return;
}
AreaTypeInterface areaType=null;
try
{
areaType=this.areaTypeModel.getAreaTypeAt(selectedRowIndex);
}catch(DAOException daoException)
{
//this case won't arise
}
int selection=JOptionPane.showConfirmDialog(this,"Delete:"+areaType.getName()+
"?","confirmation",JOptionPane.YES_NO_OPTION);
if(selection==JOptionPane.YES_OPTION)
{
try
{
this.areaTypeModel.remove(areaType.getName());
this.areaTypeModel.fireTableDataChanged();
this.setAreaTypeTableRowHeight();
this.areaTypeTable.repaint();
JOptionPane.showMessageDialog(this,"Area type deleted.","Notification",
JOptionPane.INFORMATION_MESSAGE);
}catch(DAOException daoException)
{
JOptionPane.showMessageDialog(this,daoException.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}
}
return;
}
if(event.getSource()==this.saveButton)
{
String vAreaType=this.areaTypeInputBox.getText().trim();
//a fail safe mechanism
if(vAreaType.length()==0)
{
JOptionPane.showMessageDialog(this,"Area type required.","Error",JOptionPane.ERROR_MESSAGE);
return;
}
try
{
AreaTypeInterface areaType=new AreaType(vAreaType);
this.areaTypeModel.add(areaType);
this.areaTypeModel.fireTableDataChanged();
this.setAreaTypeTableRowHeight();
this.areaTypeTable.repaint();
this.searchInputBox.setText("");
this.search(vAreaType);
this.areaTypeInputBox.setText("");
JOptionPane.showMessageDialog(this,"Area type added.","Notification",
JOptionPane.INFORMATION_MESSAGE);
}catch(DAOException daoException)
{
JOptionPane.showMessageDialog(this,daoException.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
}
}
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
}
public void changedUpdate(DocumentEvent documentEvent)
{
//gets called when a set or set of attributes change 
//In our application we don't want to do  anything in this case
}
private void search(String areaTypeName)
{
if(areaTypeName.length()==0)
{
this.searchErrorLabel.setText("");
this.areaTypeTable.clearSelection();
return;
}
for(int x=0;x<areaTypeModel.getRowCount();x++)
{
if(((String)this.areaTypeModel.getValueAt(x,1)).toUpperCase().startsWith(areaTypeName.toUpperCase()))
{
this.searchErrorLabel.setText("");
this.areaTypeTable.setRowSelectionInterval(x,x);
this.areaTypeTable.scrollRectToVisible(this.areaTypeTable.getCellRect(x,x,false));
return;
}
}
this.searchErrorLabel.setText("Not found");
this.areaTypeTable.clearSelection();
}
private void setButtonState()
{
this.saveButton.setEnabled(!(areaTypeInputBox.getText().trim().length()==0));
}
private void setAreaTypeTableRowHeight()
{
for(int x=0;x<areaTypeTable.getRowCount();x++)
{
this.areaTypeTable.setRowHeight(x,35);
}
}
}