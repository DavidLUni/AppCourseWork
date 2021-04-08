/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Constants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author juan
 */
public class ProfilePanel extends JPanel {

    public ProfilePanel(int Flag) {
        this.state = Flag;
        initComponents();

        if (this.state != Constants.ADMIN_FLAG) //if user
        {
            this.UsernameField.setEditable(false);
            this.FirstNameField.setEditable(false);
            this.LastNameField.setEditable(false);
            this.RoleBox.setEnabled(false);
            this.descriotionTextArea.setEditable(false);
            this.PasswordField.setEditable(false);

            this.saveButton.setVisible(false);
            this.deleteButton.setVisible(false);
            this.closeButton.setVisible(true);
            
        } else
        {
            
            this.UsernameField.setEditable(true);
            this.FirstNameField.setEditable(true);
            this.LastNameField.setEditable(true);
            this.RoleBox.setEnabled(true);
            this.descriotionTextArea.setEditable(true);
            this.PasswordField.setEditable(true);

            this.saveButton.setVisible(true);
            this.deleteButton.setVisible(true);
            this.closeButton.setVisible(true);
        
        }

    }

    private void initComponents() {

        Title = new JLabel("Profile");
        Title.setForeground(new Color(111, 207, 151));
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
        contentPanel.setLayout(new BorderLayout(0, 0));
        contentPanel.setBounds(0, 0, 1240, 760);
        contentPanel.setOpaque(false);

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.setOpaque(false);

        iconLabel = new JLabel();
        Image icon = new ImageIcon(getClass().getResource("/images/Logo1.png"))
                .getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        iconLabel.setIcon(new ImageIcon(icon));
        iconLabel.setAlignmentX(0.5f);
        iconLabel.setAlignmentY(0.5f);

        DescriptionLabel = new JLabel("DESCRIPTION");
        DescriptionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        DescriptionLabel.setForeground(Color.BLACK);
        DescriptionLabel.setPreferredSize(new Dimension(500, 30));
        DescriptionLabel.setMaximumSize(new Dimension(500, 30));
        DescriptionLabel.setMinimumSize(new Dimension(500, 30));
        DescriptionLabel.setAlignmentY(0.5f);
        DescriptionLabel.setAlignmentX(0.5f);

        descriotionTextArea = new JTextArea();
        descriotionTextArea.setCaretColor(new Color(111, 207, 151));
        descriotionTextArea.setColumns(1);
        descriotionTextArea.setRows(10);
        descriotionTextArea.setLineWrap(true);
        descriotionTextArea.setWrapStyleWord(true);
        descriotionTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descriotionTextArea.setBackground(new Color(242, 242, 242));
        descriotionTextArea.setForeground(Color.BLACK);
        descriotionTextArea.setPreferredSize(new Dimension(500, 120));
        descriotionTextArea.setMaximumSize(new Dimension(500, 120));
        descriotionTextArea.setMinimumSize(new Dimension(500, 120));
        descriotionTextArea.setAlignmentY(0.5f);
        descriotionTextArea.setAlignmentX(0.5f);

        //Email
        EmailLabel = new JLabel("EMAIL");
        EmailLabel.setFont(new Font("Arial", Font.BOLD, 16));
        EmailLabel.setForeground(Color.BLACK);
        EmailLabel.setPreferredSize(new Dimension(500, 30));
        EmailLabel.setMaximumSize(new Dimension(500, 30));
        EmailLabel.setMinimumSize(new Dimension(500, 30));
        EmailLabel.setAlignmentY(0.5f);
        EmailLabel.setAlignmentX(0.5f);

        EmailField = new JTextField();
        EmailField.setFont(new Font("Arial", Font.PLAIN, 14));
        EmailField.setBackground(new Color(242, 242, 242));
        EmailField.setCaretColor(new Color(111, 207, 151));
        EmailField.setBorder(null);
        EmailField.setForeground(Color.BLACK);
        EmailField.setPreferredSize(new Dimension(500, 30));
        EmailField.setMaximumSize(new Dimension(500, 30));
        EmailField.setMinimumSize(new Dimension(500, 30));
        EmailField.setAlignmentY(0.5f);
        EmailField.setAlignmentX(0.5f);

        //password
        PasswordLabel = new JLabel("PASSWORD");
        PasswordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        PasswordLabel.setForeground(Color.BLACK);
        PasswordLabel.setPreferredSize(new Dimension(500, 30));
        PasswordLabel.setMaximumSize(new Dimension(500, 30));
        PasswordLabel.setMinimumSize(new Dimension(500, 30));
        PasswordLabel.setAlignmentY(0.5f);
        PasswordLabel.setAlignmentX(0.5f);

        PasswordField = new JPasswordField();
        PasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        PasswordField.setBackground(new Color(242, 242, 242));
        PasswordField.setCaretColor(new Color(111, 207, 151));
        PasswordField.setBorder(null);
        PasswordField.setForeground(Color.BLACK);
        PasswordField.setPreferredSize(new Dimension(500, 30));
        PasswordField.setMaximumSize(new Dimension(500, 30));
        PasswordField.setMinimumSize(new Dimension(500, 30));
        PasswordField.setAlignmentY(0.5f);
        PasswordField.setAlignmentX(0.5f);

        //MINICONTAINERS
        JPanel gridBox = new JPanel();
        gridBox.setLayout(new GridLayout(4, 2, 50, 0));
        gridBox.setPreferredSize(new Dimension(500, 120));
        gridBox.setMaximumSize(new Dimension(500, 120));
        gridBox.setMinimumSize(new Dimension(500, 120));
        gridBox.setAlignmentX(0.5f);
        gridBox.setAlignmentY(0.5f);
        gridBox.setOpaque(false);

        UsernameLabel = new JLabel("USERNAME");
        UsernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        UsernameLabel.setForeground(Color.BLACK);

        UsernameField = new JTextField();
        UsernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        UsernameField.setBackground(new Color(242, 242, 242));
        UsernameField.setCaretColor(new Color(111, 207, 151));
        UsernameField.setBorder(null);
        UsernameField.setForeground(Color.BLACK);

        RoleLabel = new JLabel("ROLE");
        RoleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        RoleLabel.setForeground(Color.BLACK);

        String[] roles = {"Admin", "User"};
        RoleBox = new JComboBox<>(roles);
        RoleBox.setBorder(null);
        RoleBox.setBackground(new Color(242, 242, 242));
        RoleBox.setFont(new Font("Arial", Font.PLAIN, 14));
        RoleBox.setForeground(Color.BLACK);
        RoleBox.setOpaque(true);
        //User by default
        RoleBox.setSelectedItem("User");

        RoleBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSelectRole(e);
            }
        });

        FirstNameLabel = new JLabel("FIRST NAME");
        FirstNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        FirstNameLabel.setForeground(Color.BLACK);

        FirstNameField = new JTextField();
        FirstNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        FirstNameField.setBackground(new Color(242, 242, 242));
        FirstNameField.setCaretColor(new Color(111, 207, 151));
        FirstNameField.setBorder(null);
        FirstNameField.setForeground(Color.BLACK);

        LastNameLabel = new JLabel("LAST NAME");
        LastNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        LastNameLabel.setForeground(Color.BLACK);

        LastNameField = new JTextField();
        LastNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        LastNameField.setBackground(new Color(242, 242, 242));
        LastNameField.setCaretColor(new Color(111, 207, 151));
        LastNameField.setBorder(null);
        LastNameField.setForeground(Color.BLACK);

        gridBox.add(UsernameLabel);
        gridBox.add(RoleLabel);
        gridBox.add(UsernameField);
        gridBox.add(RoleBox);
        gridBox.add(FirstNameLabel);
        gridBox.add(LastNameLabel);
        gridBox.add(FirstNameField);
        gridBox.add(LastNameField);

        //Buttons
        saveButton = new JButton("SAVE");
        saveButton.setOpaque(true);
        saveButton.setBorder(null);
        saveButton.setForeground(new Color(255, 255, 255));
        saveButton.setBackground(new Color(45, 156, 219));
        saveButton.setFont(new Font("Arial", Font.BOLD, 16));
        saveButton.setPreferredSize(new Dimension(150, 40));
        saveButton.setMaximumSize(new Dimension(150, 40));
        saveButton.setMinimumSize(new Dimension(150, 40));

        deleteButton = new JButton("DELETE");
        deleteButton.setOpaque(true);
        deleteButton.setBorder(null);
        deleteButton.setForeground(new Color(255, 255, 255));
        deleteButton.setBackground(new Color(235, 87, 87));
        deleteButton.setFont(new Font("Arial", Font.BOLD, 16));
        deleteButton.setPreferredSize(new Dimension(150, 40));
        deleteButton.setMaximumSize(new Dimension(150, 40));
        deleteButton.setMinimumSize(new Dimension(150, 40));

        closeButton = new JButton("CLOSE");
        closeButton.setOpaque(true);
        closeButton.setBorder(null);
        closeButton.setForeground(new Color(255, 255, 255));
        closeButton.setBackground(new Color(111, 207, 151));
        closeButton.setFont(new Font("Arial", Font.BOLD, 16));
        closeButton.setPreferredSize(new Dimension(500, 40));
        closeButton.setMaximumSize(new Dimension(500, 40));
        closeButton.setMinimumSize(new Dimension(500, 40));
        
        closeButton.setAlignmentX(0.5f);
        closeButton.setAlignmentY(0.5f);

        JPanel buttonContainer = new JPanel();
        buttonContainer.setOpaque(false);
        buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.LINE_AXIS));
        buttonContainer.setPreferredSize(new Dimension(500, 40));
        buttonContainer.setMaximumSize(new Dimension(500, 40));
        buttonContainer.setMinimumSize(new Dimension(500, 40));
        buttonContainer.setAlignmentX(0.5f);
        buttonContainer.setAlignmentY(0.5f);

        buttonContainer.add(Box.createHorizontalGlue());
        buttonContainer.add(saveButton);
        buttonContainer.add(Box.createHorizontalGlue());
        buttonContainer.add(deleteButton);
        buttonContainer.add(Box.createHorizontalGlue());

        //adding form components:
        container.add(iconLabel);
        container.add(Box.createVerticalStrut(40));
        container.add(DescriptionLabel);
        container.add(descriotionTextArea);
        container.add(gridBox);
        container.add(EmailLabel);
        container.add(EmailField);
        container.add(PasswordLabel);
        container.add(PasswordField);
        container.add(Box.createVerticalStrut(20));
        container.add(buttonContainer);
        container.add(Box.createVerticalStrut(20));
        container.add(closeButton);
        contentPanel.add(Title, BorderLayout.NORTH);
        contentPanel.add(container, BorderLayout.CENTER);
        add(contentPanel);
        add(Background);

        setLayout(null);
    }

    private void onSelectRole(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        Integer roleName = (Integer) cb.getSelectedIndex();
        System.out.println(roleName);
    }

    public String getUsernameField() {
        return UsernameField.getText();
    }

    public String getFirstNameField() {
        return FirstNameField.getText();
    }

    public String getLastNameField() {
        return LastNameField.getText();
    }

    public String getEmailField() {
        return EmailField.getText();
    }

    public String getPasswordField() {
        return PasswordField.getText();
    }

    public int getRole() {
        return RoleBox.getSelectedIndex();
    }

    public String getDescriotionTextArea() {
        return descriotionTextArea.getText();
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
    
    public JButton getCloseButton()
    {
        return closeButton;
    }

    public void setUsernameField(String Username) {
        this.UsernameField.setText(Username);
    }

    public void setFirstNameField(String FirstName) {
        this.FirstNameField.setText(FirstName);
    }

    public void setLastNameField(String LastName) {
        this.LastNameField.setText(LastName);
    }

    public void setEmailField(String Email) {
        this.EmailField.setText(Email);
    }

    public void setPasswordField(String Password) {
        this.PasswordField.setText(Password);
    }

    public void setRoleBox(int Role) {
        this.RoleBox.setSelectedIndex(Role);
    }

    public void setDescriotionTextArea(String Description) {
        this.descriotionTextArea.setText(Description);
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public void setCloseButton(JButton closeButton)
    {
        this.closeButton= closeButton;
    }
    
    public Integer getIdProfile()
    {
        return this.idProfile;
    }
    public void setIdProfile(Integer id)
    {
        this.idProfile = id;
    }
    
    public void Clean()
    {
        this.idProfile = -1;
        this.EmailField.setText("");
        this.UsernameField.setText("");
        this.DescriptionLabel.setText("");
        this.FirstNameField.setText("");
        this.LastNameField.setText("");
        this.PasswordField.setText("");
    }
    
    private JLabel Title;
    private JLabel Background;
    private JPanel contentPanel;
    private JPanel container;

    //Form attributes.
    private JLabel iconLabel;
    private JLabel DescriptionLabel;
    private JLabel UsernameLabel;
    private JLabel RoleLabel;
    private JLabel FirstNameLabel;
    private JLabel LastNameLabel;
    private JLabel EmailLabel;
    private JLabel PasswordLabel;

    //TextINputs:
    private Integer idProfile;
    private JTextField UsernameField;
    private JTextField FirstNameField;
    private JTextField LastNameField;
    private JTextField EmailField;
    private JPasswordField PasswordField;
    private JComboBox RoleBox;
    private JTextArea descriotionTextArea;

    //Buttons
    private JButton saveButton;
    private JButton deleteButton;
    private JButton closeButton;

    private int state; //if for admin or user depends of it do something or show other things

}
