package Hotel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;

public class userchoice extends UnfillText
{
	private Rooms []room;
	private JFrame myframe;
	private Container c;
	private JLabel food,leave,reset ,heading,foodOrder,leaveOut,resetpassword;
	private int i;
	
	public void choicemenu(Rooms room[],int i)
	{
		this.i = i;
		this.room = room;
		
		
//--------------------------------SET JFRAME ICON------------------------------------------

		ImageIcon h1 = new ImageIcon(getClass().getResource("hotel_icon.jpg"));
		Image h2 = h1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		
//-----------------------------------------------------------------------------------------
		
		myframe = new JFrame();
		myframe.setSize(600,500);
		myframe.setIconImage(h2);
		myframe.setLocationRelativeTo(null);
		
		c = myframe.getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(null);
		
//----------------------------- SET HEADING ----------------------------------------

		heading = new JLabel("SIGN IN");
		heading.setForeground(Color.BLACK);
		heading.setFont(new Font("Aharoni",Font.BOLD,80));
		
//----------------------------- DEFINE COMPONENTS ----------------------------------	
		
		foodOrder = new JLabel("Click for order food.");
		leaveOut = new JLabel("click for leave hotel.");
		resetpassword = new JLabel("click for reset password");
		
		foodOrder.setFont(new Font("Aharoni",Font.PLAIN,15));
		foodOrder.setForeground(Color.BLACK);
		leaveOut.setFont(new Font("Aharoni",Font.PLAIN,15));
		leaveOut.setForeground(Color.BLACK);
		resetpassword.setFont(new Font("Aharoni",Font.PLAIN,15));
		resetpassword.setForeground(Color.BLACK);
		
//------------------------------ ADD SCALED IMAGES -----------------------------------
		
		ImageIcon f1 = new ImageIcon(getClass().getResource("foodPic.png"));
		Image f2 = f1.getImage().getScaledInstance(150,200,Image.SCALE_DEFAULT);
		ImageIcon f3 = new ImageIcon(f2);
		food = new JLabel(f3);
		
		ImageIcon l1 = new ImageIcon(getClass().getResource("leavePic.jpg"));
		Image l2 = l1.getImage().getScaledInstance(150,200,Image.SCALE_DEFAULT);
		ImageIcon l3 = new ImageIcon(l2);
		leave = new JLabel(l3);
		
		ImageIcon r1 = new ImageIcon(getClass().getResource("resetPic.png"));
		Image r2 = r1.getImage().getScaledInstance(150,200,Image.SCALE_DEFAULT);
		ImageIcon r3 = new ImageIcon(r2);
		reset = new JLabel(r3);

//---------------------------------- SET BOUNDS ------------------------------------------

		heading.setBounds(125,20,400,110);
		food.setBounds(20,150,160,200);
		leave.setBounds(190,150,160,200);
		reset.setBounds(370,150,160,200);
		foodOrder.setBounds(20,350,160,100);
		leaveOut.setBounds(190,350,160,100);
		resetpassword.setBounds(370,350,160,100);
		
		
//----------------------------------- ADD COMPONENTS ---------------------------------------
		c.add(heading);
		c.add(food);
		c.add(leave);
		c.add(foodOrder);
		c.add(leaveOut);
		c.add(resetpassword);
		c.add(reset);


		//----------------------------------- SELECT FOOD ---------------------------------------------

		foodOrder.addMouseListener(new MouseAdapter() { //O(n)
			public void mouseEntered(MouseEvent e) {
				foodOrder.setFont(new Font("Aharoni", Font.BOLD, 15));
			}
			public void mouseExited(MouseEvent e) {
				foodOrder.setFont(new Font("Aharoni", Font.PLAIN, 15));
			}
			public void mouseClicked(MouseEvent e) {
				foodOrder.setFont(new Font("Aharoni",Font.BOLD,15));
				new foodpage(room,i).setVisible(true);
				myframe.setVisible(false);
			}
		});

		//------------------------------------ SELECT LEAVE ------------------------------------------

		leaveOut.addMouseListener(new MouseAdapter() {  // O(n)
			public void mouseEntered(MouseEvent e) {
				leaveOut.setFont(new Font("Aharoni", Font.BOLD, 15));
			}
			public void mouseExited(MouseEvent e) {
				leaveOut.setFont(new Font("Aharoni", Font.PLAIN, 15));
			}
			public void mouseClicked(MouseEvent e) {
				leaveOut.setFont(new Font("Aharoni",Font.BOLD,15));;
				String rnt = room[i].rent_prices+"Rent Charges  =  "+room[i].rent+"/-";
				String fod = room[i].food_ordered+"\nFood Charges  =  "+room[i].foodBill+"/-";
				String bil = "Total Bill    =  "+room[i].bill+"/-";

				new leavepage(rnt,fod,bil,room,i).setVisible(true);
				myframe.setVisible(false);
			}
		});

		//------------------------------------ SELECT RESET -------------------------------------------

		resetpassword.addMouseListener(new MouseAdapter() {  //O(n)  -->   for check password (correct or not)
			public void mouseEntered(MouseEvent e) {
				resetpassword.setFont(new Font("Aharoni", Font.BOLD, 15));
			}
			public void mouseExited(MouseEvent e) {
				resetpassword.setFont(new Font("Aharoni", Font.PLAIN, 15));
			}
			public void mouseClicked(MouseEvent e) {
				resetpassword.setFont(new Font("Aharoni",Font.BOLD,15));
				resetPage r = new resetPage();
				r.resetOption(room,i);
				myframe.setVisible(false);
			}
		});
		
		myframe.setResizable(false);
		myframe.setDefaultCloseOperation(myframe.EXIT_ON_CLOSE);
		myframe.setVisible(true);

	}

}