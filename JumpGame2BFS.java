// Time Complexity : O(n)
// Space Complexity : O(n) as we are using an additional set and queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Using BFS. We will use a set to store the processed elements to avoid processing it again. Start by adding index 0 in both queue and set. Then check if queue is not empty, poll the element and calculate size as we need to calculate level. Run the for loop from 0 till the size variable and then run the for loop from 1 till the value at the polled index and calculate jump size. Check if jump size is not present in the set, add in both set and queue. And then increment level. Inside the loop we can check as soon as jump size == nums.length -1, we can return level + 1.
 */
class Solution {
    public int jump(int[] nums) {

        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int level = 0;

        set.add(0);
        q.add(0);

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0; i < size; i++){
                int curr = q.poll();
                for(int j = 1; j <= nums[curr]; j++){
                    int jump = curr + j;

                    if(jump == nums.length - 1){
                        return level + 1;
                    }

                    if(!set.contains(jump)){
                        set.add(jump);
                        q.add(jump);
                    }
                }
            }
            level ++;
        }

        return level;
    }
}