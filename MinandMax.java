public class MinandMax {
    public static void main(String args[]) {
        int a[] = {2,11,22,35,65,78,9,34};
        int min,max;
        min = a[0];
        max = a[0];
        for(int i : a){
            if(i < min ) min = i;
            if (i > max) max = i;
        }
        System.out.println("Minimum Number in the arrry is : " + min);
        System.out.println("Maximum Number in the arrry is : " + max);
}
}
