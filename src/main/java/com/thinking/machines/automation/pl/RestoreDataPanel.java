package com.thinking.machines.automation.pl;
import com.thinking.machines.automation.exceptions.*;
import com.thinking.machines.automation.interfaces.*;
import com.thinking.machines.automation.dao.*;
import com.thinking.machines.automation.components.*;
import com.thinking.machines.automation.model.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.event.*;
import java.util.zip.*;
import java.io.*;
import javax.swing.JFileChooser;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.filechooser.FileNameExtensionFilter;
public class RestoreDataPanel extends JPanel implements ActionListener,DocumentListener
{
private JLabel headingLabel;
private JButton browseButton,helpButton;
private JButton restoreBackupButton;
private JLabel destinationFolderLabel;
private JInputBox destinationFolderInputBox;
public RestoreDataPanel()
{
initComponents();
}
public void initComponents()
{
this.headingLabel=new JLabel("Restore Data");
this.headingLabel.setFont(new Font("Times New Roman",Font.BOLD,28));
this.restoreBackupButton=new JButton("Restore");
this.browseButton=new JButton("Browse");
this.helpButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.HELP_ICON)));
this.destinationFolderLabel=new JLabel("Destination Folder");
this.destinationFolderInputBox=new JInputBox(JInputBox.InputType.TEXT,100);
this.destinationFolderInputBox.setFont(new Font("Times New Roman",Font.PLAIN,24));
this.destinationFolderLabel.setFont(new Font("Times New Roman",Font.PLAIN,24));
this.browseButton=new JButton(new ImageIcon(this.getClass().getResource(GlobalResources.BROWSE_ICON)));

this.setLayout(null);
this.headingLabel.setBounds(25,10,300,40);
this.helpButton.setBounds(this.getSize().width-36,2,34,34);
this.destinationFolderLabel.setBounds(25,60,250,30);
this.destinationFolderInputBox.setBounds(25,90,380,35);
this.browseButton.setBounds(410,90,34,34);
this.restoreBackupButton.setBounds(25,180,420,25);
this.setBorder(BorderFactory.createLineBorder(Color.black));
this.add(this.headingLabel);
this.add(this.destinationFolderLabel);
this.add(this.destinationFolderInputBox);
this.add(this.helpButton);
this.add(this.browseButton);
this.add(this.restoreBackupButton);
this.addListeners();
}
public void addListeners()
{

this.restoreBackupButton.addActionListener(this);
this.browseButton.addActionListener(this);

}

public Dimension getSize()
{
return new Dimension(470,230);
}
public void actionPerformed(ActionEvent event)
{
if(event.getSource()==this.browseButton)
{


                JFileChooser openFile = new JFileChooser();
openFile.setFileFilter(new FileNameExtensionFilter(".zip", "zip"));
                openFile.showOpenDialog(null);
try
{
this.destinationFolderInputBox.setText(openFile.getSelectedFile().getAbsolutePath());
}catch(NullPointerException npe)
{
}
            }
if(event.getSource()==this.restoreBackupButton)
{

if(this.destinationFolderInputBox.getText().trim().length()==0)
{
}
else
{
String zipFile = this.destinationFolderInputBox.getText().trim();
    String outputFolder = "C:\\JavaProject/homeauto/build/libs";
try
{
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry ze = zis.getNextEntry();
        while(ze!=null){
            String entryName = ze.getName();
            File f = new File(outputFolder +File.separator +  entryName);
            f.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream(f);
            int len;
            byte buffer[] = new byte[1024];
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();  
            System.out.println("OK!");
            ze = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
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
this.restoreBackupButton.setEnabled(!(destinationFolderInputBox.getText().trim().length()==0));
}




}