package Hotel;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.lang.String;

public class RoomsPrices extends JFrame implements ActionListener
{
//------------------------------DECLARE COMPONENTS-------------------------------------
	
	private Container c;
	private JLabel AC_SB_Price,AC_DB_Price,NAC_SB_Price,NAC_DB_Price,RoomsPricePagePic;
	private JButton back;
		
	
	public RoomsPrices()
	{
		
//--------------------------------SET JFRAME ICON------------------------------------------

		ImageIcon h1 = new ImageIcon(getClass().getResource("hotel_icon.jpg"));
		Image h2 = h1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		
	
//----------------------------------------------------------------------------------
		
		this.setSize(600,500);
		this.setIconImage(h2);
		this.setLocationRelativeTo(null);
		
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
//----------------------------------- DEFINE COMPONENTS -----------------------------------
		
		AC_SB_Price = new JLabel("(101 - 105)AC Room(SINGLE BED) = 3000/-(Per day)");
		AC_DB_Price = new JLabel("(106 - 110)AC Room(DOUBLE BED) = 5000/-(Per day)");
		NAC_SB_Price = new JLabel("(111 - 115)Non AC Room(SINGLE BED) = 1000/-(Per day)");
		NAC_DB_Price = new JLabel("(116 - 120)Non AC Room(DOUBLE BED) = 3000/-(Per day)");
		back = new JButton("Back");
		
//-------------------------------- SET FONT COLOR ----------------------------------------
		
		AC_SB_Price.setForeground(Color.BLACK);
		AC_DB_Price.setForeground(Color.BLACK);
		NAC_SB_Price.setForeground(Color.BLACK);
		NAC_DB_Price.setForeground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		
//-------------------------------- SET FONT STYLE ---------------------------------------		
		
		AC_SB_Price.setFont(new Font("Aharoni",Font.BOLD,20));
		AC_DB_Price.setFont(new Font("Aharoni",Font.BOLD,20));
		NAC_SB_Price.setFont(new Font("Aharoni",Font.BOLD,20));
		NAC_DB_Price.setFont(new Font("Aharoni",Font.BOLD,20));
		back.setFont(new Font("Aharoni",Font.BOLD,30));
		
//-------------------------------- SET SCALED IMAGE --------------------------------------		
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("RoomsPagePic.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600,500,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		RoomsPricePagePic = new JLabel(i3);
		
//--------------------------------- SET BOUNDS ------------------------------------------		
		
		RoomsPricePagePic.setBounds(0,0,600,500);
		AC_SB_Price.setBounds(25,50,550,50);
		AC_DB_Price.setBounds(25,110,550,50);
		NAC_SB_Price.setBounds(25,170,550,50);
		NAC_DB_Price.setBounds(25,230,550,50);
		back.setBounds(200,350,200,60);
		
//-------------------------------- ADD COMPONENTS -----------------------------------------
		
		c.add(RoomsPricePagePic);
		RoomsPricePagePic.add(AC_SB_Price);
		RoomsPricePagePic.add(AC_DB_Price);
		RoomsPricePagePic.add(NAC_SB_Price);
		RoomsPricePagePic.add(NAC_DB_Price);
		RoomsPricePagePic.add(back);
		
		
		back.addActionListener(this);
		back.setFocusable(false);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == back)
			this.setVisible(false);
	}
}