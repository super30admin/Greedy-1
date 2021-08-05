// Time: O(n^n)
//Space: O(n)

class Solution {
    HashSet<Integer> visited;
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return 0;
        visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int n = nums.length;
        
        q.add(0);
        visited.add(0);
        int jumps=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                int currIndex = q.poll();
                if(currIndex == n-1) return jumps;
                for(int j = 1; j <= nums[currIndex]; j++){
                    int newIndex = currIndex + j;
                    if(!visited.contains(newIndex)){
                            q.add(newIndex);
                            visited.add(newIndex);
                    }
                }
            }
            jumps++;
        }
        return -1;
    }
}

// Time: O(n)
//Space: O(1)
class Solution {
    HashSet<Integer> visited;
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1 ) return 0;
        int jumps = 0; int curr = 0; int next = 0;
        for(int i=0; i<nums.length-1; i++){
            next = Math.max(next,nums[i] + i);
            if(i == curr){
                jumps++;
                curr = next;
            }
            if(curr >= nums.length -1) break;
        }
        return jumps;
    }
}