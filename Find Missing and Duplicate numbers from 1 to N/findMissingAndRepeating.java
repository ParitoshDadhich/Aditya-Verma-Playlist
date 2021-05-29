class Solve {
    int[] findTwoElement(int arr[], int n) {
        int ans[] = new int[2];
        
        int i=0;
        while(i<n){
            if(arr[i] == arr[arr[i] -1])
                i++;
            else if(arr[i] != arr[arr[i] -1]){
                int t = arr[i];
                arr[i] = arr[arr[i]-1];
                arr[t-1] = t;
            }
        }
        
        // for(int k: arr)
        //     System.out.print(k + " ");
        
        for(i=0; i<n; i++){
            if(arr[i] != i+1){
                ans[0] = arr[i];
                ans[1] = i+1;
            }
        }
        
        return ans;
        
    }
}
