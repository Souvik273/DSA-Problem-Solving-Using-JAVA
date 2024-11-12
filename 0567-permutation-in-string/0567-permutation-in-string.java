class Solution {
    public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false; // s1 cannot be a permutation in a shorter s2
    
    HashMap<Character, Integer> map = new HashMap<>();
    
    // Initialize the map with the frequency of each character in s1
    for (char ch : s1.toCharArray()) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    
    int count = map.size(); // Number of unique characters in s1
    int i = 0, j = 0;
    
    while (j < s2.length()) {
        char endChar = s2.charAt(j);
        
        // If the current character is part of the map, decrement its frequency
        if (map.containsKey(endChar)) {
            map.put(endChar, map.get(endChar) - 1);
            if (map.get(endChar) == 0) count--; // Unique character in window matches required frequency
        }
        
        // If the window size matches s1's length, check for a permutation
        if (j - i + 1 == s1.length()) {
            if (count == 0) return true; // All characters matched
            
            // Slide the window by removing the left character
            char startChar = s2.charAt(i);
            if (map.containsKey(startChar)) {
                if (map.get(startChar) == 0) count++; // Moving out of a match
                map.put(startChar, map.get(startChar) + 1); // Restore frequency
            }
            i++;
        }
        
        j++;
    }
    
    return false;
}

}