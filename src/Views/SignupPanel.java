/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author juan
 */
public class SignupPanel extends JPanel
{

    public SignupPanel() 
    {
        initComponents();
    }
    
    private void initComponents()
    {
        setBackground(new Color(255,255,255));
        
        Title = new JLabel("Create account");
        Title.setForeground(new Color(111,207,151));
        Title.setFont(new Font("Arial", Font.BOLD, 32));
        Title.setAlignmentX(0.5f);
        Title.setAlignmentY(0.5f);
        
        //user
        UserLabel = new JLabel("Username");
        UserLabel.setMaximumSize(new Dimension(260, 20));
        UserLabel.setMinimumSize(new Dimension(260, 20));
        UserLabel.setPreferredSize(new Dimension(260, 20));
        UserLabel.setForeground(Color.BLACK);
        UserLabel.setFont(new Font("Arial", Font.BOLD, 14));
        UserLabel.setAlignmentX(0.5f);
        UserLabel.setAlignmentY(0.5f);
        
        UserField = new JTextField();
        UserField.setBorder(null);
        UserField.setBackground(new Color(242,242,242));
        UserField.setCaretColor(new Color(111,207,151));
        UserField.setMaximumSize(new Dimension(260, 32));
        UserField.setMinimumSize(new Dimension(260, 32));
        UserField.setPreferredSize(new Dimension(260, 32));
        UserField.setFont(new Font("Arial", Font.PLAIN, 14));
        UserField.setAlignmentX(0.5f);
        UserField.setAlignmentY(0.5f);
        
        //Email
        EmailLabel = new JLabel("Email");
        EmailLabel.setMaximumSize(new Dimension(260, 20));
        EmailLabel.setMinimumSize(new Dimension(260, 20));
        EmailLabel.setPreferredSize(new Dimension(260, 20));
        EmailLabel.setForeground(Color.BLACK);
        EmailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        EmailLabel.setAlignmentX(0.5f);
        EmailLabel.setAlignmentY(0.5f);
        
        EmailField = new JTextField();
        EmailField.setBorder(null);
        EmailField.setBackground(new Color(242,242,242));
        EmailField.setCaretColor(new Color(111,207,151));
        EmailField.setMaximumSize(new Dimension(260, 32));
        EmailField.setMinimumSize(new Dimension(260, 32));
        EmailField.setPreferredSize(new Dimension(260, 32));
        EmailField.setFont(new Font("Arial", Font.PLAIN, 14));
        EmailField.setAlignmentX(0.5f);
        EmailField.setAlignmentY(0.5f);
        
        //password
        PasswordLabel = new JLabel("Password");
        PasswordLabel.setMaximumSize(new Dimension(260, 20));
        PasswordLabel.setMinimumSize(new Dimension(260, 20));
        PasswordLabel.setPreferredSize(new Dimension(260, 20));
        PasswordLabel.setForeground(Color.BLACK);
        PasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        PasswordLabel.setAlignmentX(0.5f);
        PasswordLabel.setAlignmentY(0.5f);
        
        PasswordField = new JPasswordField();
        PasswordField.setBorder(null);
        PasswordField.setBackground(new Color(242,242,242));
        PasswordField.setCaretColor(new Color(111,207,151));
        PasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        PasswordField.setMaximumSize(new Dimension(260, 32));
        PasswordField.setMinimumSize(new Dimension(260, 32));
        PasswordField.setPreferredSize(new Dimension(260, 32));
        PasswordField.setAlignmentX(0.5f);
        PasswordField.setAlignmentY(0.5f);
        
        //confirm password
        ResetPasswordLabel = new JLabel("Confirm password");
        ResetPasswordLabel.setMaximumSize(new Dimension(260, 20));
        ResetPasswordLabel.setMinimumSize(new Dimension(260, 20));
        ResetPasswordLabel.setPreferredSize(new Dimension(260, 20));
        ResetPasswordLabel.setForeground(Color.BLACK);
        ResetPasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        ResetPasswordLabel.setAlignmentX(0.5f);
        ResetPasswordLabel.setAlignmentY(0.5f);
        
        ResetPasswordField = new JPasswordField();
        ResetPasswordField.setBorder(null);
        ResetPasswordField.setBackground(new Color(242,242,242));
        ResetPasswordField.setCaretColor(new Color(111,207,151));
        ResetPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        ResetPasswordField.setMaximumSize(new Dimension(260, 32));
        ResetPasswordField.setMinimumSize(new Dimension(260, 32));
        ResetPasswordField.setPreferredSize(new Dimension(260, 32));
        ResetPasswordField.setAlignmentX(0.5f);
        ResetPasswordField.setAlignmentY(0.5f);
        
        //Signup button
        SignupButton = new JButton("REGISTER");
        SignupButton.setForeground(Color.WHITE);
        SignupButton.setFont(new Font("Arial", Font.BOLD, 16));
        SignupButton.setBorder(null);
        SignupButton.setBackground(new Color(111,207,151));
        SignupButton.setPreferredSize(new Dimension(260, 40));
        SignupButton.setMaximumSize(new Dimension(260, 40));
        SignupButton.setMinimumSize(new Dimension(260, 40));
        SignupButton.setAlignmentX(0.5f);
        SignupButton.setAlignmentY(0.5f);
        SignupButton.setOpaque(true);
        
        //Login
        LoginLabel = new JLabel("Log in");
        LoginLabel.setFont(new Font("Arial", Font.BOLD, 13));
        LoginLabel.setForeground(new Color(111,207,151));
        JLabel SignUPLabeltxt = new JLabel("Don't have an account? ");
        LoginLabel.setForeground(new Color(111,207,151));
        
        JPanel LoginContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        LoginContainer.setBackground(Color.WHITE);
        LoginContainer.setMaximumSize(new Dimension(200, 15));
        LoginContainer.setMinimumSize(new Dimension(200, 15));
        LoginContainer.add(SignUPLabeltxt);
        LoginContainer.add(LoginLabel);
        LoginContainer.setAlignmentX(0.5f);
        LoginContainer.setAlignmentY(0.5f);
        
        //add components
        add(Box.createVerticalStrut(10));
        add(Title);
        
        //username
        add(Box.createVerticalGlue());
        add(UserLabel);
        add(UserField);
        //email
        add(Box.createVerticalStrut(10));
        add(EmailLabel);
        add(EmailField);
        //password;
        add(Box.createVerticalStrut(10));
        add(PasswordLabel);        
        add(PasswordField);
        add(Box.createVerticalStrut(10));
        add(ResetPasswordLabel);
        add(ResetPasswordField);
        add(Box.createVerticalGlue());
        //Sign up
        add(SignupButton);
        add(Box.createVerticalStrut(30));
        add(LoginContainer);
        add(Box.createVerticalStrut(60));

        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);
    }
    
    public JButton getSignupButton()
    {
        return this.SignupButton;
    }
    
    public JLabel getLoginLabel()
    {
        return this.LoginLabel;
    }
    
    public String getUsername()
    {
        return this.UserField.getText();
    }
    
    public String getEmail()
    {
        return this.EmailField.getText();
    }
    public char[] getPassword()
    {
        return this.PasswordField.getPassword();
    }
    
    public char[] getConfirmPassword()
    {
        return this.ResetPasswordField.getPassword();
    }
    
    
    public void setUsername(String username)
    {
        this.UserField.setText(username);
    }
    public void setEmail(String email)
    {
        this.EmailField.setText(email);
    }
    public void setPassword(String password)
    {
        this.PasswordField.setText(password);
    }
    public void setResetPasword(String password)
    {
        this.ResetPasswordField.setText(password);
    }
    
    public void clean()
    {
        this.UserField.setText(null);
        this.EmailField.setText(null);
        this.PasswordField.setText(null);
        this.ResetPasswordField.setText(null);
    }
    
    private JLabel Title;
    private JLabel EmailLabel;
    private JLabel UserLabel;
    private JLabel PasswordLabel;
    private JLabel ResetPasswordLabel;
    private JLabel LoginLabel;
    private JTextField EmailField;
    private JTextField UserField;
    private JPasswordField PasswordField;
    private JPasswordField ResetPasswordField;
    private JButton SignupButton;
    
}
