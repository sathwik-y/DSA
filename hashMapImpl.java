import java.util.ArrayList;
import java.util.LinkedList;
class HashMap<K,V> { // K and V are generics, they act as a place holder for any Data Type 
     class Node {
        K key;
        V value;
        Node(K key,V value) {
            this.key = key;
            this.value = value;
        }
    }
    private int n; // all the nodes (of the linked list present at each array index)
    private int N; // buckets (array size)
    private LinkedList<Node> buckets[];

    @SuppressWarnings("unchecked")
    public HashMap() {
        this.N = 4;
        this.buckets = new LinkedList[4];
        for(int i = 0; i<N; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }
    public int hashFunction(K key) {
        int bi = key.hashCode();
        return Math.abs(bi) % N;
    }

    public int searchLL(K key, int bi) {
        LinkedList<Node> li = buckets[bi];
        for(int i = 0; i<li.size();i++) {
            if(li.get(i).key == key) return i;
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public void rehash(){
        LinkedList<Node> oldBucket[] = buckets;
        buckets = new LinkedList[N*2];
        for(int i = 0; i<N*2; i++) {
            this.buckets[i] = new LinkedList<>();
        }
        for(int i = 0; i<oldBucket.length;i++) { //for bi
            LinkedList<Node> li = buckets[i];
            for(int j = 0; j<li.size();j++) { // for di
                Node node = li.get(j);
                put(node.key,node.value);
            }
        }
    }
    public void put(K key, V value){
        int bi = hashFunction(key); // bucket index
        int di = searchLL(key,bi); // Data Index : (Linked List index ): returns -1 if the key doesnt exist in the array
        if(di == -1 ) { // adds the new node if they key doesnt exist in the array
            buckets[bi].add(new Node(key, value));
            n++;
        } else{ // if the key exists, updates its value
            Node node = buckets[bi].get(di);
            node.value = value;
        }
        double lambda = (double)n/N;
        if(lambda > 2.0) {
            rehash();
        }
    }
    public V get(K key) {
        int bi = hashFunction(key);
        int di = searchLL(key,bi); 
        if(di!=-1) {
            return buckets[bi].get(di).value;
        }else{
            return null;
        }

    }
    public V removeKey(K key) {
        int bi = hashFunction(key);
        int di = searchLL(key,bi); 
        if(di!=-1) {
            Node node = buckets[bi].remove(di);
            n--;
            return node.value;
        }else{
            return null;
        }
    }
    public boolean containsKey(K key) {
        int bi = hashFunction(key);
        int di = searchLL(key,bi); 
        if(di!=-1) {
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for(int i =0;i<buckets.length;i++){ //for bi
            LinkedList<Node> li = buckets[i];
            for(int j =0;j<li.size();j++){ // for di
                Node node = li.get(j);
                keys.add(node.key);
            }
        }
        return keys;
    }
    public boolean isEmpty(){
        return n==0;
    }

}


public class hashMapImpl {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hash = new HashMap<>(); 
        hash.put(1, 1000);
        hash.put(2,2000);
        hash.put(3,3000); 

        // Printing all the data
        System.out.println("The Key-Value pairs are: ");
        ArrayList<Integer> keys = hash.keySet();
        for(int i : keys){
            System.out.println(i + " : " + hash.get(i) );
        }
    }
}
