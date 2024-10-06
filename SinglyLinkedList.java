class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class SinglyLinkedList{
    Node head;

    public void add_at_end(int data){
        Node newnode = new Node(data);
        if(head ==null) {
           head = newnode;
        }
        else {
            Node current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = newnode;
        }
    }
    public void add_at_begin(int data) {
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
    }
    public void add_at_pos(int data,int pos) {
        if(pos == 1) {
            add_at_begin(data);
        }
        else {
            Node newnode = new Node(data);
            Node previous = head;
            int count = 1;
            while(count<pos-1) {
                previous = previous.next;
                count++;
            }
            Node current = previous.next;
            previous.next = newnode;
            newnode.next = current;
        }
    }
    public void del_at_beg() {
        if(head != null) {
        Node temp = head;
        head = head.next;
        temp.next = null;

    }
}
    public void del_at_end() {
        if(head!=null && head.next!=null) {
            Node current = head;
            Node previous = null;
            while(current.next!=null) {
                previous = current;
                current = current.next;
            }   
            if(previous!=null)
            previous.next = null;
        }
    }
    public void del_at_pos(int pos) {
        if(pos == 1) del_at_beg();
        else {
        Node previous = head;
        int count = 1;
        while(count<pos-1) {
            previous = previous.next;
            count++;
        }
        Node current = previous.next;
        previous.next = current.next;
        current.next = null;
        }
    }
    public void search(int data) {
        Node current = head;
        int count  = 1;
        while(current!=null) {
            current = current.next;
            count++;
            if(current.data == data){
                System.out.println();
                System.out.print("The given number : " + data + " is fouund at node " + count);
                break;
            }
        }
    }
    public  void delkey(int key) {
        Node current = head;
        Node prev = null;
        while(current!=null && current.data!=key) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
    }
    public void display(){
        Node current = head;
        while(current!=null){
            if(current.next!=null) {
            System.out.print(current.data + "-->");
        }
        else {
            System.out.print(current.data);
        }
        current = current.next;
    }
    }
    public void count(){
        int count = 0;
        Node current = head;
        while(current!=null){
            count++;
            current = current.next;
        }
        System.out.println("The Total number of elememts in the list is : " + count);
    }
    public void reverse() {
        System.out.print("The reversed list is : ");
        Node previous = null; // used to track the previous node to link the "current" node to the "previous" node thus making it reverse
        Node current = head; // used to traverse and change the links of each and everynode
        Node next;    // used to maintain access to the next node when the "current" node is pointed to the "previous node"
        while(current!=null) {
            next = current.next; // store the address of the next node before changing the value of the "current" node to the previous value 
            current.next = previous; // This is the actual reversing. Points the current node to the previous node thus making it reverse. N1 <--- N2 
            previous = current; // now that "current" node is reversed , move the previous to the next node in line. 
            current = next; // move the current node to the next node which we saved in the first step
        }
        head = previous; // at the end "previous" node will go to the last node ( which will be become the first node after reversing) 
                        // so take the head pointer to that node , as all the functions start with head node. 
    }
    public void nth_node_from_end(int n) {
        Node mainPtr = head;
        Node refPtr = head;
        int count = 0;
        // First push the reference pointer  n nodes further : 
        while(count<n) {
            refPtr = refPtr.next;
            count++;
        } 
        /*example : if we want to find the 2nd node from the end 
         this refPtr will start at the 3rd node from the start , thus skipping the first 2 nodes.
         */
        while(refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
            }
            /*
             With this is refPtr will go to null when the main ptr is n nodes away. 
             So once refPtr reaches null , the mainPtr will be at the nth node from the end. 
             because the difference  between the two pointers is 'n'
             */
        System.out.println("The " + n + " node from the end is : " + mainPtr.data);
        /*
         Alternate Solution (own) :
        int length = 0;
        Node current = head;
        while(current!=null){
            length++;
            current = current.next;
        }
        int target = length-n;
        int count = 0;
        Node real = head;
        while(count!=target) {
            real = real.next;
            count++;
        }
        System.out.println(real.data);
         */
    }  
    public  void remove_dup() { // works only with sorted SLL
        Node current = head;
        while(current!=null && current.next!=null) {
            if(current.data == current.next.data) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
    }
    public void add_in_sorted(int data) {
        Node newnode = new Node(data);
        Node current = head;
        Node temp = null;
        while(current!=null && current.data<newnode.data) // taking the newnode to the correct position , as long as the current nodes data is less than new node , keep going forward
         {
            temp = current;
            current = current.next;
        }
        /* after the while loop , the newnode will be inserted between the temp and current nodes. 
        temp node is less than new node , currentnode is greater than the new node. 
        current.data < newnode.data satisfies the above statement.  
        */
        // If temp is null, it means the new node should be the new head ( mostly wont happen)
        if (temp == null) {
        newnode.next = head;
        head = newnode;
        } else {
        // Insert the new node between temp and current
        newnode.next = current;
        temp.next = newnode;
        }
}
    
    public static Node mergeSort(Node head) {
        if(head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // seperate the list by making it prev.next = null
        Node list1 = mergeSort(head); // head till prev is one list 
        Node list2 = mergeSort(slow);
        Node merged = merge_sorted_lists(list1, list2);
        return merged;
    }

    public static Node merge_sorted_lists(Node a , Node b) {
    Node dummy = new Node(0);
    Node tail = dummy;
    while(a!=null && b!=null) {
        if(a.data<b.data) {
            tail.next = a;
            a = a.next;
        }
        else {
            tail.next = b;
            b = b.next;
        }
        tail = tail.next; // this is needed to go to the newly added node so that we can add the nodes after the newly added node. 
    }
    tail.next = (a != null) ? a : b;
    return dummy.next;
}
    
    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.add_at_end(1);
        list1.add_at_end(4);
        list1.add_at_end(6);
        list1.add_at_end(8);
        list1.add_at_end(7);
        list1.add_at_begin(3);
        list1.add_at_begin(5);
        list1.add_at_end(2);
        list1.display();
        System.out.println();
        }
    }   

