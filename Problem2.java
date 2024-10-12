class Solution {
    public int jump(int[] nums) {

        int n = nums.length;
        if(n==1) return 0;
        int cs = nums[0];
        int range = cs;
        int lastrange = cs;
        int jump = 1;
        int counter = 1;
        for(int i=1;i<n-1;i++){
            if(cs>n-1-i && i==1) return jump;
            if(range<i) {
                range = lastrange;
                counter = 0;
            }
            
            if(cs<=nums[i]){
                cs = nums[i];
                lastrange = nums[i]+i;
                if(counter==0){
                    jump++;
                    counter++;
                }
            }
            else{
                cs = cs-1;
            }
            

            if(cs>=n-1-i) return jump+1;
                

            
        }
        return jump;
        
    }
}