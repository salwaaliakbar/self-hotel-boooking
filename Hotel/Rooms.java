package Hotel;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.lang.String;
import javax.swing.border.Border;
import java.io.*;

class UserNameShouldBeUnique extends Exception
{
	public String getMessage()
	{
		return "USERNAME SHOULD BE UNIQUE";
	}
}

class forUserName
{
	static String usernamesingup[] = new String[20];
	static 
	{
		usernamesingup[0] = "ahmed";
		usernamesingup[10] = "hania";
		usernamesingup[11] = "sara";
		usernamesingup[15] = "akbar";
	}
}
public class Rooms extends UnfillText implements ActionListener,Checkpassword
{
	//5000 for AC Room(Double Bed) per day
	//3000 for Ac Room(Single Bed) per day 
	//3000 for Non AC Room(Double Bed) per day
	//1000 for Non Ac Room(Single Bed) per day
	
	public static int AC_SB = 3000,AC_DB = 5000,NAC_SB = 1000,NAC_DB = 3000;
	public int roomnum,bill,no,daysCmd,rent,c,n,countforoneexp,foodBill = 0;
	public String Su,p,food_ordered,rent_prices,NameCmd , AddressCmd , CnicCmd , PhoneCmd , RoomType , BedType;
	private JFrame myframe;
	private Container con;
	private JTextField name,cnic,address,phone,username;
	private JTextArea note;
	private SpinnerModel value;
	private JSpinner days;
	private int totalFieldLabel = 8;
	private JLabel l[] = new JLabel[totalFieldLabel];
	private String text[] = {"Enter Name","Enter CNIC","Enter Phone Number","Enter Address","Enter Stay Days","FOR SIGNUP PLEASE PROVIDE","Enter UserName","Enter Password"};
	private JButton signup;
	private JLabel picture;
	private JPasswordField password;
	private Border border,border1;
	private boolean correctpass;
	
	public int getRoomNum()
	{
		return this.roomnum;
	}
	
	public void forRoomNum(int i)
	{
		this.roomnum = (i+101);
	}
	
	
	public void Options2(int no,int i)
	{
		this.no = no;
		this.n = i;
		
//--------------------------------SET JFRAME ICON------------------------------------------

		ImageIcon h1 = new ImageIcon(getClass().getResource("hotel_icon.jpg"));
		Image h2 = h1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		
//--------------------------------------------------------------------------------------------
		
		myframe = new JFrame("REGISTRATION");
		myframe.setSize(600,500);
		myframe.setIconImage(h2);
		myframe.setLocationRelativeTo(null);
		
		con = myframe.getContentPane();
		con.setBackground(Color.WHITE);
		con.setLayout(null);
	
//------------------------ DEFINE COMPONENTS ---------------------------------------		

		for(int j=0; j<totalFieldLabel; j++)
		{
			l[j] = new JLabel(text[j]);
		}
		note = new JTextArea(); 
		signup = new JButton("SignUp");
		
		name = new JTextField(15);
		cnic = new JTextField(15);
		phone = new JTextField(15);
		address = new JTextField(15);
		value = new SpinnerNumberModel(1,1,30,1);
		days = new JSpinner(value);
		username = new JTextField(15);
		password = new JPasswordField(15);
		border = BorderFactory.createLineBorder(Color.RED);
		border1 = BorderFactory.createLineBorder(Color.GRAY);
		
//------------------------- SET SCALED IMAGE ----------------------------------------		
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("registrationpage.jpg"));
		Image i2 = i1.getImage().getScaledInstance(290,500,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		picture = new JLabel(i3);
		
//-------------------------- SET BUTTON COLOR AND FONT --------------------------------
		
		note.setForeground(Color.RED);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		note.setFont(new Font("Aharoni",Font.BOLD,10));
		signup.setFont(new Font("Aharoni",Font.BOLD,20));
		
//------------------------------ SET BOUNDS ----------------------------------------------	
	
		l[0].setBounds(25,25,125,25);
		l[1].setBounds(25,60,125,25);
		l[2].setBounds(25,95,125,25);
		l[3].setBounds(25,130,125,25);
		l[4].setBounds(25,165,125,25);
		l[5].setBounds(75,225,275,25);
		l[6].setBounds(25,285,125,25);
		l[7].setBounds(25,320,125,25);
		
		name.setBounds(170,25,125,25);
		cnic.setBounds(170,55,125,25);
		phone.setBounds(170,90,125,25);
		address.setBounds(170,125,125,25);
		days.setBounds(170,160,125,25);
		username.setBounds(170,280,125,25);
		password.setBounds(170,315,125,25);
		note.setBounds(3,340,310,30);
		signup.setBounds(100,380,125,50);
		picture.setBounds(310,0,290,500);
		
//------------------------------- ADD COMPONENTS -----------------------------------
		for(int j=0; j<totalFieldLabel; j++)
		{
			con.add(l[j]);
		}
		con.add(name);
		con.add(cnic);
		con.add(phone);
		con.add(address);
		con.add(days);
		con.add(username);
		con.add(password);
		con.add(note);
		con.add(signup);
		con.add(picture);
		
		signup.setFocusable(false);
		signup.addActionListener(this);
		
//---------------------------- ACTION METHOD OF KEYLISTENER ------------------------------			
		
		password.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent event)
			{
				if(!(new String(password.getPassword()).trim().isEmpty()))
				{
					password.setBorder(border1);
					note.setText(null);
				}
			}
		});
//-------------------------------------------------------------------------------------------
			
		myframe.setResizable(false);
		myframe.setDefaultCloseOperation(myframe.EXIT_ON_CLOSE);
		myframe.setVisible(true);
	
		
	}

	
//--------------------------- ACTION METHOD OF ACTIONLISTENER----------------------------
	
	public void actionPerformed(ActionEvent event)
	{	
		UIManager.put("OptionPane.background",Color.WHITE);
		UIManager.put("Panel.background",Color.WHITE);
		UIManager.put("Button.background",Color.BLACK);
		UIManager.put("Button.foreground", Color.WHITE);
		UIManager.put("Button.font",new Font("Aharoni",Font.PLAIN,20));
		UIManager.put("ButtonUI", NonFocusableButtonUI.class.getName());
		
		ImageIcon icon1 = new ImageIcon(getClass().getResource("warning.jpg"));
		Image icon2 = icon1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon icon3 = new ImageIcon(icon2);
		
		try
		{
			
//----------------- WHEN USERNAME ARE SAME OR PASSWORD ARE NOT CORRECT --------------------------

			if(!(name.getText().trim().isEmpty() || cnic.getText().trim().isEmpty() || phone.getText().trim().isEmpty() || address.getText().trim().isEmpty() || username.getText().trim().isEmpty() || new String(password.getPassword()).trim().isEmpty()))
			{
					countforoneexp = 0;
					forUserName.usernamesingup[n] = username.getText();
					Su = username.getText();
					p = new String(password.getPassword());
					daysCmd = (Integer)days.getValue();
					NameCmd = name.getText();
					CnicCmd = cnic.getText();
					PhoneCmd = phone.getText();
					AddressCmd = address.getText();
					bill = foodBill + rent;
					c = 0;
					
					//------------------------METHOD TO CHECK THE PASSWORD AS REUIRMENT--------------------------- 						
					
					correctpass = check(p);
					if(!correctpass)
					{
						countforoneexp++;
						password.setText(null);
						password.setBorder(border);
						note.setText("Password must be 8 character long and contain atleast\n a number,a uppercase,a lowercase and a special character");
					}
					
					else
					{
						for(int i=0; i<20; i++)
						{
							if(Su.equalsIgnoreCase(forUserName.usernamesingup[i]))
							{
								c++;
							}
						}					
						try
						{
							if(c > 1)
							{
								countforoneexp++;
								throw new UserNameShouldBeUnique();
							}
						
						}
						catch(UserNameShouldBeUnique e)
						{
							JOptionPane.showMessageDialog(null,"Your UserName Should Be Unique","WARNING",JOptionPane.WARNING_MESSAGE,icon3);
							username.setText(null);
						}
					}
					
				}
		
//------------------------ WHEN TEXT FIELD EMPTY-------------------------------------
			
			if(name.getText().trim().isEmpty() || cnic.getText().trim().isEmpty() || phone.getText().trim().isEmpty() || address.getText().trim().isEmpty() || username.getText().trim().isEmpty() || new String(password.getPassword()).trim().isEmpty())
			{
				if(countforoneexp == 0)
				{
					throw new UnfillText();
				}
			}
			
//--------------------------- ACTION PERFORMED ON SIGN UP -----------------------------

			else if(event.getSource() == signup)
			{	
				if(no >100 && no<=105)
				{
					rent = AC_SB*daysCmd;
					rent_prices = daysCmd+" x (AC_SB) = "+rent+"/-\n";
				}
				else if(no >105 && no<=110)
				{
					rent = AC_DB*daysCmd;
					rent_prices = daysCmd+" x (AC_DB) = "+rent+"/-\n";
				}
				else if(no >110 && no<=115)
				{
					rent = NAC_SB*daysCmd;
					rent_prices = daysCmd+" x (NAC_SB)= "+rent+"/-\n";
				}
				else if(no >115 && no<=120)
				{
					rent = NAC_DB*daysCmd;
					rent_prices = daysCmd+" x (NAC_DB) = "+rent+"/-\n";
				}
				bill = rent + foodBill;
				myframe.setVisible(false);
//-------------------------------- SET DIALOG BOX IMAGE ICON ----------------------------------
				
				ImageIcon S_icon1 = new ImageIcon(getClass().getResource("successful.jpg"));
				Image S_icon2 = S_icon1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
				ImageIcon S_icon3 = new ImageIcon(S_icon2);
				
				JOptionPane.showMessageDialog(null,"You have Succesfully registered and Your room number is "+no+".\nPlzz take your keys from reception.THANKYOU","INFORMTION",JOptionPane.INFORMATION_MESSAGE,S_icon3);
				ExistingRecord.Add(NameCmd , CnicCmd , PhoneCmd , AddressCmd , RoomType , BedType , daysCmd , roomnum , bill);
			}
		}
		catch(Exception e)
		{
			
			JOptionPane.showMessageDialog(null,"Please fill all text fields","WARNING",JOptionPane.WARNING_MESSAGE,icon3);
		}
		
	}
		
}