// Time Complexity = 1 - O(n^2), 2 - O(n)
// Space Complexity = 1 - O(n), 2 - O(1)


// 1. BFS Approach
class Solution {
  public boolean canJump(int[] nums) {
    if(nums == null || nums.length == 0) return true;
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    queue.add(0);
    visited.add(0);
    while(!queue.isEmpty()) {
      int current = queue.poll();
      for(int i = 0; i<=nums[current]; i++) {
        int jump = current + i;
        if(jump == nums.length -1) return true;
        if(!visited.contains(jump)) {
          visited.add(jump);
          queue.add(jump);
        }
      }
    }
    return false;
  }
}

// 2. Greedy Approach

class Solution {
  public boolean canJump(int[] nums) {
    if(nums == null || nums.length == 0 || nums.length == 1) return true;
    int n = nums.length;
    int destination = n - 1;
    for(int i = n-2; i>=0; i--) {
      if(nums[i] + i >= destination) destination = i;
    }
    return destination == 0;
  }
}