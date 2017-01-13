package com.dos.exception;

public class UserNeedLoginException extends Exception
{
    public UserNeedLoginException(String msg){
        super(msg);
    }
}