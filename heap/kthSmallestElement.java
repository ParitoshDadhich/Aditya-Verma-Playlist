class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: arr){
            pq.add(i);
            if(pq.size() > k)
                pq.poll();
        }
        
        return pq.peek();
    } 
}
