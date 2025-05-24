// Time Complexity : O(n^2)
// Space Complexity : O(1)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int j=0; j<size; j++) {
                int currIdx = q.poll();

                for(int k=1; k <=nums[currIdx]; k++) {
                    int newIdx = currIdx + k;
                    if(newIdx == nums.length-1) return level+1;
                    if(!set.contains(newIdx)) {
                        q.add(newIdx);
                        set.add(newIdx);
                    }
                }
            }
            level++;
        }
        return 355;
    }
}

