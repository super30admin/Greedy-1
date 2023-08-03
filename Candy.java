// TC = O(2n) as 2 passes which can be approximated to O(n)
class Solution {
    public int candy(int[] ratings) {
        int[] result = new int[ratings.length];
        Arrays.fill(result,1);
        /* first pass */
        if(ratings.length == 1) return 1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i-1]<ratings[i]){
                result[i] = result[i-1] + 1;
            }
        }
        /*second pass */
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                result[i] = Math.max(result[i],result[i+1]+1);
            }
        }
        int sum = 0;
        for(int i=0;i<result.length;i++){
            sum += result[i];
        }
        return sum;
    }
}

// class Solution {
//     public int candy(int[] ratings) {
//         int[] result = new int[ratings.length];
//         Arrays.fill(result,1);
//         /* first pass */
//         if(ratings.length == 1) return 1;
//         for(int i=1;i<ratings.length;i++){
//             if(ratings[i-1]<ratings[i]){
//                 result[i] = result[i-1] + 1;
//             }
//         }
//         System.out.println(Arrays.toString(result));
//         /*second pass */
//         for(int i=ratings.length-2;i>=1;i--){
//             if(ratings[i]>ratings[i+1]){
//                 result[i] = if result[i-1]==result[i]? result[i-1],result[i+1]) + 1:Math.max(result[i-1],result[i+1]) + 1;
//             }
//         }
//         if(ratings[0]>ratings[1]) result[0] = result[1]+1;
//         System.out.println(Arrays.toString(result));
//         int sum = 0;
//         for(int i=0;i<result.length;i++){
//             sum += result[i];
//         }
//         return sum;
//     }
// }