class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularSinglyLinkedList{
    Node tail;
    int length;
    public boolean isEmpty() {
        return tail == null;
    }
    public void add_at_begin(int data) {
        Node newnode = new Node(data);
        if(isEmpty()) {
            tail = newnode;
            tail.next = tail;
        }
        else {
            newnode.next = tail.next;
            tail.next = newnode;
        }
        length++;
    }
    public void add_at_end(int data){
        Node newnode = new Node(data);
        if(isEmpty()) {
            tail = newnode;
            tail.next = tail;
        }
        else{
            newnode.next = tail.next;
            tail.next = newnode;
            tail = tail.next;
        }
        length++;
    }
    public void add_at_pos(int data , int pos) {
        if(pos == 1) add_at_begin(data);
        else if(pos == length+1) add_at_end(data);
        else{
            Node newnode = new Node(data);
            Node previous = tail.next;
            int count = 1;
            while(count<pos-1) {
                previous = previous.next;
                count++;
            }
            Node current = previous.next;
            previous.next = newnode;
            newnode.next = current;
        }
        length++;
    }
    public void del_at_begin(){
        if(tail.next == tail) tail = null;
        else tail.next = tail.next.next;
        length--;
    }
    public void del_at_end() {
        if(tail.next == tail) tail = null;
        else {
            Node current = tail.next;
            while(current.next!=tail){
                current = current.next;
            }
            current.next = tail.next;
            tail = current;
        }
        length--;
    }
    public void del_at_pos(int pos){
        if(pos == 1) del_at_begin();
        else if(pos == length) del_at_end();
        else {
            Node previous = tail.next;
            int count = 1;
            while(count<pos-1) {
                previous = previous.next;
                count++;
            }
            previous.next = previous.next.next;

        }
        length--;
    }
    public void display(){
        Node current = tail.next;
        do{
            if(current.next!=tail.next) {
                System.out.print(current.data + "-->");
            }
            else {
                System.out.print(current.data);
            }
            current = current.next;
        }while(current!=tail.next);
    }

public static void main(String[] args) {
    CircularSinglyLinkedList list1 = new CircularSinglyLinkedList();
    list1.add_at_end(1);
    list1.add_at_end(2);
    list1.add_at_end(3);
    list1.add_at_begin(0);
    list1.add_at_pos(30, 3);
    list1.del_at_pos(3);
    list1.display();
}
}