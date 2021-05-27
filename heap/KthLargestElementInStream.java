
class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i: arr){
            if(pq.size() < k){
                pq.add(i);
            }
            else{
                if(i > pq.peek()){
                    pq.poll();
                    pq.add(i);
                }
            }
            
            if(pq.size() < k)
                list.add(-1);
            else
                list.add(pq.peek());
        }
        
        int ans[] = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            ans[i] = list.get(i);
            
        return ans;
    }
};
