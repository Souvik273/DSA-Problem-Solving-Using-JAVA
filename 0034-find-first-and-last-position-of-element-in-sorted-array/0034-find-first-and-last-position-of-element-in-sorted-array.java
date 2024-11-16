class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOcc = firstOccurence(nums,target);
        int lastOcc = lastOccurence(nums,target);
        return new int[]{firstOcc,lastOcc};
    }
    public int firstOccurence(int a[],int k){
        int s=0,e=a.length-1;
        int res=-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(a[mid]==k){
                res=mid;
                e=mid-1;
            }
            else if(a[mid]>k)e=mid-1;
            else s=mid+1;
        }
        return res;
    }
    public int lastOccurence(int a[],int k){
        int s=0,e=a.length-1;
        int res=-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(a[mid]==k){
                res=mid;
                s=mid+1;
            }
            else if(a[mid]>k)e=mid-1;
            else s=mid+1;
        }
        return res;
    }
}