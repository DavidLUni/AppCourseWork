/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class UserDB {

    public UserDB() {
    }

    public void createTable() {

        Connection conn = Connect.getConnection();
        Statement stmt = null;
        String createString;

        createString = "CREATE TABLE IF NOT EXISTS user (\n"
                + "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n"
                + "  username TEXT NOT NULL ,\n"
                + "  email TEXT NOT NULL UNIQUE,\n"
                + "  password TEXT NOT NULL,\n"
                + "  salt TEXT NOT NULL, \n"
                + "  firstname TEXT,\n"
                + "  lastname TEXT,\n"
                + "  description TEXT,\n"
                + "  role INTEGER DEFAULT 0,\n"
                + "  created_At DATETIME DEFAULT CURRENT_TIMESTAMP "
                + ");";

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(createString);
            System.out.println("DATABASE: User table created");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("SQLException: " + e.getMessage());
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("SQLExtoption: " + e.getMessage());
                }
            }
        }

    }

    public void createAccount(UserModel Account) throws Exception {

        Connection conn = Connect.getConnection();
        PreparedStatement stmt;
        String createString;

        createString = "INSERT INTO user (username, email, password, salt)"
                + " VALUES (?,?,?,?);";

        try {
            stmt = conn.prepareStatement(createString);
            stmt.setString(1, Account.getUsername());
            stmt.setString(2, Account.getEmail());
            stmt.setString(3, Account.getPassword());
            stmt.setString(4, Account.getSalt());

            stmt.executeUpdate();
            System.out.println("DATABASE: Account successfully created ");
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("DATABASE: Account error to create.");

            throw new Exception("User already exist.");
        }

    }

    public void createUser(UserModel User) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt;
        String createString;

        createString = "INSERT INTO user("
                + "username, email, password, salt "
                + "firstname, lastname, role, description) "
                + "VALUES(?,?,?,?,?,?,?,?);";

        try {
            stmt = conn.prepareStatement(createString);
            stmt.setString(1, User.getUsername());
            stmt.setString(2, User.getEmail());
            stmt.setString(3, User.getPassword());
            stmt.setString(4, User.getSalt());
            stmt.setString(5, User.getFirstname());
            stmt.setString(6, User.getLastname());
            stmt.setInt(7, User.getRole());
            stmt.setString(8, User.getDescription());

            stmt.executeUpdate();

            System.out.println("DATABASE: User successfully created.");
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("DATABASE: User error to create.");
        }
    }

    public void updateUser(UserModel user) throws Exception {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt;
        String updateString;

        updateString = "UPDATE user "
                + "SET username = ?, "
                + "firstname = ?,"
                + "lastname = ?,"
                + "email = ?,"
                + "password= ?,"
                + "salt= ?,"
                + "description= ?,"
                + "role= ? "
                + "WHERE id = ?;";

        try {
            stmt = conn.prepareStatement(updateString);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getFirstname());
            stmt.setString(3, user.getLastname());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getSalt());
            stmt.setString(7, user.getDescription());
            stmt.setInt(8, user.getRole());
            stmt.setInt(9, user.getId());

            stmt.executeUpdate();
            System.out.println("DATABASE: User successfully updated.");
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("DATABASE: User error update .");
            throw new Exception("Could not update user");
        }
    }

    public void deleteUser(int id) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt;
        String deleteString;

        deleteString = "DELETE FROM user WHERE id=?";

        try {
            stmt = conn.prepareStatement(deleteString);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("DATABASE: User successfully deleted.");
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("DATABASE: User error to delete user.");
        }
    }

    public UserModel showOne(int id) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt;
        String stmtString;

        stmtString = "SELECT * FROM user WHERE id = ?;";
        ArrayList<UserModel> userList = new ArrayList<>();

        try {
            stmt = conn.prepareStatement(stmtString);
            //set value

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            System.out.println("DATABASE: Query successully.");

            while (rs.next()) {
                if (rs.getString("email") != null) {
                    UserModel Account = new UserModel();
                    Account.setId(rs.getInt("id"));
                    Account.setUsername(rs.getString("username"));
                    Account.setFirstname(rs.getString("firstname"));
                    Account.setLastname(rs.getString("lastname"));
                    Account.setEmail(rs.getString("email"));
                    Account.setPassword(rs.getString("password"));
                    Account.setSalt(rs.getString("salt"));
                    Account.setRole(rs.getInt("role"));
                    Account.setDescription(rs.getString("description"));
                    Account.setCreated_at(rs.getString("created_at"));
                    userList.add(Account);
                }
            }

            if (!userList.isEmpty()) {
                return userList.get(0);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public UserModel findUserByEmail(String email) {
        Connection conn = Connect.getConnection();
        PreparedStatement stmt;
        String findOne;

        findOne = "SELECT * FROM user WHERE email = ?;";
        UserModel Account = null;
        try {
            stmt = conn.prepareStatement(findOne);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("email") != null) {
                    UserModel user = new UserModel();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setFirstname(rs.getString("firstname"));
                    user.setLastname(rs.getString("lastname"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setSalt(rs.getString("salt"));
                    user.setRole(rs.getInt("role"));
                    user.setDescription(rs.getString("description"));
                    user.setCreated_at(rs.getString("created_at"));

                    Account = user;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Account;

    }

    public ArrayList<UserModel> showAll() {
        Connection conn = Connect.getConnection();
        Statement stmt;
        String stmtString;

        stmtString = "SELECT id, username, email, role, created_at FROM user ;";
        ArrayList<UserModel> userList = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(stmtString);

            System.out.println("DATABASE: Query successully.");

            while (rs.next()) {
                if (rs.getString("email") != null) {
                    UserModel Account = new UserModel();
                    Account.setId(rs.getInt("id"));
                    Account.setUsername(rs.getString("username"));
                    Account.setEmail(rs.getString("email"));
                    Account.setRole(rs.getInt("role"));
                    Account.setCreated_at(rs.getString("created_at"));
                    userList.add(Account);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userList;
    }
}
