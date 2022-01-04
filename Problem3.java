class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 1)
            return 1;
        int left[] = new int[ratings.length];
        int right[] = new int[ratings.length];

        int current = 0;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1])
                current++;
            else
                current = 0;
            left[i] = current;
        }
        current = 0;
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1])
                current++;
            else
                current = 0;
            right[i] = current;
        }

        int res = 0;
        for(int i=0;i<ratings.length;i++){
            res+=1+Math.max(left[i],right[i]);
        }
        return res;
    }
}