//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubstrDistinctChars(String s) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        int max =0;
        int i=0,j=0;
        while(j<s.length()){
            char endchar = s.charAt(j);
            map.put(endchar,map.getOrDefault(endchar,0)+1);
            if(map.size()<j-i+1){
                while(map.size()<j-i+1){
                    char startchar = s.charAt(i);
                    map.put(startchar,map.get(startchar)-1);
                    if(map.get(startchar)==0)map.remove(startchar);
                    i++;
                }
            }
            if(map.size()==j-i+1){
                max=Math.max(max,j-i+1);
            }
            j++;
        }
        return max;
    }
}