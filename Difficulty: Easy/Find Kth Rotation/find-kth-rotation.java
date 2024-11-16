//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        int n = arr.size();
        if (n == 1 || arr.get(0) < arr.get(n - 1)) {
            return 0; // Already sorted, no rotation.
        }

        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is the pivot (minimum element).
            if ((mid == 0 || arr.get(mid) < arr.get(mid - 1)) && 
                (mid == n - 1 || arr.get(mid) < arr.get(mid + 1))) {
                return mid;
            }

            // Decide which side to search.
            if (arr.get(mid) >= arr.get(0)) {
                start = mid + 1; // Pivot must be in the right half.
            } else {
                end = mid - 1; // Pivot must be in the left half.
            }
        }

        return 0; // This should not be reached for valid input.
    }
}
