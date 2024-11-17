//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        int low = 0 , high = arr.length-1;
        Arrays.sort(arr);
        int floor = Floor(arr,x,low,high) ;
        int ceil = Ceil(arr,x,low,high)  ;
        return new int[]{floor,ceil};
    }
    public int Floor(int []a,int k , int low , int high){
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(a[mid]<=k){
                ans = a[mid];
                low=mid+1;
            }
            else if(a[mid]>k){
                high=mid-1;
            }
        }
        return ans;
    }
     public int Ceil(int []a,int k , int low , int high){
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(a[mid]>=k){
                ans = a[mid];
                high=mid-1;
            }
            else if(a[mid]<k){
                low=mid+1;
            }
        }
        return ans;
    }
}
