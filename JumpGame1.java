//TC : O(N^2)
//SC : O(N)

class Solution {
    HashMap<Integer, Boolean> map;
    public boolean canJump(int[] nums) {
        
        map = new HashMap<>();
        return check(nums, 0);
    }
    public boolean check(int[] nums, int index){
        if(index >= nums.length - 1)    return true;
        
        for(int i = nums[index]; i >= 1; i--){
            
            int c = index + i;
            if(map.containsKey(c))  return map.get(c);
            else{
                boolean res = check(nums, c);
                map.put(c, res);
                if(res) return true;
            }
        }
        
        return false;
        
    }
}




/*
//TC : O(N)
//SC : O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int dest = nums.length - 1;
        
        for(int i = nums.length - 2; i>=0; i--){
            if(i + nums[i] >= dest){
                dest = i;
            }
        }
        
        return dest == 0;
    }
}
*/






