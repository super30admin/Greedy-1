// Problem1 Jump Game (https://leetcode.com/problems/jump-game/)


// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    public boolean canJump(int[] nums) {
        int p=nums.length-1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]+i>=p)
                p=i;
        }
        return p==0;
    }
}


           
//Problem2 Jump Game II (https://leetcode.com/problems/jump-game-ii/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int farthest=0;
        int curr=0;
        for(int i=0;i<nums.length-1;i++)
        {
            farthest=Math.max(farthest,nums[i]+i);
            if(i==curr)
            {
                jumps++;
                curr=farthest;
                if(curr>=nums.length-1)
                {
                    break;
                }
            }
        }
        return jumps;
    }
}


// Problem3 Candy (https://leetcode.com/problems/candy/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int candy(int[] ratings) {
        int []res=new int[ratings.length];
        Arrays.fill(res,1);
        for(int i=1;i<ratings.length;i++)
        {
            if(ratings[i]>ratings[i-1])
            {
                res[i]=res[i-1]+1;
            }  
        }
        int sum=res[res.length-1];
        for(int i=ratings.length-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                res[i]=Math.max(res[i+1]+1,res[i]);
            }
            sum+=res[i]; 
        }
        return sum;
    }
}


