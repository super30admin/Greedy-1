// https://leetcode.com/problems/candy/description/

// Time Complexity: O(n)
// Space Complexity: O(1)


class Solution {
    public:
        int candy(vector<int>& ratings) {
            int n = ratings.size();
            int total = n;
            int i=1;
            while(i<n){
                if(ratings[i] == ratings[i-1]){
                    i++;
                    continue;
                }
    
                //Increasing slope
                int peak=0;
                while(i<n && ratings[i] > ratings[i-1]){
                    peak++;
                    total+=peak;
                    i++;
                }
    
                //Decreasing slope
                int valley=0;
                while(i<n && ratings[i] < ratings[i-1]){
                    valley++;
                    total+=valley;
                    i++;
                }
                total -= min(peak, valley);
                if(i == n) return total;
            }
            return total;
        }
    };