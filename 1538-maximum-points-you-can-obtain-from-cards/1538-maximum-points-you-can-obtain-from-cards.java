class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0 , maxSum = 0 ;
        for(int i = 0 ; i<k ; i++){
            sum+=cardPoints[i];
        }
        maxSum=sum;
        int rindex = cardPoints.length-1;
        for(int i = k-1 ; i >= 0 ; i--){
            sum=sum-cardPoints[i];
            sum+=cardPoints[rindex];
            maxSum = Math.max(sum,maxSum);
            rindex= rindex-1;
        }
        return maxSum;
    }
}