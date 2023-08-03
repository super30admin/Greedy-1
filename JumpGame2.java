// BFS Implementation TC = exponential
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 1) return 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(0);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            // level processing
            while(size>0){
                int currIdx = q.poll();
                for(int i=0;i<=nums[currIdx];i++){
                    int newIdx = i + currIdx;
                    if(newIdx == nums.length-1) return count;
                    if(!visited.contains(newIdx)){
                        q.add(newIdx); visited.add(newIdx);
                    }
                }
                size--;   
            }
            
        }
        return count;
    }
}