/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.tools;

import com.mycompany.copycenter.entity.Users;

/**
 *
 * @author max19
 */
public class CurrentUser {
    private static Users currentUser;

    public static Users getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Users currentUser) {
        CurrentUser.currentUser = currentUser;
    }
}
