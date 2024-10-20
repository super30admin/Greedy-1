// Two pass algorithm
// TC: O(n)
// SC: O(n)
class Candy {
    public int candy(int[] ratings) {
        int[] result = new int[ratings.length];
        Arrays.fill(result,1);
        int sum = 0;
        for(int i=1;i<ratings.length;i++) {
            if(ratings[i] > ratings[i-1]) {
                result[i] = result[i-1] + 1;
            }
        }

        for(int i=ratings.length-2;i>=0;i--) {
            if(ratings[i] > ratings[i+1] && result[i] <= result[i+1]) {
                result[i] = result[i+1] + 1;
            }
        }
        for(int i=0;i<result.length;i++) {
            sum+= result[i];
        }
        return sum;
    }
}