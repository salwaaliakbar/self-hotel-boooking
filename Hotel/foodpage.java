package Hotel;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.lang.String;

public class foodpage extends JFrame implements ActionListener 
{
	private Rooms room[];
	private int i,count = 0;
	private Container c;
	private int totalFoodItem = 7;
	private JLabel foodItem[] = new JLabel[totalFoodItem];
	private String foodName[] = {"Chiken Biryani Rs. 450/-","Zinger Burger Rs. 499/-","Penne Alfredo Pasta Rs. 450/-","Fish Chilli Dry Rs. 675/-","Chiken Chowmien Rs. 499/-","Chiken Handi Rs. 869/-","Malai Kheer Rs. 599/-"};
	private JLabel foodpagepic,note,quan;
	private JComboBox<String> choose;
	private SpinnerModel value;
	private JSpinner quantity;
	private JTextArea text;
	private JScrollPane pane;
	private JButton order,selected;
	private String t1 = "";

	public foodpage(Rooms room[],int i)
	{
		this.room = room;
		this.i = i;
		
//--------------------------------SET JFRAME ICON------------------------------------------

		ImageIcon h1 = new ImageIcon(getClass().getResource("hotel_icon.jpg"));
		Image h2 = h1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		
//----------------------------------------------------------------------------------------
		
		this.setSize(600,620);
		this.setIconImage(h2);
		this.setLocationRelativeTo(null);
		
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
//--------------------------------- DEFINE COMPONENTS -----------------------------------	
		
		for(int j=0; j<totalFoodItem; j++)
		{
			foodItem[j] = new JLabel(foodName[j]);
		}
		
		note = new JLabel("NOTE : you can choose more than one food by selected one by one");
		quan = new JLabel("Quantity");
		text = new JTextArea("Your order",10,0);
		selected = new JButton("Selected");
		order = new JButton("Order");
		pane = new JScrollPane(text);
		String fooditem[] = {"Chiken Biryani","Zinger Burger","Penne Alfredo Pasta","Fish Chilli Dry","Chiken Chowmien","Chiken Handi","Malai Kheer"};
		choose = new JComboBox<>(fooditem);
		
		value = new SpinnerNumberModel(1,1,12,1);
		quantity = new JSpinner(value);
		
//--------------------------------- SET FONT COLOR -------------------------------------
		
		for(int j=0; j<totalFoodItem; j++)
		{
			foodItem[j].setForeground(Color.WHITE);
		}
		
		note.setForeground(Color.WHITE);
		quan.setForeground(Color.WHITE);
		selected.setBackground(Color.BLACK);
		selected.setForeground(Color.WHITE);
		order.setBackground(Color.BLACK);
		order.setForeground(Color.WHITE);
		
//-------------------------------- SET FONT STYLE -------------------------------------		
		
		for(int j=0; j<totalFoodItem; j++)
		{
			foodItem[j].setFont(new Font("Aharoni",Font.BOLD,20));
		}
		
		quan.setFont(new Font("Aharoni",Font.BOLD,20));
		selected.setFont(new Font("Aharoni",Font.BOLD,20));
		order.setFont(new Font("Aharoni",Font.BOLD,20));
		
//---------------------------------- SET SCALED IMAGE -----------------------------------
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("foodpage.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600,620,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		foodpagepic = new JLabel(i3);
		
//---------------------------------- SET BOUNDS -----------------------------------------
		
		foodpagepic.setBounds(0,0,600,600);
		foodItem[0].setBounds(25,20,400,25);
		foodItem[1].setBounds(25,55,400,25);
		foodItem[2].setBounds(25,90,400,25);
		foodItem[3].setBounds(25,125,400,25);
		foodItem[4].setBounds(25,160,400,25);
		foodItem[5].setBounds(25,195,400,25);
		foodItem[6].setBounds(25,230,400,25);
		note.setBounds(25,265,400,15);
		choose.setBounds(25,290,250,25);
		quan.setBounds(25,332,100,20);
		quantity.setBounds(125,332,150,25);
		pane.setBounds(25,385,250,100);
		selected.setBounds(25,510,120,50);
		order.setBounds(160,510,120,50);
		
//-------------------------------------- ADD COMPONENTS ----------------------------------
		
		c.add(foodpagepic);
		foodpagepic.add(note);
		foodpagepic.add(choose);
		foodpagepic.add(quan);
		foodpagepic.add(quantity);
		foodpagepic.add(pane);
		foodpagepic.add(selected);
		foodpagepic.add(order);
		for(int j=0; j<totalFoodItem; j++)
		{
			foodpagepic.add(foodItem[j]);
		}
		
		selected.setFocusable(false);
		order.setFocusable(false);
		
		selected.addActionListener(this);
		order.addActionListener(this);
		
		
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public void actionPerformed(ActionEvent event)
	{	
		if(event.getSource() == selected)
		{
			if(count == 0)
				text.setText(null);
			
			count++;
			String selectedvalue = choose.getSelectedItem().toString();
			int val = (Integer)quantity.getValue();
			
			String t = text.getText()+count+"."+selectedvalue+" ("+val+")\n";
			text.setText(t);
			
			if(selectedvalue == "Chiken Biryani")
			{
				room[i].foodBill = room[i].foodBill+(val*450);
				t1 = t1+val+" x "+selectedvalue+" = "+val*450+"/-\n";
			}
			
			else if(selectedvalue == "Zinger Burger")
			{
				room[i].foodBill = room[i].foodBill+(val*499);
				t1 = t1+val+" x "+selectedvalue+" = "+val*499+"/-\n";
			}
			
			else if(selectedvalue == "Penne Alfredo Pasta")
			{
				room[i].foodBill = room[i].foodBill+(val*450);
				t1 = t1+val+" x "+selectedvalue+" = "+val*450+"/-\n";
			}
			
			else if(selectedvalue == "Fish Chilli Dry")
			{
				room[i].foodBill = room[i].foodBill+(val*675);
				t1 = t1+val+" x "+selectedvalue+" = "+val*675+"/-\n";
			}
			
			else if(selectedvalue == "Chiken Chowmien")
			{
				room[i].foodBill = room[i].foodBill+(val*499);
				t1 = t1+val+" x "+selectedvalue+" = "+val*499+"/-\n";
			}
			
			else if(selectedvalue == "Chiken Handi")
			{
				room[i].foodBill = room[i].foodBill+(val*869);
				t1 = t1+val+" x "+selectedvalue+" = "+val*869+"/-\n";
			}
			
			else if(selectedvalue == "Malai Kheer")
			{
				room[i].foodBill = room[i].foodBill+(val*599);
				t1 = t1+val+" x "+selectedvalue+" = "+val*599+"/-\n";
			}
			room[i].food_ordered = t1;
			room[i].bill = room[i].foodBill + room[i].rent;
			ExistingRecord.update(room[i].NameCmd , room[i].CnicCmd , room[i].PhoneCmd , room[i].AddressCmd , room[i].RoomType , room[i].BedType , room[i].daysCmd , room[i].roomnum , room[i].bill);
		}
		else if(event.getSource() == order)
		{
			UIManager.put("OptionPane.background",Color.WHITE);
			UIManager.put("Panel.background",Color.WHITE);
			UIManager.put("Button.background",Color.BLACK);
			UIManager.put("Button.foreground", Color.WHITE);
			UIManager.put("Button.font",new Font("Aharoni",Font.PLAIN,20));
			UIManager.put("ButtonUI", NonFocusableButtonUI.class.getName());
			
			if(text.getText().equals("Your order"))
			{
				ImageIcon icon1 = new ImageIcon(getClass().getResource("warning.jpg"));
				Image icon2 = icon1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
				ImageIcon icon3 = new ImageIcon(icon2);
				
				JOptionPane.showMessageDialog(null,"Plzz select some food first","WARNING",JOptionPane.WARNING_MESSAGE,icon3);
				
			}
			else
			{
				this.setVisible(false);
				JOptionPane.showMessageDialog(null,"Your food will be deliver in 10 min. THANKS","FOOD MESSAGE",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}