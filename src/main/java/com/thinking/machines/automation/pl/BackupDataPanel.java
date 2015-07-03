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
import java.util.zip.*;
import java.io.*;
import javax.swing.JFileChooser;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class BackupDataPanel extends JPanel implements ActionListener,DocumentListener
{
private JLabel headingLabel;
private JButton browseButton,helpButton;
private ImageIcon browseIcon;
private JButton createBackupButton;
private JLabel destinationFolderLabel;
private JInputBox destinationFolderInputBox;
public BackupDataPanel()
{
initComponents();
}
public void initComponents()
{
this.headingLabel=new JLabel("Backup Data");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,28));
this.createBackupButton=new JButton("Create Backup");
//this.browseButton=new JButton("Browse");
this.helpButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.HELP_ICON)));
this.destinationFolderLabel=new JLabel("Destination Folder");
this.destinationFolderInputBox=new JInputBox(JInputBox.InputType.TEXT,50);
this.destinationFolderInputBox.setFont(new Font("Times New Roman",Font.PLAIN,24));
this.destinationFolderLabel.setFont(new Font("Times New Roman",Font.PLAIN,24));
this.browseButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.BROWSE_ICON)));

this.setLayout(null);
this.headingLabel.setBounds(25,10,300,40);
this.helpButton.setBounds(this.getSize().width-36,2,34,34);
this.destinationFolderLabel.setBounds(25,60,250,30);
this.destinationFolderInputBox.setBounds(25,90,380,35);
this.browseButton.setBounds(410,90,34,34);
this.createBackupButton.setBounds(25,180,420,25);
//this.loginButton.setBounds(this.getSize().width/2-140,500,100,64);
this.setBorder(BorderFactory.createLineBorder(Color.black));
this.add(this.headingLabel);
this.add(this.destinationFolderLabel);
this.add(this.destinationFolderInputBox);
this.add(this.helpButton);
this.add(this.browseButton);
this.add(this.createBackupButton);
this.addListeners();
}
public void addListeners()
{

this.createBackupButton.addActionListener(this);
this.browseButton.addActionListener(this);

}

public Dimension getSize()
{
return new Dimension(470,230);
}
public void actionPerformed(ActionEvent event)
{
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
Date date=new Date();
if(event.getSource()==this.browseButton)
{


                JFileChooser openFile = new JFileChooser();
openFile.setSelectedFile(new File(dateFormat.format(date)+"homeauto.zip"));
                openFile.showOpenDialog(null);
try
{
this.destinationFolderInputBox.setText(openFile.getSelectedFile().getAbsolutePath());
}catch(NullPointerException npe)
{
}
            }
if(event.getSource()==this.createBackupButton)
{
try
{
String output=this.destinationFolderInputBox.getText().trim();
        // input file 
        FileInputStream in = new FileInputStream("homeauto.db");

        // out put file 
ZipOutputStream out;
if(this.destinationFolderInputBox.getText().trim().length()==0)
{
out = new ZipOutputStream(new FileOutputStream(dateFormat.format(date)+"homeauto.zip"));
}
else
{
out = new ZipOutputStream(new FileOutputStream(output));
}
        // name the file inside the zip  file 
        out.putNextEntry(new ZipEntry("homeauto.db")); 

        // buffer size
        byte[] b = new byte[1024];
        int count;

        while ((count = in.read(b)) > 0) {
            out.write(b, 0, count);
        }

        out.close();
        in.close();
}catch(FileNotFoundException fnf)
{
System.out.println(fnf);
}
catch(IOException io)
{
System.out.println(io);
}



}

}
public void insertUpdate(DocumentEvent documentEvent)
{
//gets called when something gets inserted into the document
//this.search(this.userNameInputBox.getText().trim());
}


public void removeUpdate(DocumentEvent documentEvent)
{
//gets called when something gets removed from the document
}

public void changedUpdate(DocumentEvent documentEvent)
{
//gets called when a set or set of attributes change
//In our application we wont need this case
}



private void setButtonState()
{
this.createBackupButton.setEnabled(!(destinationFolderInputBox.getText().trim().length()==0));
}



public void search(String set)
{

}
}