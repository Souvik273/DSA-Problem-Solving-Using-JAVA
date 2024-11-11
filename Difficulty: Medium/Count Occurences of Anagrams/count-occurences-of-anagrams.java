//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int k = pat.length();
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int a=0;a<k;a++){
            char c = pat.charAt(a);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int count = map.size();
        int i=0,j=0,ans=0;
        
        while(j<txt.length()){
            char endChar = txt.charAt(j);
            if(map.containsKey(endChar)){
                map.put(endChar , map.get(endChar)-1);
                if(map.get(endChar)==0)count--;
            }
            if(j-i+1==k){
                if(count==0)ans++;
                char startChar = txt.charAt(i);
                if(map.containsKey(startChar)){
                    if (map.get(startChar) == 0) {
                    count++;
                }
                map.put(startChar, map.get(startChar) + 1);
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}