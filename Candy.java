//Time Complexity: o(n)
//Space Complexity: 0(n)
//Expln: First iterate from left to right and if the value is greater than previous  and candies are less or equals increment the current by prev+1,
// Iterate from r to l do the same thing if the val is greater than next and candies are less or equals increment curr by next +1.
// Iterate through the candies to find the total result. 
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);
        int res = 0;
        for(int i =0; i < len; i++)
        {
            if(i-1 >= 0)
            {
                if (ratings[i] > ratings[i-1] && candies[i] <= candies[i-1]) {
                    candies[i] = candies[i-1]+1;
                }   
            }
        }
        for(int i = len-1; i>=0; i--)
        {
            if(i+1 < len)
            {
                if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]){
                    candies[i] = candies[i+1] + 1;
                }
            }
        }
        for(int j =0; j < len; j++)
        {
            res += candies[j];
        }
        return res;
    }
}