// ## Problem1 Jump Game (https://leetcode.com/problems/jump-game/)

// time: O(n)
//space: O(1)


const canJump = function(nums) {
    if(nums.length === 1) return true;
    let required = 1;
    for(let i = nums.length - 2; i >=0; i--) {
        if(nums[i] < required) required++;
        else if(nums[i] >= required && i === 0) return true;
        else if(nums[i] >= required) required = 1;
    }
    return false;
};