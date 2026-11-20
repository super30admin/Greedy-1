
// using bfs to work on adding each element jumps and verify if it reaches end of the array 

// o(n2) complexity for every value we are looking for next values available. 
//o(n) space complexity

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1){ return true;}

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        q.add(0);
        set.add(0);

        
        

        while(!q.isEmpty()){
            int index = q.poll();
            int val = nums[index];
            for(int i = 1; i <= val; i ++){
                int newIndex = index + i;
                if(newIndex == nums.length -1){ return true;}
                if(!set.contains(newIndex)){
                    set.add(newIndex);
                    q.add(newIndex);
                }


            }

        }
        return false;

        
    }
}
