package Hotel;

//--------------------------- NODE CLASS ------------------------------------
class Node {
    String Name , Cnic , Phone , Address , RoomType , bedType;
    int days , room_number , TotalBill;
    Node left,right;
    Node(String Name , String Cnic , String Phone , String Address , String RoomType , String bedType ,int days , int room_num , int TotalBill) {
        this.Name = Name;
        this.Cnic = Cnic;
        this.days = days;
        this.room_number = room_num;
        this.Phone = Phone;
        this.Address = Address;
        this.RoomType = RoomType;
        this.bedType = bedType;
        this.TotalBill = TotalBill;
        this.left = this.right = null;
    }
}

//--------------------------- BST FOR HANDLE COLLISION IN HASHTABLE ------------------------------------
public class BST {
    Node root;

    BST() {
        this.root = null;
    }

    void insert(String Name, String Cnic, String Phone, String Address, String RoomType, String bedType, int days, int room_num, int TotalBill) { //O(n)
        Node newAdd = new Node(Name, Cnic, Phone, Address, RoomType, bedType, days, room_num, TotalBill);
        root = insert(root, newAdd);
    }

    //--------------------------- INSERT METHOD ------------------------------------
    Node insert(Node node , Node newAdd) {
        if(node == null) {
            return newAdd;
        }
        if(node.Name.compareTo(newAdd.Name) > 0) { // left side
            node.left = insert(node.left , newAdd);
        } else { // right side
            node.right = insert(node.right , newAdd);
        }
        return node;
    }

    //--------------------------- REMOVE METHOD ------------------------------------
    Node remove(Node node , String  Name, String Cnic, String Phone, String Address, String RoomType, String bedType, int days, int room_num, int TotalBill) {
        if(node.Name.compareTo(Name) < 0) { // node.right
            node.right = remove(node.right , Name, Cnic, Phone, Address, RoomType, bedType, days, room_num, TotalBill);
        }
        else if(node.Name.compareTo(Name) > 0) { // node.left
            node.left = remove(node.left , Name, Cnic, Phone, Address, RoomType, bedType, days, room_num, TotalBill);
        }
        else { // deleteValue == node.data
            if (Cnic.equals(node.Cnic) && Phone.equals(node.Phone) && Address.equals(node.Address) && RoomType.equals(node.RoomType) && bedType.equals(node.bedType) && days == node.days && room_num == node.room_number && TotalBill == node.TotalBill) {
                //case 1
                if (node.right == null && node.left == null) {
                    return null;
                }
                //case 2
                if (node.right == null) {
                    return node.left;
                } else if (node.left == null) {
                    return node.right;
                }
                //case 3
                else {
                    Node Successor = InOrderSuccessor(node.right);
                    node.Name = Successor.Name;
                    node.Cnic = Successor.Cnic;
                    node.Phone = Successor.Phone;
                    node.Address = Successor.Address;
                    node.RoomType = Successor.RoomType;
                    node.bedType = Successor.bedType;
                    node.days = Successor.days;
                    node.room_number = Successor.room_number;
                    node.TotalBill = Successor.TotalBill;
                    node.right = remove(root.right, Successor.Name , Successor.Cnic , Successor.Phone , Successor.Address , Successor.RoomType, Successor.bedType , Successor.days , Successor.room_number , Successor.TotalBill);

                }
            }
        }
        return node;
    }
    private Node InOrderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    //--------------------------- UPDATE METHOD ------------------------------------
    void update(Node node , String Name, String Cnic, String Phone, String Address, String RoomType, String bedType, int days, int room_num, int TotalBill) {
        if(node.Name.compareTo(Name) < 0) { // node.right
            update(node.right , Name, Cnic, Phone, Address, RoomType, bedType, days, room_num, TotalBill);
        }
        else if(node.Name.compareTo(Name) > 0) { // node.left
            update(node.left , Name, Cnic, Phone, Address, RoomType, bedType, days, room_num, TotalBill);
        }
        else {
            if(Cnic.equals(node.Cnic) && Phone.equals(node.Phone) && Address.equals(node.Address) && RoomType.equals(node.RoomType) && bedType.equals(node.bedType) && days == node.days && room_num == node.room_number) {
                node.TotalBill = TotalBill;
            }
        }
    }
}
