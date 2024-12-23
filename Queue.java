


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class Queue {
    Node front;
    Node rear;
    private int length = 0;

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int data) {
        Node newnode = new Node(data);
        if(isEmpty()) {
            front = rear = newnode;
        }
        else { 
            rear.next = newnode;
            rear = newnode;
        }
        length++;
    }

    public int front(){
        return front.data;
    }

    public void dequeue() {
        if(isEmpty()) {
            System.out.println("The Queue is empty");
        }
        else{
            front = front.next;
            if (front == null){
                rear = null;
            }
        }
        length--;

    }

    public void display() {
        Node temp = front;
        while(temp!=null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

    }
    public void genBinary(int n) // generate binary numbers from 1 to nz
    {
        Queue que = new Queue();
        que.enqueue(1);
        for(int i = 0;i<n;i++){
            String f = Integer.toString(que.front());
            System.out.print(f + "-> ");
            que.dequeue();
            que.enqueue(Integer.parseInt(f+"0"));
            que.enqueue(Integer.parseInt(f+"1"));
        }

        // que.display();
    }
    public static void main(String[] args) {
        Queue q1 = new Queue();
        // q1.enqueue(1);
        // q1.enqueue(2);
        // q1.enqueue(3);
        // q1.enqueue(4);
        // q1.enqueue(5);
        // q1.display();
        // System.out.println();
        // q1.dequeue();
        // q1.display();
        q1.genBinary(5);
    }
}
