class Solution {
    //Do a Left pass and right pass to update the candies based on neighbour elements
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int candy(int[] ratings) {
        int n = ratings.length;
        
        int[] candies = new int[n];
        Arrays.fill(candies,1);
        //left pass
        for(int i=0;i<n-1;i++)
        {
            if(ratings[i]<ratings[i+1])
            {
                candies[i+1] = candies[i] + 1; 
            }
        }

        //right pass
        for(int i=n-1;i>=1;i--)
        {
            if(ratings[i]<ratings[i-1])
            {
                candies[i-1] = Math.max(candies[i-1], candies[i]+1);
            }
        }

        int sum = 0;
        for(int i:candies)
        {
            sum += i;
        }
        return sum;
    }
}