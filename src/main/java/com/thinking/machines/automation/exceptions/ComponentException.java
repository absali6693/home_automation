package com.thinking.machines.automation.exceptions;
public class ComponentException extends RuntimeException
{
private String message;
public ComponentException()
{
this.message=null;
}
public ComponentException(String message)
{
this.message=message;
}
public void setMessage(String message)
{
this.message=message;
}
public String getMessage()
{
return this.message;
}
public String toString()
{
if(this.message==null)
{
return "ComponentException";
}
else
{
return "ComponentException:"+this.message;
}
}
}