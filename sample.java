// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Candy-T.C=O(n), S.C=O(n)
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++)
            res[i]=1;
        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1])
                res[i]=res[i-1]+1;
        }
        
        int total=res[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
                res[i]=Math.max(res[i],res[i+1]+1);
        total+=res[i];
        }
        return total;
    }
}


class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int jumps=1;
        int currInt=nums[0];
        int nextInt=nums[0];
        for(int i=0;i<nums.length;i++){
            nextInt=Math.max(nextInt,i+nums[i]);
            if(i == currInt){
                if(i!=nums.length - 1)
                    jumps++;
                currInt=nextInt;
            }
        }
        return jumps;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
//         Boolean[] memo = new Boolean[nums.length];
//         return dfs(nums, 0, memo);
//     }

//     private boolean dfs(int[] nums, int idx, Boolean[] memo) {
//         if (idx >= nums.length - 1) {
//             return true;
//         }
        
//         if (memo[idx] != null) {
//             return memo[idx];
//         }
        
//         for (int j = 1; j <= nums[idx]; j++) {
//             int newIdx = idx + j;
//             if (dfs(nums, newIdx, memo)) {
//                 memo[idx] = true; 
//                 return true;
//             }
//         }
        
//         memo[idx] = false; 
//         return false;
//     }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        queue.add(0);
        visited.add(0);
        while(!queue.isEmpty())
        {
            int a=queue.poll();
            if(a==nums.length-1)
                return true;
            for(int i=1;i<=nums[a];i++){
                int newa=a+i;
                if(newa>=nums.length-1)
                    return true;
                if(!visited.contains(newa))
                {
                    queue.add(newa);
                    visited.add(newa);
                }
            }
        }
        return false;
    }
}