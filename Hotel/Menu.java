package Hotel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Menu implements ActionListener
{
	Registration r = new Registration();
	SignIn s = new SignIn();
	
//-------------------------------DECLARE COMPONENTS-----------------------------------------

	private JFrame myframe;
	private Container c;
	private JMenuBar mb;
	private JMenu prices,home,customer_record;
	private JMenuItem FoodItemPrices,roomRentPrices,reg,sign,left , existing;
	private JButton b1,b2;
	private JLabel coverpic,heading;
	
	
	public void Disply()
	{

//--------------------------------SET JFRAME ICON------------------------------------------

		ImageIcon h1 = new ImageIcon(getClass().getResource("hotel_icon.jpg"));
		Image h2 = h1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		
//--------------------------------------------------------------------------------------
		
		myframe = new JFrame();
		myframe.setIconImage(h2);
		Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        myframe.setSize(screenSize.width,screenSize.height);
		myframe.setLocationRelativeTo(null);
		
		c = myframe.getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(null);
		
//--------------------------------ADD DETAILS -------------------------------------

		mb = new JMenuBar();
		prices = new JMenu("Prices");
		home = new JMenu("Home");
		reg = new JMenuItem("Registration");
		sign = new JMenuItem("Sign In");
		FoodItemPrices = new JMenuItem("Food Prices");
		roomRentPrices = new JMenuItem("Rooms prices");
		customer_record = new JMenu("Customer's Record");
		existing = new JMenuItem("Existing customer");
		left = new JMenuItem("Leaved customer");
		b1 = new JButton("Registration");
		b2 = new JButton("SignIn");

//-------------------------------- HEADING -----------------------------------------------
		
		heading = new JLabel("WELCOME TO FIVE STAR HOTEL");
		heading.setFont(new Font("Aharoni",Font.BOLD,50));
		heading.setForeground(Color.BLACK);
		
//-------------------------------- SET BACKGROUND COLOR-----------------------------------		
		
		mb.setBackground(Color.BLACK);
		FoodItemPrices.setBackground(Color.BLACK);
		roomRentPrices.setBackground(Color.BLACK);
		reg.setBackground(Color.BLACK);
		sign.setBackground(Color.BLACK);
		existing.setBackground(Color.BLACK);
		left.setBackground(Color.BLACK);
		b1.setBackground(Color.BLACK);
		b2.setBackground(Color.BLACK);
		
//-------------------------------- SET FONT COLOR ------------------------------------------ 
		
		prices.setForeground(Color.WHITE);
		home.setForeground(Color.WHITE);
		customer_record.setForeground(Color.WHITE);
		FoodItemPrices.setForeground(Color.WHITE);
		roomRentPrices.setForeground(Color.WHITE);
		reg.setForeground(Color.WHITE);
		sign.setForeground(Color.WHITE);
		existing.setForeground(Color.WHITE);
		left.setForeground(Color.WHITE);
		b1.setForeground(Color.WHITE);
		b2.setForeground(Color.WHITE);
		
//------------------------------ SET FONT AND FONT STYLE-------------------------------------
		
		prices.setFont(new Font("Aharoni",Font.BOLD,15));
		home.setFont(new Font("Aharoni",Font.BOLD,15));
		customer_record.setFont(new Font("Aharoni",Font.BOLD,15));
		FoodItemPrices.setFont(new Font("Aharoni",Font.BOLD,15));
		roomRentPrices.setFont(new Font("Aharoni",Font.BOLD,15));
		reg.setFont(new Font("Aharoni",Font.BOLD,15));
		sign.setFont(new Font("Aharoni",Font.BOLD,15));
		existing.setFont(new Font("Aharoni",Font.BOLD,15));
		left.setFont(new Font("Aharoni",Font.BOLD,15));
		b1.setFont(new Font("Aharoni",Font.BOLD,25));
		b2.setFont(new Font("Aharoni",Font.BOLD,25));
		
//-------------------------------- ADD SCALED IMAGE--------------------------------------------
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("coverpic.jpg"));
		Image i2 = i1.getImage().getScaledInstance(screenSize.width,screenSize.height,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		coverpic = new JLabel(i3);
		
	
//------------------------------- SET BOUNDS OF COMPONENTS-------------------------------------	
	
		int headingWidth = 900;

		coverpic.setBounds(0,-20,screenSize.width,screenSize.height);
		heading.setBounds(((screenSize.width - headingWidth)+100) / 2,50,900,50);
		b1.setBounds((screenSize.width - 190) / 2, (screenSize.height - 175) -70 , 190, 50);
		b2.setBounds((screenSize.width - 190) / 2, ((screenSize.height - 175)), 190, 50);
		
//-------------------------------- ADD COMPONENTS ---------------------------------------------

		coverpic.add(heading);
		coverpic.add(b1);
		coverpic.add(b2);
		prices.add(roomRentPrices);
		prices.add(FoodItemPrices);
		home.add(reg);
		home.add(sign);
		customer_record.add(existing);
		customer_record.add(left);
		mb.add(home);
		mb.add(prices);
		mb.add(customer_record);
		c.add(coverpic);
		myframe.setJMenuBar(mb);
	
//-------------------------------- CALL FOR EVENT HANDLING ----------------------------------	
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		reg.addActionListener(this);
		sign.addActionListener(this);
		FoodItemPrices.addActionListener(this);
		roomRentPrices.addActionListener(this);
		left.addActionListener(this);
		existing.addActionListener(this);
	
		b1.setFocusable(false);
		b2.setFocusable(false);
		myframe.setResizable(false);
		myframe.setDefaultCloseOperation(myframe.EXIT_ON_CLOSE);
		myframe.setVisible(true);
	}	

//---------------------------- METHOD FOR EVENT HANDLING -------------------------------------	
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == b1 || event.getSource() == reg)
		{
			r.Options1();
		}
		else if(event.getSource() == b2 || event.getSource() == sign)
		{
			s.SignInOption(r.room);	
		}
		else if(event.getSource() == FoodItemPrices)
		{
			new foodPricesPage().setVisible(true);
		}
		else if(event.getSource() == roomRentPrices)
		{
			new RoomsPrices().setVisible(true);
		}
		else if(event.getSource() == left) {
			new LogIn("Left");
		}
		else if(event.getSource() == existing) {
			new LogIn("Exist");
		}
	}
	
	
}