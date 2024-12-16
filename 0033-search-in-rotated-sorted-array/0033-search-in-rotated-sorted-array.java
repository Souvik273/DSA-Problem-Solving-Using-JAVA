class Solution {
    public int search(int[] nums, int target) {
        int low = 0 , high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target)return mid;
            else if(nums[low]<=nums[mid]){
                // left part sorted 
                // check if the target lies b/w low and mid 
                if(nums[low]<=target && nums[mid]>=target)high=mid-1;
                else low = mid+1;
            }
            else {
                // right part sorted 
                // check if the target lies b/w high and mid 
                if(nums[high]>=target && nums[mid]<=target)low=mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
}