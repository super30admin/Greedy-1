
// Time Complexity : O(n)
// Space Complexity : O(n)

//We use two passes. In the first pass, we traverse from left to right and assign candies
//to the kids with increasing ratings. In the second pass, we traverse from right to left
//and update the candies for the kids with decreasing ratings if they deserve more candies.
//Finally, we sum up the candies array and return the total count.

class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int can[]=new int[n];
        Arrays.fill(can,1);   //atleat 1 candy

        for(int i=1;i<n;i++){   //left pass only handle inc rating
            if(ratings[i]>ratings[i-1])
                can[i]=can[i-1]+1;
        }
        for(int i=n-2;i>=0;i--){   //right pass and fix if the kid deserves more
            if(ratings[i]>ratings[i+1])
                can[i]=Math.max(can[i],can[i+1]+1);
        }
        int count=0;
        for(int num:can)
            count+=num;
        return count;
    }
}