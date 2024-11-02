class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int NSum = (n*(n+1))/2;
        int ArrSum = 0;
        for(int i=0;i<nums.length;i++){
            ArrSum += nums[i];
        }
        return NSum - ArrSum ;
    }
}