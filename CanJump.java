class CanJump {
    
    //time: O(n)
    //space: O(n)
    //did it run successfully on leetcode: yes
    public boolean canJump(int[] nums) {
        //if input array is empty of just has one element
        if(nums==null || nums.length == 0 || nums.length==1) return true;
        
        //initializing destination
        int destination = nums.length-1;
        //lopping the input starting from the end
        for(int i=nums.length-2; i>=0; i--){
            //if I can reach the destination from current index
            if(i+nums[i] >= destination){
                //update destination to current index
                destination = i;
                
            }
            
            
        }
        return destination==0;
    }
	}