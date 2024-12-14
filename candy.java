class Solution {
    public int candy(int[] ratings) {
        int up=0,down=0,candies=1;
        int newSlope=0,oldSlope=0;
        int n = ratings.length;
        if(n == 0) return 0;
        if(n == 1) return 1;
        for(int i=1;i<n;i++){
            if(ratings[i]<ratings[i-1]){
                newSlope=-1;
            }
            else if(ratings[i]>ratings[i-1]){
                newSlope=1;
            }
            else newSlope=0;

            if((oldSlope>0 && newSlope==0) ||(oldSlope<0 && newSlope>=0)){
                candies+=total(up)+total(down)+Math.max(up,down);
                up=0;down=0;
            }

            if(newSlope>0){
                up++;
            }
            else if(newSlope<0){
                down++;
            }
            else candies++;

            oldSlope=newSlope;
        }
        candies+=total(up)+total(down)+Math.max(up,down);
        return candies;
    }
    private int total(int n){
        return(n*(n+1)/2);
    }
}
