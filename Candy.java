/*
class Solution:
    def candy(self, ratings: List[int]) -> int:
        if ratings is None or len(ratings) == 0:
            return 0
        
        result = [1]*len(ratings)
        # left pass
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                result[i] = result[i-1] + 1
        
        # right pass
        for i in range(len(ratings)-2, -1, -1):
            if ratings[i] > ratings[i+1]:
                result[i] = max(result[i], result[i+1]+1)
        
        total = 0
        for candy in result:
            total += candy
        return total
*/
// time - O(n)
// space - O(n)
// logic - first filled result with one candy for each child and then did left and right pass to give child more candies than its neighbour
class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        
        int[] result = new int[ratings.length];
        
        Arrays.fill(result, 1);
        // left pass
        for (int i=1; i<ratings.length; i++){
            if (ratings[i] > ratings[i-1])
                result[i] = result[i-1] + 1;
        }
        
        // right pass
        for (int i=ratings.length-2; i>=0; i--){
            if (ratings[i] > ratings[i+1])
                result[i] = Math.max(result[i], result[i+1]+1);
        }
        int total=0;
        for (int candy: result){
             total += candy;
        }
           
        
        return total;
    }
}