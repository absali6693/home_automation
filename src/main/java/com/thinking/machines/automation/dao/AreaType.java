package com.thinking.machines.automation.dao;
import com.thinking.machines.automation.interfaces.*;
public class AreaType implements AreaTypeInterface
{
String name;
public AreaType()
{
this.name="";
}
public AreaType(String name)
{
this.name=name;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public boolean equals(Object object)
{
if(!(object instanceof AreaType)) return false;
AreaType areaType=(AreaType)object;
return this.name.equalsIgnoreCase(areaType.name);
}
public int compareto(AreaType areaType)
{
String t1=this.name.toUpperCase();
String t2=areaType.name.toUpperCase();
return t1.compareTo(t2);
}
}