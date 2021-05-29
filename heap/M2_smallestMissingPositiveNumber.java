class Solution {
    public int firstMissingPositive(int[] arr) {
        int n = arr.length;
        int i=0;
        while(i<n){ 
            int corrPos = arr[i] - 1;
            if((arr[i] >=1 && arr[i] <=n) && (arr[i] != arr[corrPos])){
                int t = arr[i];
                arr[i] = arr[corrPos];
                arr[corrPos] = t;
            }
            else
                i++;
        }
        
        for(i=0; i<n; i++)
            if(arr[i] != i+1)
                return i+1;
        
        return n+1;
        
    }
}
