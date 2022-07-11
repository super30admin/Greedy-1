//https://leetcode.com/problems/candy/
// Time Complexity :O(n)  
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] can=new int[n];
        Arrays.fill(can,1);
        //going towards left comparing with the left element,first lement doesnt need a check
        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1])
                can[i]=can[i-1]+1;
        }
        //going from left to right comparing with the right element so last element doesnt need a check
        int sum=can[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
                can[i]=Math.max(can[i],can[i+1]+1);
            sum+=can[i];
        }
        System.out.println(Arrays.toString(can));
        return sum;
    }
}