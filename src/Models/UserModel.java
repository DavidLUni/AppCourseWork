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
public class UserModel {
    private int id;
    private String username;
    private String lastname;
    private String firstname;
    private String description;
    private String email;
    private String salt;
    private String password;
    private int role;
    private String created_at;

    public UserModel(int id, String username, String lastname, String firstname, String description, String email, String password,String salt, int role, String created_at) {
        this.id = id;
        this.username = username;
        this.lastname = lastname;
        this.firstname = firstname;
        this.description = description;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.role = role;
        this.created_at = created_at;
    }
    
    public UserModel(){}
    
    public String getSalt() {
        return salt;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    
    
}
