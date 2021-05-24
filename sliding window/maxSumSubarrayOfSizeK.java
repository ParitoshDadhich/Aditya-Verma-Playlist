class Solution{
    static int maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        int i=0;
        int j=0;
        int sum=0;
        int max = Integer.MIN_VALUE;
        
        // sliding window algorithm
        while(j<n){
            sum += arr.get(j);
            if((j-i+1)<k)
                j++;
            else if((j-i+1)==k){
                max = Math.max(max, sum);
                sum -= arr.get(i);
                i++;
                j++;
            }
        }
        return max;
    }
}
