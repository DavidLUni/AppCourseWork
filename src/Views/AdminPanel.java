/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Constants;
import Models.UserDB;
import Models.UserModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author juan
 */
public class AdminPanel extends JPanel {

    public AdminPanel(int Flag, ArrayList<UserModel> list) {
        this.list = list;
        this.Flag = Flag;
        initComponents();
        initTable();
        
        if (this.Flag == Constants.USER_FLAG)
        {
            this.addButton.setVisible(false);
        }
    }

    private void initComponents() {
        Title = new JLabel("Admin Console");
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

        descriptionArea = new JTextArea();
        descriptionArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
                + "sed do eiusmod tempor incididunt ut labore et dolore magna"
                + " aliqua. Ut enim ad minim veniam, ");
        descriptionArea.setRows(4);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setPreferredSize(new Dimension(1000, 50));
        descriptionArea.setMaximumSize(new Dimension(1000, 50));
        descriptionArea.setMinimumSize(new Dimension(1000, 50));
        descriptionArea.setAlignmentX(0.5f);
        descriptionArea.setAlignmentY(0.5f);

        //Buttons
        addButton = new JButton("CREATE USER");
        addButton.setPreferredSize(new Dimension(150, 40));
        addButton.setMaximumSize(new Dimension(150, 40));
        addButton.setMinimumSize(new Dimension(150, 40));
        addButton.setBackground(new Color(45, 156, 219));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setOpaque(true);
        addButton.setBorder(null);

        viewProfileButton = new JButton("VIEW PROFILE");
        viewProfileButton.setPreferredSize(new Dimension(150, 40));
        viewProfileButton.setMaximumSize(new Dimension(150, 40));
        viewProfileButton.setMinimumSize(new Dimension(150, 40));
        viewProfileButton.setForeground(Color.WHITE);
        viewProfileButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewProfileButton.setBackground(new Color(111, 207, 151));
        viewProfileButton.setOpaque(true);
        viewProfileButton.setBorder(null);

        JPanel searchContainer = new JPanel(new BorderLayout(0, 0));
        searchContainer.setPreferredSize(new Dimension(380, 40));
        searchContainer.setMinimumSize(new Dimension(380, 40));
        searchContainer.setMaximumSize(new Dimension(380, 40));
        searchContainer.setBorder(BorderFactory.createLineBorder(new Color(111, 207, 151), 2));

        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(300, 40));
        searchField.setMinimumSize(new Dimension(300, 40));
        searchField.setMaximumSize(new Dimension(300, 40));
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setBackground(new Color(242, 242, 242));
        searchField.setCaretColor(new Color(111, 207, 151));
        searchField.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        searchField.setForeground(Color.BLACK);

        searchButton = new JButton("SEARCH");
        searchButton.setPreferredSize(new Dimension(80, 40));
        searchButton.setMinimumSize(new Dimension(80, 40));
        searchButton.setMaximumSize(new Dimension(80, 40));
        searchButton.setForeground(Color.WHITE);
        searchButton.setBackground(new Color(111, 207, 151));
        searchButton.setFont(new Font("Arial", Font.BOLD, 16));
        searchButton.setOpaque(true);
        searchButton.setBorder(null);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search(e);
            }
        });

        searchContainer.add(searchField, BorderLayout.CENTER);
        searchContainer.add(searchButton, BorderLayout.EAST);

        JPanel buttonsContainer = new JPanel();
        buttonsContainer.setPreferredSize(new Dimension(1000, 40));
        buttonsContainer.setMinimumSize(new Dimension(1000, 40));
        buttonsContainer.setMaximumSize(new Dimension(1000, 40));
        buttonsContainer.setOpaque(false);
        buttonsContainer.setLayout(new BoxLayout(buttonsContainer, BoxLayout.LINE_AXIS));
        buttonsContainer.setAlignmentX(0.5f);
        buttonsContainer.setAlignmentY(0.5f);
        buttonsContainer.add(searchContainer);
        buttonsContainer.add(Box.createHorizontalGlue());
        buttonsContainer.add(viewProfileButton);
        buttonsContainer.add(Box.createHorizontalStrut(50));
        buttonsContainer.add(addButton);

        //jtable
        table = new JTable();

        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(111, 207, 151));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setPreferredSize(new Dimension(250, 40));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(111, 207, 151), 2));
        table.setBackground(Color.WHITE);
        table.setShowGrid(false);
        table.setShowHorizontalLines(true);

        table.setGridColor(new Color(111, 207, 151));
        table.setRowHeight(40);

        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        renderer.setBorder(null);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        table.setSelectionBackground(new Color(242, 242, 242));
        table.setSelectionForeground(Color.BLACK);

        scrollPanel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        scrollPanel.setViewportView(table);
        scrollPanel.setSize(new Dimension(1000, 400));
        scrollPanel.setMaximumSize(new Dimension(1000, 400));
        scrollPanel.setMinimumSize(new Dimension(1000, 400));
        scrollPanel.setAlignmentX(0.5f);
        scrollPanel.setAlignmentY(0.5f);
        scrollPanel.setOpaque(false);
        scrollPanel.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.trackColor = Color.white;
                this.thumbColor = new Color(111, 207, 151);
            }
        });
        scrollPanel.getVerticalScrollBar().setOpaque(false);

        container.add(Box.createVerticalStrut(50));
        container.add(descriptionArea);
        container.add(Box.createVerticalStrut(20));
        container.add(buttonsContainer);
        container.add(Box.createVerticalStrut(20));
        container.add(scrollPanel);
        container.add(Box.createVerticalGlue());

        contentPanel.add(Title, BorderLayout.NORTH);
        contentPanel.add(container, BorderLayout.CENTER);
        add(contentPanel);
        add(Background);

        setLayout(null);
    }

    /*private void initTable() {
        Object[] columns = {"ID", "USERNAME", "EMAIL", "ROLE", "CREATED AT"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);

        db = new UserDB();
        myList = new ArrayList<>();
        myList = db.showAll();
        myList.forEach((user) -> {

            String role = (user.getRole() == 0) ? "Admin" : "User";
            model.addRow(new Object[]{
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                role,
                user.getCreated_at()
            });
        });

        table.setModel(model);
    }*/
    
    private void initTable()
    {
        Object[] columns = {"ID", "USERNAME","EMAIL", "ROLE", "USER"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);
        
        if(this.list != null)
        {
            list.forEach((user) -> {
                String role = (user.getRole() == 0) ? "Admin" : "User";
                
                model.addRow(new Object[]{
                
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    role,
                    user.getCreated_at()
                });
            });
        }
        
        table.setModel(model);
    }

    private UserDB db;
    private ArrayList<UserModel> myList;

    private void search(ActionEvent e) {
        RowFilter<DefaultTableModel, Object> rf = null;

        try {
            rf = RowFilter.regexFilter(searchField.getText(), 2);
        } catch (Exception ex) {
            return;
        }
        sorter.setRowFilter(rf);

        if (searchField.getText() == null) {
            sorter.setRowFilter(null);
        }
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getViewProfileButton() {
        return viewProfileButton;
    }

    public JTable getTable() {
        return table;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public void setViewProfileButton(JButton viewProfileButton) {
        this.viewProfileButton = viewProfileButton;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
    
    public void setList(ArrayList<UserModel> list)
    {
        this.list = list;
        initTable();
    }


    
    private ArrayList<UserModel> list;
    private int Flag;
    private JLabel Background;
    private JPanel contentPanel;
    private JLabel Title;
    private JPanel container;

    private JTextField searchField;
    private JButton searchButton;
    private JButton addButton;
    private JButton viewProfileButton;
    private JTextArea descriptionArea;
    private JTable table;
    private JScrollPane scrollPanel;
    private TableRowSorter sorter;
}
