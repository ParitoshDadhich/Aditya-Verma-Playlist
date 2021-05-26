class Solution{
    
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        int i=0;
        int j=0;
        int max=0;
        int sum=0;
        
        while(j<n){
            sum += arr[j];
            
            if(sum < k)
                j++;
                
            else if(sum == k){
                max = Math.max(max, j-i+1);
                j++;
            }
            
            else if(sum > k){
                while(sum > k){
                    sum = sum - arr[i];
                    i++;
                }
                j++;
            }
            
        }
        
        return max;
    }
}
