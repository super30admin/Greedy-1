TC - O(N)
 SC -O(1)

/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    let jump=0,count=0,max=0;
    for(let i=0;i<nums.length-1;i++)
    { 
        jump=Math.max(jump,nums[i]+i);
        
        if(i===max){
          max=jump;
          count++;
        }
    }
    return count;
};