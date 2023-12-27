public class Solution
	{
        // Time Complexity : O(n)
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No 
        public int Candy(int[] ratings)
        {
            int n = ratings.Length;
            int[] result = new int[ratings.Length];
            for (int k = 0; k < n; k++)
            {
                result[k] = 1;
            }

            //left pass
            for(int i = 1; i < n; i++)
            {
                if (ratings[i] > ratings[i-1])
                {
                    result[i] = result[i - 1] + 1;
                }
            }
            //right pass
            int minCandies = result[n-1];

            for (int i = n-2; i >= 0; i--)
            {
                if (ratings[i] > ratings[i+1])
                {
                    result[i] = Math.Max(result[i], result[i + 1] + 1);
                }
                minCandies += result[i];
            }
            return minCandies;
        }
}
