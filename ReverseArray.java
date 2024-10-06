
public class ReverseArray{

    public static void reverseArray(int [] arr ,int start,int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr [end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void printArray(int [] arr){
        for (int i = 0 ; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int [] numbers = {2,11,22,35,65,78,9,34};
        printArray(numbers);
        reverseArray(numbers, 0, numbers.length - 1);
        printArray(numbers);
    } 
}