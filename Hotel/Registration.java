package Hotel;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Registration implements ActionListener
{
	public Rooms room[] = new Rooms[20];
	
	private JFrame myframe;
	private Container c;
	private JRadioButton AC,NonAC,SB,DB;
	private JButton cont;
	private JLabel pic;
	private ButtonGroup Bgroup11,Bgroup2;
	private int count;
	public Registration()
	{
		for(int i=0; i<20; i++) {
			room[i] = null;
		}
		
//----------------------------- ALREADY REGISTERED DATA ---------------------------

		room[0] = new Rooms();
		room[0].Su = "ahmed";
		room[0].p = "Ahmed12@";
		room[0].daysCmd = 2;
		room[0].roomnum = (0+101);
		room[0].RoomType = "AC Room";
		room[0].BedType = "Single Bed";
		room[0].NameCmd = "Ahmed Ali";
		room[0].AddressCmd ="Karachi";
		room[0].PhoneCmd = "0333-8754897";
		room[0].CnicCmd = "45504-9764775-9";
		room[0].rent = (room[0].daysCmd*room[0].AC_SB);
		//room[0].foodBill = 0;
		room[0].bill = room[0].foodBill+room[0].rent;
		room[0].rent_prices = room[0].daysCmd+" x (AC_SB) = "+room[0].rent+"/-\n";
		ExistingRecord.Add(room[0].NameCmd , room[0].CnicCmd , room[0].PhoneCmd , room[0].AddressCmd , room[0].RoomType , room[0].BedType , room[0].daysCmd , room[0].roomnum , room[0].bill);

		room[10] = new Rooms();
		room[10].Su = "hania";
		room[10].p = "Hania22@";
		room[10].roomnum = (10+101);
		room[10].daysCmd = 1;
		room[10].RoomType = "AC Room";
		room[10].BedType = "Single Bed";
		room[10].NameCmd = "Hania Khan";
		room[10].AddressCmd ="Karachi";
		room[10].PhoneCmd = "0312-9814897";
		room[10].CnicCmd = "45504-1798645-9";
		room[10].rent = (room[10].daysCmd*room[10].NAC_SB);
		//room[10].foodBill = 0;
		room[10].rent_prices = room[10].daysCmd+" x (NAC_SB) = "+room[10].rent+"/-\n";
		room[10].bill = room[10].foodBill+room[10].rent;
		ExistingRecord.Add(room[10].NameCmd , room[10].CnicCmd , room[10].PhoneCmd , room[10].AddressCmd , room[10].RoomType , room[10].BedType , room[10].daysCmd , room[10].roomnum , room[10].bill);

		room[11] = new Rooms();
		room[11].Su = "sara";
		room[11].p = "Sara760@";
		room[11].daysCmd = 5;
		room[11].roomnum = (11+101);
		room[11].RoomType = "Non-AC Room";
		room[11].BedType = "Single Bed";
		room[11].NameCmd = "Sara Sheikh";
		room[11].AddressCmd ="Islamabad";
		room[11].PhoneCmd = "0322-8058153";
		room[11].CnicCmd = "45504-1264975-0";
		room[11].rent = (room[11].daysCmd*room[11].NAC_SB);
		//room[11].foodBill = 0;
		room[11].bill = room[11].foodBill+room[11].rent;
		room[11].rent_prices = room[11].daysCmd+" x (NAC_SB) = "+room[11].rent+"/-\n";
		ExistingRecord.Add(room[11].NameCmd , room[11].CnicCmd , room[11].PhoneCmd , room[11].AddressCmd , room[11].RoomType , room[11].BedType , room[11].daysCmd , room[11].roomnum , room[11].bill);

		room[15] = new Rooms();
		room[15].Su = "akbar";
		room[15].p = "Akbar54@";
		room[15].daysCmd = 3;
		room[15].roomnum = (15+101);
		room[15].RoomType = "Non-AC Room";
		room[15].BedType = "Single Bed";
		room[15].NameCmd = "Akbar";
		room[15].AddressCmd ="Sukkur";
		room[15].PhoneCmd = "0311-0924827";
		room[15].CnicCmd = "45504-0664173-1";
		room[15].rent = (room[15].daysCmd*room[15].NAC_DB);
		//room[15].foodBill = 0;
		room[15].bill = room[15].foodBill+room[15].rent;
		room[15].rent_prices = room[15].daysCmd+" x (NAC_DB) = "+room[15].rent+"/-\n";
		ExistingRecord.Add(room[15].NameCmd , room[15].CnicCmd , room[15].PhoneCmd , room[15].AddressCmd , room[15].RoomType , room[15].BedType , room[15].daysCmd , room[15].roomnum , room[15].bill);
		
	}
	
//------------------------------- WHEN REQUIRED ROOM IS BOOKED ------------------------------
	
	public void code()
	{	
	
//--------------------------- FOR DIALOG BOX COLOR AND ICON -----------------------------------
		
		UIManager.put("OptionPane.background",Color.WHITE);
		UIManager.put("Panel.background",Color.WHITE);
		UIManager.put("Button.background",Color.BLACK);
		UIManager.put("Button.foreground", Color.WHITE);
		UIManager.put("Button.font",new Font("Aharoni",Font.PLAIN,20));
		UIManager.put("ButtonUI",NonFocusableButtonUI.class.getName());
		
		ImageIcon icon1 = new ImageIcon(getClass().getResource("warning.jpg"));
		Image icon2 = icon1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon icon3 = new ImageIcon(icon2);
		
		JOptionPane.showMessageDialog(null,"Sorry we don't have empty room according to your demand.","INFORMATION",JOptionPane.INFORMATION_MESSAGE,icon3);
	}
	
	public void Options1()
	{
		
//--------------------------------SET JFRAME ICON------------------------------------------

		ImageIcon h1 = new ImageIcon(getClass().getResource("hotel_icon.jpg"));
		Image h2 = h1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		
//--------------------------------------------------------------------------------------------
		
		myframe = new JFrame("REGISTRATION");
		myframe.setSize(600,500);
		myframe.setIconImage(h2);
		myframe.setLocationRelativeTo(null);
		
		c = myframe.getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(null);
		
//------------------------------- DEFINE COMPONENTS ------------------------------------
		AC = new JRadioButton("AC");
		NonAC = new JRadioButton("NonAC");
		SB = new JRadioButton("Single Bed");
		DB = new JRadioButton("Double Bed");
		cont = new JButton("Continue");
		
//-------------------------------- FOR BUTTON GROUP -------------------------------------------
		
		Bgroup11 = new ButtonGroup();
		Bgroup2 = new ButtonGroup();
		
//-------------------------------- SET BACKGROUND COLOR --------------------------------------
		
		AC.setBackground(Color.WHITE);
		NonAC.setBackground(Color.WHITE);
		SB.setBackground(Color.WHITE);
		DB.setBackground(Color.WHITE);
		cont.setBackground(Color.BLACK);
		cont.setForeground(Color.WHITE);
		cont.setFont(new Font("Aharoni",Font.BOLD,20));
		
//---------------------------- ADD SCALED IMAGE ---------------------------------------
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("room.jpg"));
		Image i2 = i1.getImage().getScaledInstance(420,500,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		pic = new JLabel(i3);
		
		
//---------------------------- SET BOUNDS ---------------------------------------------

		pic.setBounds(0,-20,420,500);
		AC.setBounds(420,0,200,50);
		NonAC.setBounds(420,75,200,50);
		SB.setBounds(420,150,200,50);
		DB.setBounds(420,225,200,50);
		cont.setBounds(435,325,125,50);
		
//--------------------------- ADD RADIO BUTTON IN BUTTON GROUP ------------------------
		
		Bgroup11.add(AC);
		Bgroup11.add(NonAC);
		Bgroup2.add(SB);
		Bgroup2.add(DB);

//---------------------------- ADD COMPONENTS IN FRAME --------------------------------

		c.add(AC);
		c.add(NonAC);
		c.add(SB);
		c.add(DB);
		c.add(cont);
		c.add(pic);

		AC.setFocusable(false);
		NonAC.setFocusable(false);
		SB.setFocusable(false);
		DB.setFocusable(false);
		cont.setFocusable(false);
		cont.addActionListener(this);
		
		myframe.setDefaultCloseOperation(myframe.EXIT_ON_CLOSE);
		myframe.setResizable(false);
		myframe.setVisible(true);
	}

	public void actionPerformed(ActionEvent event)
	{
//--------------------------------- AC ROOM SELECTED ---------------------------------
		
		if(AC.isSelected())
		{
			if(SB.isSelected())
			{
				count = 0;
				for(int i=0; i<5; i++)
				{
					if(room[i] == null)
					{
						room[i] = new Rooms();
						room[i].forRoomNum(i);
						if(event.getSource() == cont)
						{
							room[i].RoomType = "AC Room";
							room[i].BedType = "Single Bed";
							room[i].Options2(room[i].getRoomNum(),i);
							myframe.setVisible(false);
							break;
						}
					}
					count++;
				}
				if(count >= 5)
				{
					code();
				}
			}
			else if(DB.isSelected())
			{
				count = 0;
				for(int i=5; i<10; i++)
				{
					if(room[i] == null)
					{
						room[i] = new Rooms();
						room[i].forRoomNum(i);
						if(event.getSource() == cont)
						{
							room[i].RoomType = "AC Room";
							room[i].BedType = "Double Bed";
							room[i].Options2(room[i].getRoomNum(),i);
							myframe.setVisible(false);
							break;
						}
					}
					count++;
				}
				if(count >= 5)
				{
					code();
				}
			}
		}
		
// ---------------------------- NON AC ROOM SELECTED ------------------------------------

		else if(NonAC.isSelected())
		{
			if(SB.isSelected())
			{
				for(int i=10; i<15; i++)
				{
					if(room[i] == null)
					{
						room[i] = new Rooms();
						room[i].forRoomNum(i);
						if(event.getSource() == cont)
						{
							room[i].RoomType = "Non-AC Room";
							room[i].BedType = "Single Bed";
							room[i].Options2(room[i].getRoomNum(),i);
							myframe.setVisible(false);
							break;
						}
						
					}
					count++;
				}
				if(count >= 5)
				{
					code();
				}
			}
			else if(DB.isSelected())
			{
				count = 0;
				for(int i=15; i<20; i++)
				{
					if(room[i] == null)
					{
						room[i] = new Rooms();
						room[i].forRoomNum(i);
						if(event.getSource() == cont)
						{
							room[i].RoomType = "Non-AC Room";
							room[i].BedType = "Double Bed";
							room[i].Options2(room[i].getRoomNum(),i);
							myframe.setVisible(false);
							break;
						}
					
					}
					count++;
				}
				if(count >= 5)
				{
					code();
				}
			}
		}
	}
}
	