// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int jump(int[] nums) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int steps = 0;
        Set<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int currIndex = queue.poll();
                if(currIndex>=nums.length-1)
                    return steps;
                else {
                    for(int j=1;j<=nums[currIndex];j++){
                        if(!visited.contains(currIndex+j)) {
                            queue.add(currIndex+j);
                            visited.add(currIndex+j);
                        }
                    }
                }
            }
            steps++;
        }
        
        return 123456;
    }
}
