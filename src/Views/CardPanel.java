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
import java.awt.TextArea;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author juan
 */
public class CardPanel extends JPanel
{

    public CardPanel() 
    {
        initComponents();
    }
    
    private void initComponents()
    {
    
        setBackground(new Color(111,207,151));
        setPreferredSize(new Dimension(300, 400));
        setMaximumSize(new Dimension(300, 400));
        setMinimumSize(new Dimension(300, 400));
        
        iconLabel = new JLabel();
        Image icon = new ImageIcon(getClass().getResource("/images/Logo1.png"))
                .getImage()
                .getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        iconLabel.setIcon(new ImageIcon(icon));
        iconLabel.setAlignmentX(0.5f);
        iconLabel.setAlignmentY(0.5f);
        
        Title = new JLabel();
        Title.setText("Title");
        Title.setForeground(new Color(255,255,255));
        Title.setFont(new Font("Arial", Font.BOLD, 24));
        Title.setAlignmentY(0.5f);
        Title.setAlignmentX(0.5f);
        
        
        SubTitle = new JLabel();
        SubTitle.setText("SubTitle");
        SubTitle.setForeground(new Color(255,255,255));
        SubTitle.setFont(new Font("Arial", Font.BOLD, 18));
        SubTitle.setAlignmentY(0.5f);
        SubTitle.setAlignmentX(0.5f);
        
        
        Description = new JTextArea();
        Description.setColumns(0);
        Description.setRows(20);
        Description.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
                + "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " 
                + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ");
        
        Description.setLineWrap(true);
        Description.setWrapStyleWord(true);
        Description.setForeground(new Color(255,255,255));
        Description.setFont(new Font("Arial", Font.BOLD, 16));
        Description.setOpaque(false);
        Description.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        
        add(Box.createVerticalStrut(20));
        add(iconLabel);
        add(Box.createVerticalStrut(10));
        add(Title);
        add(SubTitle);
        add(Box.createVerticalStrut(20));
        add(Description);
        
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);
    }
    
    public void setTitle(String Title)
    {
        this.Title.setText(Title);
    }
    
    public void setSubTitle(String Subtitle)
    {
        this.SubTitle.setText(Subtitle);
    }
    public void setDescription(String Description)
    {
        this.Description.setText(Description);
    }
    
    public String getTitle()
    {
        return this.Title.getText();
    }
    public String getSubTitle()
    {
        return this.SubTitle.getText();
    }
    public String getDescription()
    {
        return this.Description.getText();
    }
    
    private JLabel iconLabel;
    private JLabel Title;
    private JLabel SubTitle;
    private JTextArea Description;
    
}
