//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public int candy(int[] ratings) {
        
        int[] temp = new int[ratings.length];
        
        Arrays.fill(temp,1);
        
        for(int i = 1; i < ratings.length; i ++){
            
            if(ratings[i] > ratings[i-1]){
                
                temp[i] = temp[i-1] + 1;
            }
        }
        
         for(int i = ratings.length - 2; i >= 0; i --){
            
            if(ratings[i] > ratings[i+1]){
                
                temp[i] = Math.max(temp[i],temp[i+1] + 1);
            }
        }
        
        int result = 0;
        
        for(int i = 0; i < ratings.length; i ++){
            
            result = result + temp[i];
        }
        
        return result;
    }
}