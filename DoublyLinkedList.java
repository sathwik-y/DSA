class Node{
    int data;
    Node next;
    Node prev;
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class DoublyLinkedList {

    Node head;
    Node tail;
    private int length;
    public boolean isEmpty() {
        return length == 0;
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

    public void add_at_end(int data) {
        Node newnode = new Node(data);
        if(isEmpty()) {
            head = tail = newnode;
        }
        else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        } 
        length++;
    }

    public void add_at_begin(int data) {
        Node newnode = new Node(data);
        if(isEmpty()) {
            head = tail = newnode;
        }
        else {
            head.prev = newnode;
            newnode.next = head;
            head = newnode;
        }
    }

    public void add_at_pos(int data , int pos) {
        if(pos == 1) {
            add_at_begin(data);
        }
        else if(pos == length+1) {
            add_at_end(data);
        }
        else{
            Node newnode = new Node(data);
            Node prev = head;
            int count = 1;
            while(count<pos-1) {
                prev = prev.next;
                count++;
            }
            Node current = prev.next;
            prev.next = newnode;
            current.prev = newnode;
            newnode.prev = prev;
            newnode.next = current;
            
        }
        length++;
    }

    public void del_at_end(){
        if(tail == null) {
            System.out.println("No Elements in the list");
        }
        if(head == tail) {
            head = tail = null;
        }
        else {
        Node dummy = tail;
        tail = tail.prev;
        dummy.prev = null;
        tail.next = null;
        }
    }
    
    public void del_at_begin() {
        if(head == null) {
            System.out.println("No Elements in the list");
        }
        if(head == tail) {
            head = tail = null;
        }
        else {
        Node dummy = head;
        head = head.next;
        head.prev = null;
        dummy.next = null;
        }
    }
    public static void main(String[] args) {
        DoublyLinkedList list1 = new DoublyLinkedList();
        list1.add_at_end(1);
        list1.add_at_end(2);
        list1.add_at_end(3);
        list1.add_at_begin(0);
        list1.add_at_pos(25,3);

        list1.display();
        list1.del_at_end();
        System.out.println();
        list1.display();
    }
}
