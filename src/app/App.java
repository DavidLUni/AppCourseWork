/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Views.AuthScreen;
/**
 *
 * @author juan
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        AuthScreen authScreen = new AuthScreen();
        authScreen.setVisible(true);
    }
    
}
