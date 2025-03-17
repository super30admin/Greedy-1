// Author: Subhed Chavan
// Batch: December 24
// Problem : Candy
// Approach: Greedy
// Time Complexity: O(n)
// Space Complexity: O(n)


class Solution {
public:
    int candy(vector<int>& ratings) {
        if (ratings.empty()) {
            return 0;
        }
        int n = ratings.size();
        vector<int> candies(n, 1);
        
        // Check the rating of each child with the left neighbor
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Check the rating of each child with the right neighbor
        int sum = candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        
        return sum;
    }
};
