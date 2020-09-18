// Time Complexity : O(n)
// Space Complexity : O(1) 

class Solution {
    public int jump(int[] nums) {
      if (nums.length <= 1) return 0;
        int nextInt = nums[0], currInt = nums[0], jumps = 1;
        List<Integer> path = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            nextInt = Math.max(nextInt, i + nums[i]);
            if (i < nums.length - 1 && currInt == i) {                
                currInt = nextInt;
                jumps++;
            }
        }
        return jumps;
    }    
    
}