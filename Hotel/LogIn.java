package Hotel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends UnfillText implements ActionListener {
    //--------------------------DECLARE COMPONENTS -------------------------------------

    private JFrame myframe;
    private Container c;
    private JLabel l1,l2,signinpic , admin;
    private JTextField user;
    private JPasswordField pass;
    private JButton signin;
    private String choose;

    LogIn(String left_exist) {
        choose = left_exist;
        //--------------------------------SET JFRAME ICON------------------------------------------

        ImageIcon h1 = new ImageIcon(getClass().getResource("hotel_icon.jpg"));
        Image h2 = h1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);

//-----------------------------------------------------------------------------------------------

        myframe = new JFrame("Log In");
        myframe.setSize(600,450);
        myframe.setIconImage(h2);
        myframe.setLocationRelativeTo(null);

        c = myframe.getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(null);

//------------------------------ DEFINE COMPONENTS ---------------------------------------

        l1 = new JLabel("Enter username");
        l2 = new JLabel("Enter Password");
        admin = new JLabel("For Only Admin");
        user = new JTextField(15);
        pass = new JPasswordField(15);
        signin =  new JButton("LogIn");

//------------------------------- SET BUTTON COLOR AND FONT STYLE --------------------------

        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.setFont(new Font("Aharoni",Font.BOLD,30));
        l1.setFont(new Font("Aharoni",Font.BOLD,15));
        l2.setFont(new Font("Aharoni",Font.BOLD,15));
        admin.setFont(new Font("Aharoni",Font.BOLD,38));
//-------------------------------- ADD SCALED IMAGE--------------------------------------------

        ImageIcon i1 = new ImageIcon(getClass().getResource("admin Icon.png"));
        Image i2 = i1.getImage().getScaledInstance(400,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        signinpic = new JLabel(i3);

//--------------------------------- SET BOUNDS -----------------------------------------

        signinpic.setBounds(300,0,400,450);
        l1.setBounds(12,100,150,25);
        l2.setBounds(12,180,150,25);
        admin.setBounds(10,20,300,50);
        user.setBounds(140,100,170,50);
        pass.setBounds(140,180,170,50);
        signin.setBounds(75,280,200,60);

//--------------------------------- ADD COMPONENTS -------------------------------------

        c.add(signinpic);
        c.add(l1);
        c.add(l2);
        c.add(admin);
        c.add(user);
        c.add(pass);
        c.add(signin);


        signin.addActionListener(this);

        signin.setFocusable(false);
        myframe.setResizable(false);
        myframe.setVisible(true);
        myframe.setDefaultCloseOperation(myframe.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent event)
    {

//----------------- SET DIALOG BOX BACKGROUND COLOR,FONT COLR,AND FONT STYLE-------------

        UIManager.put("OptionPane.background",Color.WHITE);
        UIManager.put("Panel.background",Color.WHITE);
        UIManager.put("Button.background",Color.BLACK);
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.font",new Font("Aharoni",Font.PLAIN,20));
        UIManager.put("ButtonUI",NonFocusableButtonUI.class.getName());

//-------------------------------- IMAGE ICON FOR DIALOG BOX --------------------------------------------

        ImageIcon icon1 = new ImageIcon(getClass().getResource("warning.jpg"));
        Image icon2 = icon1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);

        try
        {
//----------------------------IF TEXT ARE UNFILL-------------------------------------

            if(user.getText().trim().isEmpty() || new String(pass.getPassword()).trim().isEmpty() )
            {
                throw new UnfillText();
            }

//----------------------------- PRESS SIGN IN ----------------------------------------

            else if(event.getSource() == signin)
            {
               if(user.getText().equals("Salwa") && new String(pass.getPassword()).equals("S@lwa12345")) {
                   if(choose == "Left") {
                       new LeavingRecord().setVisible(true);
                       myframe.setVisible(false);
                   }
                   else if(choose == "Exist") {
                       new ExistingRecord().setVisible(true);
                       myframe.setVisible(false);
                   }
               }

//----------------------------- INVALID USERNAME OR PASSWORD -----------------------------
                else {

                    try
                    {
                        throw new InvalidusernameORpassword();
                    }
                    catch(InvalidusernameORpassword e)
                    {
                        myframe.setVisible(false);
                        JOptionPane.showMessageDialog(null,"Incorrect username or password","WARNING",JOptionPane.WARNING_MESSAGE,icon3);
                    }
                }

            }
        }
        catch(UnfillText e)
        {
            JOptionPane.showMessageDialog(null,"Please fill all text fields","WARNING",JOptionPane.WARNING_MESSAGE,icon3);
        }
    }
}
