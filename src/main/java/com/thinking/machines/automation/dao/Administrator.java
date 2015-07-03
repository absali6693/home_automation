package com.thinking.machines.automation.dao;
import com.thinking.machines.automation.interfaces.*;
public class Administrator implements AdministratorInterface
{
private String username;
private String password;
private String hintQuestion;
private String hintAnswer;
public Administrator()
{
this.username="";
this.password="";
this.hintQuestion="";
this.hintAnswer="";
}
public Administrator(String username,String password,String hintQuestion,String hintAnswer)
{
this.username=username;
this.password=password;
this.hintQuestion=hintQuestion;
this.hintAnswer=hintAnswer;
}
public void setUsername(String username)
{
this.username=username;
}
public void setPassword(String password)
{
this.password=password;
}
public String getUsername()
{
return this.username;
}
public String getPassword()
{
return this.password;
}
public void setHintQuestion(String hintQuestion)
{
this.hintQuestion=hintQuestion;
}
public void setHintAnswer(String hintAnswer)
{
this.hintAnswer=hintAnswer;
}
public String getHintQuestion()
{
return this.hintQuestion;
}
public String getHintAnswer()
{
return this.hintAnswer;
}
public boolean equals(Object object)
{
if(!(object instanceof Administrator)) return false;
Administrator administrator=(Administrator)object;
return this.username.equals(administrator.getUsername()) && this.password.equals(administrator.getPassword());
}
}
