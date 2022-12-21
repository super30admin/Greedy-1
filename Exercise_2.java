class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int c = 0, ne = 0;
        int j =0;
        for(int i =0; i<n-1; ++i){
            ne = Math.max(ne, i+nums[i]);
            if(i == c){
                ++j;
                c =ne;
            }
       }

       return j;

    }
}
//tc = O(n)
//sc = O(1)
