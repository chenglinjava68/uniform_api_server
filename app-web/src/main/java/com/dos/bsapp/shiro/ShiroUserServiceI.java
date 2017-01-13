package com.dos.bsapp.shiro;
import com.dos.bsapp.shiro.ShiroDbRealm.ShiroUser;
import java.util.*;



public interface ShiroUserServiceI
{
    ShiroUser createShiroUser(String un, char[] pwd, Object additional);
    Map<String,List<String>> collectRolePermission(ShiroUser su);

}