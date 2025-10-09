// This algo calculates total candies that can be spread at every peak and valley. We track the slope and count and when we reach either a valley or peak we calculcate and reset the slope and up or down count
class Solution {
    public int candy(int[] ratings) {
        int upCount = 0, downCount = 0;
        int newDir = 0, oldDir = 0, totalCount = 0;

        for(int i=1;i<ratings.length;i++) {

            if(ratings[i]>ratings[i-1]) {
                newDir=1;
            } else if(ratings[i]<ratings[i-1]) {
                newDir=-1;
            } else {
                newDir=0;
            }
            
            if((oldDir<0 && newDir>=0) || (oldDir>0 && newDir==0)) {
                totalCount += getVal(downCount) + getVal(upCount) + Math.max(downCount, upCount);
                upCount=0;
                downCount=0;
            }

            if(newDir==1) {
                upCount++;
            } else if(newDir==-1) {
                downCount++;
            } else {
                totalCount++;
            }

            oldDir = newDir;
        }

      // Append left over counts
        totalCount += getVal(downCount) + getVal(upCount) + Math.max(downCount, upCount);
        return totalCount+1;
    }

    private int getVal(int val) {
        return ((val)*(val+1))/2;
    }
}

