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
public class ResetPanel extends JPanel
{

    public ResetPanel() 
    {
        initComponents();
    }
    
    private void initComponents()
    {
        setBackground(new Color(255,255,255));
        
        Title = new JLabel("Reset password");
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
        
        //password
        PasswordLabel = new JLabel("New password");
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
        
        //Reset
        ResetButton = new JButton("RESET PASSWORD");
        ResetButton.setForeground(Color.WHITE);
        ResetButton.setFont(new Font("Arial", Font.BOLD, 16));
        ResetButton.setBorder(null);
        ResetButton.setBackground(new Color(111,207,151));
        ResetButton.setPreferredSize(new Dimension(260, 40));
        ResetButton.setMaximumSize(new Dimension(260, 40));
        ResetButton.setMinimumSize(new Dimension(260, 40));
        ResetButton.setAlignmentX(0.5f);
        ResetButton.setAlignmentY(0.5f);
        ResetButton.setOpaque(true);
        
        //Cancel
        CancelButton = new JButton("CANCEL");
        CancelButton.setForeground(Color.WHITE);
        CancelButton.setFont(new Font("Arial", Font.BOLD, 16));
        CancelButton.setBorder(null);
        CancelButton.setBackground(new Color(235,87,87));
        CancelButton.setPreferredSize(new Dimension(260, 40));
        CancelButton.setMaximumSize(new Dimension(260, 40));
        CancelButton.setMinimumSize(new Dimension(260, 40));
        CancelButton.setAlignmentX(0.5f);
        CancelButton.setAlignmentY(0.5f);
        CancelButton.setOpaque(true);
        
        //add components
        add(Box.createVerticalStrut(10));
        add(Title);
        add(Box.createVerticalGlue());  
        //email
        add(EmailLabel);
        add(EmailField);
        add(Box.createVerticalStrut(10));
        //password;
        add(PasswordLabel);        
        add(PasswordField);
        add(Box.createVerticalStrut(10));
        add(ResetPasswordLabel);
        add(ResetPasswordField);
        add(Box.createVerticalGlue()); 
        
        //Sign up
        add(ResetButton);
        add(Box.createVerticalStrut(5));
        add(CancelButton);
        add(Box.createVerticalStrut(60));

        
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);
    }
    
    public JButton getResetButton()
    {
        return this.ResetButton;
    }
    public JButton getCancelButton()
    {
        return this.CancelButton;
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
    
    
    public void setEmail(String email)
    {
        this.EmailField.setText(email);
    }
    
    public void setPasword(String password)
    {
        this.PasswordField.setText(password);
    }
       
    public void setConfirmPassword(String password)
    {
        this.ResetPasswordLabel.setText(password);
    }
    
    
    public void clean() 
    {
        this.EmailField.setText(null);
        this.PasswordField.setText(null);
        this.ResetPasswordField.setText(null);
    }
    
    private JLabel Title;
    private JLabel EmailLabel;
    private JLabel PasswordLabel;
    private JLabel ResetPasswordLabel;
    private JTextField EmailField;
    private JPasswordField PasswordField;
    private JPasswordField ResetPasswordField;
    private JButton ResetButton;
    private JButton CancelButton;
}
