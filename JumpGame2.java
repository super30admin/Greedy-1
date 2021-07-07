//Time Complexity: O(N^2)
//Space Complexity: O(1)
//Check for base case if the nums array has only 1 element then we know that the no of jumps is 0.
//Set count and i to 0 initially 
//AS long as the sum if ith index and the value at i is less than the length of the nums array iterate over the nums array from 1st index till j is equal to or less than value at i.
//Check if the value at j+i th index plus the jth index in nums array is > the maxval if so update maxval to the value at j+i th index plus the jth index.
//And update maxvalindex to i+j
//move i to the maxvalindex and increment the count
//Finally return count+1 which is our total number of jumps
class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1)
        {
            return 0;
        }
        int count = 0;
        int i =0;
        while(i+nums[i] < nums.length-1)
        {
            int maxVal = 0;
            int maxValIndex = 0;
            for(int j = 1; j<=nums[i];j++)
            {
                if(nums[j+i]+j > maxVal)
                {
                    maxVal = nums[j+i]+j;
                    maxValIndex = i+j;
                }
            }
            i = maxValIndex;
            count++;
        }
        return count+1;
    }
}

//Time Complexity: O(N)
//Space Complexity: O(1)
//Check for base case if the length of nums array n is only 1 or 0 if so return 0 as 0 jumps required.
//Initialise jump to 1 and curmax and nextmax value to 0th index value of nums array.
//Iterate over the nums array from 0 to n. Calculate nextmax by taking max between the current nextmax and value in nums array at i th index plus i and update nextmax
//Check if i =curmax and i is not the last element if so increment jump and update curmax value to nextmaxval
//Check if curmax value is greater than or equal to last index n-1 if so break from loop cause then there is no point moving ahead.
//Return the jump value.
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1||n==0)
        {
            return 0;
        }
        int jump = 1;
        int curMax = nums[0];
        int nextMax = nums[0];
        for(int i = 0; i<n; i++)
        {
            nextMax = Math.max(nextMax, nums[i]+i);
            if(i==curMax && i!=n-1)
            {
                jump++;
                curMax = nextMax;
            }
            if(curMax>=n-1)
            {
                break;
            }
        }
        return jump;
    }
}

