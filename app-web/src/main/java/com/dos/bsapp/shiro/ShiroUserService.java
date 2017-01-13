package com.dos.bsapp.shiro;

import com.dos.bsapp.shiro.ShiroDbRealm.ShiroUser;
import java.util.*;
public class ShiroUserService
{
    public ShiroUser createShiroUser(String un, char[] pwd, Object additional){
        //PrimitiveUser userInfo = new PrimitiveUser(); // userInfo = userGetService.getBasicBy(token.getUsername(),token.getPassword(),token.getAddition());
            //ShiroUser su = new ShiroUser(userInfo.getId(),userInfo.getNick(),token.getAddition());

        return new ShiroUser(12,un,additional);
    }

    public Map<String,List<String>> collectRolePermission(ShiroUser su)
    {
        Map<String,List<String>> ret = new HashMap<String,List<String>>();
        List<String> rList = new ArrayList<String>();
        rList.add("user");
        ret.put("role",rList);
        List<String> pList = new ArrayList<String>();
        pList.add("user:delete");
        ret.put("permission",pList);
        return ret;
    }
}