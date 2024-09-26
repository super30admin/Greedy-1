using System;
namespace Algorithms
{
    public class Candy
    {
        /// Time Complexity : O(N) 
        // Space Complexity :O(N) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 
        public int CandyAlt(int[] ratings)
        {
            if (ratings == null || ratings.Length == 0) return 0;
            int[] result = new int[ratings.Length];
            Array.Fill(result, 1);

            int n = ratings.Length;
            for (int i = 1; i < n; i++)
            {
                if (ratings[i] > ratings[i - 1])
                    result[i] = result[i - 1] + 1;
            }
            int sum = result[n - 1];
            for (int i = n - 2; i >= 0; i--)
            {
                if (ratings[i] > ratings[i + 1])
                {
                    result[i] = Math.Max(result[i], result[i + 1] + 1);
                }
                sum += result[i];
            }

            return sum;
        }
    }
}
