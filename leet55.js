TC - O(N)
 SC - O(1)

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
 
  let jump=0,k=0;
  for(let i=0;i<nums.length;i++)
  {
      
      if(i>jump)return false;
      jump=Math.max(jump,nums[i]+i);
  }
  return true;
};