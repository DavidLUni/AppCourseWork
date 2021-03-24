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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
        
        descriptionArea = new JTextArea();
        descriptionArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " 
                + "sed do eiusmod tempor incididunt ut labore et dolore magna" 
                + " aliqua. Ut enim ad minim veniam, ");
        descriptionArea.setRows(4);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setPreferredSize(new Dimension(1000,50));
        descriptionArea.setMaximumSize(new Dimension(1000,50));
        descriptionArea.setMinimumSize(new Dimension(1000,50));
        descriptionArea.setAlignmentX(0.5f);
        descriptionArea.setAlignmentY(0.5f);
        
        //Buttons
        addButton = new JButton("CREATE USER");
        addButton.setPreferredSize(new Dimension(150,40));
        addButton.setMaximumSize(new Dimension(150,40));
        addButton.setMinimumSize(new Dimension(150,40));
        addButton.setBackground(new Color(45,156,219));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setOpaque(true);
        addButton.setBorder(null);
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                create(e);
            }
        });
        
        viewProfileButton = new JButton("VIEW PROFILE");
        viewProfileButton.setPreferredSize(new Dimension(150,40));
        viewProfileButton.setMaximumSize(new Dimension(150,40));
        viewProfileButton.setMinimumSize(new Dimension(150,40));
        viewProfileButton.setForeground(Color.WHITE);
        viewProfileButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewProfileButton.setBackground(new Color(111,207,151));
        viewProfileButton.setOpaque(true);
        viewProfileButton.setBorder(null);
        
        viewProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view(e);
            }
        });
        
        JPanel searchContainer = new JPanel(new BorderLayout(0, 0));
        searchContainer.setPreferredSize(new Dimension(380,40));
        searchContainer.setMinimumSize(new Dimension(380,40));
        searchContainer.setMaximumSize(new Dimension(380,40));
        searchContainer.setBorder(BorderFactory.createLineBorder(new Color(111,207,151),2));
        
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(300,40));
        searchField.setMinimumSize(new Dimension(300,40));
        searchField.setMaximumSize(new Dimension(300,40));
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setBackground(new Color(242,242,242));
        searchField.setCaretColor(new Color(111,207,151));
        searchField.setBorder(null);
        searchField.setForeground(Color.BLACK);
        
        searchButton = new JButton("SEARCH");
        searchButton.setPreferredSize(new Dimension(80,40));
        searchButton.setMinimumSize(new Dimension(80,40));
        searchButton.setMaximumSize(new Dimension(80,40));
        searchButton.setForeground(Color.WHITE);
        searchButton.setBackground(new Color(111,207,151));
        searchButton.setFont(new Font("Arial",Font.BOLD, 16));
        searchButton.setOpaque(true);
        searchButton.setBorder(null);
        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search(e);
            }
        });
        
        searchContainer.add(searchField, BorderLayout.CENTER);
        searchContainer.add(searchButton,BorderLayout.EAST);
        
        JPanel buttonsContainer = new JPanel();
        buttonsContainer.setPreferredSize(new Dimension(1000,40));
        buttonsContainer.setMinimumSize(new Dimension(1000,40));
        buttonsContainer.setMaximumSize(new Dimension(1000,40));
        buttonsContainer.setOpaque(false);
        buttonsContainer.setLayout(new BoxLayout(buttonsContainer, BoxLayout.LINE_AXIS));
        buttonsContainer.setAlignmentX(0.5f);
        buttonsContainer.setAlignmentY(0.5f);
        buttonsContainer.add(searchContainer);
        buttonsContainer.add(Box.createHorizontalGlue());
        buttonsContainer.add(viewProfileButton);
        buttonsContainer.add(Box.createHorizontalStrut(50));
        buttonsContainer.add(addButton);
        
       
        container.add(Box.createVerticalStrut(50));
        container.add(descriptionArea);
        container.add(Box.createVerticalStrut(20));
        container.add(buttonsContainer);
        container.add(Box.createVerticalGlue());
        
        contentPanel.add(Title, BorderLayout.NORTH);
        contentPanel.add(container, BorderLayout.CENTER);
        add(contentPanel);
        add(Background);
        
        
        setLayout(null);
    }
    
    
    private void search (ActionEvent e){}
    private void view(ActionEvent e){}
    private void create(ActionEvent e){}
    
    
    private JLabel Background;
    private JPanel contentPanel;
    private JLabel Title;
    private JPanel container;
    
    private JTextField searchField;
    private JButton searchButton;
    private JButton addButton;
    private JButton viewProfileButton;
    private JTextArea descriptionArea;
}
