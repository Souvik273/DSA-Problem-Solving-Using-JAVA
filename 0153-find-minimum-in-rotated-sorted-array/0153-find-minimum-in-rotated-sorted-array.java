class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1 || nums[0]<nums[n-1])return nums[0];

        int i=0,j=n-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if((mid==0 || nums[mid]<=nums[mid-1]) &&
            (mid==n-1 || nums[mid]<=nums[mid+1]))return nums[mid];
            if(nums[mid]>=nums[0])i=mid+1;
            else if(nums[mid]<=nums[n-1])j=mid-1;
        }
        return nums[0];
    }
}