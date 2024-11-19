class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long sum = 0, maxSum = 0;

        int i = 0, j = 0;
        while (j < nums.length) {
            // Add the current element to the sum
            sum += nums[j];

            // Add the current element to the set
            while (set.contains(nums[j])) {
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            set.add(nums[j]);

            // Check if the window size equals k
            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            j++;
        }
        return maxSum;
    }
}
