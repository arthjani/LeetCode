class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int prev = 0;
        int zeros = 0;
        int cur = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {                
                zeros++;
                if (zeros > 1) {
                   max = Math.max(max, prev + cur + 1);
                    zeros = 1;
                }
                prev = cur;
                cur = 0;
            } else {
                cur++;
            }
        }
        if (cur > 0) {
            max = Math.max(max, cur);
        }
        if (zeros >= 1) {
            max = Math.max(max, prev + cur + 1);
        }
        return max;
    }
}