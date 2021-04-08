package Views;

import Models.Constants;
import Models.PasswordUtils;
import Models.UserDB;
import Models.UserModel;
import Models.Validator;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author juan
 */
public class AppScreen extends JFrame {

    public AppScreen() {
    }

    //init with profile info
    public AppScreen(UserModel profile) {
        this.profile = profile;
        this.adminDB = new UserDB();
        this.UserList = adminDB.showAll();

        initComponents();

        //fill info
        menuPanel.setUsername(this.profile.getUsername());

        //fill profile
        ProfilePanel.setUsernameField(this.profile.getUsername());
        ProfilePanel.setEmailField(this.profile.getEmail());
        ProfilePanel.setDescriotionTextArea(this.profile.getDescription());
        ProfilePanel.setFirstNameField(this.profile.getFirstname());
        ProfilePanel.setLastNameField(this.profile.getLastname());
        ProfilePanel.setRoleBox(this.profile.getRole());
        //ProfilePanel.setPasswordField(this.profile.getPassword());
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //menuPanel;
        MenuContainer = new JPanel();
        MenuContainer.setBackground(new Color(111, 207, 151));
        MenuContainer.setLayout(new BorderLayout(0, 0));

        //contentPanel
        ContentPanel = new JPanel();
        ContentPanel.setBackground(new Color(255, 255, 255));
        ContentPanel.setLayout(new BoxLayout(ContentPanel, BoxLayout.PAGE_AXIS));
        //ContentContainer
        ContentContainer = new JPanel();
        ContentContainer.setLayout(new CardLayout(0, 0));
        ContentContainer.setAlignmentX(0);
        ContentContainer.setAlignmentY(0);
        ContentContainer.setBackground(new Color(255, 255, 255));

        //CloseContainer;
        closeContainer = new JPanel();
        closeContainer.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        closeContainer.setAlignmentX(0);
        closeContainer.setAlignmentY(0);
        closeContainer.setBackground(new Color(255, 255, 255));
        //Label to close
        closeLabel = new JLabel();
        closeLabel.setForeground(new Color(111, 207, 151));
        closeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        closeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        closeLabel.setPreferredSize(new Dimension(32, 32));
        closeLabel.setMinimumSize(new Dimension(32, 32));
        closeLabel.setMaximumSize(new Dimension(32, 32));
        closeLabel.setText("X");
        closeLabel.setBackground(new Color(111, 207, 151));
        //Listener
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }

        });

        //menu
        menuPanel = new MenuPanel();

        menuPanel.getDashboardButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickDashboard(e);
            }
        });

        menuPanel.getProfileButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickProfile(e);
            }
        });

        menuPanel.getAdminConsoleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickAdmin(e);
            }
        });

        menuPanel.getAboutUsButton().addActionListener(new ActionListener() {
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
        DashboardPanel = new DashboardPanel();
        ProfilePanel = new ProfilePanel(Constants.ADMIN_FLAG);

        //listeners for Profile.
        ProfilePanel.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProfile(e);
            }
        });

        ProfilePanel.getCloseButton().setVisible(false);

        ProfilePanel.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProfile(e);
            }
        });

        AdminPanel = (this.profile != null) ? new AdminPanel(this.profile.getRole(), this.UserList) : new AdminPanel(Constants.ADMIN_FLAG, this.UserList);
        AdminPanel.getViewProfileButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewProfile(e);
            }
        });
        AdminPanel.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createProfile(e);
            }
        });

        UserPanel = new ProfilePanel(this.profile.getRole());
        UserPanel.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProfile(e);
            }
        });
        UserPanel.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProfile(e);
            }
        });
        UserPanel.getCloseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeProfile(e);
            }
        });

        createPanel = new ProfilePanel(Constants.ADMIN_FLAG);
        createPanel.getCloseButton().setVisible(false);
        createPanel.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        createPanel.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeProfile(e);
            }
        });

        AboutPanel = new AboutUsPanel();

        ContentContainer.add(DashboardPanel, "DASHBOARD");
        ContentContainer.add(ProfilePanel, "PROFILE");
        ContentContainer.add(UserPanel, "USER");
        ContentContainer.add(createPanel, "CREATE");
        ContentContainer.add(AdminPanel, "ADMIN");
        ContentContainer.add(AboutPanel, "ABOUT");

        MenuContainer.add(menuPanel, BorderLayout.CENTER);

        closeContainer.add(closeLabel);
        ContentPanel.add(closeContainer);
        ContentPanel.add(ContentContainer);

        setSize(1440, 800);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width - this.getSize().width) / 2, (dim.height - this.getSize().height) / 3);

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

    private void onClickDashboard(ActionEvent e) {
        System.out.println("Click on dashboard");
        CardLayout cards = (CardLayout) (ContentContainer.getLayout());
        cards.show(ContentContainer, "DASHBOARD");
    }

    private void onClickProfile(ActionEvent e) {
        System.out.println("Click on Profile");
        CardLayout cards = (CardLayout) (ContentContainer.getLayout());
        cards.show(ContentContainer, "PROFILE");
    }

    private void onClickAdmin(ActionEvent e) {
        System.out.println("Click on Admin console");
        CardLayout cards = (CardLayout) (ContentContainer.getLayout());
        cards.show(ContentContainer, "ADMIN");
    }

    private void onClickAbout(ActionEvent e) {
        System.out.println("Click on About us");
        CardLayout cards = (CardLayout) (ContentContainer.getLayout());
        cards.show(ContentContainer, "ABOUT");
    }

    private void onClickLogOut(ActionEvent e) {
        System.out.println("Click on LogOut");
        AuthScreen Login = new AuthScreen();
        Login.setVisible(true);
        this.dispose();
    }

    //Profile//User and Create actions
    private void saveProfile(ActionEvent e) //update
    {

        if (e.getSource() == this.ProfilePanel.getSaveButton()) //profile
        {
            System.out.println("Press save or update profile");

            //update info of personal profile.
            //verify if minumun data is writen in the form.
            //verify of new password if provided.
            //if password ? proccess to encrypt and modify User model.
            //modify userModel with the new data 
            //update user from db. set the new data to profile.
            //update admin list
            try {

                String username = ProfilePanel.getUsernameField();
                String email = ProfilePanel.getEmailField();
                String description = ProfilePanel.getDescriotionTextArea();
                int role = ProfilePanel.getRole();
                String firstName = ProfilePanel.getFirstNameField();
                String lastName = ProfilePanel.getLastNameField();
                String password = ProfilePanel.getPasswordField();
                System.out.println(password);
                //verify minimun data : Username, Email
                Validator.isValidEmail(email);
                Validator.isString(username);

                //verify if password is provided
                if (!password.equals("")) {
                    //if password , verify andencrypt it
                    Validator.isValidPassword(password);
                    //encrypt
                    String salt = PasswordUtils.getSalt(Constants.SALT);
                    String newPassword = PasswordUtils.generateSecurePassword(password, salt);

                    this.profile.setSalt(salt);
                    this.profile.setPassword(password);
                }

                //update model
                this.profile.setUsername(username);
                this.profile.setEmail(email);
                this.profile.setRole(role);
                this.profile.setDescription(description);
                this.profile.setLastname(lastName);
                this.profile.setFirstname(firstName);

                //update db.
                adminDB.updateUser(profile);

                //update adminconsole. and profilePanel.
                this.ProfilePanel.setUsernameField(this.profile.getUsername());
                this.ProfilePanel.setUsernameField(this.profile.getUsername());
                this.ProfilePanel.setEmailField(this.profile.getEmail());
                this.ProfilePanel.setDescriotionTextArea(this.profile.getDescription());
                this.ProfilePanel.setFirstNameField(this.profile.getFirstname());
                this.ProfilePanel.setLastNameField(this.profile.getLastname());
                this.ProfilePanel.setRoleBox(this.profile.getRole());

                ArrayList<UserModel> newList = adminDB.showAll();
                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new Object[]{"ID", "USERNAME", "EMAIL", "ROLE", "USER"});
                newList.forEach((user) -> {

                    String user_role = (user.getRole() == 0) ? "Admin" : "User";
                    model.addRow(new Object[]{
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user_role,
                        user.getCreated_at()
                    });
                });

                this.AdminPanel.getTable().setModel(model);

                JOptionPane.showMessageDialog(this, "Your profile has been updated");
            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }

        if (e.getSource() == this.UserPanel.getSaveButton()) //User info
        {
            System.out.println("Press save or update User");
            //same process as profile
            
            Integer selectedId = this.UserPanel.getIdProfile();

            try {
                UserModel selectedUser = this.adminDB.showOne(selectedId);
                String username = this.UserPanel.getUsernameField();
                String email = this.UserPanel.getEmailField();
                String description = this.UserPanel.getDescriotionTextArea();
                String firstName = this.UserPanel.getFirstNameField();
                String lastName = this.UserPanel.getLastNameField();
                int role = this.UserPanel.getRole();
                String password = this.UserPanel.getPasswordField();

                //validate inputs minimun requirements username and email
                Validator.isString(username);
                Validator.isValidEmail(email);

                if (!password.equals("")) {
                    //Validate password
                    Validator.isValidPassword(password);
                    String salt = PasswordUtils.getSalt(Constants.SALT);
                    String newPassword = PasswordUtils.generateSecurePassword(password, salt);

                    selectedUser.setSalt(salt);
                    selectedUser.setPassword(password);
                }

                //update model user
                selectedUser.setUsername(username);
                selectedUser.setEmail(email);
                selectedUser.setRole(role);
                selectedUser.setDescription(description);
                selectedUser.setLastname(lastName);
                selectedUser.setFirstname(firstName);

                //update db
                adminDB.updateUser(selectedUser);

                //refress
                ArrayList<UserModel> newList = adminDB.showAll();
                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new Object[]{"ID", "USERNAME", "EMAIL", "ROLE", "USER"});
                newList.forEach((user) -> {

                    String user_role = (user.getRole() == 0) ? "Admin" : "User";
                    model.addRow(new Object[]{
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user_role,
                        user.getCreated_at()
                    });
                });

                this.AdminPanel.getTable().setModel(model);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }

        }

        if (e.getSource() == this.createPanel.getSaveButton()) //create user
        {
            System.out.println("Press save or update create");
            //verify if minimun field are written.
            //encrypt password
            //create user into database
            //close create
            //update admin console table
            //open user profile.
        }

    }

    private void deleteProfile(ActionEvent e) {

        if (e.getSource() == this.ProfilePanel.getDeleteButton()) //profile
        {
            System.out.println("Press delete profile");

            //delete user from db. en logout
            String[] options = {"YES", "CANCEL"};

            int option = JOptionPane.showOptionDialog(
                    null, "Are you sure that you want to delete your account?.",
                    "Profile",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    options,
                    options[1]);

            if (option == 0) {
                System.out.println("Procced to delete");
                try {
                    adminDB.deleteUser(this.profile.getId());
                    AuthScreen authScreen = new AuthScreen();
                    authScreen.setVisible(true);
                    this.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }

            }

        }

        if (e.getSource() == this.UserPanel.getDeleteButton()) //deleteUser
        {
            System.out.println("Press delete User");
            //delete user
            //update admin
            //go to admin
            
            //delete 
            
            Integer userId = this.UserPanel.getIdProfile();
            String[] options = {"YES", "CANCEL"};

            int option = JOptionPane.showOptionDialog(
                    null, "Are you sure that you want to delete your account?.",
                    "Profile",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    options,
                    options[1]);

            if (option == 0) {
                System.out.println("Procced to delete");
                try {
                    this.adminDB.deleteUser(userId);
                    JOptionPane.showMessageDialog(this, "User has been deleted");
                    
                    ArrayList<UserModel> newList = adminDB.showAll();
                    DefaultTableModel model = new DefaultTableModel();
                    model.setColumnIdentifiers(new Object[]{"ID", "USERNAME", "EMAIL", "ROLE", "USER"});
                    newList.forEach((user) -> {

                    String user_role = (user.getRole() == 0) ? "Admin" : "User";
                    model.addRow(new Object[]{
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user_role,
                        user.getCreated_at()
                        });
                    });
                    
                    
                    CardLayout cards = (CardLayout)(this.ContentContainer.getLayout());
                    cards.show(ContentContainer, "ADMIN");
                    this.UserPanel.Clean();
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }

            }
            
            
        }

    }

    private void closeProfile(ActionEvent e) {
        System.out.println("Press close profile");
        CardLayout cards = (CardLayout) (ContentContainer.getLayout());
        cards.show(ContentContainer, "ADMIN");
        this.UserPanel.Clean();
    }

    //adminConsoleActions
    private void viewProfile(ActionEvent e) {
        System.out.println("Press view profile");

        //get selected id 
        Integer row = this.AdminPanel.getTable().getSelectedRow();
        Integer id = (Integer) this.AdminPanel.getTable().getValueAt(row, 0);

        if (id != -1) {
            if (this.profile.getId() == id) {
                CardLayout cards = (CardLayout) (ContentContainer.getLayout());
                cards.show(ContentContainer, "PROFILE");
            } else {

                try {
                    UserModel selectedUser = this.adminDB.showOne(id);

                    this.UserPanel.setUsernameField(selectedUser.getUsername());
                    this.UserPanel.setDescriotionTextArea(selectedUser.getDescription());
                    this.UserPanel.setLastNameField(selectedUser.getLastname());
                    this.UserPanel.setFirstNameField(selectedUser.getFirstname());
                    this.UserPanel.setEmailField(selectedUser.getEmail());
                    this.UserPanel.setRoleBox(selectedUser.getRole());

                    CardLayout cards = (CardLayout) (ContentContainer.getLayout());
                    cards.show(ContentContainer, "USER");

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        }

    }

    private void createProfile(ActionEvent e) {
        System.out.println("Press create profile");

        CardLayout cards = (CardLayout) (ContentContainer.getLayout());
        cards.show(ContentContainer, "CREATE");
    }

    private UserDB adminDB;
    private UserModel profile;
    private ArrayList<UserModel> UserList;

    private JPanel MenuContainer;
    private JPanel ContentPanel;
    private JPanel ContentContainer;
    private JPanel closeContainer;
    private JLabel closeLabel;
    private MenuPanel menuPanel;

    //panelcards
    private DashboardPanel DashboardPanel;
    private ProfilePanel ProfilePanel;
    private AdminPanel AdminPanel;
    private AboutUsPanel AboutPanel;
    private ProfilePanel createPanel;
    private ProfilePanel UserPanel;

}
