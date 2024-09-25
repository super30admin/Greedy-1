//bfs 
// Time C: O(n)
// Space C: O(n)

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n < 2)
            return 0;
        int jumps = 1;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int j=0 ; j<size ; j++) {
                int index = q.poll(); //0
                for(int i=1 ; i <= nums[index] ; i++) {
                    int newIndex = index + i;
                    if(newIndex == n-1) {
                        return jumps;
                    }
                    if(!set.contains(newIndex)) {
                        q.add(newIndex);
                        set.add(newIndex);
                    }
                }
            }
            jumps += 1;
        }
        return 0;
    }
}

//dfs
// Time C: O(n)
// Space C: O(n)

class Solution {
    HashMap<Integer, Integer> dpMap;
    private int dfs(int index, int[] nums) {
        if(index >= nums.length - 1) {
            return 0;
        }
        if(dpMap.containsKey(index)) {
            return dpMap.get(index);
        }
        //logic
        int min = 9999;
        for(int i=1 ; i <= nums[index] ; i++) {
            int newIndex = i+index;
            min = Math.min(min, dfs(newIndex, nums));
        }
        dpMap.put(index, min + 1);
        return min+1;
    }
    public int jump(int[] nums) {
        if(nums.length < 2)
            return 0;
        dpMap = new HashMap<>();
        return dfs(0, nums);
    }
}