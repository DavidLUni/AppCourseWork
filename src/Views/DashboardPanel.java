/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author juan
 */
public class DashboardPanel extends JPanel 
{

    public DashboardPanel() 
    {
        initComponents();
    }
    
    private void initComponents()
    {
        Title = new JLabel("Dashboard");
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
        
        
        //container for total
        containerTotal = new JPanel();
        containerTotal.setLayout(new BoxLayout(containerTotal, BoxLayout.LINE_AXIS));
        containerTotal.setAlignmentX(0.5f);
        containerTotal.setAlignmentY(0.5f);
        containerTotal.setBackground(new Color(242,242,242));
        containerTotal.setSize(new Dimension(900,100));
        containerTotal.setMinimumSize(new Dimension(900,100));
        containerTotal.setMaximumSize(new Dimension(900,100));
        
        JLabel label1 = new JLabel("COUNT POINTS");
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        label1.setForeground(Color.black);
        label1.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel label2 = new JLabel("TWO WHEELS");
        label2.setFont(new Font("Arial", Font.BOLD, 16));
        label2.setForeground(Color.black);
        label2.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel label3 = new JLabel("FOUR WHEELS");
        label3.setFont(new Font("Arial", Font.BOLD, 16));
        label3.setForeground(Color.black);
        label3.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        
        countLabel = new JLabel();
        countLabel.setFont(new Font("Arial", Font.BOLD, 30));
        countLabel.setForeground(new Color(111,207,151));
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);
        countLabel.setText("0");
        
        twoLabel = new JLabel();
        twoLabel.setFont(new Font("Arial", Font.BOLD, 30));
        twoLabel.setForeground(new Color(111,207,151));
        twoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        twoLabel.setText("0");
        
        fourLabel = new JLabel();
        fourLabel.setFont(new Font("Arial", Font.BOLD, 30));
        fourLabel.setForeground(new Color(111,207,151));
        fourLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fourLabel.setText("0");
        
        
        //container1
        JPanel container1 = new JPanel(new BorderLayout(0, 0));
        container1.add(label1, BorderLayout.NORTH);
        container1.add(countLabel, BorderLayout.CENTER);
        container1.setOpaque(false);
        
        //container2
        JPanel container2 = new JPanel(new BorderLayout(0, 0));
        container2.add(label2, BorderLayout.NORTH);
        container2.add(twoLabel, BorderLayout.CENTER);
        container2.setOpaque(false);
        
        //container3
        JPanel container3 = new JPanel(new BorderLayout(0, 0));
        container3.add(label3, BorderLayout.NORTH);
        container3.add(fourLabel, BorderLayout.CENTER);
        container3.setOpaque(false);
        
        containerTotal.add(container1);
        containerTotal.add(container2);
        containerTotal.add(container3);
        
        //container Selectors
        containerSelectors = new JPanel();
        containerSelectors.setLayout(new BoxLayout(containerSelectors, BoxLayout.LINE_AXIS));
        containerSelectors.setSize(new Dimension(900, 40));
        containerSelectors.setMinimumSize(new Dimension(900, 40));
        containerSelectors.setMaximumSize(new Dimension(900, 40));
        containerSelectors.setOpaque(false);
        
        
        Object[] list = new Object[]{"item 1", "item 2"};
        countPointBox = new JComboBox();
        countPointBox.setModel(new DefaultComboBoxModel(list));
        countPointBox.setBorder(null);
        countPointBox.setFont(new Font("Arial", Font.PLAIN, 16));
        countPointBox.setSize(new Dimension(450, 40));
        countPointBox.setPreferredSize(new Dimension(450, 40));
        countPointBox.setMinimumSize(new Dimension(450, 40));
        countPointBox.setMaximumSize(new Dimension(450, 40));
        
        countPointBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selecCountPoint(e);
            }
        });
        
        Object[] list1 = new Object[]{2018,2019, 2020, 2021};
        yearBox = new JComboBox();
        yearBox.setModel(new DefaultComboBoxModel(list1));
        yearBox.setBorder(null);
        yearBox.setFont(new Font("Arial", Font.PLAIN, 16));
        yearBox.setSize(new Dimension(100, 40));
        yearBox.setMinimumSize(new Dimension(100, 40));
        yearBox.setPreferredSize(new Dimension(100, 40));
        yearBox.setMaximumSize(new Dimension(100, 40));
        
        yearBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectYear(e);
            }
        });
        
        
        containerSelectors.add(countPointBox);
        containerSelectors.add(Box.createHorizontalGlue());
        containerSelectors.add(yearBox);
        
        
        
        //container information and charts
        containerInfo = new JPanel();
        containerInfo.setLayout(new BoxLayout(containerInfo, BoxLayout.PAGE_AXIS));
        containerInfo.setOpaque(false);
        
        
        //container count info.
        
        
        JScrollPane scrollPanel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setSize(new Dimension(1000, 500));
        scrollPanel.setMaximumSize(new Dimension(1000, 500));
        scrollPanel.setMinimumSize(new Dimension(1000, 500));
        scrollPanel.setAlignmentX(0.5f);
        scrollPanel.setAlignmentY(0.5f);
        scrollPanel.setOpaque(false);
        scrollPanel.setViewportView(containerInfo);
        scrollPanel.setBorder(null);
       scrollPanel.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.trackColor = Color.white;
                this.thumbColor = new Color(111, 207, 151);
            }
        });
        scrollPanel.getVerticalScrollBar().setOpaque(false);
        
        
        container.add(Box.createVerticalStrut(50));
        container.add(containerTotal);
        container.add(Box.createVerticalStrut(30));
        container.add(containerSelectors);
        container.add(Box.createVerticalStrut(15));
        container.add(scrollPanel);
        
        contentPanel.add(Title, BorderLayout.NORTH);
        contentPanel.add(container, BorderLayout.CENTER);
        add(contentPanel);
        add(Background);
        
        
        setLayout(null);
    }
    
    private void selecCountPoint(ActionEvent e)
    {

        JComboBox cb = (JComboBox) e.getSource();
        Integer choise = (Integer) cb.getSelectedItem();

        System.out.println("year: " + choise);        
    }
    
    private void selectYear(ActionEvent e)
    {
                  
        JComboBox cb = (JComboBox) e.getSource();
        String choise = (String) cb.getSelectedItem();

        System.out.println("count point: " + choise);
    }
    
    private JLabel Background;
    private JPanel contentPanel;
    private JLabel Title;
    private JPanel container;
    
    
    //containers:
    private JPanel containerTotal;
    private JPanel containerSelectors;
    private JPanel containerInfo;
    
    //data to display
    private JLabel countLabel;
    private JLabel twoLabel;
    private JLabel fourLabel;
    
    //choises
    private JComboBox countPointBox;
    private JComboBox yearBox;
}
