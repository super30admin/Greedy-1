/* Time Complexity : O(n*max*qMax)) 
 *  n - length of input array - nums 
 *  max - the max value in nums as the internal for loop would run that many times at the maximum 
 *	qMax - max size of the queue */
/* Space Complexity : O(2n) ~ O(n) 
 *  size taken by the queue and hashset */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//BFS

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int jumps = 1;
        q.add(0);
        set.add(0);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curr = q.poll();
                for(int j = 1; j <= nums[curr]; j++){
                    int child = curr + j;
                    if(child == n-1) return jumps;
                    if(!set.contains(child)){
                        q.add(child);
                        set.add(child); 
                    }
                }                
            }
            jumps++;
        }
        return jumps;
    }
}