// Time Complexity: O(n) n = size of ratings vector
// Space Complexity: O(1)
class Solution {
public:
    int candy(vector<int>& ratings) {
        if(ratings.size() == 0) return 0;
        vector<int> candies(ratings.size(), 1);
        
        // Forward pass
        for(int i = 1; i < ratings.size(); i++) { // O(n)
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        
        // Backward pass
        for(int i = ratings.size()-2; i >= 0; i--) { // O(n)
            if(ratings[i] > ratings[i+1]) {
                candies[i] = max(candies[i], candies[i+1] + 1);
            }
        }
        
        int sum = 0;
        for(auto i : candies) // O(n)
            sum += i;
        return sum;
    }
};
