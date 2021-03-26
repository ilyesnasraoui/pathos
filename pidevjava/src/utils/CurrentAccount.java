/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Entités.user;

/**
 *
 * @author Wissem
 */
public class CurrentAccount extends user {
    static user current ;

    public CurrentAccount(int id, String username, String password, String email, String role) {
        super(id, username, password, email, role);
    }

    public CurrentAccount() {
    }



    
}
