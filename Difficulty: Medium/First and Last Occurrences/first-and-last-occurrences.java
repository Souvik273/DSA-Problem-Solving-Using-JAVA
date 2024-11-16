//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class GFG {
    ArrayList<Integer> find(int nums[], int target) {
        int firstOcc = firstOccurence(nums,target);
        int lastOcc = lastOccurence(nums,target);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(firstOcc);
        list.add(lastOcc);
        return list;
    }
    int firstOccurence(int a[],int k){
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
    int lastOccurence(int a[],int k){
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


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            int x = Integer.parseInt(br.readLine());
            GFG ob = new GFG();
            ArrayList<Integer> ans = ob.find(arr, x);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends