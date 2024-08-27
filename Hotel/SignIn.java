package Hotel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.lang.String;

//------------------------ EXCEPTION METHOD FOR INVALID USERNAME OR PASSWORD ---------------------

class InvalidusernameORpassword extends Exception
{
	public String getMessage()
	{
		return "Invalid UserName OR Password";
	}
}

//-------------------------- SIGNIN METHOD -------------------------------------

public class SignIn extends UnfillText implements ActionListener
{
	userchoice u = new userchoice();
	
//--------------------------DECLARE COMPONENTS -------------------------------------	
	
	private JFrame myframe;
	private Container c;
	private Rooms room[];
	private JLabel l1,l2,signinpic;
	private JTextField user;
	private JPasswordField pass;
	private JButton signin;
	private int count;
	
	public void SignInOption(Rooms room[]) 
	{
		this.room = room;
		
//--------------------------------SET JFRAME ICON------------------------------------------

		ImageIcon h1 = new ImageIcon(getClass().getResource("hotel_icon.jpg"));
		Image h2 = h1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		
//-----------------------------------------------------------------------------------------------
		
		myframe = new JFrame("Sign In");
		myframe.setSize(600,450);
		myframe.setIconImage(h2);
		myframe.setLocationRelativeTo(null);
		
		c = myframe.getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(null);
		
//------------------------------ DEFINE COMPONENTS ---------------------------------------
		
		l1 = new JLabel("Enter username");
		l2 = new JLabel("Enter Password");
		user = new JTextField(15);
		pass = new JPasswordField(15);
		signin =  new JButton("SignIn");
		
//------------------------------- SET BUTTON COLOR AND FONT STYLE --------------------------
		
		signin.setBackground(Color.BLACK);
		signin.setForeground(Color.WHITE);
		signin.setFont(new Font("Aharoni",Font.BOLD,30));
		l1.setFont(new Font("Aharoni",Font.BOLD,15));
		l2.setFont(new Font("Aharoni",Font.BOLD,15));
//-------------------------------- ADD SCALED IMAGE--------------------------------------------	
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("black symbol.png"));
		Image i2 = i1.getImage().getScaledInstance(400,450,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		signinpic = new JLabel(i3);
		
//--------------------------------- SET BOUNDS -----------------------------------------

		signinpic.setBounds(300,0,400,450);
		l1.setBounds(12,90,150,25);
		l2.setBounds(12,170,150,25);
		user.setBounds(140,90,170,50);
		pass.setBounds(140,170,170,50);
		signin.setBounds(75,280,200,60);
		
//--------------------------------- ADD COMPONENTS -------------------------------------
		
		c.add(signinpic);
		c.add(l1);
		c.add(l2);
		c.add(user);
		c.add(pass);
		c.add(signin);
		
		
		signin.addActionListener(this);
		
		signin.setFocusable(false);
		myframe.setResizable(false);
		myframe.setDefaultCloseOperation(myframe.EXIT_ON_CLOSE);
		myframe.setVisible(true);
		
		
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
				count = 0;
				for(int i=0; i<20; i++)
				{
					if(room[i] != null && user.getText().equalsIgnoreCase(room[i].Su) && new String(pass.getPassword()).equals(room[i].p))
					{
						u.choicemenu(room,i);
						myframe.setVisible(false);
						break;
					}
					count++;
				}
				
//----------------------------- INVALID USERNAME OR PASSWORD -----------------------------
				
				if(count == 20)
				{
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