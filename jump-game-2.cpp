/*
TC = O(n) - single pass
SC - O(1) - constant since no other storage used other than local vars
Difficulties - This one is still tricky for me, I was trying a reverse greedy approach but that was not optimal somehow
I understand that we move forward expanding our range, and only take a jump every time our pre-decided limit is hit

but this also has me confused because that means there is always a jump from the first position, which does make sense

and after that there will be another 0 or more jumps, which we count after getting to the end of the range that the first jump could take us to

I hope to improve my understanding of this going forward.
LeetCode Run - Yes, optimal beats 100% of other submissions on runtime.


*/

class Solution {
    public:
        int jump(vector<int>& nums) {
            int n = nums.size();
            if (n == 1) return 0;
            
            int jumpCount = 0;
    
            int currEnd = 0;
            int farthest = 0;
    
            int i = 0;
    
            while (i < n - 1) {
                farthest = max(farthest, i + nums[i]);
                if (i == currEnd) {
                    jumpCount += 1;
                    currEnd = farthest; // I don't get this at all
                }
                i += 1;
            }
    
            return jumpCount;
        }
    };
