/*Running Time Complexity: O(n)
Space Complexity: O(n)
Successfully Run and Compiled on leetcode
*/
class Solution {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res,1);
        //Left side 
        for(int i = 1;i<res.length;i++){
            //compare with left element
            if(ratings[i-1]<ratings[i]){
                res[i] = res[i-1]+1;
            }
           //System.out.println(res[i]); 
        }
        //Right side
        for(int i=res.length-2;i>=0;i--){
            //compare with right element
            if(ratings[i+1]<ratings[i]){
                res[i] = Math.max(res[i+1]+1,res[i]);
                
            }
        }
        int sum = 0;
        for(int i =0;i<res.length;i++){
            sum+=res[i];
        }
        return sum;
    }
}