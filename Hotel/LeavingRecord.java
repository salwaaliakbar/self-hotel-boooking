package Hotel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.String;
import javax.swing.table.JTableHeader;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
public class LeavingRecord extends JFrame implements ActionListener {

    //--------------------------DECLARE COMPONENTS -------------------------------------

    private JButton back , searchButton;
    private boolean found = false;
    private JTextField search;
    private Border border;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scrollPane;
    private JTableHeader header;
    String [][]data;
    static BST []Leavingrecords;
    static {
        Leavingrecords = new BST[26];
        for(int i = 0; i<26; i++) {
            Leavingrecords[i] = null;
        }
        LeavingRecord.Add("Isha malik" , "45504-0685673-1" , "0311-0924827" , "Hyderabad" , "AC" , "Double",3,106,9900);
        LeavingRecord.Add("Zain" , "45504-9534163-1" , "0312-07564827" , "Sukkur" , "Non-AC" , "Single",1,111,5869);
        LeavingRecord.Add("Kiran" , "45504-0664973-1" , "0311-192484782" , "Karachi" , "Non-AC" , "Single",1 , 112 , 1000);
        LeavingRecord.Add("Aisha" , "45504-06967173-1" , "0300-7384827" , "Lahore" , "AC" , "Double",5 ,107 , 27638);
        LeavingRecord.Add("Kumar" , "45504-9664173-1" , "0333-092967127" , "Karachi" , "AC" , "Single",2 ,101,6000);
        LeavingRecord.Add("Aiman" , "45504-9304113-1" , "0311-01859827" , "Karachi" , "Non-AC" , "Double",2,116,6450);
    }
    LeavingRecord() {

        //--------------------------------SET JFRAME ICON------------------------------------------

        ImageIcon h1 = new ImageIcon(getClass().getResource("hotel_icon.jpg"));
        Image h2 = h1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        this.setIconImage(h2);

        //------------------------------------------------------------------------------------

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        this.setSize(screenSize.width,screenSize.height);
        this.setLocationRelativeTo(null);

        //-------------------------------- DECLARE AND SET TABLE ---------------------------------------

        String []colNames = {"Name", "CNIC", "Phone Num" , "Address" , "Room" , "Bed" , "Days", "Room Num", "Total Bill"};
        data = getDataForTable();
        model = new DefaultTableModel(data, colNames);
        table = new JTable(model);
        table.setFont(new Font("Aharoni", Font.PLAIN, 15));
        table.setRowHeight(30);
        header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        scrollPane = new JScrollPane(table);

        //-------------------------- SET BUTTON AND TEXT FIELD -------------------------------------

        back = new JButton("Back");
        back.setFont(new Font("Aharoni", Font.BOLD , 30));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);

        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Aharoni", Font.BOLD , 30));
        searchButton.setForeground(Color.WHITE);
        searchButton.setBackground(Color.BLACK);

        border = BorderFactory.createLineBorder(Color.WHITE);

        search = new JTextField("Search");
        search.setFont(new Font("Aharoni", Font.ITALIC , 25));
        search.setBackground(Color.WHITE);
        search.setBorder(border);

        //-------------------------- SET SCALED IMAGE ---------------------------------

        ImageIcon l1 = new ImageIcon(getClass().getResource("searchBarIcon.png"));
        Image l2 = l1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);

        //-------------------------- DECLARE AND SET PANEL ---------------------------------

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new BoldLineBorder(Color.BLACK, 10, true));
        panel.add(new JLabel(l3), BorderLayout.EAST);
        panel.add(search, BorderLayout.CENTER);

        //-------------------------- SET BOUNDS ----------------------------------------

        panel.setBounds((screenSize.width /2)+250 , screenSize.height-150 , 330 , 60);
        searchButton.setBounds((screenSize.width/2), screenSize.height-150 , 220 , 60);
        back.setBounds((screenSize.width/2)-250, screenSize.height-150 , 220 , 60);
        scrollPane.setBounds(0, 0, screenSize.width, screenSize.height-120);

        //----------------------------- ADD COMPONENTS --------------------------------------

        this.add(back);
        this.add(searchButton);
        this.add(panel);
        this.add(scrollPane);

        back.setFocusable(false);
        back.addActionListener(this);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //---------------------------- ACTION METHOD OF KEYLISTENER ------------------------------

        search.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent event)
            {
                if(((search.getText().trim().isEmpty())))
                {
                    model.setRowCount(0);
                    for (String[] rowData : data) {
                        model.addRow(rowData);
                    }
                    table.setModel(model);
                }
            }
        });

        //---------------------------- ACTION METHOD OF MOUSELISTENER ------------------------------

        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(search.getText().equals("Search"))
                  search.setText(null);
            }
        });
    }

    //--------------------------- ACTION METHOD OF ACTIONLISTENER----------------------------

    public void actionPerformed(ActionEvent event)
    {
        //--------------------------- SET DIALOG BOX ICON ------------------------------------

        ImageIcon icon1 = new ImageIcon(getClass().getResource("warning.jpg"));
        Image icon2 = icon1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);

        if(event.getSource() == back) {
            this.setVisible(false);
        }
        else if(event.getSource() == searchButton) {
            String searchName = search.getText();
            try {
                if (!searchName.isEmpty() && !searchName.equals("Search")) {
                    int idx = HashFunction(searchName);
                    if(Leavingrecords[idx] != null)
                        Searching(Leavingrecords[idx].root, searchName);
                } else {
                    throw new UnfillText();
                }
            }
            catch(UnfillText e)
            {
                found = true;
                JOptionPane.showMessageDialog(null,"Please fill all text fields","WARNING",JOptionPane.WARNING_MESSAGE,icon3);
            }
        }
        if(!found) {
            model.setRowCount(0);
        }
    }

    //--------------------------- HASH FUNCTION FOR HASHTABLE ------------------------------------
    public static int HashFunction(String name) {
        if(name.charAt(0) >= 97 && name.charAt(0) <= 122) {
            return name.charAt(0) - 97;
        }
        else {
            return name.charAt(0) - 65;
        }
    }

    //--------------------------- SEARCHING METHOD ------------------------------------
    public void Searching(Node node , String Name) {
        if(node == null) {
            return;
        }
        if(node.Name.compareToIgnoreCase(Name) < 0) { // node.right
            Searching(node.right , Name);
        }
        else if(node.Name.compareToIgnoreCase(Name) > 0) { // node.left
            Searching(node.left , Name);
        } else {
            model.setRowCount(0);
            String []temp = {node.Name , node.Cnic , node.Phone , node.Address , node.RoomType , node.bedType , node.days+"" , node.room_number+"" ,node.TotalBill+""};
            model.addRow(temp);
            table.setModel(model);
            found = true;
        }
    }

    //--------------------------- ADD METHOD ------------------------------------
    public static void Add(String Name , String Cnic , String Phone , String Address , String RoomType , String bedType ,int days , int room_num , int TotalBill) {
        int idx = HashFunction(Name);
        if(Leavingrecords[idx] == null) {
            Leavingrecords[idx] = new BST();
        }
        Leavingrecords[idx].insert(Name , Cnic , Phone , Address , RoomType , bedType ,days , room_num ,TotalBill);
    }
    public String[][] getDataForTable() {
        int rows = 0;
        for(int i = 0; i<26; i++) {
            if(Leavingrecords[i] != null) {
                rows = rows + countNode(Leavingrecords[i].root);
            }
        }
        String [][]data = new String[rows][9];
        int countRows = 0;
        for(int i = 0; i<26; i++) {
            if (Leavingrecords[i] != null) {
                countRows = inOrderTraversal(Leavingrecords[i].root, data, countRows);
            }
        }
        return data;
    }
    public static int countNode(Node node) {
        if(node == null) {
            return 0;
        }
        int count1 = countNode(node.left);
        int count2 = countNode(node.right);

        return count1 + count2 + 1;
    }
    public static int inOrderTraversal(Node node , String[][] data , int countRows) {
        if(node == null) {
            return countRows;
        }
        countRows = inOrderTraversal(node.left , data , countRows);
        data[countRows][0] = node.Name;
        data[countRows][1] = node.Cnic;
        data[countRows][2] = node.Phone;
        data[countRows][3] = node.Address;
        data[countRows][4] = node.RoomType;
        data[countRows][5] = node.bedType;
        data[countRows][6] = node.days+"";
        data[countRows][7] = node.room_number+"";
        data[countRows][8] = node.TotalBill+"";
        countRows++;
        return inOrderTraversal(node.right , data , countRows);
    }

    //--------------------------- CLASS FOR INCREASE THICKNESS FOR SEARCH BAR ------------------------------------
    public static class BoldLineBorder extends LineBorder {
        public BoldLineBorder(Color color, int thickness, boolean roundedCorners) {
            super(color, thickness, roundedCorners);
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            // Draw bold border
            Graphics2D g2d = (Graphics2D) g;
            Stroke originalStroke = g2d.getStroke();
            g2d.setStroke(new BasicStroke(getThickness(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            super.paintBorder(c, g, x, y, width, height);
            g2d.setStroke(originalStroke);
        }
    }
}
