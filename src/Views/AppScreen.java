package Views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juan
 */
public class AppScreen extends JFrame 
{

    public AppScreen()
    {
        initComponents();
    }
    
    //public AppScreen(Session user){}
    
    private void initComponents()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //menuPanel;
        MenuContainer = new JPanel();
        MenuContainer.setBackground(new Color(111,207,151));
        MenuContainer.setLayout(new BorderLayout(0, 0));
        
        //contentPanel
        ContentPanel = new JPanel();
        ContentPanel.setBackground(new Color(255,255,255));
        ContentPanel.setLayout(new BoxLayout(ContentPanel, BoxLayout.PAGE_AXIS));
        //ContentContainer
        ContentContainer = new JPanel();
        ContentContainer.setLayout(new CardLayout(0, 0));
        ContentContainer.setAlignmentX(0);
        ContentContainer.setAlignmentY(0);
        ContentContainer.setBackground(new Color(255,255,255));
        
        
        //CloseContainer;
        closeContainer = new JPanel();
        closeContainer.setLayout(new FlowLayout(FlowLayout.RIGHT, 0 ,0));
        closeContainer.setAlignmentX(0);
        closeContainer.setAlignmentY(0);
        closeContainer.setBackground(new Color(255,255,255));
        //Label to close
        closeLabel = new JLabel();
        closeLabel.setForeground(new Color(111,207,151));
        closeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        closeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        closeLabel.setPreferredSize(new Dimension(32,32));
        closeLabel.setMinimumSize(new Dimension(32,32));
        closeLabel.setMaximumSize(new Dimension(32,32));
        closeLabel.setText("X");
        closeLabel.setBackground(new Color(111,207,151));
        //Listener
          closeLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
            
        });
        
        
        //menu
        menuPanel = new MenuPanel();
        
        menuPanel.getDashboardButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickDashboard(e);
            }
        });
        
        menuPanel.getProfileButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickProfile(e);
            }
        });
        
        menuPanel.getAdminConsoleButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickAdmin(e);
            }
        });
        
        menuPanel.getAboutUsButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickAbout(e);
            }
        });
        
        menuPanel.getLogoutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickLogOut(e);
            }
        });
        
        //Content
        ProfilePanel = new ProfilePanel();
        AboutPanel = new AboutUsPanel();
        
        ContentContainer.add(ProfilePanel, "PROFILE");
        ContentContainer.add(AboutPanel, "ABOUT");
        
        MenuContainer.add(menuPanel, BorderLayout.CENTER);
        
        closeContainer.add(closeLabel);
        ContentPanel.add(closeContainer);
        ContentPanel.add(ContentContainer);
        
        
        setResizable(false);
        
        //Layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(MenuContainer, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ContentPanel, GroupLayout.PREFERRED_SIZE, 1240, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        )); 
        
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(MenuContainer, GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE)
                .addComponent(ContentPanel, GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE));
        pack();
    }
    
    
    private void onClickDashboard(ActionEvent e)
    {
        System.out.println("Click on dashboard");
    }
    
    private void onClickProfile(ActionEvent e)
    {
       System.out.println("Click on Profile");
       CardLayout cards = (CardLayout)(ContentContainer.getLayout());
       cards.show(ContentContainer, "PROFILE");
    }
    
        
    private void onClickAdmin(ActionEvent e)
    {
        System.out.println("Click on Admin console");
    }
    
            
    private void onClickAbout(ActionEvent e)
    {
        System.out.println("Click on About us");
        CardLayout cards = (CardLayout)(ContentContainer.getLayout());
        cards.show(ContentContainer, "ABOUT");
    }
    
    private void onClickLogOut(ActionEvent e)
    {
        System.out.println("Click on LogOut");
        AuthScreen Login = new AuthScreen();
        Login.setVisible(true);
        this.dispose();
    }
    
    
    
    private JPanel MenuContainer;
    private JPanel ContentPanel;
    private JPanel ContentContainer;
    private JPanel closeContainer;
    private JLabel closeLabel;
    private MenuPanel menuPanel;
    
    //panelcards
    private ProfilePanel ProfilePanel;
    private AboutUsPanel AboutPanel;
}
