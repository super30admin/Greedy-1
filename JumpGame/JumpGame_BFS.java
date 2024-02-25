/* Time Complexity : O(n*max)) 
 *  n - length of input array - nums 
 *  max - the max value in nums as the internal for loop would run that many times at the maximum */
/* Space Complexity : O(2n) ~ O(n) 
 *  size taken by the queue and hashset */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


//BFS

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        HashSet<Integer> set = new HashSet<>();//to keep track of visited nodes
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        set.add(0);
        while(!q.isEmpty()){
            int i = q.poll();
            //[2,3,1,1,4]
            //at i = 0, loop from 1 to 2 => we can move either one position or two positions
            for(int j = 1; j <= nums[i]; j++){
                int child = i + j;
                //we reached the last idx
                if(child == nums.length-1) return true;
                if(!set.contains(child)){
                    q.add(child);
                    set.add(child);
                }
            }
        }
        return false;
    }
}