// Time Complexity: O(n)
// Space Complexity: O(n)
// Did you run the code on LeetCode? Yes

// Approach:
// 1. Create a vector to store the distribution of candies for each child, initialized to 1.
// 2. Traverse the ratings from left to right, and if the current rating is greater than the previous one, increment the candy count for that child based on the previous child's count.
// 3. Traverse the ratings from right to left, and if the current rating is greater than the next one, update the candy count for that child based on the next child's count.
// 4. Finally, sum up the candy counts for all children and return the total count.

class Solution {
    public:
        int candy(vector<int>& ratings) {
            vector<int> distribution(ratings.size(), 1);
            for(int i = 1; i < ratings.size(); i++){
                if(ratings[i] > ratings[i - 1]){
                    distribution[i] = 1 + distribution[i - 1];
                }
            }
            for(int i = ratings.size() - 1; i > 0; i--){
                if(ratings[i - 1] > ratings[i]){
                    distribution[i - 1] =max(distribution[i - 1], 1 + distribution[i]); 
                }
            }
            int res = 0; 
            for(int i : distribution){
                res += i;
            }
            return res;
        }
    };