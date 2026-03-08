
/**
 * @param {number[]} nums
 * @return {number}
 * Greedy
 * Treat each jump as a range/level you can reach.
   While scanning the current range, compute the farthest position reachable next.
   When you reach the end of the current range, take a jump and extend the range to the farthest.
   T.C: O(n)
   S.C: O(1)
 */
var jump = function (nums) {
    let n = nums.length;
    if (n === 1) return 0;
    let currInt = nums[0];
    let nextInt = nums[0];
    let jump = 1;

    for (let i = 1; i < n; i++) {
        nextInt = Math.max(nextInt, i + nums[i]);
        if (i === currInt && currInt < n-1) {
            currInt = nextInt;
            jump++;
        }
    }
    return jump;
};



/**
 * @param {number[]} nums
 * @return {number}
 * DP
 */
var jump = function (nums) {
    let n = nums.length;
    let memo = new Array(n).fill(-1);
    if (n === 1) return 0;
    const dfsHelper = (idx) => {
        // base
        if (idx >= n - 1) return 0;

        // action
        let minJumps = Infinity;
        if (memo[idx] !== -1) return memo[idx];
        let maxJumps = nums[idx];
        for (let j = 1; j <= maxJumps; j++) {
            let newIdx = idx + j;
            minJumps = Math.min(minJumps, 1 + dfsHelper(newIdx));
        }
        memo[idx] = minJumps;
        return minJumps;


    };
    return dfsHelper(0);
};