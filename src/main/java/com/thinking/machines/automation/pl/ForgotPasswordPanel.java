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
class ForgotPasswordPanel extends JPanel implements ActionListener
{
private JLabel headingLabel;
private JButton helpButton;
private JLabel hintQuestionLabel1;
private JLabel hintQuestionLabel2;
private JLabel hintAnswerLabel;
private JInputBox hintAnswerInputBox;
private JClearTextField hintAnswerClearTextField;
private ImageIcon recoverIcon;
private JButton recoverButton;
ForgotPasswordPanel()
{
initComponents();
}
public void initComponents()
{
this.setLayout(null);

this.headingLabel=new JLabel("Forgot Password");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,22));
this.headingLabel.setBounds(25,3,300,40);
this.add(this.headingLabel);

this.helpButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.HELP_ICON)));
this.helpButton.setBounds(this.getSize().width-36,2,34,34);
this.add(this.helpButton);

this.hintQuestionLabel1=new JLabel("Hint Question");
this.hintQuestionLabel1.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.hintQuestionLabel1.setBounds(25,60,150,30);
this.add(this.hintQuestionLabel1);

try
{
AdministratorDAO administratorDAO=new AdministratorDAO();
AdministratorInterface administrator=administratorDAO.get();
this.hintQuestionLabel2=new JLabel(administrator.getHintQuestion());
}catch(DAOException daoException)
{
System.out.println(daoException);
}


this.hintQuestionLabel2.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.hintQuestionLabel2.setBounds(25,107,350,30);
this.add(this.hintQuestionLabel2);

this.hintAnswerLabel=new JLabel("Hint Answer");
this.hintAnswerLabel.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.hintAnswerLabel.setBounds(25,154,150,30);
this.add(this.hintAnswerLabel);

this.hintAnswerInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
this.hintAnswerInputBox.setFont(new Font("Times New Roman",Font.PLAIN,22));
this.hintAnswerInputBox.setBounds(25,201,350,30);
this.add(this.hintAnswerInputBox);

this.hintAnswerClearTextField=new JClearTextField(this.hintAnswerInputBox);
this.hintAnswerClearTextField.setBounds(376,201,30,30);
this.add(this.hintAnswerClearTextField);

this.recoverIcon=new ImageIcon(this.getClass().getResource(GlobalResources.RECOVER_ICON));
this.recoverButton=new JButton(this.recoverIcon);
this.recoverButton.setBounds(200,255,75,75);
this.add(this.recoverButton);

this.addListeners();
this.setBorder(BorderFactory.createLineBorder(Color.black));
}

public void addListeners()
{
this.recoverButton.addActionListener(this);
}

public void actionPerformed(ActionEvent ev)
{
try
{
AdministratorDAO administratorDAO=new AdministratorDAO();
AdministratorInterface administrator=administratorDAO.get();
if(!(hintAnswerInputBox.getText().trim().equals(administrator.getHintAnswer())))
{
JOptionPane.showMessageDialog(this,"Invalid answer.","Error",JOptionPane.ERROR_MESSAGE);
hintAnswerInputBox.setText("");
hintAnswerInputBox.requestFocus();
}
else
{
String vUsername=administrator.getUsername();
String vPassword=administrator.getPassword();
JOptionPane.showMessageDialog(this,"Username:"+vUsername+"   "+"Password:"+vPassword);
SwingUtilities.getWindowAncestor(this).dispose();
LoginUI loginUI=new LoginUI();
}
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}

public Dimension getSize()
{
return new Dimension(450,400);
}
}