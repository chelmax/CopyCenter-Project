/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.models;

import com.mycompany.copycenter.entity.Users;
import com.mycompany.copycenter.tools.CurrentUser;
import com.mycompany.copycenter.tools.QueryExecuter;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author max19
 */
public class AuthModel {
    
    public boolean login(String name, String surname, char[] password){
        List<Users> user = QueryExecuter.executeGetterHQLQuery(
                "from Users u where "
                + "u.name = '" + name + "' && "
                + "u.surname = '" + surname + "' && "
                + "u.password = '" + String.valueOf(password) + "'"
        );
        if(user.isEmpty()){
            return false;
        } else{
            CurrentUser.setCurrentUser(user.get(0));
            return true;
        }   
    }
    
    public boolean signup(String name, String surname, char[] password, char[] rpassword, String post){
        if("".equals(name) || "".equals(password) || "".equals(surname) )
            return false;
        if(!Arrays.equals(password, rpassword))
            return false;
        QueryExecuter.executeSQLQuery(
                "INSERT INTO Users (name, surname, password, post, salary) VALUES ("
                + "'" + name+ "', "
                + "'" + surname + "', "
                + "'" + String.valueOf(password) + "', "
                + "'" + post + "', "
                + "0)"
        );  
        return true;
    }
   
    
}
