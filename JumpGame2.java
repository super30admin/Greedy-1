
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Time Complexity : O(k^N)
// Space Complexity : O(2N)

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if(n <= 1) return 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        q.add(0);
        set.add(0);
        int jumps =0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int currIdx = q.poll();
                for(int j=1;j <= nums[currIdx];j++){
                    int newIdx = j + currIdx;

                    if(newIdx >= n-1) return jumps+1;
                    if(!set.contains(newIdx)){
                        q.add(newIdx);
                        set.add(newIdx);
                    }
                }
            }
            jumps++;
        }

        return 32;
    }
}

//TC: O(N)
// SC :O(1)
class Solution {
    public int jump(int[] nums) {

        if(nums.length <= 1) return 0;
        int jumps=1;
        int currInt =nums[0];
        int maxInt =nums[0];

        for(int i=1;i< nums.length -1;i++) {

            maxInt = Math.max(maxInt, nums[i]+i);

            if(currInt < nums.length-1 && i == currInt) {
                jumps++;
                currInt = maxInt;
            }
        }

        return jumps;
    }
}