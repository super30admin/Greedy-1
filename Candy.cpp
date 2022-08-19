// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Perform following 3 passes.
 *   1. Give 1 candy to everyone.
 *   2. Iterate from left to right, if current element has higher rating than element on its left then,
 *      assign left element candies + 1 to current element.
 *   3. Iterate from right to left, if current element has higher rating than element on its right then,
 *      assign max of right element candies + 1 and current assigned candies to current element.     
 */

class Solution {
public:
    int candy(vector<int>& ratings) {
        
        if (ratings.empty())
        {
            return 0;
        }
        
        int n = ratings.size();
        vector<int> candies(n, 1);
        
        // Left pass
        for (int i = 1; i < n; i++)
        {
            if (ratings[i] > ratings[i - 1])
            {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Right pass
        int totalCandies = candies[n - 1];
        for (int i = n - 2; i >= 0; i--)
        {
            if (ratings[i] > ratings[i + 1])
            {
                candies[i] = max(candies[i], candies[i + 1] + 1);
            }
            
            totalCandies += candies[i];
        }
        
        return totalCandies;
    }
};