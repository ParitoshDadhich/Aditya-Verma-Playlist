class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        
        int i=0;
        int j=0;
        while(j<n){
            // calculations
            while(deque.size()>0 && deque.getLast()<arr[j])
                deque.pollLast();
            deque.add(arr[j]);
            
            if(j-i+1 < k)
                j++;
            else if(j-i+1 == k){
                // finding the answer which we did in the calculation part
                list.add(deque.peek());
                // slide
                if(deque.peek() == arr[i])
                    deque.pollFirst();
                
                i++;
                j++;
            }
        }
        
        int ans[] = new int[list.size()];
        for(i=0; i<list.size(); i++)
            ans[i] = list.get(i);
        
        return ans;
    }
}
