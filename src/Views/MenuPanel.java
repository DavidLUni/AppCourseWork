/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author juan
 */
public class MenuPanel extends JPanel
{

    public MenuPanel() 
    {
        initComponents();
    }
    
    
    private void initComponents()
    {
        setBackground(new Color(111,207,151));
        
        //Title
        Title = new JLabel("Welcome");
        Title.setForeground(new Color(255,255,255));
        Title.setFont(new Font("Arial", Font.BOLD, 24));
        Title.setAlignmentX(0.5f);
        Title.setAlignmentY(0.5f);
        
        //images
        imgIconLabel = new JLabel();
        Image icon = new  ImageIcon(getClass().getResource("/images/Logo.png"))
                .getImage()
                .getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        imgIconLabel.setIcon(new ImageIcon(icon));
        imgIconLabel.setAlignmentX(0.5f);
        imgIconLabel.setAlignmentY(0.5f);
        
        usernameLabel = new JLabel();
        usernameLabel.setText("username");
        usernameLabel.setForeground(new Color(255,255,255));
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        usernameLabel.setAlignmentX(0.5f);
        usernameLabel.setAlignmentY(0.5f);
        
        
        logoLabel = new JLabel();
        Image logo = new ImageIcon(getClass().getResource("/images/logo2.png"))
                .getImage()
                .getScaledInstance(42, 42, Image.SCALE_SMOOTH);
        logoLabel.setIcon(new ImageIcon(logo));
        logoLabel.setAlignmentX(0.5f);
        logoLabel.setAlignmentY(0.5f);
        
        
        
        dashBoardButton = new JButton("Dashboard");
        dashBoardButton.setBackground(new Color(111,207,151));
        dashBoardButton.setForeground(new Color(255,255,255));
        dashBoardButton.setFont(new Font("Arial", Font.BOLD, 16));
        dashBoardButton.setHorizontalAlignment(SwingConstants.LEFT);
        dashBoardButton.setMaximumSize(new Dimension(200,50));
        dashBoardButton.setMinimumSize(new Dimension(200,50));
        dashBoardButton.setPreferredSize(new Dimension(200,50));
        dashBoardButton.setOpaque(true);
        dashBoardButton.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        dashBoardButton.setAlignmentX(0.5f);
        dashBoardButton.setAlignmentY(0.5f);
        
        profileButton = new JButton("Profile");
        profileButton.setForeground(new Color(255,255,255));
        profileButton.setBackground(new Color(111,207,151));
        profileButton.setFont(new Font("Arial", Font.BOLD, 16));
        profileButton.setHorizontalAlignment(SwingConstants.LEFT);
        profileButton.setMaximumSize(new Dimension(200,50));
        profileButton.setMinimumSize(new Dimension(200,50));
        profileButton.setPreferredSize(new Dimension(200,50));
        profileButton.setOpaque(true);
        profileButton.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        profileButton.setAlignmentX(0.5f);
        profileButton.setAlignmentY(0.5f);
        
        adminButton = new JButton("Admin console");
        adminButton.setForeground(new Color(255,255,255));
        adminButton.setBackground(new Color(111,207,151));
        adminButton.setFont(new Font("Arial", Font.BOLD, 16));
        adminButton.setHorizontalAlignment(SwingConstants.LEFT);
        adminButton.setMaximumSize(new Dimension(200,50));
        adminButton.setMinimumSize(new Dimension(200,50));
        adminButton.setPreferredSize(new Dimension(200,50));
        adminButton.setOpaque(true);
        adminButton.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        adminButton.setAlignmentX(0.5f);
        adminButton.setAlignmentY(0.5f);
        
        aboutUsButton = new JButton("About us");
        aboutUsButton.setForeground(new Color(255,255,255));
        aboutUsButton.setBackground(new Color(111,207,151));
        aboutUsButton.setFont(new Font("Arial", Font.BOLD, 16));
        aboutUsButton.setHorizontalAlignment(SwingConstants.LEFT);
        aboutUsButton.setMaximumSize(new Dimension(200,50));
        aboutUsButton.setMinimumSize(new Dimension(200,50));
        aboutUsButton.setPreferredSize(new Dimension(200,50));
        aboutUsButton.setOpaque(true);
        aboutUsButton.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        aboutUsButton.setAlignmentX(0.5f);
        aboutUsButton.setAlignmentY(0.5f);
        
        //addding mouse Listener
        dashBoardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                
                dashBoardButton.setBackground(new Color(255,255,255));
                dashBoardButton.setForeground(new Color(111,207,151));
                
                profileButton.setBackground(new Color(111,207,151));
                profileButton.setForeground(new Color(255,255,255));
                
                adminButton.setBackground(new Color(111,207,151));
                adminButton.setForeground(new Color(255,255,255));
                
                aboutUsButton.setBackground(new Color(111,207,151));
                aboutUsButton.setForeground(new Color(255,255,255));
            }
            
        });
        
        profileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
                
                dashBoardButton.setBackground(new Color(111,207,151));
                dashBoardButton.setForeground(new Color(255,255,255));
                
                profileButton.setBackground(new Color(255,255,255));
                profileButton.setForeground(new Color(111,207,151));
                
                adminButton.setBackground(new Color(111,207,151));
                adminButton.setForeground(new Color(255,255,255));
                
                aboutUsButton.setBackground(new Color(111,207,151));
                aboutUsButton.setForeground(new Color(255,255,255));
            }
        });
        
        adminButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
                
                dashBoardButton.setBackground(new Color(111,207,151));
                dashBoardButton.setForeground(new Color(255,255,255));
                
                profileButton.setBackground(new Color(111,207,151));
                profileButton.setForeground(new Color(255,255,255));
                
                adminButton.setBackground(new Color(255,255,255));
                adminButton.setForeground(new Color(111,207,151));
                
                aboutUsButton.setBackground(new Color(111,207,151));
                aboutUsButton.setForeground(new Color(255,255,255));
            }
        });
        
        aboutUsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
                
                dashBoardButton.setBackground(new Color(111,207,151));
                dashBoardButton.setForeground(new Color(255,255,255));
                
                profileButton.setBackground(new Color(111,207,151));
                profileButton.setForeground(new Color(255,255,255));
                                
                adminButton.setBackground(new Color(111,207,151));
                adminButton.setForeground(new Color(255,255,255));
                
                aboutUsButton.setBackground(new Color(255,255,255));
                aboutUsButton.setForeground(new Color(111,207,151));
            }            
        });
        
        
        //LogoutBtn
        LogoutButton = new JButton("LOGOUT");
        LogoutButton.setForeground(new Color(255,255,255));
        LogoutButton.setBackground(new Color(235,87,87));
        LogoutButton.setMaximumSize(new Dimension(200,50));
        LogoutButton.setMinimumSize(new Dimension(200,50));
        LogoutButton.setPreferredSize(new Dimension(200,50));
        LogoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        LogoutButton.setBorder(null);
        LogoutButton.setOpaque(true);
        LogoutButton.setAlignmentX(0.5f);
        LogoutButton.setAlignmentY(0.5f);
        
        
        //MenuButtons
        
        add(Box.createVerticalStrut(15));
        add(Title);
        add(Box.createVerticalStrut(30));
        add(imgIconLabel);
        add(Box.createVerticalStrut(5));
        add(usernameLabel);
        add(Box.createVerticalStrut(50));
        add(logoLabel);
        add(Box.createVerticalStrut(15));
        add(dashBoardButton);
        add(profileButton);
        add(adminButton);
        add(aboutUsButton);
        add(Box.createVerticalGlue());
        add(LogoutButton);
        //Layout 
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);
    }
    
    
    
    
    public JButton getDashboardButton()
    {
        return this.dashBoardButton;
    }
    
    public JButton getProfileButton()
    {
        return this.profileButton;
    }
    
    public JButton getAdminConsoleButton()
    {
        return this.adminButton;
    }
    
    public JButton getAboutUsButton()
    {
        return this.aboutUsButton;
    }
    
    public JButton getLogoutButton()
    {
        return this.LogoutButton;
    }
    
    public void setUsername(String username)
    {
        this.usernameLabel.setText(username);
    }
    
    public String getUsername()
    {
        return this.usernameLabel.getText();
    }
    
    private JLabel Title;
    private JLabel imgIconLabel;
    private JLabel logoLabel;
    private JLabel usernameLabel;
    private JButton LogoutButton;
    
    //Buttons
    private JButton dashBoardButton;
    private JButton profileButton;
    private JButton adminButton;
    private JButton aboutUsButton;
    
}
