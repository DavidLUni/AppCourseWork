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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juan
 */
public class LoginPanel extends JPanel
{
    
    public LoginPanel() 
    {
        initComponents();
    }
    
    
    private void initComponents()
    {
        setBackground(new Color(255,255,255));
        
        Title = new JLabel("Welcome");
        Title.setForeground(new Color(111,207,151));
        Title.setFont(new Font("Arial", Font.BOLD, 32));
        Title.setAlignmentX(0.5f);
        Title.setAlignmentY(0.5f);
        
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
        
        //Password
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
        
        forgotPwd = new JLabel("Forgot your password?");
        forgotPwd.setForeground(Color.BLACK);
        forgotPwd.setFont(new Font("Arial", Font.PLAIN, 13));
        forgotPwd.setAlignmentX(0.0f);
        forgotPwd.setAlignmentY(0.5f);
        
        //Loginbutton
        LoginButton = new JButton("LOGIN");
        LoginButton.setForeground(Color.WHITE);
        LoginButton.setFont(new Font("Arial", Font.BOLD, 16));
        LoginButton.setBorder(null);
        LoginButton.setBackground(new Color(111,207,151));
        LoginButton.setPreferredSize(new Dimension(260, 40));
        LoginButton.setMaximumSize(new Dimension(260, 40));
        LoginButton.setMinimumSize(new Dimension(260, 40));
        LoginButton.setAlignmentX(0.5f);
        LoginButton.setAlignmentY(0.5f);
        LoginButton.setOpaque(true);
        
        
        //Sign up
        SignUPLabel = new JLabel("Sign up");
        SignUPLabel.setFont(new Font("Arial", Font.BOLD, 13));
        SignUPLabel.setForeground(new Color(111,207,151));
        JLabel SignUPLabeltxt = new JLabel("Don't have an account? ");
        SignUPLabel.setForeground(new Color(111,207,151));
        
        JPanel signUpContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        signUpContainer.setBackground(Color.WHITE);
        signUpContainer.setMaximumSize(new Dimension(200, 15));
        signUpContainer.setMinimumSize(new Dimension(200, 15));
        signUpContainer.add(SignUPLabeltxt);
        signUpContainer.add(SignUPLabel);
        signUpContainer.setAlignmentX(0.5f);
        signUpContainer.setAlignmentY(0.5f);
        
        //add components to 
        add(Box.createVerticalStrut(10));
        add(Title);
        //Email
        add(Box.createVerticalGlue());
        add(EmailLabel);
        add(EmailField);
        //Password
        add(Box.createVerticalStrut(10));
        add(PasswordLabel);
        add(PasswordField);
        add(Box.createVerticalStrut(10));
        add(forgotPwd);
        
        add(Box.createVerticalGlue());
        add(LoginButton);
        add(Box.createVerticalStrut(30));
       
        add(signUpContainer);
        add(Box.createVerticalStrut(60));
        
        //Layout
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);

    }
    
    public JButton getLoginButton()
    {
        return this.LoginButton;
    }
    
    public JLabel getForgotPasswordLabel()
    {
        return this.forgotPwd;
    }
    
    public JLabel getSignupLabel()
    {
            return this.SignUPLabel;
    }
    
    public String getEmail()
    {
        return this.EmailField.getText();
    }
    
    public void setEmail(String email)
    {
        this.EmailField.setText(email);
    }
    
    public char[] getPassword()
    {
        return this.PasswordField.getPassword();
    }
    
    public void setPassword(String password)
    {
       this.PasswordField.setText(password);
    }
    
    public void clean()
    {
        this.EmailField.setText(null);
        this.PasswordField.setText(null);
    }
    
    //Atributes
    private JLabel Title;
    private JLabel EmailLabel;
    private JLabel PasswordLabel;
    private JTextField EmailField;
    private JPasswordField PasswordField;
    private JLabel forgotPwd;
    private JButton LoginButton;
    private JLabel SignUPLabel;

}
