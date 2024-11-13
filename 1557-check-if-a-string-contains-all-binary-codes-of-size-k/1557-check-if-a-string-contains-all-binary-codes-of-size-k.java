class Solution {
    public boolean hasAllCodes(String s, int k) {
         int requiredCount = 1 << k; 
        
        HashSet<String> uniqueCodes = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            String substring = s.substring(i, i + k);
            uniqueCodes.add(substring);
            if (uniqueCodes.size() == requiredCount) {
                return true;
            }
        }
        return uniqueCodes.size() == requiredCount;
    }
}