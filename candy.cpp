/*

TC - O(1), since two linear passes
SC - O(n), since additional space needed for candies vector
Issues - tricky to think of the two-pass greedy solution
Solved on Leetcode - yes, need to revisit again in the future.
*/

class Solution {
    public:
        int candy(vector<int>& ratings) {
            int n = ratings.size();
    
            vector<int> candies(n,1);
    
            int res = 0;
    
            for (int i = 1 ; i < n; i++) {
                if (ratings[i] > ratings[i-1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }
    
            for (int i = n - 1; i > 0; i--) {
                if (ratings[i - 1] > ratings[i]) {
                    candies[i - 1] = max(candies[i] + 1, candies[i - 1]);
                }
                res += candies[i - 1];
            }
    
            return res + candies[n-1];
        }
    };
