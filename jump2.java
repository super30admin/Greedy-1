/*
Tc --> O(n^2)
Sc --> O(n)
*/
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 0;
        }
        int[] res = new int[n];
        Arrays.fill(res, 99999);
        for(int i=n-2;i>=0;i--){
            if(nums[i]==0) continue;
            int min_val = res[i];
            int j=i;
            while(j<=nums[i]+i){
                if(j>=n-1){
                    min_val = 1;
                    break;
                }
                min_val = Math.min(1+res[j],min_val);
                j++;
                
            }//while
            
            res[i] = min_val;
        }//for
        // for(int i=0;i<res.length;i++){
        //     System.out.println(res[i]);
        // }

        return res[0];
    }//method
}