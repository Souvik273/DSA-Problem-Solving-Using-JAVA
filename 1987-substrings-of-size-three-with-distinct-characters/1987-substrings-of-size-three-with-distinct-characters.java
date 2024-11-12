class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0,j=0;
        int ans = 0;

        while(j<s.length()){
            char endChar = s.charAt(j);
            map.put(endChar,map.getOrDefault(endChar,0)+1);

            if(j-i+1==3){
                if(map.size()==3)ans++;
                char startChar = s.charAt(i);
                map.put(startChar,map.get(startChar)-1);
                if(map.get(startChar)==0)map.remove(startChar);
                i++;
            }
            j++;
        }
        return ans;
    }
}