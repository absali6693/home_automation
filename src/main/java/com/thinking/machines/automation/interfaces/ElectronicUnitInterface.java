package com.thinking.machines.automation.interfaces;
public interface ElectronicUnitInterface
{
public int getCode();
public boolean isSwitchable();
public boolean isControllable();
public String getControlName();
public String getName();
public AreaTypeInterface getAreaType();
public void setName(String name);
public void setControlName(String controlName);
public void setIsSwitchable(boolean switchable);
public void setIsControllable(boolean controllable);
public void setAreaType(AreaTypeInterface areaType);
public void setCode(int code);
}