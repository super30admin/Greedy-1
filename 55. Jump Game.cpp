/*
Time: O(n)
Space: O(1)

Greedy:
    For any index i, we can jump to cell i to i+nums[i]
    which cell we should jump to?
    for each cell k between i to i+nums[i]
    the greedy (and optimal) choice is to pick a cell with highest k + nums[k] value
*/
class Solution {
public:
    int canJump(vector<int>& nums) {
        int n = nums.size();
        int curr = 0;

        while(curr < n-1){
            int max_idx = curr; //which cell within current jump range has the furthest jumping capacity?
            for(int i=curr+1;i<= min(n-1,curr+nums[curr]);i++){
                int curr_reach = min(n-1, i+nums[i]);
                int max_reach = min(n-1, max_idx + nums[max_idx]);

                // >= sign is important, we want to go as far right as possible if we have same reachability
                if(curr_reach >= max_reach){
                    max_idx = i;
                }
            }

            if(max_idx == curr)  return false; //no more cell reachable
            curr = max_idx; //we jump to the best cell
        }

        return true;
    }
};
