/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author juan
 */
public class AboutUsPanel extends JPanel
{

    public AboutUsPanel() 
    {
        initComponents();
    }
    
    private void initComponents()
    {
        
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
        
        
        Title = new JLabel("About us");
        Title.setForeground(new Color(111,207,151));
        Title.setFont(new Font("Arial", Font.BOLD, 32));
        Title.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 0));
        
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.LINE_AXIS));
        container.setOpaque(false);
        
        card1 = new CardPanel();
        card2 = new CardPanel();
        card3 = new CardPanel();
        
        westminserLabel = new JLabel();
        Image westIcon = new ImageIcon(getClass().getResource("/images/westminster.png"))
                .getImage()
                .getScaledInstance(150, 35, Image.SCALE_SMOOTH);
        westminserLabel.setIcon(new ImageIcon(westIcon));
        westminserLabel.setHorizontalAlignment(SwingConstants.CENTER);
        westminserLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        
        container.add(Box.createHorizontalGlue());
        container.add(card1);
        container.add(Box.createHorizontalGlue());
        container.add(card2);
        container.add(Box.createHorizontalGlue());
        container.add(card3);
        container.add(Box.createHorizontalGlue());
        
        
        contentPanel.add(Title, BorderLayout.NORTH);
        contentPanel.add(container, BorderLayout.CENTER);
        contentPanel.add(westminserLabel, BorderLayout.SOUTH);
        add(contentPanel);
        add(Background);
        
        
        setLayout(null);
        
    
    }
    
    private JLabel Background;
    private JPanel contentPanel;
    private JLabel Title;
    private JPanel container;
    private JLabel westminserLabel;
    
    private CardPanel card1, card2, card3;
    
}
