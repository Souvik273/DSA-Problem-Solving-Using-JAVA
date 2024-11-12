class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        int i=0,j=0;
        while(j<nums.length){
            while(!deque.isEmpty() && deque.peekLast()<nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            if(j-i+1==k){
                list.add(deque.peekFirst());
                if(deque.peekFirst()==nums[i]){
                    deque.removeFirst();
                }
                i++;
            }
            j++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}