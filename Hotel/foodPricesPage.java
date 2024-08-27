package Hotel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;

public class foodPricesPage extends JFrame implements ActionListener
{
	private Container c;
	private int totalFoodItem = 7;
	private JLabel foodItem[] = new JLabel[totalFoodItem];
	private String foodName[] = {"Chicken Biryani Rs. 450/-","Zinger Burger Rs. 499/-","Penne Alfredo Pasta Rs. 450/-","Fish Chilli Dry Rs. 675/-","Chiken Chowmien Rs. 499/-","Chiken Handi Rs. 869/-","Malai Kheer Rs. 599/-"};
	private JLabel foodPricesPagePic;
	private JButton back;
	
	public foodPricesPage()
	{
		
//--------------------------------SET JFRAME ICON------------------------------------------

		ImageIcon h1 = new ImageIcon(getClass().getResource("hotel_icon.jpg"));
		Image h2 = h1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		
//-------------------------------------------------------------------------------------------
		
		this.setSize(600,550);
		this.setIconImage(h2);
		this.setLocationRelativeTo(null);
		
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
//-----------------------------------DEFINE COMPONENTS ----------------------------------		
		
		back = new JButton("Back");
		for(int j=0; j<totalFoodItem; j++)
		{
			foodItem[j] = new JLabel(foodName[j]);
		}
		
//---------------------------------- SET FONT COLOR -----------------------------------		
		
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		for(int j=0; j<totalFoodItem; j++)
		{
			foodItem[j].setForeground(Color.WHITE);
		}
		
		
//-------------------------------SET FONT STYLE ----------------------------------------		
		
		back.setFont(new Font("Aharoni",Font.BOLD,35));
		for(int j=0; j<totalFoodItem; j++)
		{
			foodItem[j].setFont(new Font("Aharoni",Font.BOLD,25));
		}
		
//------------------------------- SET SCALED IMAGE --------------------------------------		
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("foodPricespage.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		foodPricesPagePic = new JLabel(i3);
		
//------------------------------ SET BOUNDS ---------------------------------------------		
		
		foodPricesPagePic.setBounds(0,0,600,550);
		foodItem[0].setBounds(140,85,400,30);
		foodItem[1].setBounds(140,125,400,30);
		foodItem[2].setBounds(140,165,450,30);
		foodItem[3].setBounds(140,205,400,30);
		foodItem[4].setBounds(140,245,400,30);
		foodItem[5].setBounds(140,285,400,30);
		foodItem[6].setBounds(140,325,400,30);
		back.setBounds(190,370,200,60);
		
//------------------------------- ADD COMPONENTS ------------------------------------------		
		
		c.add(foodPricesPagePic);
		foodPricesPagePic.add(back);
		for(int j=0; j<totalFoodItem; j++)
		{
			foodPricesPagePic.add(foodItem[j]);
		}
		
		
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