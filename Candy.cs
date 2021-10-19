using System;
using System.Collections.Generic;
using System.Text;

namespace GreedyAlgorithm
{
    class CandyLC
    {
        public int Candy(int[] ratings)
        {
            if (ratings == null || ratings.Length == 0) return 0;
            int n = ratings.Length;
            int[] candies = new int[n];
            Array.Fill(candies, 1);
            //check for left neighbor
            for (int i = 1; i < n; i++)
            {
                if (ratings[i] > ratings[i - 1])
                {
                    candies[i] = candies[i-1] + 1;
                }
            }
            //check for right neighbor
            int sum = candies[n - 1];
            for (int i = n - 2; i >= 0; i--)
            {
                if (ratings[i] > ratings[i + 1])
                {
                    candies[i] = Math.Max(candies[i], 1 + candies[i + 1]);
                }
                sum += candies[i];
            }
            return sum;
        }

    }
}
