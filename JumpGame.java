class Solution {
    public boolean canJump(int[] nums) {
     int maxd=0;
        
        for(int i=0;i<nums.length;i++){
            if(maxd>=nums.length-1){return true;}
            maxd=Math.max(i+nums[i],maxd);
               if(i==maxd&&nums[i]==0){break;}
            
        }
        return false;
    }
}
