/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author juan
 */
public class AdminPanel extends JPanel
{

    public AdminPanel() 
    {
        initComponents();
    }
    
    
    private void initComponents()
    {
        Title = new JLabel("Admin Console");
        Title.setForeground(new Color(111,207,151));
        Title.setFont(new Font("Arial", Font.BOLD, 32));
        Title.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 0));
        
        Background = new JLabel();
        Image backgrounLogo = new ImageIcon(getClass().getResource("/images/Background1.png"))
                .getImage()
                .getScaledInstance(1240, 800, Image.SCALE_SMOOTH);
        Background.setIcon(new ImageIcon(backgrounLogo));
        Background.setBorder(null);
        Background.setBounds(0, 0, 1240, 800);
        
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(0,0));
        contentPanel.setBounds(0, 0, 1240, 760);
        contentPanel.setOpaque(false);
        
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.setOpaque(false);
        
        
        contentPanel.add(Title, BorderLayout.NORTH);
        contentPanel.add(container, BorderLayout.CENTER);
        add(contentPanel);
        add(Background);
        
        
        setLayout(null);
    }
    
    
    
    private JLabel Background;
    private JPanel contentPanel;
    private JLabel Title;
    private JPanel container;
    
}
