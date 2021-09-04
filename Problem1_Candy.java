// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) {
        
        if(ratings==null||ratings.length==0)
            return 0;
        
        int[] candies=new int[ratings.length];
        
        Arrays.fill(candies,1);
        
        //left pass
        for(int i=1;i<ratings.length;i++)
        {
            if(ratings[i]>ratings[i-1])
                candies[i]=candies[i-1]+1;
        }
        
        int minCandies=candies[ratings.length-1];
        
        //right pass
        for(int i=ratings.length-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            
            minCandies+=candies[i]; // adding all candies values 
        }
        
        return minCandies;
    }
}
