package com.thinking.machines.automation.components;
import javax.swing.*;
import java.awt.event.*;
public class JClearTextField extends JLabel
{
private JTextField targetTextField;
public JClearTextField(JTextField targetTextField)
{
setIcon(new ImageIcon(this.getClass().getResource("clearIcon.png")));
this.targetTextField=targetTextField;
this.addMouseListener(new MouseAdapter(){
public void mouseClicked(MouseEvent mouseEvent)
{
JClearTextField.this.targetTextField.setText("");
}
});
}
}