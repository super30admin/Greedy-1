//TC : O(N)
//SC : O(1)
class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
        int nextNum = nums[0];
        int currNum = nums[0];
        
        int ans = 1;
        for(int i = 1; i< nums.length; i++){
            nextNum = Math.max(nextNum, i + nums[i]);
            if(i == currNum && i != nums.length - 1){
                ans++;
                currNum = nextNum;
            }
        }
        
        return ans;
        
    }
}

/*

//TC : O(N^2)
//SC : O(N)

class Solution {
    int[] dp;
    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        return dfs(nums, 0);
    }
    public int dfs(int[] nums, int i){
        if(i >= nums.length - 1){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        
        int min = Integer.MAX_VALUE;
        for(int c = 1; c<= nums[i]; c++){
            
            int ans = dfs(nums, c + i);
            min = Math.min(ans, min);
        }
        if(min != Integer.MAX_VALUE){
                dp[i] = min + 1;
        }else{
                dp[i] = min;
        }
        
        
        
        return dp[i];
    }
}
*/

/*
//TC : O(N^2)
//SC : O(N)
class Solution {
    public int jump(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        
        queue.add(0);
        set.add(0);
        
        int answer = 0;
        while(!queue.isEmpty()){
            int c = queue.size();
            
            while(c-- > 0){
                int curr = queue.poll();
                if(curr >= nums.length - 1) return answer;
                
                for(int i = 1; i<= nums[curr]; i++){
                    int index = curr + i;
                    if(index >= nums.length - 1)    return answer+1;
                    
                    if(!set.contains(index)){
                        queue.add(index);
                        set.add(index);
                    }
                    
                }
            }
            answer++;
        }
        
        return answer;
    }
}

*/