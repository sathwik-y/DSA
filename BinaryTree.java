import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node right;
    Node left;
    Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
}

public class BinaryTree {
       static int index = -1;
        public static Node buildTree(int nodes[]){
            index++;
            if(index >= nodes.length || nodes[index] == -1){
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes); 
            return newNode;
        }

        public void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }


        public void inorder(Node root){
            if(root == null){
                return;
            }   
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);    
        }

        public void postorder(Node root){
            if(root == null){
                return;
            }  
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");

        } 
        public void levelorder(Node root) {
            Queue<Node> q = new LinkedList<> ();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()) 
            {
                Node current = q.remove();
                if(current == null){
                    System.out.println();
                    if(q.isEmpty()) break;
                    else q.add(null);
                }
                else { 
                    System.out.print(current.data+" ");
                    if(current.left!=null) q.add(current.left);
                    if(current.right!=null) q.add(current.right);  
                }
            }
        }

        public int countNode(Node root){
            if(root == null) return 0;
            int leftNode = countNode(root.left);
            int rightNode = countNode(root.right);
            return (leftNode + rightNode + 1);
        }

        public int sumNode(Node root){
            if(root == null) return 0;
            int leftSum = sumNode(root.left);
            int rightSum = sumNode(root.right);
            return (leftSum + rightSum + root.data);
        }

            public int height(Node root){
                if(root  == null)  return 0;
                int leftHeight = height(root.left);
                int rightHeight = height(root.right);
                return Math.max(leftHeight, rightHeight) +1;
            }

        public int diameter(Node root){
            if(root == null) return 0;
            int diam1 = diameter(root.left); // left subtree excluding the root node
            int diam2 = diameter(root.right); // right subtree excluding the root node
            int diam3 = height(root.left) + height(root.right) + 1; // path which involves the root node
            return Math.max(diam3, Math.max(diam1,diam2)); // find the max between these 3 paths and return it as the diameter of our tree
        }
    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // tree.sumNode(root);
        System.out.println(tree.diameter(root));
    }
}


