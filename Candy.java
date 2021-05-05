// TC - O(n), SC - O(1)

// LC - 135

class Solution {
    public int candy(int[] ratings) {
		// Sanity check
        if(ratings == null || ratings.length == 0){
            return 0;
        }
		// initialize output array
        int[] output = new int[ratings.length];
		// Initially everyone has 1 candy
        Arrays.fill(output, 1);
		// Currently, iterate from 1 to end and check if ratings[i] > ratings[i-1], then output[i] = output[i-1]+1
        for(int i=1; i<ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                output[i] = output[i-1]+1;
            }
        }
        int ct = output[output.length-1];
		// Now coming from back
        for(int i=ratings.length-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                output[i] = Math.max(output[i+1]+1, output[i]);
            }
            ct += output[i];
        }
        // return ct
        return ct;
    }
}

// class Solution {
//     public int candy(int[] ratings) {
//         if(ratings == null || ratings.length == 0){
//             return 0;
//         }
//         int[] output = new int[ratings.length];
//         Arrays.fill(output, 1);
//         for(int i=1; i<ratings.length; i++){
//             if(ratings[i] > ratings[i-1]){
//                 output[i] = output[i-1]+1;
//             }
//         }
        
//         for(int i=ratings.length-2; i>=0; i--){
//             if(ratings[i] > ratings[i+1]){
//                 output[i] = Math.max(output[i+1]+1, output[i]);
//             }
//         }
        
//         int ct = 0;
//         for(int val : output){
//             ct += val;
//         }
//         return ct;
//     }
// }