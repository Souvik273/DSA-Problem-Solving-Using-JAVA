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

class Solution {
    public int[] getFloorAndCeil(int k, int[] arr) {
        // Sort the array to enable binary search
        Arrays.sort(arr);
        int n = arr.length;

        // Initialize floor and ceil values
        int floor = -1;
        int ceil = -1;

        // Binary search to find floor and ceil
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                // If element equals k, both floor and ceil are k
                return new int[]{arr[mid], arr[mid]};
            } else if (arr[mid] < k) {
                // Update floor and move to the right half
                floor = arr[mid];
                low = mid + 1;
            } else {
                // Update ceil and move to the left half
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        // Return the computed floor and ceil values
        return new int[]{floor, ceil};
    }
}
