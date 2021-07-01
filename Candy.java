import java.util.*;

public class Candy{

    //Tried with one pass, comparing previous and next but it failed in if the current value changed but the previous values still remains same.
    //With two pass. Calculate based on left elements.
    //Second pass calculate right elements and update it.
    
    //TC: O(N) We are iterating all the elements.
    //SC: O(N) We are using extra int array for calculation purpose.
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] temp = new int[n];
        int result = 0;
        Arrays.fill(temp, 1);
        
        for(int i=1;i<n;i++) {
            if(ratings[i]> ratings[i-1]) {
                temp[i] = temp[i-1] +1;
            }
        }
        
        for(int i=n-2;i>=0;i--) {
            if(ratings[i] >ratings[i+1]) {
                temp[i] = Math.max(temp[i], temp[i+1] +1);
            }
        }
        
        for(int i: temp) {
            result += i;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Candy c = new Candy();
        int result = c.candy(new int[]{1,0,2});
        System.out.println("The result: "+result);
    }
}