//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {
    // Function to find largest rectangular area possible in a given histogram.
    
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        int [] nextSmallerRight = findNextSmallerRight(arr);
        int [] nextSmallerLeft = findNextSmallerLeft(arr);
        int maxArea = 0; // Changed from Integer.MIN_VALUE to 0
        for(int i=0;i<n;i++){
            int width = nextSmallerRight[i]-nextSmallerLeft[i]-1;
            int area = width*arr[i];
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
    
    public static int[] findNextSmallerRight(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){ // Changed i>0 to i>=0 to cover all elements
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) // Changed > to >=
                st.pop();
            
            if(st.isEmpty()){
                ans[i]=n; // When no smaller element found on right
            } else {
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    
    public static int[] findNextSmallerLeft(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) // Changed > to >=
                st.pop();
            
            if(st.isEmpty()){
                ans[i]=-1; // When no smaller element found on left
            } else {
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends