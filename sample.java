//****JUMP GAME****
// Time Complexity :O(N)
// Space Complexity :O(1);
// Did this code successfully run on Leetcode :y
// Any problem you faced while coding this :n;
class Solution {
    public boolean canJump(int[] nums) {
        
        //null case
        if(nums.length==0) return true;
        
        int n=nums.length;
        int target=n-1;
        
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]+ i >=target)
            {
                target=i;
            }
        }
        
        return target==0;
    }
}

// Your code here along with comments explaining your approach


//*****CANDY****\

//Greedy 
//Take one decision at a time

class Solution {
    public int candy(int[] ratings) {
        
        
        if(ratings.length==0 || ratings==null) return 0;
        int n=ratings.length;
        
        if(n==1) return 1;
        int[] ans=new int[n];
        if(ratings.length==1) return 1;
        Arrays.fill(ans, 1);
        //forward pass
        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1])
            {
                ans[i]=1+ ans[i-1];
            }
        }
        
        //Backward pass
        int sum=ans[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                ans[i]=Math.max(ans[i], 1+ ans[i+1]);
            }
            sum += ans[i];
        }
        return sum;
    }
}
