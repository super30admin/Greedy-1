class Solution {
    HashSet<Integer> visited;

    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }

        int jump = 0, size;

        visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.add(0);

        while(!q.isEmpty()) {
            size = q.size();
            for(int i = 0; i < size; i++) {
                int ind = q.poll();
                for(int j = 1; j <= nums[ind]; j++) {
                    int newInd = ind + j;
                    if(newInd == nums.length - 1) {
                        return jump + 1;
                    }
                    if(!visited.contains(newInd)) {
                        q.add(newInd);
                        visited.add(newInd);
                    }
                }
            }
            jump++;
        }
        return -1;
    }
}