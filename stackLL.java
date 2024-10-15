
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class stackLL {
    Node top = null;
    private int length = 0;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node newnode = new Node(data);
        newnode.next = top;
        top = newnode;
        length++;
    }
    
    public int pop() {
        if(isEmpty()) {
            System.out.println("The stack is empty.");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        length--;
        return popped;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("The stack is empty.");
            return -1;
        }
        return top.data;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("The stack is empty.");
        }
        Node current = top;
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
    
    public void reverse(int data) {
        char[] newchar = Integer.toString(data).toCharArray();
        stackLL revstack = new stackLL();
        for (char c : newchar) {
            revstack.push(c-'0'); // or can use Character.getNumericValue(c)
        }
        while(!revstack.isEmpty()){
            System.out.print(revstack.pop());
        }
        }
    public static void main(String[] args) {
        stackLL stack1 = new stackLL();
        stack1.push(0);
        stack1.push(1);
        stack1.push(2);
        stack1.display();
        stack1.pop();
        System.out.println();
        stack1.display();
     }
}
