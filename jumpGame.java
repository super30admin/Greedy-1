//time O(N) where N is the number of elements in array
//spapce O(1)
//approach: Greedy, Start from the last element as target and see if it's possible to reach or breach the target from previous element. If not, move to one more previous element and check. Once it's possible to reach or breach then move the target to that index as if it's new target. Return true if the target is index 0.

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n -1;
        for (int i = n -2; i >=0; i--) {
            int curr = nums[i];
            if(curr + i >= target) {
                target = i;
            }
        }
        return target == 0;
    }
}

//BFS
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;  
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        while(!q.isEmpty()) {// 2 3 0 1 4
            int currIdx = q.poll(); // 0
            for(int i = 1; i <= nums[currIdx]; i++) {
                int newIdx = currIdx + i;
                if(newIdx >= n -1)  return true;
                if(!set.contains(newIdx)){
                    q.add(newIdx);
                    set.add(newIdx);
                }
            }
        }
        return false;
    }
}
