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
public class AdministratorPanel extends JPanel implements ActionListener,DocumentListener
{
private  JLabel headingLabel;
private JLabel headingLabel1;
private JButton helpButton;
private JLabel userNameLabel;
private JLabel passwordLabel;
private JLabel confirmPasswordLabel;
private JLabel hintQuestionLabel;
private JLabel hintAnswerLabel;

private ImageIcon adminIcon;
private ImageIcon adminBlurredIcon;
private ImageIcon cancelIcon;
private ImageIcon cancelBlurredIcon;

private JButton saveButton;
private JButton cancelButton;

private JInputBox userNameInputBox;
private JPasswordField passwordInputBox;
private JPasswordField confirmPasswordInputBox;
private JInputBox hintQuestionInputBox;
private JInputBox hintAnswerInputBox;

private JClearTextField userNameClearTextField;
private JClearTextField passwordClearTextField;
private JClearTextField confirmPasswordClearTextField;
private JClearTextField hintQuestionClearTextField;
private JClearTextField hintAnswerClearTextField;

private JLabel upperPasswordLabel;
private JLabel rightLabel;
private ImageIcon rightIcon;
private JLabel wrongLabel;
private ImageIcon wrongIcon;
private JLabel rightLabel2;
private ImageIcon rightIcon2;
private JLabel wrongLabel2;
private ImageIcon wrongIcon2;

AdministratorPanel()
{
initComponents();
}
public void initComponents()
{
this.setLayout(null);

this.headingLabel=new JLabel("Administrator");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,22));
this.headingLabel.setBounds(25,3,300,40);
this.add(this.headingLabel);

this.helpButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.HELP_ICON)));
this.helpButton.setBounds(this.getSize().width-36,2,34,34);
this.add(this.helpButton);


this.headingLabel1=new JLabel("Set Administrator Information");
this.headingLabel1.setFont(new Font("Times New Roman",Font.BOLD,22));
this.headingLabel1.setBounds(180,40,300,40);
this.add(this.headingLabel1);

this.userNameLabel=new JLabel("User Name");
this.userNameLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.userNameLabel.setBounds(25,100,150,30);
this.add(this.userNameLabel);

this.userNameInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
//this.userNameInputBox.setBorder(BorderFactory.createLineBorder(Color.black));
this.userNameInputBox.requestFocus();
this.userNameInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.userNameInputBox.setBounds(215,100,375,30);
this.add(this.userNameInputBox);


this.userNameClearTextField=new JClearTextField(this.userNameInputBox);
this.userNameClearTextField.setBounds(591,100,30,30);
this.add(this.userNameClearTextField);

this.passwordLabel=new JLabel("Password");
this.passwordLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.passwordLabel.setBounds(25,150,150,30);
this.add(this.passwordLabel);

this.upperPasswordLabel=new JLabel("Password must be of 8 characters.");
this.upperPasswordLabel.setFont(new Font("Times New Roman",Font.PLAIN,13));
this.upperPasswordLabel.setForeground(Color.red);
this.upperPasswordLabel.setBounds(215,128,200,30);
this.add(this.upperPasswordLabel);

this.rightIcon=new ImageIcon(this.getClass().getResource(GlobalResources.RIGHT_ICON));
this.rightLabel=new JLabel(this.rightIcon);
this.rightLabel.setBounds(571,127,20,20);
this.add(this.rightLabel);
this.rightLabel.setVisible(false);

this.wrongIcon=new ImageIcon(this.getClass().getResource(GlobalResources.WRONG_ICON));
this.wrongLabel=new JLabel(wrongIcon);
this.wrongLabel.setBounds(571,127,20,20);
this.add(this.wrongLabel);
this.wrongLabel.setVisible(false);

//this.passwordInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
this.passwordInputBox=new JPasswordField(50);
this.passwordInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.passwordInputBox.setBounds(215,150,375,30);
this.add(this.passwordInputBox);
//this.passwordInputBox.setEchoChar('*');


this.passwordClearTextField=new JClearTextField(this.passwordInputBox);
this.passwordClearTextField.setBounds(591,150,30,30);
this.add(this.passwordClearTextField);

this.confirmPasswordLabel=new JLabel("Confirm Password");
this.confirmPasswordLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.confirmPasswordLabel.setBounds(25,200,175,30);
this.add(this.confirmPasswordLabel);

this.rightIcon2=new ImageIcon(this.getClass().getResource(GlobalResources.RIGHT_ICON));
this.rightLabel2=new JLabel(this.rightIcon2);
this.rightLabel2.setBounds(571,180,20,20);
this.add(this.rightLabel2);
this.rightLabel2.setVisible(false);

this.wrongIcon2=new ImageIcon(this.getClass().getResource(GlobalResources.WRONG_ICON));
this.wrongLabel2=new JLabel(this.wrongIcon2);
this.wrongLabel2.setBounds(571,180,20,20);
this.add(this.wrongLabel2);
this.wrongLabel2.setVisible(false);

this.confirmPasswordInputBox=new JPasswordField(50);
this.confirmPasswordInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.confirmPasswordInputBox.setBounds(215,200,375,30);
this.add(this.confirmPasswordInputBox);
//this.confirmPasswordInputBox.setEchoChar('*');

this.confirmPasswordClearTextField=new JClearTextField(this.confirmPasswordInputBox);
this.confirmPasswordClearTextField.setBounds(591,200,30,30);
this.add(this.confirmPasswordClearTextField);

this.hintQuestionLabel=new JLabel("Hint Question");
this.hintQuestionLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.hintQuestionLabel.setBounds(25,250,150,30);
this.add(this.hintQuestionLabel);

this.hintQuestionInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
this.hintQuestionInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.hintQuestionInputBox.setBounds(215,250,375,30);
this.add(this.hintQuestionInputBox);

this.hintQuestionClearTextField=new JClearTextField(this.hintQuestionInputBox);
this.hintQuestionClearTextField.setBounds(591,250,30,30);
this.add(this.hintQuestionClearTextField);

this.hintAnswerLabel=new JLabel("Hint Answer");
this.hintAnswerLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.hintAnswerLabel.setBounds(25,300,150,30);
this.add(this.hintAnswerLabel);

this.hintAnswerInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
this.hintAnswerInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.hintAnswerInputBox.setBounds(215,300,375,30);
this.add(this.hintAnswerInputBox);

this.hintAnswerClearTextField=new JClearTextField(this.hintAnswerInputBox);
this.hintAnswerClearTextField.setBounds(591,300,30,30);
this.add(this.hintAnswerClearTextField);

this.adminIcon=new ImageIcon(this.getClass().getResource(GlobalResources.ADMIN_ICON));
this.adminBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.ADMIN_BLURRED_ICON));
this.saveButton=new JButton(adminIcon);
this.saveButton.setEnabled(false);
this.saveButton.setDisabledIcon(adminBlurredIcon);
this.saveButton.setBounds(260,350,64,64);
this.add(this.saveButton);

this.cancelIcon=new ImageIcon(this.getClass().getResource(GlobalResources.CANCEL_ICON));
this.cancelBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.CANCEL_BLURRED_ICON));
this.cancelButton=new JButton(cancelIcon);
this.cancelButton.setDisabledIcon(new ImageIcon(this.getClass().getResource(GlobalResources.CANCEL_BLURRED_ICON)));
this.cancelButton.setBounds(330,350,64,64);
this.cancelButton.setEnabled(false);
this.add(this.cancelButton);

this.addListeners();
this.setBorder(BorderFactory.createLineBorder(Color.black));
}

public void addListeners()
{
this.saveButton.addActionListener(this);
this.cancelButton.addActionListener(this);
this.userNameInputBox.getDocument().addDocumentListener(this);








this.passwordInputBox.getDocument().addDocumentListener(new DocumentListener(){
public void insertUpdate(DocumentEvent ev)
{
if(isAllFilled()) saveButton.setEnabled(true);
else saveButton.setEnabled(false);
if(anyFilled()) cancelButton.setEnabled(true);

if(passwordInputBox.getText().length()<8)
{
rightLabel.setVisible(false);
wrongLabel.setVisible(true);
}
else
{
wrongLabel.setVisible(false);
rightLabel.setVisible(true);
}


if(new String(confirmPasswordInputBox.getPassword()).length()!=0)
{
if((new String(passwordInputBox.getPassword()).equals(new String(confirmPasswordInputBox.getPassword()))) && passwordInputBox.getText().length()>=8)
{
rightLabel.setVisible(true);
rightLabel2.setVisible(true);
wrongLabel.setVisible(false);
wrongLabel2.setVisible(false);
}
}

}
public void removeUpdate(DocumentEvent ev)
{
if(isAllFilled()) saveButton.setEnabled(true);
else saveButton.setEnabled(false);
if(passwordInputBox.getText().length()==0)
{
wrongLabel.setVisible(false);
rightLabel.setVisible(false);
}
if(passwordInputBox.getText().length()>=1 && passwordInputBox.getText().length()<8)
{
rightLabel.setVisible(false);
wrongLabel.setVisible(true);
}


else
{
if(new String(confirmPasswordInputBox.getPassword()).length()!=0)
{
if((new String(passwordInputBox.getPassword()).equals(new String(confirmPasswordInputBox.getPassword())))&& passwordInputBox.getText().length()>=8)
{
rightLabel.setVisible(true);
rightLabel2.setVisible(true);
wrongLabel.setVisible(false);
wrongLabel2.setVisible(false);
}
else
{
rightLabel.setVisible(true);
rightLabel2.setVisible(false);
wrongLabel2.setVisible(true);
}
}
}
}
public void changedUpdate(DocumentEvent ev)
{
}
});


















this.confirmPasswordInputBox.getDocument().addDocumentListener(new DocumentListener(){
public void insertUpdate(DocumentEvent ev)
{
if(isAllFilled()) saveButton.setEnabled(true);
else saveButton.setEnabled(false);
if(anyFilled())  cancelButton.setEnabled(true);
if(passwordInputBox.getText().length()!=0)
{
if(!(passwordInputBox.getText().equals(confirmPasswordInputBox.getText())))
{
rightLabel2.setVisible(false);
wrongLabel2.setVisible(true);
}
else
{
wrongLabel2.setVisible(false);
rightLabel2.setVisible(true);
}
}
else
{
rightLabel2.setVisible(false);
wrongLabel2.setVisible(true);
}
}
public void removeUpdate(DocumentEvent ev)
{

if(isAllFilled()) saveButton.setEnabled(true);
else saveButton.setEnabled(false);
if(anyFilled())  cancelButton.setEnabled(true);
else cancelButton.setEnabled(false);

if(confirmPasswordInputBox.getText().length()==0)
{
wrongLabel2.setVisible(false);
rightLabel2.setVisible(false);
}
else
{
if(passwordInputBox.getText().length()!=0)
{
if(!(passwordInputBox.getText().equals(confirmPasswordInputBox.getText())))
{
wrongLabel2.setVisible(true);
rightLabel2.setVisible(false);
}
else
{
wrongLabel2.setVisible(false);
rightLabel2.setVisible(true);
}
}
}
}
public void changedUpdate(DocumentEvent ev)
{
}
});
this.hintQuestionInputBox.getDocument().addDocumentListener(this);
this.hintAnswerInputBox.getDocument().addDocumentListener(this);
}

public void actionPerformed(ActionEvent event)
{
if(event.getSource()==saveButton)
{
//System.out.println(this.passwordInputBox.getPassword());
String vUserName=null;
String vPassword=null;
String vHintQuestion=null;
String vHintAnswer=null;
AdministratorInterface administrator=null;
AdministratorDAOInterface administratorDAO;
try
{
vUserName=this.userNameInputBox.getText().trim();
vPassword=this.passwordInputBox.getText();
vHintQuestion=this.hintQuestionInputBox.getText().trim();
vHintAnswer=this.hintAnswerInputBox.getText().trim();
administrator=new Administrator(vUserName,vPassword,vHintQuestion,vHintAnswer);
administratorDAO=new AdministratorDAO();
administratorDAO.set(administrator);
SwingUtilities.getWindowAncestor(this).dispose();
MenuUI menuUI=new MenuUI();
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
if(event.getSource()==cancelButton)
{
if((this.userNameInputBox.getText().length()!=0)|| (this.passwordInputBox.getText().length()!=0) || (this.confirmPasswordInputBox.getText().length()!=0) || (this.hintQuestionInputBox.getText().length()!=0)|| (this.hintAnswerInputBox.getText().length()!=0) )
{
this.userNameInputBox.setText("");
this.passwordInputBox.setText("");
this.confirmPasswordInputBox.setText("");
this.hintQuestionInputBox.setText("");
this.hintAnswerInputBox.setText("");
this.userNameInputBox.requestFocus();
}
}
}

public void insertUpdate(DocumentEvent documentEvent)
{
//gets called when something gets inserted into the document
if(isAllFilled()) saveButton.setEnabled(true);
else
{
 saveButton.setEnabled(false);
this.cancelButton.setEnabled(true);
}
}
public void removeUpdate(DocumentEvent documentEvent)
{
//gets called when something gets remove from the document
if(isAllFilled()) saveButton.setEnabled(true);
else saveButton.setEnabled(false);
if(anyFilled())
{
this.cancelButton.setEnabled(true);
}
else
{
this.cancelButton.setEnabled(false);
}
}
public void changedUpdate(DocumentEvent documentEvent)
{
//gets called when a set or set of attributes change 
//In our application we don't want to do  anything in this case
}

public Dimension getSize()
{
return new Dimension(650,430);
}
public boolean anyFilled()
{
if(this.userNameInputBox.getText().trim().length()!=0) return true;
if(this.passwordInputBox.getText().length()>0) return true;
if(this.confirmPasswordInputBox.getText().length()>0) return true;
if(this.hintQuestionInputBox.getText().trim().length()!=0) return true;
if(this.hintAnswerInputBox.getText().trim().length()!=0) return true;
System.out.println("Abbas");
return false;
}
public boolean isAllFilled()
{
if(this.userNameInputBox.getText().trim().length()!=0 && new String(this.passwordInputBox.getPassword()).length()!=0
&& new String(this.confirmPasswordInputBox.getPassword()).length()!=0 && 
this.hintQuestionInputBox.getText().trim().length()!=0 && 
this.hintAnswerInputBox.getText().trim().length()!=0)
{
if(new String(this.passwordInputBox.getPassword()).equals(new String(this.confirmPasswordInputBox.getPassword())))
{
return true;
}
}
return false;
}
}
