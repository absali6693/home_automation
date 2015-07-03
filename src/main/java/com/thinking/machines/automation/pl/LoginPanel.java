package com.thinking.machines.automation.pl;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.model.*;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.components.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class LoginPanel extends JPanel implements ActionListener
{
private JLabel headingLabel;
private JButton helpButton;
private JLabel userNameLabel;
private JInputBox userNameInputBox;
private JClearTextField userNameClearTextField;
private JLabel passwordLabel;
private JPasswordField passwordInputBox;
private JClearTextField passwordClearTextField;
private JButton loginButton;
private ImageIcon loginIcon;
private ImageIcon loginBlurredIcon;
private JButton forgotPasswordButton;
private ImageIcon forgotPasswordIcon;

LoginPanel()
{
initComponents();
}
public void initComponents()
{
this.setLayout(null);

this.userNameInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
this.userNameInputBox.setFont(new Font("Times New Roman",Font.PLAIN,20));
this.userNameInputBox.setBounds(25,85,290,30);
this.add(this.userNameInputBox);
this.userNameInputBox.requestFocus();

this.headingLabel=new JLabel("Authencation");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,22));
this.headingLabel.setBounds(25,3,300,40);
this.add(this.headingLabel);

this.helpButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.HELP_ICON)));
this.helpButton.setBounds(this.getSize().width-36,2,34,34);
this.add(this.helpButton);

this.userNameLabel=new JLabel("Username");
this.userNameLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.userNameLabel.setBounds(25,50,150,30);
this.add(this.userNameLabel);



this.userNameClearTextField=new JClearTextField(this.userNameInputBox);
this.userNameClearTextField.setBounds(316,85,32,32);
this.add(this.userNameClearTextField);

this.passwordLabel=new JLabel("Password");
this.passwordLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.passwordLabel.setBounds(25,124,150,30);
this.add(this.passwordLabel);

this.passwordInputBox=new JPasswordField(50);
this.passwordInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.passwordInputBox.setBounds(25,159,290,30);
this.add(this.passwordInputBox);

this.passwordClearTextField=new JClearTextField(this.passwordInputBox);
this.passwordClearTextField.setBounds(316,159,32,32);
this.add(this.passwordClearTextField);

this.loginIcon=new ImageIcon(this.getClass().getResource(GlobalResources.LOGIN_ICON));
this.loginBlurredIcon=new ImageIcon(this.getClass().getResource(GlobalResources.LOGIN_BLURRED_ICON));
this.loginButton=new JButton(loginIcon);
this.loginButton.setDisabledIcon(loginBlurredIcon);
this.loginButton.setBounds(115,215,64,64);
//this.loginButton.setEnabled(false);
this.add(this.loginButton);

this.forgotPasswordIcon=new ImageIcon(this.getClass().getResource(GlobalResources.FORGOT_PASSWORD_ICON));

this.forgotPasswordButton=new JButton(forgotPasswordIcon);
this.forgotPasswordButton.setBounds(183,215,64,64);
this.add(this.forgotPasswordButton);

this.addListeners();
this.setBorder(BorderFactory.createLineBorder(Color.black));
}

public void addListeners()
{
this.loginButton.addActionListener(this);
this.forgotPasswordButton.addActionListener(this);
//this.userNameInputBox.getDocument().addDocumentListener(this);
//this.passwordInputBox.getDocument().addDocumentListener(this);
}

/*public void insertUpdate(DocumentEvent ev)
{
if(this.userNameInputBox.getText().trim().length()!=0 && this.passwordInputBox.getText().length()!=0)
{
String vUsername="";
String vPassword="";
try
{
AdministratorDAO administratorDAO=new AdministratorDAO();
AdministratorInterface administrator=administratorDAO.get();
vUsername=administrator.getUsername();
vPassword=administrator.getPassword();
if(vUsername.equals(this.userNameInputBox.getText().trim()) && vPassword.equals(new String(this.passwordInputBox.getPassword())))
{
this.loginButton.setEnabled(true);
}
else
{
this.loginButton.setEnabled(false);
}
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}
public void removeUpdate(DocumentEvent ev)
{
if(this.userNameInputBox.getText().trim().length()!=0 && this.passwordInputBox.getText().length()!=0)
{
String vUsername="";
String vPassword="";
try
{
AdministratorDAO administratorDAO=new AdministratorDAO();
AdministratorInterface administrator=administratorDAO.get();
vUsername=administrator.getUsername();
vPassword=administrator.getPassword();
if(vUsername.equals(this.userNameInputBox.getText().trim()) && vPassword.equals(new String(this.passwordInputBox.getPassword())))
{
this.loginButton.setEnabled(true);
}
else
{
this.loginButton.setEnabled(false);
}
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}
public void changedUpdate(DocumentEvent ev)
{
}
*/
public void actionPerformed(ActionEvent ev)
{
if(ev.getSource()==this.loginButton)
{
String vUserName;
String vPassword;
try
{
AdministratorDAOInterface administratorDAO=new AdministratorDAO();
vUserName=this.userNameInputBox.getText().trim();
vPassword=new String(this.passwordInputBox.getPassword());
AdministratorInterface administrator=administratorDAO.get(vUserName);
if(!(vPassword.equals(administrator.getPassword()))) 
{
this.passwordInputBox.setText("");
this.passwordInputBox.requestFocus();
throw new DAOException("Invalid Username/Password.");
}
SwingUtilities.getWindowAncestor(this).dispose();
MenuUI menuUI=new MenuUI();
}catch(DAOException daoException)
{

JOptionPane.showMessageDialog(this,daoException.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
}
}
if(ev.getSource()==this.forgotPasswordButton)
{
SwingUtilities.getWindowAncestor(this).dispose();
ForgotPasswordUI forgotPasswordUI=new ForgotPasswordUI();
}
}

public Dimension getSize()
{
return new Dimension(350,300);
}
}