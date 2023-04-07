//BFS
//TC: O(n^k) --> n: length of arr & k = number of jumps
//SC: O(n)

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        if (nums.length < 2) return true;
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        q.add(0);
        while(!q.isEmpty()){
            int i =q.poll();
           for(int j = 1; j<= nums[i]; j++){
               int newIndex = i+j;
               if(newIndex >= n-1) return true;
               if(!set.contains(newIndex)){
                    q.add(newIndex);
                   set.add(newIndex);
               }
              
           }
           
        }
         return false;
    }
}
