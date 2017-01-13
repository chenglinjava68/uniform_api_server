package com.dos.shiro;
import java.util.*;



public interface ShiroUserServiceI
{
    ShiroDbRealm.ShiroUser createShiroUser(String un, char[] pwd, Object additional);
    Map<String,List<String>> collectRolePermission(ShiroDbRealm.ShiroUser su);

}