/*
 * TC = O(N)
 * SC = O(N) 
 * 
 * We maintain left sum and right sum
 */
import java.util.*;
public class Candy {
    
    public static int candy(int[] ratings)
    {
        if(ratings == null || ratings.length == 0) return 0;
        
        int n = ratings.length;
        int[] result = new int[n];
        
        Arrays.fill(result,1);
        
        for(int i = 1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1])
            {
                result[i] = result[i-1]+1;
            }
        }
        
        for(int i = n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                result[i] = Math.max(result[i],result[i+1]+1);
            }
        }
        
        int sum = 0;
        
        for(int i:result)
        {
            sum+=i;
        }
        
        return sum;
    }

    public static void main(String args[])
    {
        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));
    }
    
}
