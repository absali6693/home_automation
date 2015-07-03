package com.thinking.machines.automation.dao;
import com.thinking.machines.automation.interfaces.*;
public class ElectronicUnit implements ElectronicUnitInterface
{
private int code;
private String controlName;
private String name;
private boolean switchable;
private boolean controllable;
private AreaTypeInterface areaType;

public ElectronicUnit()
{
controlName="";
name="";
code=0;
switchable=false;
controllable=false;
areaType=null;
}

public ElectronicUnit(int code,String name,String controlName,AreaTypeInterface areaType,boolean switchable,boolean controllable)
{
this.code=code;
this.name=name;
this.controlName=controlName;
this.areaType=areaType;
this.switchable=switchable;
this.controllable=controllable;
}

public int getCode()
{
return this.code;
}

public boolean isSwitchable()
{
return this.switchable;
}

public boolean isControllable()
{
return this.controllable;
}

public String getControlName()
{
return this.controlName;
}

public String getName()
{
return this.name;
}

public AreaTypeInterface getAreaType()
{
return this.areaType;
}

public void setName(String name)
{
this.name=name;
}

public void setControlName(String controlName)
{
this.controlName=controlName;
}

public void setIsSwitchable(boolean switchable)
{
this.switchable=switchable;
}

public void setIsControllable(boolean controllable)
{
this.controllable=controllable;
}

public void setAreaType(AreaTypeInterface areaType)
{
this.areaType=areaType;
}

public void setCode(int code)
{
this.code=code;
}
}