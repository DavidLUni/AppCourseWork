/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.PasswordUtils;
import Models.UserDB;
import Models.UserModel;
import Models.Validator;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author juan
 */
public class AuthScreen extends JFrame
{
    UserDB authDatabase;
    public AuthScreen()
    {
        authDatabase = new UserDB();
        authDatabase.createTable();
        initComponents();
    }
    
    
    //Init components
    private void initComponents()
    {
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Panel where the logo is
        LogoPanel = new JPanel();
        LogoPanel.setBackground(new Color(111,207,151));
        
        logoLabel = new JLabel();
        Image img = new ImageIcon(getClass().getResource("/images/background.png")).getImage().getScaledInstance(300, 500, Image.SCALE_AREA_AVERAGING);
        logoLabel.setIcon(new ImageIcon(img));
        
        //Panel where All the screen auth will be allocated.
        authPanel = new JPanel();
        authPanel.setBackground(new Color(255,255,255));
        authPanel.setLayout(new BoxLayout(authPanel, BoxLayout.PAGE_AXIS));
        
        closeContainer = new JPanel();
        closeContainer.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        closeContainer.setAlignmentX(0);
        closeContainer.setAlignmentY(0);
        closeContainer.setBackground(new Color(255,255,255));
        
        authContainer = new JPanel(new CardLayout(0, 0));
        authContainer.setAlignmentX(0);
        authContainer.setAlignmentY(0);
        authContainer.setBackground(new Color(255,255,255));
        
        //Label to close implements MouseClick event
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
        closeLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
            
        });
        
        //auth panels
        LoginPane = new LoginPanel();
        LoginPane.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPressLogin(e);
            }
        });
        LoginPane.getSignupLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                onClickSignUp(e);
            }
        });
        LoginPane.getForgotPasswordLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                onClickForgot(e);
            }
        });
        
        SignupPane = new SignupPanel();
        SignupPane.getSignupButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPressSignUp(e);
            }
        });
        
        SignupPane.getLoginLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                onClickLogin(e);
            }
        });
        
        ResetPane = new ResetPanel();
        ResetPane.getResetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPressReset(e);
            }
        });
        ResetPane.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPressCancel(e);
            }
        });
        
        authContainer.add(LoginPane, "LOGIN");
        authContainer.add(SignupPane, "SIGNUP");
        authContainer.add(ResetPane, "RESET");
        
        closeContainer.add(closeLabel);  
        authPanel.add(closeContainer);
        authPanel.add(authContainer);
        
        
        LogoPanel.add(logoLabel);
        //remove when it is finished
        setUndecorated(true);
        setResizable(false);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(800,500);
        setLocation((dim.width - this.getSize().width)/2, (dim.height - this.getSize().height)/3);
        //Layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(LogoPanel, GroupLayout.PREFERRED_SIZE,300,  GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(authPanel,GroupLayout.PREFERRED_SIZE,500,  GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    ));

       layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(LogoPanel,GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(authPanel,GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE));
        
        pack();
    }
    
    /*
        important 
    */
    private void onPressLogin(ActionEvent e)
    {
        System.out.println("Press on login");
        //validate fields
        //find account 
        //if exist compare passwords.
        //if everything correct open dashboard passing profile.
        //close auth screen
        
        //if errors
        //promt dialog to explain errors.
        
        String email = LoginPane.getEmail();
        char[] password = LoginPane.getPassword();
        
        try {
            //Validate inputs
            Validator.isValidEmail(email);
            Validator.isString(new String(password));
            
            //find user
            
            UserModel Account = authDatabase.findUserByEmail(email);
            
            if(Account != null)
            {
                System.out.println("Database: Account found.");
                
                //verify password.
                System.out.println("Auth: Comparing passwords..");
                if (PasswordUtils.verifyUserPassword(new String(password), Account.getPassword(), Account.getSalt()))
                {
                    System.out.println("Auth: Password match. access granted");
                    
                    //Access to dashboard
                    //Go to dashboard
                    AppScreen app = new AppScreen(Account);
                    app.setVisible(true);
                    this.dispose();
                }else
                {
                    System.out.println("Auth: Password does not match");
                    throw new Exception("Email or password are not valid. Please try again");
                }
            }else
            {
                throw new Exception("Account does not exist. Please try again");
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }
    
    /*
        important
    */
    private void onPressSignUp(ActionEvent e)
    {
        System.out.println("Press on SignUp");
        //validate inputs
        //if error during validations
        //show error message.
        //encryopt password 
        //create usermodel
        //insert account into db
        //clean form and clean form
        
        String username = SignupPane.getUsername();
        String email = SignupPane.getEmail();
        char[] password = SignupPane.getPassword();
        char[] confirmPassword = SignupPane.getConfirmPassword();
        
        //validate username email and passwords 
        
        try 
        {
            Validator.isString(username);
            Validator.isValidEmail(email);
            Validator.isValidPassword(new String(password));
            Validator.isValidPassword(new String(confirmPassword));

            //validate if the passwords are equal
            Validator.confirmPassword(new String(password), new String(confirmPassword));

            //Encrypt password
            String salt = PasswordUtils.getSalt(20);
            String hashPwd = PasswordUtils.generateSecurePassword(new String(password), salt);
            
            //create model account
            UserModel newAccount = new UserModel();
            newAccount.setUsername(username);
            newAccount.setEmail(email);
            newAccount.setSalt(salt);
            newAccount.setPassword(hashPwd);
            
            //CALL INSTANCE OF DB;
            authDatabase.createAccount(newAccount);
            JOptionPane.showMessageDialog(this, "Account is succesfully created.");
            //clean form
            SignupPane.clean();
            //go to login
            CardLayout cards = (CardLayout)(authContainer.getLayout());
            cards.show((authContainer), "LOGIN");
        } catch (Exception ex) 
        {
            //Create a dialog box 
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }
    
    private void onPressReset(ActionEvent e)
    {
       System.out.println("Press on Reset password");
       
       //validate inputs
       //find account 
       //hash password 
       //update user 
       //go to login.
       
       String email = ResetPane.getEmail();
       char[] newPassword = ResetPane.getPassword();
       char[] confirmPassword = ResetPane.getConfirmPassword();
       
        try 
        {
            //validate inputs
            Validator.isValidEmail(email);
            Validator.isValidPassword(new String(newPassword));
            Validator.isValidPassword(new String(confirmPassword));
            
            //compare password to confirm are equals
            Validator.confirmPassword(new String(newPassword), new String(confirmPassword));
            
            
            //Find user
            UserModel Account = authDatabase.findUserByEmail(email);
            
            if(Account != null)
            {
                //HASH new password and creating new salt
                String salt = PasswordUtils.getSalt(20);
                String password = PasswordUtils.generateSecurePassword(new String(newPassword), salt);
                
                //updating usermodel
                Account.setSalt(salt);
                Account.setPassword(password);
                
                //update record from database
                authDatabase.updateUser(Account);
                
                JOptionPane.showMessageDialog(this, "Password has been updated.");
                //GO TO LOGIN
                CardLayout cards = (CardLayout)(authContainer.getLayout());
                cards.show(authContainer, "LOGIN");
                ResetPane.clean();
                
            }else
            {
                throw new Exception("Account does not exist. Please try again or create a new account.");
            }
            
            
        } catch (Exception ex) 
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    private void onPressCancel(ActionEvent e)
    {
        System.out.println("Press on Cancel");
        CardLayout cards = (CardLayout)(authContainer.getLayout());
        cards.show(authContainer, "LOGIN");
        ResetPane.clean();
    }
    
    private void onClickLogin(MouseEvent e)
    {
       //clean signup
       System.out.println("Click on Login"); 
       CardLayout cards = (CardLayout)(authContainer.getLayout());
       cards.show(authContainer, "LOGIN");
       SignupPane.clean();
    }
    
    private void onClickSignUp(MouseEvent e)
    {
        
        //clean Login
        System.out.println("Click on SignUp");
        CardLayout cards = (CardLayout)(authContainer.getLayout());
        cards.show(authContainer, "SIGNUP");
        LoginPane.clean();
        
    }
    
    private void onClickForgot(MouseEvent e)
    {
        //clean login
        System.out.println("Click on Forgot password");
        CardLayout cards = (CardLayout)(authContainer.getLayout());
        cards.show(authContainer, "RESET");
        LoginPane.clean();
    }
    
    private JPanel LogoPanel;
    private JLabel logoLabel;
    private JPanel authPanel;
    private JLabel closeLabel;
    private JPanel  authContainer;
    private JPanel closeContainer;
    private LoginPanel LoginPane;
    private SignupPanel SignupPane;
    private ResetPanel ResetPane;
}
