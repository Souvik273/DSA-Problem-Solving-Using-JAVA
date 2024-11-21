class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int index = peakElement(mountainArr);
        int leftAns = findInAscending(0, index, target, mountainArr);
        if (leftAns != -1) {
            return leftAns;
        }
        
        return findInDescending(index + 1, n - 1, target, mountainArr);
    }

    public int peakElement(MountainArray arr) {
        int n = arr.length();
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && mid < n - 1) {
                if (arr.get(mid) > arr.get(mid + 1) && arr.get(mid) > arr.get(mid - 1)) {
                    return mid;
                } else if (arr.get(mid) < arr.get(mid + 1)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (mid == 0) {
                if (arr.get(0) > arr.get(1)) return 0;
                else return 1;
            } else if (mid == n - 1) {
                if (arr.get(n - 1) > arr.get(n - 2)) return n - 1;
                else return n - 2;
            }
        }
        return -1;
    }

    public int findInAscending(int low, int high, int target, MountainArray arr) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = arr.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int findInDescending(int low, int high, int target, MountainArray arr) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = arr.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
