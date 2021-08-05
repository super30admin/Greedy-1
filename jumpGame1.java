// Time: O(n^n)
//Space: O(n^n)

class Solution {
    HashSet<Integer> visited;
    int n;
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        visited = new HashSet<>();
        n = nums.length;
        return dfs(nums,0);
    }
    private boolean dfs(int[] nums,int index){
        if(visited.contains(index)) return false;
        if(index == n-1) return true;
        
        visited.add(index);
        for(int j=1; j <= nums[index];j++){
            if(dfs(nums,index+j)) return true;
        }
        return false;
    }
}

// Time: O(n^n)
//Space: O(n)

class Solution {
    HashSet<Integer> visited;
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return true;
        visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int n = nums.length;
        
        q.add(0);
        visited.add(0);
        while(!q.isEmpty()){
            int currIndex = q.poll();
            for(int j = 1; j <= nums[currIndex]; j++){
                int newIndex = currIndex + j;
                if(!visited.contains(newIndex)){
                    if(newIndex == n-1) return true;
                    q.add(newIndex);
                    visited.add(newIndex);
                }
            }
        }
        return false;
    }
}

// Time: O(n)
//Space: O(1)

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return true;
        int n = nums.length;
        int destination = nums.length - 1;
        for(int i=n-2; i>= 0; i--){
            if(nums[i] + i >= destination){
                destination = i;
            }
        }
        return destination == 0;
    }
}