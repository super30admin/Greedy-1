//TIme-o(n)
//space-O(1)
//Had implemented before a brute force approach, this was i learnt in class

public boolean canJump(int[] nums) {
        
        int d=nums.length-1;
        int i=nums.length-2;        
        while(i>-1)
        {
            if(d==0)
            {
                return true;
            }
            if(nums[i]+i>=d)
            {
                System.out.println(nums[i]+i);
                
                d=i;
            }
            i--;
        }
        return false;
        
        
    }
