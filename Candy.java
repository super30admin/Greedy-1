// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) {
        //forward pass...compare with just left
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);
        
        for(int i=1;i<ratings.length;i++) {
            if(ratings[i]>ratings[i-1])
                candies[i] = candies[i-1]+1;
        }
        
        int min = candies[ratings.length-1];
        //backward, compare with right
        for(int i=ratings.length-2;i>=0;i--) {
            if(ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }
            
            //System.out.println(candies[i]);
            min+=candies[i];
        }
        
        return min;
    }
}
