//O(n)
//O(1)
class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        int jump = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int k =0;k<size;k++){
                int i = q.poll();
                for(int j =1; j<=nums[i];j++){
                    int newIndex = i+j;
                    if(newIndex == nums.length-1) return jump;
                     if(!set.contains(newIndex)){
                         q.add(newIndex);
                         set.add(newIndex);
                     }
                }  
            }
            jump++;
        }
        return 54654;
    }
}
