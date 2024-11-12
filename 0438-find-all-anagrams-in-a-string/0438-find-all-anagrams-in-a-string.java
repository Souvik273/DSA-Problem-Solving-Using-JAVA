class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();

        int k = p.length();
        for(int i=0;i<k;i++){
            char ch = p.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count =map.size();
        int i=0,j=0;
        while(j<s.length()){
            char endChar = s.charAt(j);
            if(map.containsKey(endChar)){
                map.put(endChar,map.get(endChar)-1);
                if(map.get(endChar)==0)count--;
            }
            if(j-i+1==k){
                if(count==0)list.add(i);
                char startChar = s.charAt(i);
                if(map.containsKey(startChar)){
                    if(map.get(startChar)==0)count++;
                    map.put(startChar,map.get(startChar)+1);
                }
                i++;
            }
            j++;
        }
        return list;
    }
}