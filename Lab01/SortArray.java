import java.util.Arrays;
public class SortArray{
    public static void main(String[] args) {
        
    double[] array = {205, 433, 12, 754, 67};
    int n = 5;
    double sum = 0; 
    for(int i=0; i<n; i++) {
        for(int j=i+1; j<n; j++) {
            if(array[j]<array[i]) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
    for(int i=0; i<n; i++) sum += array[i];
    double average = sum/n;
    String result = "The sum and average of all the elements are " + sum + " and " + average;
    System.out.println("The sorted array: ");
    System.out.println(Arrays.toString(array));
    System.out.println(result);
}
}
