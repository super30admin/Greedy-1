// Time Complexity = O(n^2)
// Space Complexity = O(n)

class Solution {
  public int jump(int[] nums) {
    if(nums.length == 1) return 0;
    Queue<int[]> queue = new LinkedList<>();
    Set<Integer> set = new HashSet<>();
    queue.add(new int[]{0,0});
    set.add(0);
    while(!queue.isEmpty()) {
      int[] current = queue.poll();
      int index = current[0];
      int level = current[1];
      for(int i = 1; i<=nums[index]; i++) {
        int newIndex = index + i;
        if(newIndex == nums.length - 1) return level + 1;
        if(!set.contains(newIndex)) {
          queue.add(new int[]{newIndex, level+1});
          set.add(newIndex);
        }
      }
    }
    return -1;
  }
}
