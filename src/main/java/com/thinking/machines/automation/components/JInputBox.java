package com.thinking.machines.automation.components;
import com.thinking.machines.automation.exceptions.*;
import javax.swing.*;
import javax.swing.text.*;
public class JInputBox extends JTextField
{
public enum InputType {TEXT,DATE,NUMBER};
public enum SetType {VALID,INVALID};
public enum NumberType {POSITIVE,NEGATIVE,BOTH};
public enum DateFormat {DDMMYYYY,MMDDYYYY,YYYYMMDD,YYYYDDMM,DDYYYYMM,MMYYYYDD,DDMMYY,MMDDYY,YYDDMM,YYMMDD,MMYYDD,DDYYMM};
private InputType inputType;
private SetType setType;
private NumberType numberType;
private DateFormat dateFormat;
private String setCharacters;
private int maxLength;
private int numberOfDecimalPlaces;

public JInputBox(InputType inputType)
{
this.maxLength=32767;
if(inputType==InputType.DATE)
{
this.inputType=InputType.TEXT;
throw new ComponentException("Invalid argument.");
}
this.inputType=inputType;
setDocument(new JInputBoxPlainDocument());
}

public JInputBox(InputType inputType,SetType setType,String setCharacters,int maxLength)
{
if(inputType!=InputType.TEXT)
{
this.inputType=InputType.TEXT;
this.maxLength=32767;
throw new ComponentException("Invalid argument.");
}
this.inputType=inputType;
this.setType=setType;
this.setCharacters=setCharacters;
this.maxLength=(maxLength>=1 && maxLength<=32767)?maxLength:32767;
setDocument(new JInputBoxPlainDocument());
}

public JInputBox(InputType inputType,int maxLength)
{
this(inputType);
this.maxLength=(maxLength>=1 && maxLength<=32767)? maxLength:32767;
setDocument(new JInputBoxPlainDocument());
}

public JInputBox(InputType inputType,NumberType numberType)
{
if(inputType!=InputType.NUMBER)
{
this.inputType=InputType.TEXT;
this.maxLength=32767;
throw new ComponentException("Invalid argument.");
}
this.inputType=inputType;
this.numberType=numberType;
this.maxLength=19;
setDocument(new JInputBoxPlainDocument());
}

public JInputBox(InputType inputType,NumberType numberType,int maxLength)
{
this(inputType,numberType);
this.maxLength=19;
setDocument(new JInputBoxPlainDocument());
}

public JInputBox(InputType inputType,NumberType numberType,int maxLength,int numberOfDecimalPlaces)
{
this(inputType,numberType,maxLength);
this.numberOfDecimalPlaces=(numberOfDecimalPlaces>=0 && numberOfDecimalPlaces<=6)?numberOfDecimalPlaces:0;
setDocument(new JInputBoxPlainDocument());
}

public JInputBox(InputType inputType,DateFormat dateFormat)
{
if(inputType!=InputType.DATE)
{
this.inputType=InputType.TEXT;
this.maxLength=32767;
throw new ComponentException("Invalid argument.");
}
this.inputType=inputType;
this.dateFormat=dateFormat;
setDocument(new JInputBoxPlainDocument());
}

boolean isInputValid()
{
return true;
}

class JInputBoxPlainDocument extends PlainDocument
{
public void insertString(int position,String data,AttributeSet attributeSet) throws BadLocationException
{
if(isInputValid())
{
super.insertString(position,data,attributeSet);
}
}
}
}