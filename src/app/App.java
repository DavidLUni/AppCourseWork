/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import Models.UserDB;
import Models.UserModel;
import Views.AppScreen;
/**
 *
 * @author juan
 */
public class App 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here

    
       /*AuthScreen authScreen = new AuthScreen();
       authScreen.setVisible(true);*/
        UserDB db = new UserDB();
        UserModel Account = db.findUserByEmail("admin@admin.com");
        AppScreen app = new AppScreen(Account);
        app.setVisible(true);
      /**  AppScreen appScreen = new AppScreen();
        appScreen.setVisible(true);**/


    }
    
}
