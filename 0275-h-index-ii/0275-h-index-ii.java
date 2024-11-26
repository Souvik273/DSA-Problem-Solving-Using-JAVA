class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        
        while (left <= right) {
            int midIdx = left + (right - left) / 2;
            
            // Calculate papers with at least current citation count
            int papersWithCitations = n - midIdx;
            
            // Compare current citation count with papers count
            if (citations[midIdx] == papersWithCitations) {
                return papersWithCitations;
            } else if (citations[midIdx] < papersWithCitations) {
                // Need more citations, search right half
                left = midIdx + 1;
            } else {
                // Too many citations, search left half
                right = midIdx - 1;
            }
        }
        
        // Return the maximum h-index
        return n - left;
    }
}