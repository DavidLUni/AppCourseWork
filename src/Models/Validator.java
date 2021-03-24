/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author juan
 */
public class Validator 
{
    
    public static void isValidEmail(String email)
    {
        email = email.trim();
        
        if(email == null || email.equals("")) 
            throw new IllegalArgumentException("Email is empty");
        
        
        //RFC 5322 Official Standard
        if(!email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]"
                + "+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]"
                + "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9]"
                + "(?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\"
                + "[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4]"
                + "[0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-"
                + "\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
            throw new IllegalArgumentException("Provide a valid email");
    }
    
    public static void isString(String string)
    {
        string = string.trim();
        if(string == null || string.equals(""))
            throw new IllegalArgumentException("Field is empty");
    }
    
    public static void isValidPassword(String password)
    {
        password = password.trim();
        
        if(password == null || password.equals(""))
            throw new IllegalArgumentException("Password is empty");
        
        /*
            Password must contain at least one digit 0-9
            Password must contain at least one lowecase
            Password must contain at least one uppercase
            Password must containe at lesat one special character !@#&() 
            Password must contain a length of at least 8 Characters and maximun of 20 characters
        */
        String message = "Please provide secure password with the following criteria: \n"
                + "1. Password must container at least one digit 0-9 \n"
                + "2. Must contain at least one lowercase. \n"
                + "3. Must contain at least one uppercase. \n"
                + "4. Must container at least one special character [- _ / * ^ ! @ # & ( ) ].\n"
                + "5. Must container a length of at least 8 Characters and 20 maximun. ";
        
        if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*"
                + "[!@#&-_/*^()–[{}]:;',?/*~$^+=<>]).{8,20}$"))
                throw new IllegalArgumentException(message);
    }
    
    public static void confirmPassword(String password, String repeatPassword)
    {

        
        if(!password.equals(repeatPassword))
            throw new IllegalArgumentException("Password are not the same.");
        
        
    }
}
