// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) 
    {
        int n = ratings.length;
        if(n <= 1)
        {
            return n;
        }
        int [] arr = new int[n];
        Arrays.fill(arr, 1);
        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1])
            {
                arr[i] = arr[i-1] + 1;
            }
        }
        int candles = arr[n-1];
        for(int i = n-2; i>=0; i--)
        {
            if(ratings[i] > ratings[i+1])
            {
                arr[i] = Math.max(arr[i], arr[i+1]+1);
            }
            candles += arr[i];
        }
        return candles;
    }
}