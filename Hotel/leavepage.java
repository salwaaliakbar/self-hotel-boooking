package Hotel;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.lang.String;

public class leavepage extends JFrame implements ActionListener
{
	private Rooms room[];
	private Container c;
	private JTextField total_bill;
	private JTextArea food_bill,rent_bill;
	private JButton leave;
	private JLabel leavepagepic,heading,rent,food,bill,note;
	private JScrollPane foodPane,rentPane;
	private int i;
	
	public leavepage(String rentBillToPay,String foodBillToPay,String totalBillToPay,Rooms room[],int i)
	{
		this.room = room;
		this.i = i;
		
//--------------------------------SET JFRAME ICON------------------------------------------

		ImageIcon h1 = new ImageIcon(getClass().getResource("hotel_icon.jpg"));
		Image h2 = h1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		
//-------------------------------------------------------------------------------------------
		
		this.setSize(600,500);
		this.setIconImage(h2);
		this.setLocationRelativeTo(null);
		
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
//------------------------------ DEFINE COMPONENTS -------------------------------------
		
		heading = new JLabel("CHECKOUT");
		rent = new JLabel("Rent Bill");
		food = new JLabel("Food Bill");
		bill = new JLabel("Total Bill");
		note = new JLabel("NOTE : Plzz Pay your bill at reception");
		rent_bill = new JTextArea(rentBillToPay,0,0);
		food_bill = new JTextArea(foodBillToPay,15,0);
		total_bill = new JTextField(totalBillToPay);
		leave = new JButton("Leave");
		foodPane = new JScrollPane(food_bill);
		rentPane = new JScrollPane(rent_bill);
		
//------------------------- SET FONT COLOR,BACKGROUND AND FONT STYLE ---------------------
		
		heading.setForeground(Color.BLACK);
		note.setForeground(Color.RED);
		leave.setBackground(Color.BLACK);
		leave.setForeground(Color.WHITE);
		heading.setFont(new Font("Aharoni",Font.BOLD,30));
		note.setFont(new Font("Aharoni",Font.BOLD,15));
		leave.setFont(new Font("Aharoni",Font.BOLD,20));
		
//-------------------------- SET SCALED IMAGE --------------------------------------		
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("leavepagepic.jpg"));
		Image i2 = i1.getImage().getScaledInstance(300,500,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		leavepagepic = new JLabel(i3);
		
		
//--------------------------------SET BOUNDS ----------------------------------		
		
		leavepagepic.setBounds(300,0,300,500);
		heading.setBounds(50,10,200,75);
		rent.setBounds(25,95,100,50);
		food.setBounds(25,155,100,150);
		bill.setBounds(25,315,100,25);
		note.setBounds(25,350,300,25);
		rentPane.setBounds(125,100,175,45);
		foodPane.setBounds(125,165,175,140);
		total_bill.setBounds(125,315,175,25);
		leave.setBounds(75,400,125,50);
	
//------------------------------- ADD COMPONENTS -----------------------------------
	
		c.add(leavepagepic);
		c.add(heading);
		c.add(rent);
		c.add(food);
		c.add(bill);
		c.add(rentPane);
		c.add(foodPane);
		c.add(total_bill);
		c.add(note);
		c.add(leave);
		
		leave.setFocusable(false);
		leave.addActionListener(this);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == leave)
		{
			LeavingRecord.Add(room[i].NameCmd , room[i].CnicCmd , room[i].PhoneCmd , room[i].AddressCmd , room[i].RoomType , room[i].BedType , room[i].daysCmd , room[i].roomnum , room[i].bill);
			ExistingRecord.Delete(room[i].NameCmd , room[i].CnicCmd , room[i].PhoneCmd , room[i].AddressCmd , room[i].RoomType , room[i].BedType , room[i].daysCmd , room[i].roomnum , room[i].bill);
			room[i] = null;
			forUserName.usernamesingup[i] = null;
			this.setVisible(false);
			
			UIManager.put("OptionPane.background",Color.WHITE);
			UIManager.put("Panel.background",Color.WHITE);
			UIManager.put("Button.background",Color.BLACK);
			UIManager.put("Button.foreground", Color.WHITE);
			UIManager.put("Button.font",new Font("Aharoni",Font.PLAIN,20));
			UIManager.put("ButtonUI", NonFocusableButtonUI.class.getName());
			
			JOptionPane.showMessageDialog(null,"NOTE : plzz pay your bill at reception\nThanks! for choosing our resturant.","THANKS",JOptionPane.PLAIN_MESSAGE);
			
		}
	}
}