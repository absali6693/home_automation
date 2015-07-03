package com.thinking.machines.automation.pl;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.components.*;
import com.thinking.machines.automation.model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class EditAdministratorInformationPanel extends JPanel implements ActionListener,DocumentListener
{

//-----------DECLARATION OF VARIABLES-----------------
private JLabel headingLabel;
private JButton helpButton;
private JLabel currentUsernameLabel;
private JInputBox currentUsernameInputBox;
private JClearTextField currentUsernameClearTextField;
private JLabel currentPasswordLabel;
private JPasswordField currentPasswordInputBox;
private JClearTextField currentPasswordClearTextField;
private ImageIcon editIcon;
private ImageIcon editBlurredIcon;
private JButton editButton;

private JLabel userNameLabel;
private JLabel passwordLabel;
private JLabel confirmPasswordLabel;
private JLabel hintQuestionLabel;
private JLabel hintAnswerLabel;

private ImageIcon updateIcon;
private ImageIcon editBlurredIcon1;
private ImageIcon cancelIcon;
private ImageIcon cancelBlurredIcon;

private JButton updateButton;
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

private boolean gotCalled;
//--------------DECLARATION ENDS------------------

EditAdministratorInformationPanel()
{
initComponents();
}
//--------------INIT COMPONENTS--------------
public void initComponents()
{
this.setLayout(null);

this.headingLabel=new JLabel("Edit Administrator Information");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,22));
this.headingLabel.setBounds(25,3,400,40);
this.add(this.headingLabel);

this.helpButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.HELP_ICON)));
this.helpButton.setBounds(this.getSize().width-36,2,34,34);
this.add(this.helpButton);

this.currentUsernameLabel=new JLabel("Current Username");
this.currentUsernameLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.currentUsernameLabel.setBounds(25,58,180,30);
this.add(this.currentUsernameLabel);

this.currentUsernameInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
this.currentUsernameInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.currentUsernameInputBox.setBounds(210,58,300,30);
this.add(this.currentUsernameInputBox);

this.currentUsernameClearTextField=new JClearTextField(this.currentUsernameInputBox);
this.currentUsernameClearTextField.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.currentUsernameClearTextField.setBounds(511,58,30,30);
this.add(this.currentUsernameClearTextField);

this.currentPasswordLabel=new JLabel("Current Password");
this.currentPasswordLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.currentPasswordLabel.setBounds(25,103,180,30);
this.add(this.currentPasswordLabel);

this.currentPasswordInputBox=new JPasswordField(50);
this.currentPasswordInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.currentPasswordInputBox.setBounds(210,103,300,30);
this.add(this.currentPasswordInputBox);

this.currentPasswordClearTextField=new JClearTextField(this.currentUsernameInputBox);
this.currentPasswordClearTextField.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.currentPasswordClearTextField.setBounds(511,103,30,30);
this.add(this.currentPasswordClearTextField);

this.editIcon=new ImageIcon(this.getClass().getResource(GlobalResources.EDIT_ICON));
this.editBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.EDIT_BLURRED_ICON));
this.editButton=new JButton(this.editIcon);
this.editButton.setBounds(250,173,64,64);
this.editButton.setDisabledIcon(this.editBlurredIcon);
this.editButton.setEnabled(false);
this.add(this.editButton);


this.addListeners();
this.setBorder(BorderFactory.createLineBorder(Color.black));
}
//--------------INIT COMPONENTS-------------

//--------------ADDLISTENERS--------------
public void addListeners()
{
this.editButton.addActionListener(this);
this.currentUsernameInputBox.getDocument().addDocumentListener(this);
this.currentPasswordInputBox.getDocument().addDocumentListener(this);
}
//-----------ENDS-------------
//------------GENERALISED METHODS OF DOCUMENT LISTENER-------------
	//-----------INSERTUPDATE-----------//
public void insertUpdate(DocumentEvent ev)
{
try
{
AdministratorDAO administratorDAO=new AdministratorDAO();
AdministratorInterface administrator=administratorDAO.get();
if(this.currentUsernameInputBox.getText().trim().length()>0 && this.currentPasswordInputBox.getText().length()>0)
{
String vUsername=this.currentUsernameInputBox.getText().trim();
String vPassword=new String(this.currentPasswordInputBox.getPassword());
if(vUsername.equals(administrator.getUsername()) && vPassword.equals(administrator.getPassword()))
{
this.editButton.setEnabled(true);
}
else
{
this.editButton.setEnabled(false);
}
}

}catch(DAOException daoException)
{
System.out.println(daoException);
}

if(gotCalled==true)
{
if(isAllFilled()) updateButton.setEnabled(true);
else
{
this.updateButton.setEnabled(false);
this.cancelButton.setEnabled(true);
}
}

}
	//-------ENDS----------
	//------------REMOVEUPDATE---------------
public void removeUpdate(DocumentEvent ev)
{
try
{
AdministratorDAO administratorDAO=new AdministratorDAO();
AdministratorInterface administrator=administratorDAO.get();
if(this.currentUsernameInputBox.getText().trim().length()>0 && this.currentPasswordInputBox.getText().length()>0)
{
String vUsername=this.currentUsernameInputBox.getText().trim();
String vPassword=new String(this.currentPasswordInputBox.getPassword());
if(vUsername.equals(administrator.getUsername()) && vPassword.equals(administrator.getPassword()))
{
this.editButton.setEnabled(true);
}
else
{
this.editButton.setEnabled(false);
}
}
}catch(DAOException daoException)
{
System.out.println(daoException);
}

if(gotCalled==true)
{
if(isAllFilled()) updateButton.setEnabled(true);
else updateButton.setEnabled(false);
if(anyFilled())
{
this.cancelButton.setEnabled(true);
}
else
{
this.cancelButton.setEnabled(false);
}
}

}
	//-----------ENDS-------------
	//------------CHANGEDUPDATE----------------
public void changedUpdate(DocumentEvent ev)
{
}
	//------------ENDS--------------
//----------------ENDS-----------------
//----------------ACTIONPERFORMED----------------------
public void actionPerformed(ActionEvent ev)
{
if(ev.getSource()==editButton)
{
this.setSize(550,600);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
SwingUtilities.getWindowAncestor(this).setSize(550+40,600+60);
SwingUtilities.getWindowAncestor(this).setLocation(d.width/2-590/2,d.height/2-660/2);
SwingUtilities.getWindowAncestor(this).setVisible(true);
this.currentUsernameInputBox.setEditable(false);
this.currentPasswordInputBox.setEditable(false);
this.editButton.setEnabled(false);
initComponents1();
//gotCalled=true;
}

if(ev.getSource()==updateButton)
{
//System.out.println(this.passwordInputBox.getPassword());
String vUserName="";
String vPassword="";
String vHintQuestion="";
String vHintAnswer="";
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
administratorDAO.set(administrator/*,this.currentUsernameInputBox.getText(),new String(this.currentPasswordInputBox.getPassword())*/);
SwingUtilities.getWindowAncestor(this).dispose();
LoginUI loginUI=new LoginUI();
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
if(ev.getSource()==cancelButton)
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
//---------------------ENDS----------------

//----------------INITCOMPONENTS(1)----------------
public void initComponents1()
{
this.userNameLabel=new JLabel("New User");
this.userNameLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.userNameLabel.setBounds(25,257,150,30);
this.add(this.userNameLabel);

this.userNameInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
this.userNameInputBox.requestFocus();
this.userNameInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.userNameInputBox.setBounds(205,257,305,30);
this.add(this.userNameInputBox);

this.userNameClearTextField=new JClearTextField(this.userNameInputBox);
this.userNameClearTextField.setBounds(511,257,30,30);
this.add(this.userNameClearTextField);

this.passwordLabel=new JLabel("New Password");
this.passwordLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.passwordLabel.setBounds(25,312,150,30);
this.add(this.passwordLabel);

this.upperPasswordLabel=new JLabel("Password must be of 8 characters.");
this.upperPasswordLabel.setFont(new Font("Times New Roman",Font.PLAIN,13));
this.upperPasswordLabel.setForeground(Color.red);
this.upperPasswordLabel.setBounds(205,290,200,30);
this.add(this.upperPasswordLabel);

this.rightIcon=new ImageIcon(this.getClass().getResource(GlobalResources.RIGHT_ICON));
this.rightLabel=new JLabel(this.rightIcon);
this.rightLabel.setBounds(495,292,20,20);
this.add(this.rightLabel);
this.rightLabel.setVisible(false);

this.wrongIcon=new ImageIcon(this.getClass().getResource(GlobalResources.WRONG_ICON));
this.wrongLabel=new JLabel(wrongIcon);
this.wrongLabel.setBounds(495,292,20,20);
this.add(this.wrongLabel);
this.wrongLabel.setVisible(false);

this.passwordInputBox=new JPasswordField(50);
this.passwordInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.passwordInputBox.setBounds(205,312,305,30);
this.add(this.passwordInputBox);
//this.passwordInputBox.setEchoChar('*');


this.passwordClearTextField=new JClearTextField(this.passwordInputBox);
this.passwordClearTextField.setBounds(511,312,30,30);
this.add(this.passwordClearTextField);

this.confirmPasswordLabel=new JLabel("Confirm Password");
this.confirmPasswordLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.confirmPasswordLabel.setBounds(25,367,175,30);
this.add(this.confirmPasswordLabel);

this.rightIcon2=new ImageIcon(this.getClass().getResource(GlobalResources.RIGHT_ICON));
this.rightLabel2=new JLabel(this.rightIcon2);
this.rightLabel2.setBounds(496,348,20,20);
this.add(this.rightLabel2);
this.rightLabel2.setVisible(false);

this.wrongIcon2=new ImageIcon(this.getClass().getResource(GlobalResources.WRONG_ICON));
this.wrongLabel2=new JLabel(this.wrongIcon2);
this.wrongLabel2.setBounds(496,348,20,20);
this.add(this.wrongLabel2);
this.wrongLabel2.setVisible(false);

this.confirmPasswordInputBox=new JPasswordField(50);
this.confirmPasswordInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.confirmPasswordInputBox.setBounds(205,367,305,30);
this.add(this.confirmPasswordInputBox);
//this.confirmPasswordInputBox.setEchoChar('*');

this.confirmPasswordClearTextField=new JClearTextField(this.confirmPasswordInputBox);
this.confirmPasswordClearTextField.setBounds(511,367,30,30);
this.add(this.confirmPasswordClearTextField);

this.hintQuestionLabel=new JLabel("Hint Question");
this.hintQuestionLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.hintQuestionLabel.setBounds(25,422,150,30);
this.add(this.hintQuestionLabel);

this.hintQuestionInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
this.hintQuestionInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.hintQuestionInputBox.setBounds(205,422,305,30);
this.add(this.hintQuestionInputBox);

this.hintQuestionClearTextField=new JClearTextField(this.hintQuestionInputBox);
this.hintQuestionClearTextField.setBounds(511,422,30,30);
this.add(this.hintQuestionClearTextField);

this.hintAnswerLabel=new JLabel("Hint Answer");
this.hintAnswerLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.hintAnswerLabel.setBounds(25,477,150,30);
this.add(this.hintAnswerLabel);

this.hintAnswerInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
this.hintAnswerInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.hintAnswerInputBox.setBounds(205,477,305,30);
this.add(this.hintAnswerInputBox);

this.hintAnswerClearTextField=new JClearTextField(this.hintAnswerInputBox);
this.hintAnswerClearTextField.setBounds(511,477,30,30);
this.add(this.hintAnswerClearTextField);

this.updateIcon=new ImageIcon(this.getClass().getResource(GlobalResources.UPDATE_ICON));
this.editBlurredIcon1=new ImageIcon(this.getClass().getResource(GlobalResources.EDIT_BLURRED_ICON));
this.updateButton=new JButton(updateIcon);
this.updateButton.setEnabled(false);
this.updateButton.setDisabledIcon(editBlurredIcon1);
this.updateButton.setBounds(250,532,64,64);
this.add(this.updateButton);

this.cancelIcon=new ImageIcon(this.getClass().getResource(GlobalResources.CANCEL_ICON));
this.cancelBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.CANCEL_BLURRED_ICON));
this.cancelButton=new JButton(cancelIcon);
this.cancelButton.setDisabledIcon(new ImageIcon(this.getClass().getResource(GlobalResources.CANCEL_BLURRED_ICON)));
this.cancelButton.setBounds(320,532,64,64);
//this.cancelButton.setEnabled(false);
this.add(this.cancelButton);

this.addListeners1();
this.setBorder(BorderFactory.createLineBorder(Color.black));
}


public void addListeners1()
{
this.gotCalled=true;
this.updateButton.addActionListener(this);
this.cancelButton.addActionListener(this);
this.userNameInputBox.getDocument().addDocumentListener(this);
this.hintQuestionInputBox.getDocument().addDocumentListener(this);
this.hintAnswerInputBox.getDocument().addDocumentListener(this);
this.passwordInputBox.getDocument().addDocumentListener(new DocumentListener(){
public void insertUpdate(DocumentEvent ev)
{
if(isAllFilled()) updateButton.setEnabled(true);
else updateButton.setEnabled(false);
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
if(isAllFilled()) updateButton.setEnabled(true);
else updateButton.setEnabled(false);
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
if(isAllFilled()) updateButton.setEnabled(true);
else updateButton.setEnabled(false);
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

if(isAllFilled()) updateButton.setEnabled(true);
else updateButton.setEnabled(false);
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
}


public boolean anyFilled()
{
if(this.userNameInputBox.getText().trim().length()!=0) return true;
if(this.passwordInputBox.getText().length()>0) return true;
if(this.confirmPasswordInputBox.getText().length()>0) return true;
if(this.hintQuestionInputBox.getText().trim().length()!=0) return true;
if(this.hintAnswerInputBox.getText().trim().length()!=0) return true;
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

public Dimension getSize()
{
return new Dimension(550,300);
}
}