class Solution{
    static int maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<i+k && j<n; j++){
                sum += arr.get(j);
            }
            if(max < sum)
                max = sum;
        }
        return max;
    }
}
