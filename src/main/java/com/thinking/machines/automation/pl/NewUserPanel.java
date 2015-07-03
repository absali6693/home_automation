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
public class NewUserPanel extends JPanel implements ActionListener
{

private  JLabel headingLabel;
private JLabel headingLabel1;
private JButton helpButton;
private JLabel userNameLabel;
private JLabel passwordLabel;
private JLabel confirmPasswordLabel;
private JLabel hintQuestionLabel;
private JLabel hintAnswerLabel;


/*private AreaTypeDAOInterface areaTypeDAO;
private ArrayList<AreaTypeInterface> areaTypes1;
private ElectronicUnitModel electronicUnitModel;
private JLabel numberOfRecordsLabel;
private JTextField numberOfRecordsTextField;
private JTable electronicUnitTable;
private JScrollPane scrollPane;

private ElectronicUnitInterface electronicUnit;
*/


private ImageIcon saveIcon;
private ImageIcon saveBlurredIcon;
private ImageIcon cancelIcon;
private ImageIcon cancelBlurredIcon;

private JButton saveButton;
private JButton cancelButton;

private JTextField userNameTextField;
private JTextField passwordTextField;
private JTextField confirmPasswordTextField;
private JTextField hintQuestionTextField;
private JTextField hintAnswerTextField;

NewUserPanel()
{
initComponents();
}
public void initComponents()
{
this.setLayout(null);

this.headingLabel=new JLabel("Administrator");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,22));

this.helpButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.HELP_ICON)));


this.headingLabel1=new JLabel("Set Administrator Information");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,22));


this.userNameLabel=new JLabel("User Name");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,22));


this.passwordLabel=new JLabel("Password");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,22));


this.confirmPasswordLabel=new JLabel("Confirm Password");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,22));


this.hintQuestionLabel=new JLabel("Hint Question");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,22));


this.hintAnswerLabel=new JLabel("Hint Answer");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,22));



this.headingLabel.setBounds(25,3,300,40);
this.helpButton.setBounds(this.getSize().width-36,2,34,34);

this.add(this.headingLabel);
this.add(this.helpButton);


this.saveIcon=new ImageIcon(this.getClass().getResource(GlobalResources.SAVE_ICON));
this.saveBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.SAVE_BLURRED_ICON));
this.saveButton=new JButton(saveIcon);
this.saveButton.setBounds(135,570,64,64);
this.add(this.saveButton);

this.cancelIcon=new ImageIcon(this.getClass().getResource(GlobalResources.CANCEL_ICON));
this.cancelBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.CANCEL_BLURRED_ICON));
this.cancelButton=new JButton(cancelIcon);
this.cancelButton.setDisabledIcon(new ImageIcon(this.getClass().getResource(GlobalResources.CANCEL_BLURRED_ICON)));
this.cancelButton.setBounds(336,570,64,64);
this.cancelButton.setEnabled(false);
this.add(this.cancelButton);
this.addListeners();
this.setBorder(BorderFactory.createLineBorder(Color.black));

}

public void addListeners()
{
this.saveButton.addActionListener(this);
this.cancelButton.addActionListener(this);
}

public void actionPerformed(ActionEvent ev)
{
}
/*
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
*/
}
