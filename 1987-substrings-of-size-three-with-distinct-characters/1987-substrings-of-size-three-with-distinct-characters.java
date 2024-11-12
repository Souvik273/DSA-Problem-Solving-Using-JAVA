class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) return 0;
        int ans = 0;
        for(int i=0;i<s.length()-2;i++){
            char firstChar = s.charAt(i);
            char secondChar = s.charAt(i+1);
            char thirdChar = s.charAt(i+2);
            if (firstChar != secondChar && secondChar != thirdChar && firstChar != thirdChar) {
            ans++;
        }
        }
        
        return ans;
    }
}