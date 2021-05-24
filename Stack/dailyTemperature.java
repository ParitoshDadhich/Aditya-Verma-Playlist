class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<int []> st = new Stack<>();
        int n = arr.length;
        int k = n-1;
        int ans[] = new int[n];
        
        for(int i=n-1; i>=0; i--){
        
            if(st.size() == 0)
                ans[k--] = 0;
            
            else if(st.size()>0 && st.peek()[0] > arr[i])
                ans[k--] = 1;
            else if(st.size()>0 && st.peek()[0] <= arr[i]){
                while(st.size()>0 && st.peek()[0] <= arr[i])
                    st.pop();
                
                if(st.size() == 0)
                    ans[k--] = 0;
                else
                    ans[k--] = st.peek()[1] - i;
            }
            st.push(new int[]{arr[i], i});
     
        }
        return ans;
    }
}
