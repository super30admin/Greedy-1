//time O(N) traverse the whole tree
//space O(N) for hashset in worst case
//approach: BFS, traverse the tree in BFS fashion ie level order traversal and return the no of jumps as soon as the last index is encountered in the tree.

class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;  
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        int jumps = 0;
        while(!q.isEmpty()) {// 2 3 0 1 4
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int currIdx = q.poll(); // 0
                for(int j = 1; j <= nums[currIdx]; j++) {
                    int newIdx = currIdx + j;
                    if(newIdx >= n -1) {
                        return jumps + 1;
                    } 
                    if(!set.contains(newIdx)){
                        q.add(newIdx);
                        set.add(newIdx);
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }
}
