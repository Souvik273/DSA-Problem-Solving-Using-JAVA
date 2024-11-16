class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return ""; // Base case: If s is shorter than t, no valid window exists
        }

        HashMap<Character, Integer> map = new HashMap<>();
        // Count frequencies of characters in t
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0, count = map.size(); // Count tracks the number of distinct characters yet to match
        int minLength = Integer.MAX_VALUE;
        String result = "";

        while (j < s.length()) {
            // Expand the window by adding the character at j
            char endChar = s.charAt(j);
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    count--; // Fully matched a character
                }
            }

            // Shrink the window when all characters are matched
            while (count == 0) {
                // Update the result if this window is smaller
                if (j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    result = s.substring(i, j + 1);
                }

                // Shrink the window from the left
                char startChar = s.charAt(i);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) {
                        count++; // No longer fully matched
                    }
                }
                i++; // Move the start of the window
            }

            j++; // Expand the window
        }

        return result;
    }
}