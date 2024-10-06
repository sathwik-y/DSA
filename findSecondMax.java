public class findSecondMax {
    public static void main(String[] args) {
        int arr[] = {13,34,2,34,33,1};
        int max = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                secondmax = max; // Always asign the previous value of max to secondmax. 
                                    //with this we can keep track of the previous max value whenever a new max value is found
                max = arr[i];
            }
            else if (arr[i] > secondmax && arr[i]!= max)  // There are some cases where we could miss the second max value WHEN we already have a max value. 
                                                          //this code gets executed when the arr[i] value is not greater than the max. meaning there could be a second max value.
            {
                secondmax = arr[i]; 
            }
        }
        System.out.println("The max value in the given array is : "+max);
        System.out.println("The second max value in the given array is : "+secondmax);
    } 
}
