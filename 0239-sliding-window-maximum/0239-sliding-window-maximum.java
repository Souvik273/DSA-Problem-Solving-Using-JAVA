class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int start = 0 , end = 0;
        Deque<Integer> possibleMax = new LinkedList<>();
        int ans[] = new int[n-k+1];
        int idx = 0;
        while(end<n){
            while(possibleMax.size()>0 && possibleMax.peekLast()<nums[end])
                possibleMax.removeLast();
            possibleMax.add(nums[end]);
            if(end-start+1==k){
                ans[idx++]=possibleMax.peek();
                if(possibleMax.peek()==nums[start])
                    possibleMax.removeFirst();
                start++;
            }
            end++;
        }
        return ans;
    }
}