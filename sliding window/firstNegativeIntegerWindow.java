
class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        ArrayList<Long> list = new ArrayList<>();
        Queue<Long> queue = new ArrayDeque<>();
        int i=0;
        int j=0;
        long nonNeg = 0;
        while(j<n){
            if(arr[j] < 0)
                queue.add(arr[j]);
            
            if(j-i+1<k)
                j++;
            else if(j-i+1 == k){
                // list.add(queue.peek());
                if(queue.size() == 0)
                    list.add(nonNeg);
                else
                    list.add(queue.peek());
                
                if(!queue.isEmpty() && queue.peek() == arr[i])
                    queue.poll();
         
                i++;
                j++;
            }
        }
        
        long ans[] = new long[list.size()];
        for(i=0; i<list.size(); i++)
            ans[i] = list.get(i);
            
        return ans;
        
    }
}


     
