class Solution {
    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];
        Arrays.fill(arr,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                arr[i] = arr[i-1] + 1;
            }
        }
        
        for(int i=ratings.length-1; i>0; i--){
            if(ratings[i]<ratings[i-1]){
                arr[i-1] = Math.max(arr[i-1], arr[i]+1);
            }
        }
        int count = 0;
        for(int i=0;i<arr.length;i++){
            count += arr[i];
        }
        return count;
    }
}

//Time complexity : O(N)
//Space complexity : O(N)
