// Time Complexity : O(n^2)
// Space Complexity : O(1)
    public boolean canJump(int[] nums) {
        int n = nums.length;

        if(n == 1) return true;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        while(!q.isEmpty()){
            int currIdx = q.poll();

            for(int k=1; k<=nums[currIdx]; k++) {
                int newIdx = currIdx + k;
                if(newIdx == nums.length-1) return true;

                if(!set.contains(newIdx)) {
                    q.add(newIdx);
                    set.add(newIdx);
                }
            }
        }

        return false;

        
    }
}

