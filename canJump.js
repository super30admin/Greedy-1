
/**
 * @param {number[]} nums
 * @return {boolean}
 * Greedy
1. Start with the last index as the target (the position we want to reach).
2. Move backwards and check if index `j` can jump to the current target.
3. If it can, move the target to 'j', if we eventually move the target to '0', the start can reach the end. 
T.C: O(n)
S.C: O(1)

 */
var canJump = function(nums) {
    let n = nums.length;
    let target = nums.length -1;
    for(let j = n-2; j >= 0; j--){
        if(j + nums[j] >= target){
            target = j;
        }
    }
    return target === 0;
};



/**
 * @param {number[]} nums
 * @return {boolean}
 * BFS
 */
var canJump = function (nums) {
    let n = nums.length;
    let set = new Set();
    set.add(0);
    let queue = [0];
    while (queue.length) {
        let curr = queue.shift();

        for (let j = 0; j <= nums[curr]; j++) {
            let newIdx = j + curr;

            if (newIdx >= n - 1) return true;
            else {
                if (!set.has(newIdx)) {
                    set.add(newIdx);
                    queue.push(newIdx);
                }
            }
        }
    }
    return false;
};


/**
 * @param {number[]} nums
 * @return {boolean}
 * DFS
 */
var canJump = function (nums) {
    const n = nums.length;
    if(n === 1) return true;
    let set = new Set();
    const dfsHelper = (idx) => {
        // base
        if(idx === n-1) return true;
        if(set.has(idx)) return false;


        // action
        for (let j = 1; j <= nums[idx]; j++) {
            const newIdx = j + idx;
            if (dfsHelper(newIdx)) return true;
        }
        set.add(idx);
        return false;

    };

    return dfsHelper(0);
};