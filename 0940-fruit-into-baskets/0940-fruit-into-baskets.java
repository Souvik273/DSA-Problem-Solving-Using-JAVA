class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0; // Maximum number of fruits collected
        int i = 0;   // Start pointer of the sliding window

        for (int j = 0; j < fruits.length; j++) {
            // Add the current fruit to the map and update its count
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            // If the map size exceeds 2, shrink the window
            while (map.size() > 2) {
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if (map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                }
                i++; // Move the start pointer
            }

            // Update the maximum number of fruits collected
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}