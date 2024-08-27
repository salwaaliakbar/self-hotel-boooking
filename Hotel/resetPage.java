package Hotel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.lang.String;

class MisMatched extends Exception
{
	public String getMessage()
	{
		return "MISMATCHED";
	}
}

public class resetPage extends UnfillText implements ActionListener,Checkpassword
{
//---------------------------- DECLARE COMPONETS -------------------------------------
	
	private Rooms room[];
	private JFrame myframe;
	private Container c;
	private JLabel newPass,conPass,resetpagepic;
	private JTextArea note;
	private JPasswordField newPassword,confrimPassword;
	private JButton change;
	private Border border,border1;
	private int i,count = 0;
	private boolean correctpass;
	
	public void resetOption(Rooms room[],int i)
	{
		this.room = room;
		this.i = i;
		
		
//--------------------------------SET JFRAME ICON------------------------------------------

		ImageIcon h1 = new ImageIcon(getClass().getResource("hotel_icon.jpg"));
		Image h2 = h1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		
//------------------------------------------------------------------------------------
		
		myframe = new JFrame();
		myframe.setSize(600,500);
		myframe.setIconImage(h2);
		myframe.setLocationRelativeTo(null);
		
		c = myframe.getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(null);
		
//------------------------ DEFINE COMPONENTS --------------------------------------
		
		newPass = new JLabel("Enter new Password");
		conPass = new JLabel("Confrim Password");
		change = new JButton("Change");
		note = new JTextArea();
		newPassword = new JPasswordField(15);
		confrimPassword = new JPasswordField(15);
		border = BorderFactory.createLineBorder(Color.RED);
		border1 = BorderFactory.createLineBorder(Color.GRAY);
		
//-------------------------- SET BUTTON AND LABEL -------------------------------------		
		
		note.setForeground(Color.RED);
		change.setBackground(Color.BLACK);
		change.setForeground(Color.WHITE);
		note.setFont(new Font("Aharoni",Font.BOLD,10));
		change.setFont(new Font("Aharoni",Font.BOLD,20));
	
//-------------------------- SET SCALED IMAGE ---------------------------------
	
		ImageIcon i1 = new ImageIcon(getClass().getResource("resetpage.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		resetpagepic = new JLabel(i3);
		
//-------------------------- SET BOUNDS ----------------------------------------		
		
		resetpagepic.setBounds(0,0,600,300);
		newPass.setBounds(75,300,150,25);
		conPass.setBounds(75,335,150,25);
		newPassword.setBounds(300,300,150,25);
		confrimPassword.setBounds(300,335,150,25);
		note.setBounds(105,360,450,30);
		change.setBounds(200,400,150,50);
		
//----------------------------- ADD COMPONENTS --------------------------------------		
		
		c.add(resetpagepic);
		c.add(newPass);
		c.add(conPass);
		c.add(newPassword);
		c.add(confrimPassword);
		c.add(note);
		c.add(change);
		
		change.setFocusable(false);
		change.addActionListener(this);
		
//---------------------------- ACTION METHOD OF KEYLISTENER ------------------------------

		newPassword.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent event)
			{
				if(!((new String(newPassword.getPassword()).trim().isEmpty())))
					{
					newPassword.setBorder(border1);
					confrimPassword.setBorder(border1);
					note.setText(null);
				}
			}
		});
//------------------------------------------------------------------------------------------
		
		
		myframe.setResizable(false);
		myframe.setDefaultCloseOperation(myframe.EXIT_ON_CLOSE);
		myframe.setVisible(true);
		
	}
	
//--------------------------- ACTION METHOD OF ACTIONLISTENER----------------------------	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == change)
		{
			
//--------------------------- SET DIALOG BOX COLORS AND STYLE ---------------------------

			UIManager.put("OptionPane.background",Color.WHITE);
			UIManager.put("Panel.background",Color.WHITE);
			UIManager.put("Button.background",Color.BLACK);
			UIManager.put("Button.foreground", Color.WHITE);
			UIManager.put("Button.font",new Font("Aharoni",Font.PLAIN,20));
			UIManager.put("ButtonUI", NonFocusableButtonUI.class.getName());
			
//--------------------------- SET DIALOG BOX ICON ------------------------------------
			
			ImageIcon icon1 = new ImageIcon(getClass().getResource("warning.jpg"));
			Image icon2 = icon1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
			ImageIcon icon3 = new ImageIcon(icon2);
			
			try
			{	
				if(!(new String(newPassword.getPassword()).trim().isEmpty() || new String(confrimPassword.getPassword()).trim().isEmpty()))
				{
					correctpass = check(new String(newPassword.getPassword()));
					
					if(!(new String(newPassword.getPassword()).equals(new String(confrimPassword.getPassword()))))
					{
						throw new MisMatched();
					}
					
					else if(!correctpass)
					{
						count++;
						newPassword.setText(null);
						confrimPassword.setText(null);
						newPassword.setBorder(border);
						confrimPassword.setBorder(border);
						note.setText("Password must be 8 character long and contain atleast a \nnumber,a uppercase,a lowercase and a special character");
					}						
				}
				
				if(new String(newPassword.getPassword()).trim().isEmpty() || new String(confrimPassword.getPassword()).trim().isEmpty())
				{
					if(count == 0)
						throw new UnfillText();
				}
				
				else if(new String(newPassword.getPassword()).equals(new String(confrimPassword.getPassword())))
				{
					room[i].p = new String(newPassword.getPassword());
					myframe.setVisible(false);
					
					ImageIcon S_icon1 = new ImageIcon(getClass().getResource("successful.jpg"));
					Image S_icon2 = S_icon1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
					ImageIcon S_icon3 = new ImageIcon(S_icon2);
					
					JOptionPane.showMessageDialog(null,"Your Password change Successfully","INFORMTION",JOptionPane.INFORMATION_MESSAGE,S_icon3);
				}
			}
			catch(MisMatched e)
			{
				JOptionPane.showMessageDialog(null,"Password and confrim Password Should be same","WARNING",JOptionPane.WARNING_MESSAGE,icon3);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Please fill all text fields","WARNING",JOptionPane.WARNING_MESSAGE,icon3);
			}
		}
		
	}
}