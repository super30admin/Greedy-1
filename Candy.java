//T: O(n)
//S: O(n)
class Solution {
    public int candy(int[] ratings) {
        int help[]= new int[ratings.length];
        Arrays.fill(help,1);
        
        for(int i=0;i<help.length-1;i++){
            
            if(ratings[i+1]>ratings [i]){
                
                help[i+1]=help[i]+1;
            }
            
        }
        
        for(int i=help.length-1;i>0;i--){
            
            if(ratings[i-1]>ratings[i] ){
                help[i-1 ]=Math.max(help[i-1],help[i]+1);
            }
            
        }
        
        int sum=0;
        for( int i=0;i<help.length;i++){
            sum+=help[i];
        }
        return sum;
    }
}
