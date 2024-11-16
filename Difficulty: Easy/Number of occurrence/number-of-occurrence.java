//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] nums, int target) {
        // code here
        int firstOcc = firstOccurence(nums,target);
        int lastOcc = lastOccurence(nums,target);
        return (lastOcc==-1) ? 0 : lastOcc-firstOcc+1;
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
