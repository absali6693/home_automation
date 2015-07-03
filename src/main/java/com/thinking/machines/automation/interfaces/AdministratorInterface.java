package com.thinking.machines.automation.interfaces;
public interface AdministratorInterface
{
public void setUsername(String username);
public void setPassword(String password);
public String getUsername();
public String getPassword();

public void setHintQuestion(String hintQuestion);
public void setHintAnswer(String hintAnswer);
public String getHintQuestion();
public String getHintAnswer();
}