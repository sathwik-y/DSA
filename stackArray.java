
    import jdk.jfr.StackTrace;

    public class stackArray {
        int top;
        int[] arr;
        int capacity;
        int length = 0;
        public stackArray(int capacity) {
            this.capacity = capacity;
            top = -1;
            arr = new int[capacity];
        }
        public boolean isFull(){
            return length == capacity;
        }
        public boolean isEmpty() {
            return top == -1;
        }
        public void push(int data){
            if(isFull()) {
                System.out.println("The stack is full");
            }
            arr[++top] = data;
            length++;
        }

        public int pop() {
            if(isEmpty()) {
                System.out.println("The stack is empty");
                return -1;
            }
            return arr[top--];
        }

        public int peek(){
            if(isEmpty()) {
                System.out.println("The stack is empty");
                return -1;
            }
            return arr[top];
        }

        public void display() {
            for(int i = top;  i>=0; i--) {
                if(i == 0 ) {
                    System.out.print(arr[i]);
                }
                else { 
                System.out.print(arr[i] + " , ");
            }
        }
        }

        public void reverse(int data) {
                char[] newchar = Integer.toString(data).toCharArray();
                stackArray revstack = new stackArray(String.valueOf(data).length());
                for (char c : newchar) {
                    revstack.push(c-'0'); // or can use Character.getNumericValue(c)
                }
                while(!revstack.isEmpty()){
                    System.out.print(revstack.pop());
                }
        }

        public static void main(String[] args) {
            stackArray stack1 = new stackArray(5);
            stack1.push(0);
            stack1.push(1);
            stack1.display();
            stack1.pop();
            System.out.println();
            stack1.display();
            stack1.reverse(1021);
        }

    }
