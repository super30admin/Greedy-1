class minCandy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        
        int n = ratings.length;
        int[] temp = new int[n];
        
        temp[0] = 1;
        for(int i = 1; i < ratings.length; i++){
            temp[i] = 1;
            if(ratings[i] > ratings[i - 1]){
                temp[i] = temp[i - 1] + 1;
            }
        }
        int result = temp[n - 1];
        for(int i = ratings.length - 2; i >=0; i--){
            if(ratings[i] > ratings[i + 1]){
                temp[i] = Math.max(temp[i], temp[i + 1] + 1);
            }
            result = result + temp[i];
        }
        return result;
    }
}

//time complexity O(n)
//space complexity O(n)